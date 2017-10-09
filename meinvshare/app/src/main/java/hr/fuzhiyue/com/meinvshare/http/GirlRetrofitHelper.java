package hr.fuzhiyue.com.meinvshare.http;

import hr.fuzhiyue.com.meinvshare.app.Constant;
import hr.fuzhiyue.com.meinvshare.app.MyApplication;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dell on 2017-09-25.
 */

public class GirlRetrofitHelper {

    private static Retrofit retrofit;

    public static Retrofit getRetrofit(){
        if (retrofit == null){
            synchronized (GirlRetrofitHelper.class){
                if (retrofit == null){
                    retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(MyApplication.defaultOkHttpClient())
                            .build();
                }
            }
        }
        return retrofit;
    }
}
