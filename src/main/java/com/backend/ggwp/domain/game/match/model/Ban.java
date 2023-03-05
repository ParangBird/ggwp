
package com.backend.ggwp.domain.game.match.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
@Getter
@Setter
@NoArgsConstructor
public class Ban {

    @SerializedName("championId")
    @Expose
    private Integer championId;
    @SerializedName("pickTurn")
    @Expose
    private Integer pickTurn;

}
