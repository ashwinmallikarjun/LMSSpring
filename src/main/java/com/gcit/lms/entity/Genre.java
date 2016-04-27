package com.gcit.lms.entity;

import java.util.List;

public class Genre {
	
	private int genre_id;
	private String genre_name;
	private List<Book> books;
	/**
	 * @return the genre_id
	 */
	public int getGenre_id() {
		return genre_id;
	}
	/**
	 * @param genre_id the genre_id to set
	 */
	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}
	/**
	 * @return the genre_name
	 */
	public String getGenre_name() {
		return genre_name;
	}
	/**
	 * @param genre_name the genre_name to set
	 */
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}
	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
