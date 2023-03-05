
package com.backend.ggwp.domain.game.match.model;

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
public class Tower {

    @SerializedName("first")
    @Expose
    private Boolean first;
    @SerializedName("kills")
    @Expose
    private Integer kills;

}
