
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
public class Perks {

    @SerializedName("statPerks")
    @Expose
    private StatPerks statPerks;
    @SerializedName("styles")
    @Expose
    private ArrayList<Style> styles = null;

}
