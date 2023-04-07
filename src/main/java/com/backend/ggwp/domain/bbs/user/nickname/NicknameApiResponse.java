package com.backend.ggwp.domain.bbs.user.nickname;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NicknameApiResponse {
    @Expose
    @SerializedName("words")
    private List<String> words;

    @Expose
    @SerializedName("seeds")
    private String seeds;
}
