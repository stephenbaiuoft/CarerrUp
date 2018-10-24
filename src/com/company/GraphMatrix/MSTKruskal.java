package com.company.GraphMatrix;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by stephen on 1/12/17.
 */
// MST for connections... Use Kruskal + Union_Find for edge lists for MST
// https://segmentfault.com/a/1190000007064752

class Connection{
    String node1;
    String node2;
    int cost;
    public Connection(String a, String b, int c){
        node1 = a;
        node2 = b;
        cost = c;
    }

    // for check
    public void print(){
        System.out.println( "node1 is: " + node1 + " node2 is : " + node2
        + " cost is : " + cost );
    }
}

class CompareCost implements Comparator<Connection>{
    public int compare(Connection a, Connection b){
        // this should be min queue, so smallest first
        return a.cost - b.cost;
    }
}

class CompareOutput implements Comparator<Connection>{
    public int compare(Connection a, Connection b){
        // if equal, alphabetical ordering
        if (a.cost == b.cost){
            // alphabetic ordering
            return a.node1.compareTo(b.node2);
        }
        // cost ordering
        return a.cost -b.cost;
    }
}

public class MSTKruskal {
    public MSTKruskal(){
        ArrayList<Connection> connections = new ArrayList<>();
        //这里还是一个苯环形状，有化学出身的看到这里可以鼓掌了
        connections.add(new Connection("A","B",6));
        connections.add(new Connection("B","C",4));
        connections.add(new Connection("C","D",5));
        connections.add(new Connection("D","E",8));
        connections.add(new Connection("E","F",1));
        connections.add(new Connection("B","F",10));
        connections.add(new Connection("E","C",9));
        connections.add(new Connection("F","C",7));
        connections.add(new Connection("B","E",3));
        connections.add(new Connection("A","F",1));


        getLowestCost(connections);
    }

    // return a list of lowest input cost connections
    public void getLowestCost ( ArrayList<Connection> inputConnections){
        CompareCost mCostComparator = new CompareCost();
        inputConnections.sort(mCostComparator);

        // map to remove duplicate node names
        HashSet map = new HashSet<String>();
        HashMap parent = new HashMap<String, String>();
        ArrayList<Connection> mResult = new ArrayList<Connection>();

        // Remeber Union_Find?
        for( Connection connection : inputConnections){
            map.add(connection.node1);
            map.add(connection.node2);

            // HashMap simply refreshes upon duplicate keys
            // node1-> node1, means it has not been added yet
            parent.put(connection.node1, connection.node1);
            parent.put(connection.node2, connection.node2);
        }

        for( Connection connection: inputConnections){
            // add to mResult
            if ( Union(connection.node1, connection.node2, parent)){
                mResult.add(connection);
            }
        }
        if ( mResult.size() != map.size() -1 ){
            // Note MST has for sure
            // E = V - 1
            System.out.println("More Vertice then edges, not fully connected");
        }

        CompareOutput mOutputComparator = new CompareOutput();
        mResult.sort( mOutputComparator);

        for ( Connection conn : mResult){
            conn.print();
        }

    }


    // return the parent testing.string of the input
    public String findParent( String node1, HashMap parent ){
        if( parent.get(node1) == node1 ){
            return node1;
        }
        return  findParent((String) parent.get(node1), parent);
    }

    // true if no cycle for added eduge
    public boolean Union( String node1, String node2, HashMap parent ){
        String node1Set = findParent(node1, parent);
        String node2Set = findParent(node2, parent);
        if (node1Set == node2Set){
            // cannot add this edge, return false
            return false;
        }

        // now node2Set is node1Set parent
        parent.put(node1Set, node2Set);
        return true;

    }


}
