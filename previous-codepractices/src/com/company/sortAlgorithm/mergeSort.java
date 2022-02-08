package com.company.sortAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by stephenbai on 2016-10-29.
 */
/*
*         mergeSort test = new mergeSort();
        String inputTest = "1 384\n" +
                "930887 692778 636916 747794 238336 885387 760493 516650 641422 202363 490028 368691 520060 897764 513927 180541 383427 89173 455737 5212 595369 702568 956430 465783 21531 722863 665124 174068 703136 513930 979803 634023 723059 133070 898168 961394 18457 175012 478043 176230 377374 484422 544920 413785 898538 575199 594325 798316 664371 566414 803527 776092 268981 759957 241874 806863 999171 906997 497282 702306 420926 477085 336328 660337 126506 750847 621730 661314 925858 616125 353896 819583 100546 898815 233368 515435 990365 344044 313751 171088 426809 117277 947179 695789 393585 705404 502652 392755 612400 999933 95061 549677 993369 947740 210013 636227 698587 348095 297540 140796 480571 651435 960379 97468 66602 710098 612903 573318 570493 926653 260757 997302 560281 724287 209442 953866 429690 228445 346620 558441 744730 958032 108118 738098 905772 834482 890676 120710 698928 704568 777857 179498 872354 254587 276966 455307 964684 406220 28625 51529 332872 805733 48830 409504 530020 258271 363369 959709 486716 226341 518150 747797 700724 142619 2246 122847 493452 892922 243556 192380 597489 537765 888229 469842 792351 165194 441501 757035 87765 470125 324915 936988 275857 373744 346492 322228 148366 709860 281937 151433 452552 316438 899229 153276 975408 901475 276122 468859 794396 36030 661238 908236 573794 65819 894429 366144 231012 335929 639530 318777 322405 964444 255764 114614 854539 118607 436841 2905 344819 235129 670689 797370 67918 569918 466997 43325 987744 259471 512184 298491 295500 689773 206726 385645 755591 617506 268140 502955 469787 907670 338083 308543 388465 110198 939508 759356 228805 376349 278612 573623 127829 949300 887344 195747 35569 354341 755423 23312 613811 267606 321802 425662 473731 44879 811306 229321 178737 79445 248627 648523 503466 586709 473417 408283 213259 412925 167638 442063 305625 962601 532037 433453 911900 419380 145551 947469 290072 900974 487132 903882 684931 808934 845895 158661 370164 657200 387982 548900 252997 152960 713774 272814 739669 187191 681096 952927 116467 365085 911341 422091 327685 443377 855543 755937 379108 517446 219757 669180 418419 706888 89413 103349 32173 451660 262010 402337 625211 166343 467588 878207 319302 697714 667373 575322 401256 864820 44600 517722 229905 955940 939812 73941 915668 311706 346229 811128 829151 565985 996659 763921 789225 602423 867270 821397 54082 645631 740085 679293 811973 207673 73851 647626 905386 741223 739300 306641 606043 783899 340714 352299 256191 280525 942591 688210 108582 288820 499337 937733 371156 495995 218005 " +
                "160380 614770 85274 981777 668851 247256 721861 348143 575580 445885 421994 223206 867622";
        String input = "1 13 160380 614770 85274 981777 668851 247256 721861 348143" +
                " 575580 445885 421994 223206 867622";
        test.sort(input);
*
*
*
* */

    // counting inversions with mergeSort!!
    // note when mergesplits, if a_i is greater than a_j, then it takes
    // (m - i + 1 ) elements are out of order [ i denotes left and j denotes right]
public class mergeSort {
    public int [] tempAry;


    public void sort(String input){
        Scanner in = new Scanner(input);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            //create a temp holding ary
            tempAry = new int[arr.length];

            // end is the ending index every time...so i dont need to check out of bound
            int countInversion = mergeSort(arr, 0, arr.length - 1);
            // print array
            HelperTool h = new HelperTool();
            if (h.verifySorted(arr)){
                System.out.println("countInversion is: " + countInversion);
                System.out.println(Arrays.toString(arr));
            }
            else{
                System.out.println("mergeSort did not sort properly");
                System.out.println(Arrays.toString(arr));
            }
            /*
           while( it < arr.length  ){
             it++;
               System.out.println( arr[it]);
           }*/
        }
    }

    public int mergeSort(int[] ary, int begin, int end){
        int countInversion = 0;

        //int left = 0;
        //int right = 0 ;
        int middle = (begin + end)  / 2;
        if( begin < end) {
            countInversion += mergeSort(ary, begin, middle);
            countInversion += mergeSort(ary, middle+1, end);
            countInversion += mergeSplits(ary, begin ,middle, end);
        }
        return countInversion ;//+ left + right;
    }

    public int mergeSplits(int[]ary, int begin, int middle,int end){
        int countInversion = 0;
        int i = begin;
        int j = middle + 1 ;
        // ary is constantly updated and always refreshes tempAry
        this.tempAry = Arrays.copyOf(ary, end + 1 );
        boolean docheck = true;
        // up to last index
        for( int k = begin; k<=end; k++ ){
            // this takes too much for checking condition
            // j > end means j is done
            if ((j>end)||(i<=middle)&&
                    (tempAry[i]<=tempAry[j])){
                ary[k] = tempAry[i];
                i++;
            }else{
                if( (i<=middle) &&(j<=end) ){
                    countInversion += middle -  i + 1;
                }
                ary[k] = tempAry[j];
                j++;
            }

        }
        return countInversion;

    }

    public int riemann(int end){
        int sum = 0;
        while(end>0){
            sum+=end;
            end--;
        }
        return sum;
    }

}
