package com.backend.ggwp.domain.entity.leagueList;

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
public class LeagueItem {
    @SerializedName("summonerId")
    @Expose
    private String summonerId;
    @SerializedName("summonerName")
    @Expose
    private String summonerName;
    @SerializedName("leaguePoints")
    @Expose
    private Integer leaguePoints;
    @SerializedName("rank")
    @Expose
    private String rank;
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
