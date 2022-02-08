package Leetcode;

/*
* Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person.

Person A will NOT friend request person B (B != A) if any of the following conditions are true:

age[B] <= 0.5 * age[A] + 7
age[B] > age[A]
age[B] > 100 && age[A] < 100
Otherwise, A will friend request B.

Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.

How many total friend requests are made?

Example 1:

Input: [16,16]
Output: 2
Explanation: 2 people friend request each other.
Example 2:

Input: [16,17,18]
Output: 2
Explanation: Friend requests are made 17 -> 16, 18 -> 17.
Example 3:

Input: [20,30,100,110,120]
Output:
Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.


Notes:

1 <= ages.length <= 20000.
1 <= ages[i] <= 120.
* */

/*
* 解题思路:
* 把条件通过 de morgan law 转换成
*  B is in range of (0.5* A + 7, A] 并且 (B <= 100 || A >= 100)
*
*  然后用
*  1. ageCount 来count 一个年龄有几个人 （注意 >=2的时候 要减1 避免同一个人给自己发request)
*  2. for-loop 来找每一个A， 然后但凡符合条件的 B的人 A都可以发friend request，
*  3. 记住BIndex 开始到A的时候， 这个很重要， 因为map的原因 直接找到了lower 和 upper bound！！！
*
*
* */
public class L825_M {
    public int numFriendRequests(int[] ages) {
        if (ages == null || ages.length < 2) return 0;
        int friendRequests = 0;
        // age ranging from 1- 120, so create the array to store occurence of each age
        int[] ageCount = new int[121];
        for (int age: ages) {
            ageCount[age] ++;
        }

        // conver the logical expression to
        // A can send a request to B if
        // B is in range of (0.5*A + 7, A] && ( (B < 100) || ( A > 100) )
        for (int A: ages) {
            if (A < 7) continue;

            // 1 is to include the range
            int BLowerBound = A / 2 + 7;
            // we used ageCount to map
            // so BIndex mapping to age with ageCount!!!!
            for (int BIndex = BLowerBound + 1; BIndex <= A; BIndex++) {
                if (BIndex <= 100 || A >= 100) {
                    friendRequests += ageCount[BIndex];
                    if (BIndex == A) {
                        // exclude itself in case when >= 2 people with ages of A
                        friendRequests -= 1;
                    }
                }
            }

        }

        return friendRequests;

    }
}
