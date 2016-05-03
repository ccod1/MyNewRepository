package com.musichub.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;


@Entity
public class Product_Info {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;
	@NotEmpty(message="Product name field is mandatory.")
	private String name;
	@NotEmpty(message="Description feild is mandatory.")
	private String desc;
	@NotEmpty(message="Manufacture feild is mandatory")
	private String manufact;
	//@Length(min=1,message="Price is not valid" )
	//@NotEmpty(message="Price feild is mandatory")
	
	@Transient
	private String img;
	
	private int price;
	@NotEmpty(message="Type feild is mandatory")
	private String type;
	private transient MultipartFile imgFile;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getManufact() {
		return manufact;
	}
	public void setManufact(String manufact) {
		this.manufact = manufact;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public MultipartFile getImgFile() {
		return imgFile;
	}
	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	

}
