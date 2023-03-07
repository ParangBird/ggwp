package com.backend.ggwp.domain.game.summoner.leagueentry;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;

@Getter
@Setter
@NoArgsConstructor
@Generated("jsonschema2pojo")
public class LeagueEntry {
    @SerializedName("leagueId")
    @Expose
    private String leagueId;
    @SerializedName("queueType")
    @Expose
    private String queueType;
    @SerializedName("tier")
    @Expose
    private String tier;
    @SerializedName("rank")
    @Expose
    private String rank;
    @SerializedName("summonerId")
    @Expose
    private String summonerId;
    @SerializedName("summonerName")
    @Expose
    private String summonerName;
    @SerializedName("leaguePoints")
    @Expose
    private Integer leaguePoints;
    @SerializedName("wins")
    @Expose
    private Integer wins;
    @SerializedName("losses")
    @Expose
    private Integer losses;
    @SerializedName("veteran")
    @Expose
    private Boolean veteran;
    @SerializedName("inactive")
    @Expose
    private Boolean inactive;
    @SerializedName("freshBlood")
    @Expose
    private Boolean freshBlood;
    @SerializedName("hotStreak")
    @Expose
    private Boolean hotStreak;
}
