
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
public class StatPerks {

    @SerializedName("defense")
    @Expose
    private Integer defense;
    @SerializedName("flex")
    @Expose
    private Integer flex;
    @SerializedName("offense")
    @Expose
    private Integer offense;

}
