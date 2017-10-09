package hr.fuzhiyue.com.meinvshare.http;

import hr.fuzhiyue.com.meinvshare.model.GirlResult;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by dell on 2017-09-25.
 */

public interface GirlService {

    @GET("api/data/{type}/{count}/{page}")
    Observable<GirlResult> getGirls(@Path("type") String type, @Path("count") int count, @Path("page") int page);
}
