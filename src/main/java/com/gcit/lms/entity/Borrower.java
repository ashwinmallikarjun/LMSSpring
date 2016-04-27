package com.gcit.lms.entity;

import java.util.List;

//import java.util.List;

public class Borrower {

	private int cardNo;
	private String name;
	private String address;
	private String phone;
	private List<BookLoans> bookloaned;
	/**
	 * @return the bookloaned
	 */
	public List<BookLoans> getBookloaned() {
		return bookloaned;
	}
	/**
	 * @param bookloaned the bookloaned to set
	 */
	public void setBookloaned(List<BookLoans> bookloaned) {
		this.bookloaned = bookloaned;
	}
	/**
	 * @return the cardNo
	 */
	public int getCardNo() {
		return cardNo;
	}
	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
