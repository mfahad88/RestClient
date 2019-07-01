package com.restclient.model.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("minimum")
	@Expose
	private String minimum;
	@SerializedName("model")
	@Expose
	private String model;
	@SerializedName("sku")
	@Expose
	private String sku;
	@SerializedName("quantity")
	@Expose
	private String quantity;
	@SerializedName("price")
	@Expose
	private String price;
	@SerializedName("cut_price")
	@Expose
	private String cutPrice;
	@SerializedName("href")
	@Expose
	private String href;
	@SerializedName("image")
	@Expose
	private String image;
	@SerializedName("special")
	@Expose
	private String special;
	@SerializedName("rating")
	@Expose
	private Integer rating;
	@SerializedName("status")
	@Expose
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMinimum() {
		return minimum;
	}

	public void setMinimum(String minimum) {
		this.minimum = minimum;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCutPrice() {
		return cutPrice;
	}

	public void setCutPrice(String cutPrice) {
		this.cutPrice = cutPrice;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}


