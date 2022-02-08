package OODII;

import java.util.*;
/*
* No food delivery.

You can reserve seats.

MAX_DINETIME = 2， which mean the maximum time for a meal is 2 hours

If the table has been reserved, it could not be assigned to another party.

The table has different size

The restaurant will choose the smallest table which fit the numbers of people(For example, if the party has 3 people, the restaurant would assign a 4-people table instead of a 10-people table)

Different from Restaurant I，you have to implement new functions in "Table". The function restaurantDescription, will be called to test your program.
*
* */
class NoTableException extends Exception{

    public NoTableException(Party p)
    {
        super("No table available for party size: " + p.getSize());
    }
}

class Meal {
    private float price;

    public Meal(float price)
    {
        this.price = price;
    }

    public float getPrice()
    {
        return this.price;
    }
}

class Order {
    private List<Meal> meals;

    public Order()
    {
        meals = new ArrayList<Meal>();
    }

    public List<Meal> getMeals()
    {
        return meals;
    }

    public void mergeOrder(Order order)
    {
        if(order != null)
        {
            for(Meal meal : order.getMeals())
            {
                meals.add(meal);
            }
        }
    }

    public float getBill()
    {
        int bill = 0;
        for(Meal meal : meals)
        {
            bill += meal.getPrice();
        }
        return bill;
    }
}

class Party {
    private int size;

    public Party(int size)
    {
        this.size = size;
    }

    public int getSize()
    {
        return this.size;
    }
}

class Table implements Comparable<Table>{
    private int id;
    private int capacity;
    private boolean available;
    private Order order;
    List<Date> reservations;

    public Table(int id, int capacity)
    {
        this.id = id;
        this.capacity = capacity;
        available = true;
        order = null;
        reservations = new ArrayList<>();
    }

    public int getId()
    {
        return this.id;
    }

    public int getCapacity()
    {
        return this.capacity;
    }

    public List<Date> getReservation()
    {
        return reservations;
    }

    public boolean isAvailable()
    {
        return this.available;
    }

    public void markAvailable()
    {
        this.available = true;
    }

    public void markUnavailable()
    {
        this.available = false;
    }

    public Order getCurrentOrder()
    {
        return this.order;
    }

    public void setOrder(Order o)
    {
        if(order == null)
        {
            this.order = o;
        }
        else
        {
            if(o != null)
            {
                this.order.mergeOrder(o);
            }
        }
    }

    @Override
    public int compareTo(Table compareTable) {
        // TODO Auto-generated method stub
        return this.capacity - compareTable.getCapacity();
    }

    private int findDatePosition(Date d)
    {
        int len = reservations.size();
        if(len == 0)
            return 0;
        if(d.getTime() > reservations.get(len - 1).getTime())
        {
            return len;
        }

        int i=0;
        int j=len;

        while(i<j){
            int m=(i+j)/2;
            if(d.getTime() > reservations.get(m).getTime()){
                i=m+1;
            }else{
                j=m;
            }
        }

        return j;
    }

    public boolean noFollowReservation(Date d)
    {
        final int MILLI_TO_HOUR = 1000 * 60 * 60;
        int position = findDatePosition(d);

        if(position < reservations.size())
        {
            Date nextReservation = reservations.get(position);
            int diff = (int) ((nextReservation.getTime() - d.getTime()) / MILLI_TO_HOUR);
            if(diff < Restaurant.MAX_DINEHOUR)
            {
                return false;
            }
        }
        return true;
    }

    public boolean reserveForDate(Date d)
    {
        final int MILLI_TO_HOUR = 1000 * 60 * 60;
        int position = findDatePosition(d);
        int before = position - 1;
        int after = position;

        if(before >= 0)
        {
            Date previousReservation = reservations.get(before);
            int diff = (int) ((d.getTime() - previousReservation.getTime()) / MILLI_TO_HOUR);
            if(diff < Restaurant.MAX_DINEHOUR)
            {
                return false;
            }
        }

        if(after < reservations.size())
        {
            Date nextReservation = reservations.get(after);
            int diff = (int) ((nextReservation.getTime() - d.getTime()) / MILLI_TO_HOUR);
            if(diff < Restaurant.MAX_DINEHOUR)
            {
                return false;
            }
        }

        reservations.add(position, d);
        return true;
    }

    public void removeReservation(Date d)
    {
        reservations.remove(d);
    }
}

class ResReservation {
    private Table table;
    private Date date;

    public ResReservation(Table table, Date date)
    {
        this.table = table;
        this.date = date;
    }

    public Date getDate()
    {
        return date;
    }

    public Table getTable()
    {
        return table;
    }
}

public class Restaurant {
    private List<Table> tables;
    private List<Meal> menu;
    public static final int MAX_DINEHOUR = 2;
    public static final long HOUR = 3600*1000;

    public Restaurant()
    {
        tables = new ArrayList<Table>();
        menu = new ArrayList<Meal>();
    }

    public void findTable(Party p) throws NoTableException
    {
        Date currentDate = new Date();
        for(Table t: tables)
        {
            if(t.isAvailable())
            {
                if(t.getCapacity() >= p.getSize())
                {
                    if(t.noFollowReservation(currentDate))
                    {
                        t.markUnavailable();
                        return;
                    }
                }
            }
        }
        throw new NoTableException(p);
    }

    public void takeOrder(Table t, Order o)
    {
        t.setOrder(o);
    }

    public float checkOut(Table t)
    {
        float bill = 0;
        if(t.getCurrentOrder() != null)
        {
            bill = t.getCurrentOrder().getBill();
        }

        t.markAvailable();
        t.setOrder(null);

        return bill;
    }

    public List<Meal> getMenu()
    {
        return menu;
    }

    public void addTable(Table t)
    {
        tables.add(t);
        Collections.sort(tables);
    }

    public ResReservation findTableForReservation(Party p, Date date)
    {
        for(Table table : tables)
        {
            if(table.getCapacity() >= p.getSize())
            {
                if(table.reserveForDate(date))
                {
                    return new ResReservation(table, date);
                }
            }
        }
        return null;
    }

    public void cancelReservation(ResReservation r)
    {
        Date date = r.getDate();
        r.getTable().removeReservation(date);
    }

    public void redeemReservation(ResReservation r)
    {
        Date date = r.getDate();
        Table table = r.getTable();

        table.markUnavailable();
        table.removeReservation(date);
    }

    public String restaurantDescription()
    {
        String description = "";
        for(int i = 0; i < tables.size(); i++)
        {
            Table table = tables.get(i);
            description += ("Table: " + table.getId() + ", table size: " + table.getCapacity() + ", isAvailable: " + table.isAvailable() + ".");
            if(table.getCurrentOrder() == null)
                description += " No current order for this table";
            else
                description +=  " Order price: " + table.getCurrentOrder().getBill();

            description += ". Current reservation dates for this table are: ";

            for(Date date : table.getReservation())
            {
                description += date.toGMTString() + " ; ";
            }

            description += ".\n";
        }
        description += "*****************************************\n";
        return description;
    }
}