package com.ust.pms.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@RequiredArgsConstructor
@ApiModel(description = "product model in appp")
public class Product {

	@Id
	@ApiModelProperty(position = 0, required = true, value="",notes = "id of product")
	private @NonNull int productId;
	@ApiModelProperty(position = 1, required = true, value="",notes = "name of product")
	private  @NonNull String productName;
	@ApiModelProperty(position = 2, required = true, value="",notes = "quantity of product")
	private @NonNull int quantityOnHand;
	@ApiModelProperty(position = 3, required = true, value="",notes = "price of product")
	private  @NonNull int price;

	
}
