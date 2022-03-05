package isen.vcard.entities;

import java.sql.Date;

public class Person {
	private Integer idperson;
	private String lastname;
	private String firstname;
	private String nickname;
	private String phone_number;
	private String address;
	private String email_address;
	private Date birth_date;
	
	public Person() {
	}
	public Person (Integer idperson, String lastname, String firstname, String nickname, String phone_number, String address, String email_address, Date birth_date ) {
		
		super();
		this.setIdperson(idperson);
		this.setLastname(lastname);
		this.setFirstname(firstname);
		this.setNickname(nickname);
		this.setPhone_number(phone_number);
		this.setAddress(address);
		this.setEmail_address(email_address);
		this.setBirth_date(birth_date);
	}
	
	public Integer getIdperson() {
		return idperson;
	}
	public void setIdperson(Integer idperson) {
		this.idperson = idperson;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	
}
