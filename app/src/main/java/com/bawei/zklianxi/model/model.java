package com.bawei.zklianxi.model;

import com.bawei.zklianxi.Api;
import com.bawei.zklianxi.ApiService;
import com.bawei.zklianxi.MyBean;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class model implements Imodel{
    private Retrofit retrofit;
    private ApiService apiService;
    private Observable<MyBean> noParams;

    @Override
    public void Request(String url, final Onclick onclick) {

//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggingInterceptor())
//                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Api.PATH)
//                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        //通过动态代理得到网络接口对象
        apiService = retrofit.create(ApiService.class);
        noParams = apiService.getdatas();

        noParams.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onclick.error(e.getMessage().toString());
                    }


                    @Override
                    public void onNext(MyBean bean) {
                        List<MyBean.ResultsBean> data=bean.getResults();
                        onclick.datasuccess(data);
                    }
                });

    }
}
