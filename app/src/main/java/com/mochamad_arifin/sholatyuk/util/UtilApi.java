package com.mochamad_arifin.sholatyuk.util;

import com.mochamad_arifin.sholatyuk.api.BaseApiService;
import com.mochamad_arifin.sholatyuk.api.RetrofitClient;

/**
 * Created by mochamad arifin on 24/11/2018.
 * github   :   https://github.com/flasharifin
 * linkedin :   https://www.linkedin.com/in/mochamad-arifin-13554112b/
 */

public class UtilApi {

    private static final String BASE_URL_API = "https://siforlat.herokuapp.com/";

    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }

    public static BaseApiService getApiServiceWithAuth(){
        return RetrofitClient.getClientWithAuth(BASE_URL_API).create(BaseApiService.class);
    }

}
