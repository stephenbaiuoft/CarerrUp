import com.company.OA2.KClostPoint;

import java.util.*;

public class TestSpace {
    // testing Java signatures and etc.

    /**
     * Business class that consists of a business name and a hashmap of nearby businesses.
     */
    class Business {
        /**
         * The name of the business.
         */
        String name;

        /**
         * A Map of nearbyBusinesses where the key is the nearby Business object
         * and the value is distance from the current Business to the nearby Business.
         */
        Map<Business, Integer> nearbyBusinesses;

        public Business(String name) {
            this.name = name;
            this.nearbyBusinesses = new HashMap<Business, Integer>();
        }

        public String getName() {
            return this.name;
        }

        public Map<Business, Integer> getNearbyBusinesses() {
            return this.nearbyBusinesses;
        }
    }


        public List<String> findReachableBusinesses(Business startingBusiness, int distance) {
            // TODO: COMPLETE ME
            // BFS question with distance
            // sanity check
            if (startingBusiness == null || distance < 0) {
                return new ArrayList<>();
            }

            HashSet<Business> visited = new HashSet<>(); // visited --> keep track
            List<String> list = new ArrayList<>()    ;
            dfs(startingBusiness, 0, distance, list, visited);

            //
            list.remove(0); // remove the startingBusiness logic
            return list;
        }

        private  void dfs(Business business, int cur, int distance,
                                List<String> list, HashSet<Business> visited) {
            if (visited.contains(business) || cur > distance) {
                return;
            }

            if (cur < distance) {
                list.add(business.getName());
            }

            visited.add(business);

            Map<Business, Integer> m = business.getNearbyBusinesses();

            for(Map.Entry<Business, Integer> entry: business.getNearbyBusinesses().entrySet() ) {
                dfs(entry.getKey(), entry.getValue() + cur, distance,
                        list, visited);
            }
            visited.remove(business);
        }


        public static void main(String[] args) {

            Comparator<Integer> c = new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return 0;
                }
            };
        }

    public double run(double[][] readings, long endTime) {
        // Type your solution here
        Arrays.sort(readings);

        double curTime = 0.0;
        double dis = 0;
        int index = 1;

        double timeMark = 0.0;
        double prevSpeed = readings[0][1];
        while (curTime < endTime && index < readings.length ) {
            timeMark = readings[index][0];

            if (curTime <= timeMark) {
                prevSpeed = readings[index-1][1];

                dis = dis + prevSpeed * (timeMark - curTime);
                curTime = timeMark;
                // update index value to find the next timeMark
                index ++;
            }
        }

        if (curTime < endTime) { // index updated until out of boundary
            prevSpeed = readings[readings.length-1][1];
            dis = dis + prevSpeed * (endTime - curTime);
        } else { // curTime > endTime,  compensate for the extra added dist
            dis = dis - prevSpeed * (curTime - endTime);
        }

        return dis;
    }

    // hour to seconds


}
