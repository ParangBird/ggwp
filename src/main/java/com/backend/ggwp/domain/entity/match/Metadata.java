
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
public class Metadata {

    @SerializedName("dataVersion")
    @Expose
    private String dataVersion;
    @SerializedName("matchId")
    @Expose
    private String matchId;
    @SerializedName("participants")
    @Expose
    private ArrayList<String> participants = null;

}
