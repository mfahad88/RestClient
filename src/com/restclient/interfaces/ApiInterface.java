package com.restclient.interfaces;

import com.restclient.model.category.CategoryBean;
import com.restclient.model.product.ProductBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

	@GET("/index.php?route=feed/rest_api/categories")
	Call<CategoryBean>categories();
	
	@GET("/index.php?route=feed/rest_api/products")
	Call<ProductBean>products(@Query("category")String catId);
}
