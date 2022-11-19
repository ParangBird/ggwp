package com.backend.ggwp.domain.leagueitem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@Generated("jsonschema2pojo")
public class LeagueList {
    @SerializedName("tier")
    @Expose
    private String tier;
    @SerializedName("leagueId")
    @Expose
    private String leagueId;
    @SerializedName("queue")
    @Expose
    private String queue;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("entries")
    @Expose
    private ArrayList<LeagueItem> entries = null;

}
