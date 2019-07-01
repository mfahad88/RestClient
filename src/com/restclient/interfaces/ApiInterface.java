package com.restclient.interfaces;

import com.restclient.model.category.CategoryBean;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

	@GET("/index.php?route=feed/rest_api/categories")
	Call<CategoryBean>categories();
}
