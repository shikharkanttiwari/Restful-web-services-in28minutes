package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "You shall not pass!")
@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min = 2,message = "Name should have atleast 2 characters")
	@ApiModelProperty(notes = "Really! Needs more than one character")
	private String name;
	@Past
	@ApiModelProperty(notes = "Future Time travel not allowed")
	private Date birthDate;
	@JsonIgnore
	private String posts;
	public User(Integer id, String name, Date birthDate, String posts) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.posts = posts;
	}
	protected User() {
		
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", posts=" + posts + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getPosts() {
		return posts;
	}
}
