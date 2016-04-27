package com.gcit.lms.entity;

import java.util.Date;

public class BookLoans {

	private Date dateOut;
	private Date dueDate;
	private Date dateIn;
	private Book books;
	private LibraryBranch branch;
	private Borrower borrower;
	/**
	 * @return the borrower
	 */
	public Borrower getBorrower() {
		return borrower;
	}
	/**
	 * @param borrower the borrower to set
	 */
	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	/**
	 * @return the dateOut
	 */
	public Date getDateOut() {
		return dateOut;
	}
	/**
	 * @param dateOut the dateOut to set
	 */
	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}
	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}
	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	/**
	 * @return the dateIn
	 */
	public Date getDateIn() {
		return dateIn;
	}
	/**
	 * @param dateIn the dateIn to set
	 */
	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}
	/**
	 * @return the books
	 */
	public Book getBooks() {
		return books;
	}
	/**
	 * @param books the books to set
	 */
	public void setBooks(Book books) {
		this.books = books;
	}
	/**
	 * @return the branch
	 */
	public LibraryBranch getBranch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(LibraryBranch branch) {
		this.branch = branch;
	}

}
