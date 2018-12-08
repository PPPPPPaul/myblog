package com.lk.utils;

public class StringTool {
    public static int[] stringToArray(String str){
        String[] tagArrays = str.split(",");
        int[] intTagArrays = new int[tagArrays.length];
        for (int i=0;i<tagArrays.length;i++){
            intTagArrays[i]=Integer.parseInt(tagArrays[i]);
        }
        return intTagArrays;
    }
}
