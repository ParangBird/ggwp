package com.backend.ggwp.controller;

import com.backend.ggwp.domain.entity.AccountInfo;
import com.backend.ggwp.domain.entity.Summoner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mysql.cj.Session;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/search")
    public String search(Model model, HttpServletRequest request) {
        String summonerName = request.getParameter("summonerName");
        StringBuffer encrypted = new StringBuffer();
        try{
            String s = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+summonerName+"?api_key=RGAPI-fae20318-7405-4d4d-8124-42ae17aa03ac";
            StringBuilder urlBuilder =
                    new StringBuilder(s);
            System.out.println("URL :" + s);
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
                encrypted.append(line + "\n");
            }
            rd.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        AccountInfo accountInfo = gson.fromJson(encrypted.toString(), AccountInfo.class);

        System.out.println("encryptedId " + accountInfo.getId());
        String encryptedId = accountInfo.getId();
        StringBuffer result = new StringBuffer();
        try {
            StringBuilder urlBuilder =
                    new StringBuilder("https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + encryptedId + "?api_key=RGAPI-fae20318-7405-4d4d-8124-42ae17aa03ac"); /*URL*/
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

        ArrayList<Summoner> summoner = gson.fromJson(result.toString() , new TypeToken<ArrayList<Summoner>>(){}.getType());
        //System.out.println("랭크게임 : "+summoner.get(0).toString());
        //System.out.println("자유랭크게임 : "+summoner.get(1).toString());
        Summoner s = null;
        System.out.println("Summoner Size" + summoner.size());
        for(int i=0;i<summoner.size();i++){
            System.out.println(summoner.get(i).getQueueType());
            if(summoner.get(i).getQueueType().equals("RANKED_SOLO_5x5"))
                s = summoner.get(i);
        }
        System.out.println(s.getLosses());
        model.addAttribute("summoner", s);
        return "home";
    }


}
