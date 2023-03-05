
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
public class Champion {

    @SerializedName("first")
    @Expose
    private Boolean first;
    @SerializedName("kills")
    @Expose
    private Integer kills;

}
