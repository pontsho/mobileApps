package org.globalcauseway.gcmobile.shared.dto;

import java.io.Serializable;

import com.google.gwt.resources.client.ImageResource;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -134211444131752658L;

	private String name;
	
	private String philanthropy;
	
	private String causes;
	
	private String quantum;
	
	private String globes;
	
	private String remarks;
	
	private String imgUrl;
	
	private String weSay;
	
	private String theySay;
	
	private String categoryname;
	
	private ImageResource image;
	
	private ImageResource logo;
	
	private int category;
	
	private int id;
	
	private int count;

	public Product() {

	}

	public Product(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	public String getPhilanthropy() {
		return philanthropy;
	}

	public void setPhilanthropy(String philanthropy) {
		this.philanthropy = philanthropy;
	}

	public String getCauses() {
		return causes;
	}

	public void setCauses(String causes) {
		this.causes = causes;
	}

	public String getQuantum() {
		return quantum;
	}

	public void setQuantum(String quantum) {
		this.quantum = quantum;
	}

	public String getGlobes() {
		return globes;
	}

	public void setGlobes(String globes) {
		this.globes = globes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public ImageResource getImage() {
		return image;
	}

	public void setImage(ImageResource image) {
		this.image = image;
	}

	public ImageResource getLogo() {
		return logo;
	}

	public void setLogo(ImageResource logo) {
		this.logo = logo;
	}

	public String getWeSay() {
		return weSay;
	}

	public void setWeSay(String weSay) {
		this.weSay = weSay;
	}

	public String getTheySay() {
		return theySay;
	}

	public void setTheySay(String theySay) {
		this.theySay = theySay;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

}
