package com.gcit.lms.entity;

public class BookCopies {

	private int noOfCopies;
	private Book books;
	private LibraryBranch branch;
	
	/**
	 * @return the noOfCopies
	 */
	public int getNoOfCopies() {
		return noOfCopies;
	}
	/**
	 * @param noOfCopies the noOfCopies to set
	 */
	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
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
