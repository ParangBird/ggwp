
package com.backend.ggwp.domain.match;

import java.util.ArrayList;
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
public class Info {

    @SerializedName("gameCreation")
    @Expose
    private Long gameCreation;
    @SerializedName("gameDuration")
    @Expose
    private Integer gameDuration;
    @SerializedName("gameEndTimestamp")
    @Expose
    private Long gameEndTimestamp;
    @SerializedName("gameId")
    @Expose
    private Long gameId;
    @SerializedName("gameMode")
    @Expose
    private String gameMode;
    @SerializedName("gameName")
    @Expose
    private String gameName;
    @SerializedName("gameStartTimestamp")
    @Expose
    private Long gameStartTimestamp;
    @SerializedName("gameType")
    @Expose
    private String gameType;
    @SerializedName("gameVersion")
    @Expose
    private String gameVersion;
    @SerializedName("mapId")
    @Expose
    private Integer mapId;
    @SerializedName("participants")
    @Expose
    private ArrayList<Participant> participants = null;
    @SerializedName("platformId")
    @Expose
    private String platformId;
    @SerializedName("queueId")
    @Expose
    private Integer queueId;
    @SerializedName("teams")
    @Expose
    private ArrayList<Team> teams = null;
    @SerializedName("tournamentCode")
    @Expose
    private String tournamentCode;

}
