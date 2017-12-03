package com.bawei.zklianxi;

import retrofit2.http.GET;
import rx.Observable;


public interface ApiService {
    @GET("Android/10/1")
    Observable<MyBean> getdatas();
}
