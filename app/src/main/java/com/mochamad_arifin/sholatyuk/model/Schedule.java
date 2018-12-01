package com.mochamad_arifin.sholatyuk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mochamad arifin on 24/11/2018.
 * github   :   https://github.com/flasharifin
 * linkedin :   https://www.linkedin.com/in/mochamad-arifin-13554112b/
 */

public class Schedule implements Serializable {

    @SerializedName("imsak")
    @Expose
    private String imsak;
    @SerializedName("fajr")
    @Expose
    private String fajr;
    @SerializedName("sunrise")
    @Expose
    private String sunrise;
    @SerializedName("dhuhr")
    @Expose
    private String dhuhr;
    @SerializedName("asr")
    @Expose
    private String asr;
    @SerializedName("sunset")
    @Expose
    private String sunset;
    @SerializedName("maghrib")
    @Expose
    private String maghrib;
    @SerializedName("isha")
    @Expose
    private String isha;
    @SerializedName("midnight")
    @Expose
    private String midnight;
    @SerializedName("date")
    @Expose
    private String date;

    public String getImsak() {
        return imsak;
    }

    public void setImsak(String imsak) {
        this.imsak = imsak;
    }

    public String getFajr() {
        return fajr;
    }

    public void setFajr(String fajr) {
        this.fajr = fajr;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getDhuhr() {
        return dhuhr;
    }

    public void setDhuhr(String dhuhr) {
        this.dhuhr = dhuhr;
    }

    public String getAsr() {
        return asr;
    }

    public void setAsr(String asr) {
        this.asr = asr;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getMaghrib() {
        return maghrib;
    }

    public void setMaghrib(String maghrib) {
        this.maghrib = maghrib;
    }

    public String getIsha() {
        return isha;
    }

    public void setIsha(String isha) {
        this.isha = isha;
    }

    public String getMidnight() {
        return midnight;
    }

    public void setMidnight(String midnight) {
        this.midnight = midnight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}