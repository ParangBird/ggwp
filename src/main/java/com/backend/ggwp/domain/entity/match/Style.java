
package com.backend.ggwp.domain.entity.match;

import java.util.ArrayList;
import java.util.List;
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
public class Style {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("selections")
    @Expose
    private ArrayList<Selection> selections = null;
    @SerializedName("style")
    @Expose
    private Integer style;

}
