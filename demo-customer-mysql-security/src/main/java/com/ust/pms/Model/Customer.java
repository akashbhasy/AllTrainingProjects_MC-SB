package com.ust.pms.Model;

import javax.persistence.Entity;
import javax.persistence.Id;



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
public class Customer {

	@Id
	private @NonNull int customerID;
	private  @NonNull String customerName;
	private @NonNull String customerAddress;
	private  @NonNull int billAmount;

	
}
