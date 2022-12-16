
package com.backend.ggwp.domain.match;

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
public class Selection {

    @SerializedName("perk")
    @Expose
    private Integer perk;
    @SerializedName("var1")
    @Expose
    private Integer var1;
    @SerializedName("var2")
    @Expose
    private Integer var2;
    @SerializedName("var3")
    @Expose
    private Integer var3;

}
