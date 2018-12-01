package com.mochamad_arifin.sholatyuk.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mochamad_arifin.sholatyuk.R;
import com.mochamad_arifin.sholatyuk.api.BaseApiService;
import com.mochamad_arifin.sholatyuk.fragment.ClockFragment;
import com.mochamad_arifin.sholatyuk.model.response.LoginResponse;
import com.mochamad_arifin.sholatyuk.model.response.PrayerTimeResponses;
import com.mochamad_arifin.sholatyuk.util.Constant;
import com.mochamad_arifin.sholatyuk.util.UtilApi;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mochamad arifin on 24/11/2018.
 * github   :   https://github.com/flasharifin
 * linkedin :   https://www.linkedin.com/in/mochamad-arifin-13554112b/
 */

public class MainActivityJava extends AppCompatActivity {


    BaseApiService mApiService;
    private LoginResponse response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_java);

        Fragment newFragment = new ClockFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_container, newFragment).commit();

        response = (LoginResponse) getIntent().getSerializableExtra("response");
        Log.e("after login", response.getMosque().getName());
        Log.e("after login", response.getMosque().getAddress());

        mApiService = UtilApi.getApiServiceWithAuth();
        getPrayerTimeSchedules();

    }

    private void getPrayerTimeSchedules() {
        mApiService.prayerTimes("10")
//        mApiService.prayerTimes("application/json",Constant.AccessToken, Constant.Uid, Constant.Client, Constant.Expiry,"10")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PrayerTimeResponses>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PrayerTimeResponses response) {
                        for(int i = 0; i < response.getSchedules().size(); i++){
                            Log.e("isi schedules", response.getSchedules().get(i).getImsak());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivityJava.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("error message", e.getMessage());
                    }

                    @Override
                    public void onComplete() {
//                        pbLoading.setVisibility(View.GONE);
                    }

                });
    }
}
