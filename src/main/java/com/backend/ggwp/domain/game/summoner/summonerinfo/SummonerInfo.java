package com.backend.ggwp.domain.game.summoner.summonerinfo;

import com.backend.ggwp.domain.time.BaseTimeEntity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "SUMMONER_INFO")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SummonerInfo extends BaseTimeEntity {

    @Expose(serialize = false, deserialize = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long summonerInfoId;

    @SerializedName("id")
    private String summonerId;
    private String accountId;
    private String puuid;
    private String name;
    private Integer profileIconId;
    private Long revisionDate;
    private Integer summonerLevel;
}
