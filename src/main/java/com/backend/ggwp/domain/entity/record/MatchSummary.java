package com.backend.ggwp.domain.entity.record;

import lombok.*;

import javax.persistence.*;

@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MatchSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer queueId;
    private String matchId;
    private Long gameEndTimestamp;
    private String name;
    private String champ;
    private String blueChamp1;
    private String blueChamp2;
    private String blueChamp3;
    private String blueChamp4;
    private String blueChamp5;
    private String redChamp1;
    private String redChamp2;
    private String redChamp3;
    private String redChamp4;
    private String redChamp5;
    private Integer perkMain;
    private Integer perkSub;
    private Integer spell1;
    private Integer spell2;
    private Integer level;
    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private Integer time;
    private Integer cs;
    private Integer totalKill;
    private Integer item0;
    private Integer item1;
    private Integer item2;
    private Integer item3;
    private Integer item4;
    private Integer item5;
    private Integer item6;
    private Boolean win;
}
