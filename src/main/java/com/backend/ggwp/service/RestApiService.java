package com.backend.ggwp.service;

import com.backend.ggwp.ApiInfo;
import com.backend.ggwp.domain.entity.AccountInfo;
import com.backend.ggwp.domain.entity.SummonerLeagueInfo;
import com.backend.ggwp.domain.entity.currentGame.CurrentGameInfo;
import com.backend.ggwp.domain.entity.match.Match;
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

    private final ApiInfo API_INFO;

    public RestApiService(ApiInfo api_info) {
        API_INFO = api_info;
    }


    public AccountInfo getAccountInfo(String summonerName){
        String apiURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+summonerName+"?api_key=" + API_INFO.getApiKey();
        StringBuffer result = restApi(apiURL);
        return new Gson().fromJson(result.toString(), AccountInfo.class);
    }

    public ArrayList<SummonerLeagueInfo> getAllSummonerLeagueInfo(String encryptedId){
        String apiURL = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + encryptedId + "?api_key=" + API_INFO.getApiKey();
        StringBuffer result = restApi(apiURL);
        return new Gson().fromJson(result.toString() , new TypeToken<ArrayList<SummonerLeagueInfo>>(){}.getType());
    }

    public ArrayList<String> getMatchIds(String puuid){
        String apiURL = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/" + puuid + "/ids?start=0&count=20&api_key=" + API_INFO.getApiKey();
        StringBuffer result = restApi(apiURL);
        return new Gson().fromJson(result.toString() , new TypeToken<ArrayList<String>>(){}.getType());
    }

    public Match getMatchInfo(String matchId){
        String apiURL = "https://asia.api.riotgames.com/lol/match/v5/matches/" + matchId + "?api_key=" + API_INFO.getApiKey();
        System.out.println("apiURL = " + apiURL);
        StringBuffer result = restApi(apiURL);
        System.out.println("result = " + result);
        Match match = new Gson().fromJson(result.toString(), Match.class);
        System.out.println("match = " + match.getInfo().getParticipants().get(0).getSummonerName());
        return match;
    }

    public CurrentGameInfo getCurrentGame(String encryptedId){
        String apiURL = "https://kr.api.riotgames.com/lol/spectator/v4/active-games/by-summoner/" + encryptedId + "?api_key="+ API_INFO.getApiKey();
        System.out.println("apiURL = " + apiURL);
        StringBuffer result = restApi(apiURL);
        System.out.println("result = " + result);
        CurrentGameInfo currentGameInfo = new Gson().fromJson(result.toString(), CurrentGameInfo.class);
        return currentGameInfo;
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
