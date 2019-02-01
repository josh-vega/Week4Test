package com.example.week4test.model.datasource.Retrofit;

import com.example.week4test.model.datasource.OkHttp.OkHttpHelper;
import com.example.week4test.model.startup.Photo;
import com.example.week4test.model.startup.Photos;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.week4test.model.Constants.BASE_URL;
import static com.example.week4test.model.Constants.PATH;
import static com.example.week4test.model.Constants.QUERY_RESULTS;

public class RetrofitHelper {
    public static Retrofit createRetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpHelper.okhttpWithIntercepterClient())
                .build();
        return retrofit;
    }

    public static RemoteService getUsers(){
        Retrofit retrofit = createRetrofitInstance();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService; //fix
    }

   /* public static Observable<UserResponse> getUserOb() {
        Retrofit retrofit = createRetrofitForRx();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getUserObservable("10");
    }*/

    public interface RemoteService{
        @GET(PATH)
        Call<Photo> getPhotoList(@Query(QUERY_RESULTS) String resultCount);

        @GET(PATH)
        Observable<Photos> getPhotoObservable(@Query(QUERY_RESULTS) String resultCount);
    }
}
