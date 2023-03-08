package com.backend.ggwp.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringFormat {
    public static String setApiString(String s) {
        String summonerName = s.replace(" ", "");
        summonerName = summonerName.charAt(0) + "+" + summonerName.substring(1);
        return summonerName;
    }
}
