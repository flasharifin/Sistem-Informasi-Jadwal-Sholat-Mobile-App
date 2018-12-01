package com.mochamad_arifin.sholatyuk.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mochamad_arifin.sholatyuk.model.Schedule;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mochamad arifin on 24/11/2018.
 * github   :   https://github.com/flasharifin
 * linkedin :   https://www.linkedin.com/in/mochamad-arifin-13554112b/
 */

public class PrayerTimeResponses implements Serializable {


    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("schedules")
    @Expose
    private List<Schedule> schedules = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

}
