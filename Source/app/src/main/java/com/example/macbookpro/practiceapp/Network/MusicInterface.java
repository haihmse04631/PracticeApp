package com.example.macbookpro.practiceapp.Network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by MacbookPro on 3/26/18.
 */

public interface MusicInterface {
    @GET("api")
    Call<MusicTypeResponseJSON> getMusicType();
}
