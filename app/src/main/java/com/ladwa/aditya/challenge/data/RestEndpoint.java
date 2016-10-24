package com.ladwa.aditya.challenge.data;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ladwa.aditya.challenge.data.model.Match;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Aditya on 24-Oct-16.
 */

public class RestEndpoint {

    private Retrofit mRetrofit;
    private final static String mBaseUrl = "https://xobin.com/static/xobin_playground/enparadigm/";


    public RestEndpoint() {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(mBaseUrl)
                .client(new OkHttpClient())
                .build();
    }


    public Observable<Match> getMatch() {
        return mRetrofit.create(MatchService.class).getMatchdata()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread());
    }

    private interface MatchService {
        @GET("/FootballScoresData.json")
        Observable<Match> getMatchdata();
    }
}
