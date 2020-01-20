package com.rafalazar.bootcamp.app.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Document(collection="plazo_fijo_accounts")
public class PlazoFijo {
	
	@Id
	private String id;
	private String nameAccount;
	private String numAccount;
	private String dniOwner;
	private String status;
	private double monto;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateAt;
	
	public PlazoFijo(){
		
	}
	
	public PlazoFijo(String nameAccount,String numAccount,String dniOwner,String status,double monto){
		this.nameAccount = nameAccount;
		this.numAccount = numAccount;
		this.dniOwner = dniOwner;
		this.status = status;
		this.monto = monto;
	}

}
