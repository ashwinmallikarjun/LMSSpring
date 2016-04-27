package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Genre;
import com.gcit.lms.entity.BookLoans;
import com.gcit.lms.entity.Publisher;

public class BookDAO extends BaseDAO implements ResultSetExtractor<List<Book>>{

	public Integer addBookWithID(Book book) throws ClassNotFoundException, SQLException {
		return saveWithID("insert into tbl_book (title, pubId) values (?, ?)", new Object[] {book.getTitle(), book.getPublisher().getPublisherId()});
	}
	
	//Reading book by ID.
	public Book readBookByID(Integer bookId) throws ClassNotFoundException, SQLException{
		@SuppressWarnings("unchecked")
		List<Book> book = (List<Book>) template.query("select * from tbl_book where bookId = ?", new Object[] {bookId}, this);
		if(book!=null && book.size() >0){
			return book.get(0);
		}
		return null;
	}
	
	//Reading book by authorID //Need to correct this method
	public List<Book> readBookByAuthorId(Integer authorId) throws ClassNotFoundException, SQLException{
		List<Book> book = (List<Book>) template.query("select * from tbl_book a inner join tbl_book_authors b on b.bookId = a.bookId inner join tbl_author c on b.authorId = c.authorId where c.authorId = ?;", new Object[] {authorId}, this);
		if(book!=null && book.size() >0){
			return book;
		}
		return null;
	}
	
	
	//Search function for book by name.
	@SuppressWarnings("unchecked")
	public List<Book> readBooksByName(String name, int pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		name = "%"+name+"%";
		return (List<Book>) template.query("select * from tbl_book where title like ?", new Object[] {name}, this);
	}
	
	//Updating book by name.
	public Integer updateBook(Book book) throws ClassNotFoundException, SQLException{
		return saveWithID("UPDATE tbl_book SET title = ? WHERE bookId = ?", new Object[] {book.getTitle(),book.getBookId()});
		}
	
	//Deleting author.
	public void deleteBook(Book book) throws ClassNotFoundException, SQLException{
		template.update("delete from tbl_book where bookId = ?", new Object[] {book.getBookId()});
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> readAllBooks() throws ClassNotFoundException, SQLException{
		return (List<Book>) template.query("select * from tbl_book", this);
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> checkOutBookList(BookLoans bc) throws ClassNotFoundException, SQLException{
		return ((List<Book>) template.query("select * from tbl_book where bookId in (select bc.bookId from tbl_book_copies as bc where bc.branchId = ? and noOfCopies>0)", new Object[] {bc.getBranch().getBranchId()}, this));
	}
	
	//Reading bookLoans by cardNo.
	public List<Book> returnBookLoanList(BookLoans bc) throws ClassNotFoundException, SQLException{
		@SuppressWarnings("unchecked")
		List<Book> brr = (List<Book>) template.query("select * from tbl_book where bookId IN (select bookId from tbl_book_loans where cardNo = ? AND branchId = ?)", new Object[] {bc.getBorrower().getCardNo(),bc.getBranch().getBranchId()}, this);
		if(brr!=null && brr.size() >0){
			return brr;
		}
		return null;
	}
	
	public Integer totalBookCount() throws ClassNotFoundException, SQLException {
		return getCount("select count(*) from tbl_book;");
	}
	
	@Override
	public List<Book> extractData(ResultSet rs) throws SQLException {
		List<Book> books = new ArrayList<Book>();
				
		while(rs.next()){
			Book b = new Book();
			b.setBookId(rs.getInt("bookId"));
			b.setTitle(rs.getString("title"));
			Publisher p = new Publisher();
			p.setPublisherId(rs.getInt("pubId"));
			b.setPublisher(p);
			books.add(b);
		}
		return books;
	}
}
