package com.ust.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Customer Model in the App")
public class Customer {

	
	@ApiModelProperty(notes = "Customer Id in the Model", required = true )
	@Id
	private int customerID;
	@ApiModelProperty(notes = "customer Name in the Model", name = "customerName", required = true, value = "customer Name")
	private String customerName;
	@ApiModelProperty(notes = "customer Address in the Model", name = "customerAddress", required = true, value = "customer Address")
	private String customerAddress;
	@ApiModelProperty(notes = "Customer billAmount in the Model", name = "billAmount", required = true, value = "billAmount")
	private int billAmount;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerID, String customerName, String customerAddress, int billAmount) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.billAmount = billAmount;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public int getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}

}
