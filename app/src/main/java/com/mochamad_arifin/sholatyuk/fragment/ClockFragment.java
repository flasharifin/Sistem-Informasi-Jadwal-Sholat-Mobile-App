package com.mochamad_arifin.sholatyuk.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mochamad_arifin.sholatyuk.util.ClockView;
import com.mochamad_arifin.sholatyuk.R;

/**
 * Created by mochamad arifin on 24/11/2018.
 * github   :   https://github.com/flasharifin
 * linkedin :   https://www.linkedin.com/in/mochamad-arifin-13554112b/
 */

public class ClockFragment extends Fragment {

    public static final String TAG = "ClockFragment";

    public static Fragment newInstance() {
        return new ClockFragment();
    }

    private ClockView mClock;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.clock_fragment, container, false);
        mClock = (ClockView) view.findViewById(R.id.clock);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mClock.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mClock.pause();
    }
}
