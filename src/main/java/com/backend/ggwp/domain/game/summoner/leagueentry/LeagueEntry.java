package com.backend.ggwp.domain.game.summoner.leagueentry;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Table(name = "league_entry", indexes = @Index(name = "idx_summoner_id", columnList = "summonerId"))
@Getter
@Setter
@NoArgsConstructor
@Generated("jsonschema2pojo")
public class LeagueEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose(serialize = false, deserialize = false)
    private Long id;

    @SerializedName("leagueId")
    @Expose
    private String leagueId;
    @SerializedName("queueType")
    @Expose
    private String queueType;
    @SerializedName("tier")
    @Expose
    private String tier;
    @Column(name = "summoner_rank")
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

    public void update(LeagueEntry leagueEntry) {
        this.freshBlood = leagueEntry.freshBlood;

    }
}
