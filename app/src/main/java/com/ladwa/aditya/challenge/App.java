package com.ladwa.aditya.challenge;

import android.app.Application;
import android.util.Log;

import com.helpshift.All;
import com.helpshift.Core;
import com.helpshift.InstallConfig;
import com.helpshift.exceptions.InstallException;

/**
 * Created by Aditya on 24-Oct-16.
 */

public class App extends Application {

    private static final String TAG = App.class.getSimpleName();
    InstallConfig installConfig = new InstallConfig.Builder().build();

    @Override
    public void onCreate() {
        super.onCreate();


        Core.init(All.getInstance());
        try {
            Core.install(this,
                    "6c70d78fe375119d4307322db62fd188",
                    "aditya.helpshift.com",
                    "aditya_platform_20161024124248620-cd60e5f70fa6840",
                    installConfig);
        } catch (InstallException e) {
            Log.e(TAG, "invalid install credentials : ", e);
        }
    }
}
