package com.backend.ggwp.restapi;

import com.backend.ggwp.config.ApiInfo;
import com.backend.ggwp.domain.summoner.AccountInfo;
import com.backend.ggwp.domain.summoner.SummonerLeagueInfo;
import com.backend.ggwp.domain.currentGame.CurrentGameInfo;
import com.backend.ggwp.domain.leagueitem.LeagueItem;
import com.backend.ggwp.domain.leagueitem.LeagueList;
import com.backend.ggwp.domain.match.Match;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

@Slf4j
@Service
public class RestApiService {

    private final ApiInfo API_INFO;

    public RestApiService(ApiInfo api_info) {
        API_INFO = api_info;
    }

    public RotationInfo getRotationInfo(){
        String apiURL = "https://kr.api.riotgames.com/lol/platform/v3/champion-rotations?api_key=" + API_INFO.getApiKey();
        StringBuffer result = restApi(apiURL);
        return new Gson().fromJson(result.toString(), RotationInfo.class);
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
        String apiURL = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/" + puuid + "/ids?start=0&count=30&api_key=" + API_INFO.getApiKey();
        //log.info("GET RECENT MATCH API : {}", apiURL);
        StringBuffer result = restApi(apiURL);
        return new Gson().fromJson(result.toString() , new TypeToken<ArrayList<String>>(){}.getType());
    }

    public ArrayList<String> getSoloMatchIds(String puuid){
        String apiURL = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/" + puuid + "/ids?queue=420&start=0&count=30&api_key=" + API_INFO.getApiKey();
        StringBuffer result = restApi(apiURL);
        return new Gson().fromJson(result.toString() , new TypeToken<ArrayList<String>>(){}.getType());
    }

    public Match getMatchInfo(String matchId){
        String apiURL = "https://asia.api.riotgames.com/lol/match/v5/matches/" + matchId + "?api_key=" + API_INFO.getApiKey();
        StringBuffer result = restApi(apiURL);
        //log.info("MATCH INFO : {}", result.toString());
        Match match = new Gson().fromJson(result.toString(), Match.class);
        return match;
    }

    public CurrentGameInfo getCurrentGame(String encryptedId){
        String apiURL = "https://kr.api.riotgames.com/lol/spectator/v4/active-games/by-summoner/" + encryptedId + "?api_key="+ API_INFO.getApiKey();
        //System.out.println("apiURL = " + apiURL);
        StringBuffer result = restApi(apiURL);
        //System.out.println("result = " + result);
        CurrentGameInfo currentGameInfo = new Gson().fromJson(result.toString(), CurrentGameInfo.class);
        return currentGameInfo;
    }

    public LeagueList getChallengerList(){
        String apiURL = "https://kr.api.riotgames.com/lol/league/v4/challengerleagues/by-queue/RANKED_SOLO_5x5?api_key=" + API_INFO.getApiKey();
        StringBuffer result = restApi(apiURL);
        LeagueList challengerList = new Gson().fromJson(result.toString() , LeagueList.class);
        for(LeagueItem c : challengerList.getEntries())
            c.setSummonerRank("Challenger");
        return challengerList;
    }

    public LeagueList getGrandMasterList(){
        String apiURL = "https://kr.api.riotgames.com/lol/league/v4/grandmasterleagues/by-queue/RANKED_SOLO_5x5?api_key=" + API_INFO.getApiKey();
        StringBuffer result = restApi(apiURL);
        LeagueList grandMasterList = new Gson().fromJson(result.toString() , LeagueList.class);
        for(LeagueItem gm : grandMasterList.getEntries())
            gm.setSummonerRank("GrandMaster");
        return grandMasterList;
    }


    public LeagueList getMasterList(){
        String apiURL = "https://kr.api.riotgames.com/lol/league/v4/masterleagues/by-queue/RANKED_SOLO_5x5?api_key=" + API_INFO.getApiKey();
        StringBuffer result = restApi(apiURL);
        LeagueList masterList = new Gson().fromJson(result.toString() , LeagueList.class);
        for(LeagueItem m : masterList.getEntries())
            m.setSummonerRank("Master");
        return masterList;

    }

    public ArrayList<LeagueEntrySummonerList> getChallengerListSortedByScore(){

        ArrayList<ArrayList<LeagueEntrySummonerList>> challengerListAll = new ArrayList<>();

        int page = 1;
        while(true){
            String apiURL = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/CHALLENGER/I?page=" + page++ + "&api_key=" + API_INFO.getApiKey();
            StringBuffer result = restApi(apiURL);
            System.out.println("result = " + result);
            System.out.println("result.length() = " + result.length());
            if(result == null || result.length() == 0 || result.length() == 3) {
                break;
            }
            ArrayList<LeagueEntrySummonerList> challengerList = new Gson().fromJson(result.toString(), new TypeToken<ArrayList<LeagueEntrySummonerList>>(){}.getType());
            challengerListAll.add(challengerList);
        }

        ArrayList<LeagueEntrySummonerList> challengerList = new ArrayList<>();

        for(int i=0;i<challengerListAll.size();i++){
            for(int j=0;j<challengerListAll.get(i).size();j++){
                challengerList.add(challengerListAll.get(i).get(j));
            }
        }
        return challengerList;
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