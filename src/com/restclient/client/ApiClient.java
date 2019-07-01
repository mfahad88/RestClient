package com.restclient.client;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.restclient.interfaces.ApiInterface;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;



public class ApiClient {
 

    public static final String BASE_URL = "https://chaseup.com.pk/";
//      public static final String BASE_URL = "http://172.28.28.51:8080/api/";
//      public static final String BASE_URL = "http://192.168.1.7:8080/";
    private static Retrofit retrofit = null;

 
    public static ApiInterface getInstance() {

          if (retrofit==null) {
              Gson gson = new GsonBuilder()
                      //.setLenient()
                      .create();
              retrofit = new Retrofit.Builder()
                      .baseUrl(BASE_URL)
                      .addConverterFactory(GsonConverterFactory.create(gson))
//                      .client(getRequestHeader())
                      .build();
          }

        return retrofit.create(ApiInterface.class);
    }


}