package org.globalcauseway.gcmobile.shared.dto;

import java.io.Serializable;

public class ProductCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -134211444131752658L;

	private String name;
	
	private int id;

	public ProductCategory() {

	}

	public ProductCategory(String name, int id) {
		this.name = name;
		this.setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
