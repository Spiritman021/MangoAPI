package com.tworoot2.mangoapi.API_Controllers;

import com.tworoot2.mangoapi.API_Interfaces.API_Interface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API_Controller {

    public static final String url = "https://testing.emango.global/";
    private static API_Controller clientObject;
    private static Retrofit retrofit;

    public API_Controller() {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized API_Controller getInstance() {
        if (clientObject == null) {
            clientObject = new API_Controller();
        }
        return clientObject;
    }

    public API_Interface getApi() {
        return retrofit.create(API_Interface.class);
    }

}
