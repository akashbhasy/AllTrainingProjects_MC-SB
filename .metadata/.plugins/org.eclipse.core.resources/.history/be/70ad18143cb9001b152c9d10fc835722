package com.ust.pms.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
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
	private @NonNull int productId;
	private  @NonNull String productName;
	private @NonNull int quantityOnHand;
	private  @NonNull int price;

	
}
