package com.mochamad_arifin.sholatyuk.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mochamad_arifin.sholatyuk.R;
import com.mochamad_arifin.sholatyuk.api.BaseApiService;
import com.mochamad_arifin.sholatyuk.model.request.LoginRequest;
import com.mochamad_arifin.sholatyuk.model.request.PrayerTimeRequest;
import com.mochamad_arifin.sholatyuk.model.response.LoginResponse;
import com.mochamad_arifin.sholatyuk.util.Constant;
import com.mochamad_arifin.sholatyuk.util.UtilApi;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by mochamad arifin on 24/11/2018.
 * github   :   https://github.com/flasharifin
 * linkedin :   https://www.linkedin.com/in/mochamad-arifin-13554112b/
 */

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edEmail, edPass;
    Button signin;
    TextView about;
    Drawable error_indicator;
    BaseApiService mApiService;
    Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        edEmail = findViewById(R.id.email);
        edPass  = findViewById(R.id.password);
        signin  = findViewById(R.id.signin);
        about   = findViewById(R.id.about);


        mApiService = UtilApi.getAPIService();

        // Setting custom drawable instead of red error indicator,
        error_indicator = getResources().getDrawable(R.drawable.complain);

        //version app from gradle
		TextView versionName = (TextView) findViewById(R.id.version);
		try{
			versionName.setText("Version."+getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
		}catch (Exception e) {
			e.printStackTrace();
		}

        signin.setOnClickListener(this);
		about.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.signin) {
            CheckMandatory();
        }else if(v.getId() == R.id.about) {
            Intent intent = new Intent(SignInActivity.this, AboutUs.class);
            startActivity(intent);
            overridePendingTransition(R.transition.fadein, R.transition.fadeout);
        }
    }

    public void CheckMandatory() {
        if (edEmail.getText().toString().matches("")) {
            edEmail.setError("Email Masih Kosong", error_indicator);
        }
        else if (edPass.getText().toString().matches("")) {
            edPass.setError("Password Masih Kosong",error_indicator);
        }
        else {
            requestRepos();
        }
    }

    private void requestRepos() {
//        pbLoading.setVisibility(View.VISIBLE);
        LoginRequest request = new LoginRequest();
        request.setEmail(edEmail.getText().toString());
        request.setPassword(edPass.getText().toString());

        mApiService.signIn(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<LoginResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Response<LoginResponse> response) {

//                        PrayerTimeRequest paramReq = new PrayerTimeRequest();
//                        paramReq.setAccesstoken(response.headers().get("Access-Token"));
//                        paramReq.setUid(response.headers().get("Uid"));
//                        paramReq.setClient(response.headers().get("Client"));
//                        paramReq.setClient(response.headers().get("Expiry"));

                        Constant.AccessToken    = response.headers().get("Access-Token");
                        Constant.Uid            = response.headers().get("Uid");
                        Constant.Client         = response.headers().get("Client");
                        Constant.Expiry         = response.headers().get("Expiry");

                        Log.e("isi AccessToken", Constant.AccessToken);
                        Log.e("isi Uid", Constant.Uid);
                        Log.e("isi Client", Constant.Client);
                        Log.e("isi Expiry", Constant.Expiry);

                        mBundle = new Bundle();
                        mBundle.putSerializable("response", response.body());
//                        mBundle.putSerializable("header", paramReq);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(SignInActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("error message", e.getMessage());
                    }

                    @Override
                    public void onComplete() {
//                        pbLoading.setVisibility(View.GONE);
                        Intent intent = new Intent(SignInActivity.this, MainActivityJava.class);
                        intent.putExtras(mBundle);
                        startActivity(intent);
                        overridePendingTransition(R.transition.fadein, R.transition.fadeout);
                    }

                });
    }
}
