package com.backend.ggwp.service;

import com.backend.ggwp.domain.entity.AccountInfo;
import com.backend.ggwp.domain.entity.SummonerLeagueInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

@Service
public class RestApiService {


    final static String api_key =  "RGAPI-e4a216fa-d297-44ed-9058-a68372c41d3d";


    public AccountInfo getAccountInfo(String summonerName){
        StringBuffer result = new StringBuffer();
        String apiURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+summonerName+"?api_key=" + api_key;
        result = restApi(apiURL);
        return new Gson().fromJson(result.toString(), AccountInfo.class);
    }

    public ArrayList<SummonerLeagueInfo> getAllSummonerLeagueInfo(String encryptedId){
        StringBuffer result = new StringBuffer();
        String apiURL = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + encryptedId + "?api_key=" + api_key;
        result = restApi(apiURL);
        return new Gson().fromJson(result.toString() , new TypeToken<ArrayList<SummonerLeagueInfo>>(){}.getType());
    }

    public ArrayList<String> getMatchIds(String puuid){
        StringBuffer result = new StringBuffer();
        String apiURL = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/" + puuid + "/ids?start=0&count=20&api_key=" + api_key;
        result = restApi(apiURL);
        return new Gson().fromJson(result.toString() , new TypeToken<ArrayList<String>>(){}.getType());
    }


    public StringBuffer restApi(String apiURL){
        StringBuffer result = new StringBuffer();
        try{
            StringBuilder urlBuilder = new StringBuilder(apiURL);
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
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
