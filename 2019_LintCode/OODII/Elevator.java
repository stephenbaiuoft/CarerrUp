package OODII;

import java.util.ArrayList;
import java.util.List;

// 一个电梯 没有按钮设计
// 有一个 电梯系统来控制

public class Elevator{
    private int currentFloor;
    private int targetFloor;
    private int status; // 0 idle, 1 up, -1 down
    // Java Singleton Syntax
    private static volatile Elevator instance = null;

    private Elevator() {
        this.currentFloor = 0;
        this.targetFloor = 0;
        this.status = 0;
    }

    // Java Syntax for Singleton Double locking Syntax
    public static  Elevator getInstance() {
        if (instance == null) {
            synchronized(Elevator.class) {
                if (instance == null) {
                    instance = new Elevator();
                }
            }
        }

        return instance;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getStatus() {
        return status;
    }

    public void moveToFloor(int targetFloor) {

        while (currentFloor < targetFloor) {
            moveUp();
        }
        while (currentFloor > targetFloor) {
            moveDown();
        }

        status = 0;
    }

    private void moveUp() {
        status = 1;
        currentFloor += 1;
    }

    private void moveDown() {
        status = -1;
        currentFloor -= 1;
    }
}


class RequestHandler {
    List<Request> requests;
    // volatile --> only 1 in the memory for allllllll threads!!!
    private static volatile RequestHandler instance = null;

    public static RequestHandler getInstance() {
        if (instance == null) {
            synchronized (RequestHandler.class) {
                if (instance == null) {
                    instance = new RequestHandler();
                }
            }
        }

        return instance;
    }

    private RequestHandler() {
        requests = new ArrayList<>();
    }


    public void addRequest(Request req) {
        synchronized (req) {
            requests.add(req);
        }
    }

    // get the next Request that has the minimum distance away from the current elevator level
    private Request getNextRequest() {
        int curentFloor = Elevator.getInstance().getCurrentFloor();
        int shortestdistance = Integer.MAX_VALUE;
        Request next = null;

        for (Request req: requests) {
            if (Math.abs(req.getTargetFloor() - curentFloor) < shortestdistance) {
                next = req;
            }
        }

        return next;
    }

    public void processRequest() {

        while (true) {
            Request req = getNextRequest();
            if (req != null) {
                while (Elevator.getInstance().getStatus() != 0);// polling or w8ing
                // Elevator.getInstance().getStatus() is 0
                Elevator.getInstance().moveToFloor(req.getTargetFloor());
                requests.remove(req);
            }
        }

    }
}


class Request {

    private int targetFloor;
    Request (int targetFloor) {
        this.targetFloor = targetFloor;
    }

    public int getTargetFloor() {
        return targetFloor;
    }
}


class User{
    public void generateRequest(int targetFloor) {
        RequestHandler.getInstance().addRequest(new Request(targetFloor));
    }
}