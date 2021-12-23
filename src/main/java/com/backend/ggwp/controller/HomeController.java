package com.backend.ggwp.controller;

import com.backend.ggwp.domain.entity.AccountInfo;
import com.backend.ggwp.domain.entity.RotationInfo;
import com.backend.ggwp.domain.entity.Summoner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    final String api_key =  "RGAPI-e4a216fa-d297-44ed-9058-a68372c41d3d";
    final String version = "11.24.1";
    @GetMapping("/")
    public String index(Model model){
        StringBuffer result = new StringBuffer();
        try { // 로테이션 챔피언 아이디 배열을 얻기 위한 여정
            StringBuilder urlBuilder =
                    new StringBuilder("https://kr.api.riotgames.com/lol/platform/v3/champion-rotations" + "?api_key=" + api_key); /*URL*/
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
        RotationInfo rotationInfo = gson.fromJson(result.toString(), RotationInfo.class);
        List<Integer> freeChampionIds = rotationInfo.getFreeChampionIds();

        ArrayList<String> freeChampionNames = new ArrayList<>();

        for(int i=0;i<freeChampionIds.size();i++){
            freeChampionNames.add(changeChampionIdToName(freeChampionIds.get(i)));
        }
        model.addAttribute("freeChampionNames1",freeChampionNames.subList(0,8));
        model.addAttribute("freeChampionNames2", freeChampionNames.subList(8,16));
        model.addAttribute("version", version);
        return "index";
        // 로테이션 챔프 이름이 담긴 배열을 건네줘야 할거 같아요
    }

    String changeChampionIdToName(Integer id){
        String name = "";
        switch(id){
            case 266:
                name = "Aatrox";break; // 챔피언 영어 이름
            case 412:
                name ="Thresh";break;
            case 23:
                name = "Tryndamere";break;
            case 147:
                name = "Seraphine"; break;
            case 526:
                name = "Rell"; break;
            case 234:
                name = "Viego"; break;
            case 887:
                name = "Gwen"; break;
            case 166:
                name = "Akshan"; break;
            case 711:
                name = "Vex";  break;
            case 79:
                name = "Gragas";break;
            case 69:
                name = "Cassiopeia";break;
            case  136:
                name = "AurelionSol";break;
            case   13:
                name = "Ryze";break;
            case   78:
                name = "Poppy";break;
            case  14:
                name = "Sion";break;
            case  1:
                name = "Annie";break;
            case  202:
                name = "Jhin";break;
            case 43:
                name = "Karma";break;
            case  111:
                name = "Nautilus";break;
            case 240:
                name = "Kled";break;
            case   99:
                name = "Lux";break;
            case  103:
                name =  "Ahri";break;
            case   2:
                name =  "Olaf";break;
            case   112:
                name =  "Viktor";break;
            case  34:
                name =  "Anivia";break;
            case   27:
                name = "Singed";break;
            case   86:
                name = "Garen";break;
            case   127:
                name = "Lissandra";break;
            case  57:
                name =    "Maokai";break;
            case  25:
                name =  "Morgana";break;
            case    28:
                name =  "Evelynn";break;
            case   105:
                name =  "Fizz";break;
            case   74:
                name =  "Heimerdinger";break;
            case   238:
                name =  "Zed";break;
            case   68:
                name =  "Rumble";break;
            case  82:
                name =  "Mordekaiser";break;
            case  37:
                name =  "Sona";break;
            case  96:
                name =  "KogMaw";break;
            case  55:
                name =  "Katarina";break;
            case  117:
                name =  "Lulu";break;
            case  22:
                name =  "Ashe";break;
            case  30:
                name =  "Karthus";break;
            case  12:
                name =  "Alistar";break;
            case  122:
                name =  "Darius";break;
            case   67:
                name = "Vayne";break;
            case  110:
                name = "Varus";break;
            case  77:
                name =  "Udyr";break;
            case  89:
                name =  "Leona";break;
            case   126:
                name = "Jayce";break;
            case   134:
                name = "Syndra";break;
            case   80:
                name =  "Pantheon";break;
            case  92:
                name = "Riven";break;
            case  121:
                name = "Khazix";break;
            case  42:
                name =  "Corki";break;
            case  268:
                name =   "Azir";break;
            case 51:
                name =   "Caitlyn";break;
            case   76:
                name =  "Nidalee";break;
            case 85:
                name =  "Kennen";break;
            case 3:
                name =  "Galio";break;
            case 45:
                name =  "Veigar";break;
            case 432:
                name =  "Bard";break;
            case 150:
                name = "Gnar";break;
            case 90:
                name =   "Malzahar";break;
            case   104:
                name =  "Graves";break;
            case  254:
                name =  "Vi";break;
            case  10:
                name =  "Kayle";break;
            case  39:
                name =  "Irelia";break;
            case  64:
                name = "LeeSin";break;
            case  420:
                name =   "Illaoi";break;
            case 60:
                name =  "Elise";break;
            case  106:
                name =  "Volibear";break;
            case 20:
                name = "Nunu";break;
            case 4:
                name =  "TwistedFate";break;
            case 24:
                name =  "Jax";break;
            case  102:
                name =  "Shyvana";break;
            case 429:
                name =  "Kalista";break;
            case 36:
                name =  "DrMundo";break;
            case 427:
                name = "Ivern";break;
            case  131:
                name = "Diana";break;
            case 63:
                name = "Brand";break;
            case 113:
                name = "Sejuani";break;
            case 8:
                name =  "Vladimir";break;
            case  154:
                name =  "Zac";break;
            case  421:
                name = "RekSai";break;
            case  133:
                name = "Quinn";break;
            case  84:
                name =  "Akali";break;
            case  163:
                name =  "Taliyah";break;
            case  18:
                name =  "Tristana";break;
            case  120:
                name =  "Hecarim";break;
            case  15:
                name = "Sivir";break;
            case  236:
                name =  "Lucian";break;
            case   107:
                name = "Rengar";break;
            case  19:
                name = "Warwick";break;
            case  72:
                name =  "Skarner";break;
            case  54:
                name = "Malphite";break;
            case  157:
                name =  "Yasuo";break;
            case  101:
                name = "Xerath";break;
            case   17:
                name = "Teemo";break;
            case  75:
                name =  "Nasus";break;
            case  58:
                name =  "Renekton";break;
            case   119:
                name =  "Draven";break;
            case  35:
                name =  "Shaco";break;
            case  50:
                name =  "Swain";break;
            case   91:
                name =  "Talon";break;
            case  40:
                name = "Janna";break;
            case   115:
                name =  "Ziggs";break;
            case   245:
                name =  "Ekko";break;
            case   61:
                name =  "Orianna";break;
            case  114:
                name = "Fiora";break;
            case  9:
                name =  "Fiddlesticks";break;
            case  31:
                name =  "ChoGath";break;
            case  33:
                name =  "Rammus";break;
            case  7:
                name =  "Leblanc";break;
            case  16:
                name =  "Soraka";break;
            case  26:
                name =  "Zilean";break;
            case  56:
                name = "Nocturne";break;
            case  222:
                name =  "Jinx";break;
            case  83:
                name = "Yorick";break;
            case  6:
                name = "Urgot";break;
            case  203:
                name =  "Kindred";break;
            case  21:
                name =  "MissFortune";break;
            case  62:
                name =  "MonkeyKing";break;
            case  53:
                name = "Blitzcrank";break;
            case   98:
                name =  "Shen";break;
            case  201:
                name =   "Braum";break;
            case  5:
                name = "XinZhao";break;
            case  29:
                name = "Twitch";break;
            case  11:
                name = "MasterYi";break;
            case  44:
                name = "Taric";break;
            case  32:
                name = "Amumu";break;
            case 41:
                name =  "Gangplank";break;
            case  48:
                name =  "Trundle";break;
            case   38:
                name = "Kassadin";break;
            case   161:
                name = "Velkoz";break;
            case   143:
                name =  "Zyra";break;
            case  267:
                name =  "Nami";break;
            case  59:
                name =  "JarvanIV";break;
            case  81:
                name =   "Ezreal";break;
            case    350:
                name =   "Yuumi";break;
            case  145:
                name =  "Kaisa";break;
            case   518:
                name = "Neeko";break;
            case   142:
                name =  "Zoe";break;
            case   498:
                name =  "Xayah";break;
            case  517:
                name =  "Sylas";break;
            case  141:
                name =   "Kayn";break;
            case   516:
                name =  "Ornn";break;
            case   555:
                name =   "Pyke";break;
            case  164:
                name =   "Camille";break;
            case   246:
                name = "Qiyana";break;
            case   497:
                name = "Rakan";break;
            case 777:
                name =  "Yone";break;
            case 876:
                name = "Lillia";break;
            case 235:
                name = "Senna";break;
            case 875:
                name = "Sett";break;
            case 523:
                name = "Aphelios";break;

            case 223:
                name = "TahmKench";break;

            case 360:
                name = "Samira";break;

            default:
                name = "null";break;


        }
        return name;
    }

    @GetMapping("/search")
    public String search(Model model, HttpServletRequest request) {
        String summonerName = request.getParameter("summonerName");
        summonerName = summonerName.replace(" ","");
        StringBuffer encrypted = new StringBuffer();
        try{ // encryptedId를 알아내기 위한 여정
            String s = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+summonerName+"?api_key=" + api_key;
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
        if(accountInfo.getId() == null)
            return "none";
        String encryptedId = accountInfo.getId();
        StringBuffer result = new StringBuffer();
        try { // 랭크정보를 알아내기 위한 여정
            StringBuilder urlBuilder =
                    new StringBuilder("https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + encryptedId + "?api_key=" + api_key); /*URL*/
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

        Summoner s = null;
        for(int i=0;i<summoner.size();i++){
            System.out.println(summoner.get(i).getQueueType());
            if(summoner.get(i).getQueueType().equals("RANKED_SOLO_5x5"))
                s = summoner.get(i);
        }
        if(s == null)
            return "none";

        model.addAttribute("summoner", s);
        return "search";
    }


}
