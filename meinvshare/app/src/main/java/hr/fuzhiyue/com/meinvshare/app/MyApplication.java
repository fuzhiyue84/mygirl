package hr.fuzhiyue.com.meinvshare.app;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by dell on 2017-09-25.
 */

public class MyApplication extends Application {

    private static MyApplication mApplication;

    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public static OkHttpClient defaultOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .writeTimeout(3, TimeUnit.SECONDS)
                .readTimeout(3, TimeUnit.SECONDS)
                .build();
        return client;
    }

    public static MyApplication getInstance(){
        return mApplication;
    }
}
