package model;

import java.util.*;

public class Client {

	private String name;
	private String lastName;
	private String id;
	private String tel;
	private String mail;
	
	
	
	public ArrayList<Vehicle> tryDrive; 

	/**
	 * 
	 * @param name
	 * @param lastName
	 * @param id
	 * @param tel
	 * @param mail
	 */
	public Client(String name, String lastName, String id, String tel, String mail) {
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.tel = tel;
		this.mail = mail;
		tryDrive = new ArrayList<>();
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel() {
		return tel;
	}

	/**
	 * 
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}

}