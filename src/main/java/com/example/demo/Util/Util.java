package com.example.demo.Util;


/**
 * Util used for utilities that support other function
 */
public class Util {

    /**
     * This method used for return a string which is a repetition of num times
     * @param num
     * @param words
     * @return
     */
    public static String generateStringTimes(int num, String words){
        String res ;
        StringBuilder stringBuilder = new StringBuilder();
        for (int x = 0 ; x < num  ; x++){
            stringBuilder.append(words);
        }
        res = stringBuilder.toString();
        return res;

    }


}
