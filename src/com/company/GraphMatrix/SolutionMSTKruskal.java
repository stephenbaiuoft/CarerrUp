package com.company.GraphMatrix;

import java.util.*;

/**
 * Created by stephen on 1/12/17.
 */

/*
class Connection{
    String node1;
    String node2;
    int cost;
    public Connection(String a, String b, int c){
        node1 = a;
        node2 = b;
        cost = c;
    }
}*/

//下面进入正题
class City_Connections {

    public ArrayList<Connection> getLowCost(ArrayList<Connection> connections) {
        //还是拿来输出
        ArrayList<Connection> result = new ArrayList<>();
        //这个是用来去重的
        Set<String> set = new HashSet<>();
        //每个string都要有个背后的string,这里用map来记录
        Map<String, String> map = new HashMap<>();
        //Kruskal算法就是先把这几条路排个序
        Collections.sort(connections, CostComparator);
        //初始化,把所有出现过的城市都加进去,同时每个城市都以自己为爹,map记录自己
        for (Connection c : connections) {
            String cityA = c.node1;
            String cityB = c.node2;
            set.add(cityA);
            set.add(cityB);
            map.put(cityA, cityA);
            map.put(cityB, cityB);
        }
        //这里其实写的简化了一点儿,对每个排出来的Connection进行检查是否成团
        for (Connection c : connections) {
            //这里把检查成环和连成环写在了一起,有点儿非主流
            //union返回true说明两个点在这次从不同联盟里面联合在了一起
            if (union(c.node1, c.node2, map)) {
                result.add(c);
            }
        }
        //如果点的个数不是比边多一条的话,那说明所有点不在同一个联盟啊
        if ((set.size() - 1) != result.size()) {
            return null; //这里不能输出空的,test case告诉我的。
        }
        Collections.sort(result, NameComparator);
        return result;
    }

    //这里其实可以拆成两个function,一个是判断是否连接,另一个是把这两个点相连
//因为模板里union返回是void
    private static boolean union(String a, String b, Map<String, String> map) {
        String aRoot = find(a, map);
        String bRoot = find(b, map);
        //这里加了个返回boolean值,就是图省事儿。
        if (aRoot.equals(bRoot)) {
            return false;
        }
        //这里是把两个点联合在了一起。
        map.put(bRoot, aRoot);
        return true;
    }

    private static String find(String a, Map<String, String> map) {
        if (a.equals(map.get(a))) {
            return a;
        }
        //这里还是图省事儿用递归去找,其实迭代写法也很容易
        String parent = find(map.get(a), map);
        //这里多了一步路径压缩,其实没啥用
        map.put(a, map.get(map.get(a)));
        return parent;
    }

    //comparator单独拎出来写,或许能稍微酷炫一点儿
    static Comparator<Connection> CostComparator = new Comparator<Connection>() {
        public int compare(Connection a, Connection b) {
            return a.cost - b.cost;
        }
    };
    static Comparator<Connection> NameComparator = new Comparator<Connection>() {
        public int compare(Connection a, Connection b) {
            if (a.node1.equals(b.node1)) {
                return a.node2.compareTo(b.node2);
            }
            return a.node1.compareTo(b.node1);
        }
    };

}

public class SolutionMSTKruskal{
    public SolutionMSTKruskal(){
        ArrayList<Connection> connections = new ArrayList<>();

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

        City_Connections run = new City_Connections();

        ArrayList<Connection> res = run.getLowCost(connections);
        for (Connection c : res){
            System.out.println(c.node1 + " -> " + c.node2 + " 需要花费大洋 : " + c.cost);
        }
    }
}

