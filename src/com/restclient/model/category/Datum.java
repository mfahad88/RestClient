package com.restclient.model.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

	@SerializedName("category_id")
	@Expose
	private String categoryId;
	@SerializedName("parent_id")
	@Expose
	private String parentId;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("image")
	@Expose
	private String image;
	@SerializedName("href")
	@Expose
	private String href;
	@SerializedName("categories")
	@Expose
	private Object categories;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Object getCategories() {
		return categories;
	}

	public void setCategories(Object categories) {
		this.categories = categories;
	}

}
