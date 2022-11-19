package com.backend.ggwp.utils;

public class StringFormat {
    public static String setApiString(String s){
        String summonerName = s;
        if(summonerName.length() == 2) summonerName = summonerName.charAt(0) + " " + summonerName.charAt(1);
        return summonerName.replace(" ","+");
    }
}
