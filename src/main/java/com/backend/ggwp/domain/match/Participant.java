
package com.backend.ggwp.domain.match;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Generated("jsonschema2pojo")
@Getter
@Setter
@NoArgsConstructor
public class Participant {

    @SerializedName("assists")
    @Expose
    private Integer assists;
    @SerializedName("baronKills")
    @Expose
    private Integer baronKills;
    @SerializedName("bountyLevel")
    @Expose
    private Integer bountyLevel;
    @SerializedName("champExperience")
    @Expose
    private Integer champExperience;
    @SerializedName("champLevel")
    @Expose
    private Integer champLevel;
    @SerializedName("championId")
    @Expose
    private Integer championId;
    @SerializedName("championName")
    @Expose
    private String championName;
    @SerializedName("championTransform")
    @Expose
    private Integer championTransform;
    @SerializedName("consumablesPurchased")
    @Expose
    private Integer consumablesPurchased;
    @SerializedName("damageDealtToBuildings")
    @Expose
    private Integer damageDealtToBuildings;
    @SerializedName("damageDealtToObjectives")
    @Expose
    private Integer damageDealtToObjectives;
    @SerializedName("damageDealtToTurrets")
    @Expose
    private Integer damageDealtToTurrets;
    @SerializedName("damageSelfMitigated")
    @Expose
    private Integer damageSelfMitigated;
    @SerializedName("deaths")
    @Expose
    private Integer deaths;
    @SerializedName("detectorWardsPlaced")
    @Expose
    private Integer detectorWardsPlaced;
    @SerializedName("doubleKills")
    @Expose
    private Integer doubleKills;
    @SerializedName("dragonKills")
    @Expose
    private Integer dragonKills;
    @SerializedName("firstBloodAssist")
    @Expose
    private Boolean firstBloodAssist;
    @SerializedName("firstBloodKill")
    @Expose
    private Boolean firstBloodKill;
    @SerializedName("firstTowerAssist")
    @Expose
    private Boolean firstTowerAssist;
    @SerializedName("firstTowerKill")
    @Expose
    private Boolean firstTowerKill;
    @SerializedName("gameEndedInEarlySurrender")
    @Expose
    private Boolean gameEndedInEarlySurrender;
    @SerializedName("gameEndedInSurrender")
    @Expose
    private Boolean gameEndedInSurrender;
    @SerializedName("goldEarned")
    @Expose
    private Integer goldEarned;
    @SerializedName("goldSpent")
    @Expose
    private Integer goldSpent;
    @SerializedName("individualPosition")
    @Expose
    private String individualPosition;
    @SerializedName("inhibitorKills")
    @Expose
    private Integer inhibitorKills;
    @SerializedName("inhibitorTakedowns")
    @Expose
    private Integer inhibitorTakedowns;
    @SerializedName("inhibitorsLost")
    @Expose
    private Integer inhibitorsLost;
    @SerializedName("item0")
    @Expose
    private Integer item0;
    @SerializedName("item1")
    @Expose
    private Integer item1;
    @SerializedName("item2")
    @Expose
    private Integer item2;
    @SerializedName("item3")
    @Expose
    private Integer item3;
    @SerializedName("item4")
    @Expose
    private Integer item4;
    @SerializedName("item5")
    @Expose
    private Integer item5;
    @SerializedName("item6")
    @Expose
    private Integer item6;
    @SerializedName("itemsPurchased")
    @Expose
    private Integer itemsPurchased;
    @SerializedName("killingSprees")
    @Expose
    private Integer killingSprees;
    @SerializedName("kills")
    @Expose
    private Integer kills;
    @SerializedName("lane")
    @Expose
    private String lane;
    @SerializedName("largestCriticalStrike")
    @Expose
    private Integer largestCriticalStrike;
    @SerializedName("largestKillingSpree")
    @Expose
    private Integer largestKillingSpree;
    @SerializedName("largestMultiKill")
    @Expose
    private Integer largestMultiKill;
    @SerializedName("longestTimeSpentLiving")
    @Expose
    private Integer longestTimeSpentLiving;
    @SerializedName("magicDamageDealt")
    @Expose
    private Integer magicDamageDealt;
    @SerializedName("magicDamageDealtToChampions")
    @Expose
    private Integer magicDamageDealtToChampions;
    @SerializedName("magicDamageTaken")
    @Expose
    private Integer magicDamageTaken;
    @SerializedName("neutralMinionsKilled")
    @Expose
    private Integer neutralMinionsKilled;
    @SerializedName("nexusKills")
    @Expose
    private Integer nexusKills;
    @SerializedName("nexusLost")
    @Expose
    private Integer nexusLost;
    @SerializedName("nexusTakedowns")
    @Expose
    private Integer nexusTakedowns;
    @SerializedName("objectivesStolen")
    @Expose
    private Integer objectivesStolen;
    @SerializedName("objectivesStolenAssists")
    @Expose
    private Integer objectivesStolenAssists;
    @SerializedName("participantId")
    @Expose
    private Integer participantId;
    @SerializedName("pentaKills")
    @Expose
    private Integer pentaKills;
    @SerializedName("perks")
    @Expose
    private Perks perks;
    @SerializedName("physicalDamageDealt")
    @Expose
    private Integer physicalDamageDealt;
    @SerializedName("physicalDamageDealtToChampions")
    @Expose
    private Integer physicalDamageDealtToChampions;
    @SerializedName("physicalDamageTaken")
    @Expose
    private Integer physicalDamageTaken;
    @SerializedName("profileIcon")
    @Expose
    private Integer profileIcon;
    @SerializedName("puuid")
    @Expose
    private String puuid;
    @SerializedName("quadraKills")
    @Expose
    private Integer quadraKills;
    @SerializedName("riotIdName")
    @Expose
    private String riotIdName;
    @SerializedName("riotIdTagline")
    @Expose
    private String riotIdTagline;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("sightWardsBoughtInGame")
    @Expose
    private Integer sightWardsBoughtInGame;
    @SerializedName("spell1Casts")
    @Expose
    private Integer spell1Casts;
    @SerializedName("spell2Casts")
    @Expose
    private Integer spell2Casts;
    @SerializedName("spell3Casts")
    @Expose
    private Integer spell3Casts;
    @SerializedName("spell4Casts")
    @Expose
    private Integer spell4Casts;
    @SerializedName("summoner1Casts")
    @Expose
    private Integer summoner1Casts;
    @SerializedName("summoner1Id")
    @Expose
    private Integer summoner1Id;
    @SerializedName("summoner2Casts")
    @Expose
    private Integer summoner2Casts;
    @SerializedName("summoner2Id")
    @Expose
    private Integer summoner2Id;
    @SerializedName("summonerId")
    @Expose
    private String summonerId;
    @SerializedName("summonerLevel")
    @Expose
    private Integer summonerLevel;
    @SerializedName("summonerName")
    @Expose
    private String summonerName;
    @SerializedName("teamEarlySurrendered")
    @Expose
    private Boolean teamEarlySurrendered;
    @SerializedName("teamId")
    @Expose
    private Integer teamId;
    @SerializedName("teamPosition")
    @Expose
    private String teamPosition;
    @SerializedName("timeCCingOthers")
    @Expose
    private Integer timeCCingOthers;
    @SerializedName("timePlayed")
    @Expose
    private Integer timePlayed;
    @SerializedName("totalDamageDealt")
    @Expose
    private Integer totalDamageDealt;
    @SerializedName("totalDamageDealtToChampions")
    @Expose
    private Integer totalDamageDealtToChampions;
    @SerializedName("totalDamageShieldedOnTeammates")
    @Expose
    private Integer totalDamageShieldedOnTeammates;
    @SerializedName("totalDamageTaken")
    @Expose
    private Integer totalDamageTaken;
    @SerializedName("totalHeal")
    @Expose
    private Integer totalHeal;
    @SerializedName("totalHealsOnTeammates")
    @Expose
    private Integer totalHealsOnTeammates;
    @SerializedName("totalMinionsKilled")
    @Expose
    private Integer totalMinionsKilled;
    @SerializedName("totalTimeCCDealt")
    @Expose
    private Integer totalTimeCCDealt;
    @SerializedName("totalTimeSpentDead")
    @Expose
    private Integer totalTimeSpentDead;
    @SerializedName("totalUnitsHealed")
    @Expose
    private Integer totalUnitsHealed;
    @SerializedName("tripleKills")
    @Expose
    private Integer tripleKills;
    @SerializedName("trueDamageDealt")
    @Expose
    private Integer trueDamageDealt;
    @SerializedName("trueDamageDealtToChampions")
    @Expose
    private Integer trueDamageDealtToChampions;
    @SerializedName("trueDamageTaken")
    @Expose
    private Integer trueDamageTaken;
    @SerializedName("turretKills")
    @Expose
    private Integer turretKills;
    @SerializedName("turretTakedowns")
    @Expose
    private Integer turretTakedowns;
    @SerializedName("turretsLost")
    @Expose
    private Integer turretsLost;
    @SerializedName("unrealKills")
    @Expose
    private Integer unrealKills;
    @SerializedName("visionScore")
    @Expose
    private Integer visionScore;
    @SerializedName("visionWardsBoughtInGame")
    @Expose
    private Integer visionWardsBoughtInGame;
    @SerializedName("wardsKilled")
    @Expose
    private Integer wardsKilled;
    @SerializedName("wardsPlaced")
    @Expose
    private Integer wardsPlaced;
    @SerializedName("win")
    @Expose
    private Boolean win;

}
