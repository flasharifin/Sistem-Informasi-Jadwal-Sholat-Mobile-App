package com.mochamad_arifin.sholatyuk.api;

import com.mochamad_arifin.sholatyuk.model.request.LoginRequest;
import com.mochamad_arifin.sholatyuk.model.response.LoginResponse;
import com.mochamad_arifin.sholatyuk.model.response.PrayerTimeResponses;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by mochamad arifin on 24/11/2018.
 * github   :   https://github.com/flasharifin
 * linkedin :   https://www.linkedin.com/in/mochamad-arifin-13554112b/
 */

public interface BaseApiService {

    @POST("api/v1/users/sign_in")
    Observable<Response<LoginResponse>> signIn(@Body LoginRequest request);

    @GET("api/v1/prayer-times/{duration}")
    Observable<PrayerTimeResponses> prayerTimes(@Path("duration") String duration);

}
