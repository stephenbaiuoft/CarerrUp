package com.company;

/**
 * Created by stephenbai on 2016-10-24.
 */

/*
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class BusinessInfo implements Comparable<BusinessInfo> {
    int id;
    double rating;

    public BusinessInfo(int id, double rating) {
        this.id = id;
        this.rating = rating;
    }

    public int compareTo(BusinessInfo b1) {
        if (this.rating < b1.rating) {
            return -1;
        }
        if (this.rating > b1.rating) {
            return 1;
        }
        return 0;
    }
}

class Solution {

//
//      List of business info data where each element is a BusinessInfo object
//      containing id and rating. Determine the median rating across all
//      businesses in businessInfoList.
//
//      @param businessInfoList List of business info objects where BusinessInfo
//          is a class containing id and rating.
//
//      @return Median rating of all businesses
//
    public static double calculateMedianRating(List<BusinessInfo> businessInfoList) {

        Hashtable<Double, Integer> hashtable = new Hashtable<>();

        for (BusinessInfo info: businessInfoList ){
            if (hashtable.containsKey(info.rating) ){
                hashtable.put(info.rating, hashtable.get(info.rating) + 1);
            }else{
                hashtable.put(info.rating, 0);
            }
        }


        //hashtable.keys();


        //TODO: COMPLETE ME
    }

    public static void LintMain(String[] args) {
        String line;
        List<BusinessInfo> businessInfoList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                businessInfoList.add(
                        new BusinessInfo(
                                Integer.parseInt(parts[0]),
                                Double.parseDouble(parts[1])
                        )
                );
            }

            double medianRating = calculateMedianRating(businessInfoList);
            System.out.println(medianRating);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}*/
