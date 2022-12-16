
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
public class Team {

    @SerializedName("bans")
    @Expose
    private ArrayList<Ban> bans = null;
    @SerializedName("objectives")
    @Expose
    private Objectives objectives;
    @SerializedName("teamId")
    @Expose
    private Integer teamId;
    @SerializedName("win")
    @Expose
    private Boolean win;

}
