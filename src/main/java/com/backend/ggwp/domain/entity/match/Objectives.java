
package com.backend.ggwp.domain.entity.match;

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
public class Objectives {

    @SerializedName("baron")
    @Expose
    private Baron baron;
    @SerializedName("champion")
    @Expose
    private Champion champion;
    @SerializedName("dragon")
    @Expose
    private Dragon dragon;
    @SerializedName("inhibitor")
    @Expose
    private Inhibitor inhibitor;
    @SerializedName("riftHerald")
    @Expose
    private RiftHerald riftHerald;
    @SerializedName("tower")
    @Expose
    private Tower tower;

}
