package nyc.c4q.hyun.vine_app.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hyun on 12/10/16.
 */

public interface VineService {
    @GET("api/timelines/users/918753190470619136")
    Call<VinePOJO> getVine();
}
