package com.backend.ggwp.controller;

import com.backend.ggwp.domain.entity.Summoner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("")
    public String home(){
        return "home";
    }

    @GetMapping("/search")
    public String search(){
        return "";
    }

    @GetMapping("/test")
    @ResponseBody
    public String allowBasic() {
        StringBuffer result = new StringBuffer();
        try {
            StringBuilder urlBuilder =
                    new StringBuilder("https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/DWnLR_opsOgnM8lwLXb4LLk_WcIgqdPo6Lr9DWUYnqHp0g?api_key=RGAPI-75e1dcb1-1e41-4450-b1a8-80b1af396592"); /*URL*/
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line + "\n");
            }
            rd.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();

        }

        Gson gson = new Gson();
        ArrayList<Summoner> summoner = gson.fromJson(result.toString() , new TypeToken<ArrayList<Summoner>>(){}.getType());
        //System.out.println("랭크게임 : "+summoner.get(0).toString());
        //System.out.println("자유랭크게임 : "+summoner.get(1).toString());
        return result + "";
    }


}
