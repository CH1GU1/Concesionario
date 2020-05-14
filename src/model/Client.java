package model;

import java.util.*;

public class Client {

	private String name;
	private String lastName;
	private String id;
	private String tel;
	private String mail;
	public ArrayList<Vehicle> tryDrive; // Is the array of favorites vehicles per client

	/**
	 * This method is the constructor of Client
	 * <b><pre>:<br><br>
	 * 
	 * @param name String name of client
	 * @param lastName String last name of client
	 * @param id integer is the id of client
	 * @param tel integer is the telephone
	 * @param mail String mail is the mail of client
	 * 
	 * <b>post:</b><br>
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
	 * This method sets the name of client
	 * <b><pre>:<br><br>
	 * 
	 * @param name
	 * 
	 * <b>post:</b><br>
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This method gets the name of client
	 * <b><pre>:<br><br>
	 * 
	 * @return name
	 * 
	 * <b>post:</b><br>
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method sets the last name of client
	 * <b><pre>:<br><br>
	 * 
	 * @param lastName
	 * 
	 * <b>post:</b><br>
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * This method gets the last name of client
	 * <b><pre>:<br><br>
	 * 
	 * @return lastName
	 * 
	 * <b>post:</b><br>
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * This method sets the id of client
	 * <b><pre>:<br><br>
	 * 
	 * @param id
	 * 
	 * <b>post:</b><br>
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * This method gets the id of client
	 * <b><pre>:<br><br>
	 * 
	 * @return id
	 * 
	 * <b>post:</b><br>
	 */
	public String getId() {
		return id;
	}
	/**
	 * This method sets the telephone of client
	 * <b><pre>:<br><br>
	 * 
	 * @param tel
	 * 
	 * <b>post:</b><br>
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * This method gets the telephone of client
	 * <b><pre>:<br><br>
	 * 
	 * @return tel
	 * 
	 * <b>post:</b><br>
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * This method sets the mail of client
	 * <b><pre>:<br><br>
	 * 
	 * @param mail
	 * 
	 * <b>post:</b><br>
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * This method gets the mail of client
	 * <b><pre>:<br><br>
	 * 
	 * @return mail
	 * 
	 * <b>post:</b><br>
	 */
	public String getMail() {
		return mail;
	}

}