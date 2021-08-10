package com.easyum.hibernate.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="Customer")
public class Customer {

	@Id
	@GenericGenerator(name="customergen" , strategy="increment")
	@GeneratedValue(generator="customergen")
	@Column(name="id")
	private Long id;

	@Column
	private String name;
	@ElementCollection(targetClass= com.easyum.hibernate.model.Address.class,fetch=FetchType.EAGER) 
	@JoinTable (name = "Address" , 
		joinColumns = @JoinColumn(name="Customer_ID"))
	private Set<com.easyum.hibernate.model.Address> contacts;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Set<com.easyum.hibernate.model.Address> getContacts() {
		return contacts;
	}
	
	public void setContacts(Set<com.easyum.hibernate.model.Address> contacts) {
		this.contacts = contacts;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
