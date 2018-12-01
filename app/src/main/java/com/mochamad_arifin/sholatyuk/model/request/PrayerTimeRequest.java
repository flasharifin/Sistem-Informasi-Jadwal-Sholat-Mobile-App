package com.mochamad_arifin.sholatyuk.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mochamad arifin on 24/11/2018.
 * github   :   https://github.com/flasharifin
 * linkedin :   https://www.linkedin.com/in/mochamad-arifin-13554112b/
 */

public class PrayerTimeRequest implements Serializable {

    @SerializedName("accesstoken")
    @Expose
    private String accesstoken;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("client")
    @Expose
    private String client;
    @SerializedName("expiry")
    @Expose
    private String expire;
    @SerializedName("duration")
    @Expose
    private String duration;

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
