
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
public class Match {

    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("info")
    @Expose
    private Info info;

}
