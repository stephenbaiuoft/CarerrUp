package ByMonth.august.March;

public class L458_PoorPigs {
    // think of the 5x5 example in terms of 2 pigs
    // now, think of 5x5x5 in terms of 3 pigs !!!
    // this is why Math.pow( _, pigNum )
    // offset 1: the remaining can be checked given
    // the poison is provided for sure!!!
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int pigNum = 0;
        while( (int) Math.pow( (minutesToTest/minutesToDie +1), pigNum) < buckets){
            pigNum++;
        }

        return pigNum;
    }
}
