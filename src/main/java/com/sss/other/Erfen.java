package com.sss.other;

public class Erfen {


    public static int a(int[] array, int start, int end, int findValue){
        if(array == null){
            return -1;
        }
        if(start <= end){
            int middle = (start + end)/2;
            int middleVal = array[middle];
            if(middleVal == findValue){
                return middle;
            }else if (middleVal > findValue){
                return a(array,start,middle-1,findValue);
            }else{
                return a(array,middle+1,end,findValue);
            }
        }else{
            return -1;
        }
    }
}
