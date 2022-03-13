package com.tworoot2.mangoapi.API_Interfaces;

import com.tworoot2.mangoapi.Models.CC_Model;
import com.tworoot2.mangoapi.Models.CareerModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API_Interface {

    @FormUrlEncoded
    @POST("student/study-abroad-country-list-mobile/ ")
    Call<String> getCountry(
            @Field("tokenKey") String tokenKey
    );

    @FormUrlEncoded
    @POST("portal/trending-career/")
    Call<List<CareerModel>> getCareers(
            @Field("tokenKey") String tokenKey
    );

}
