package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookCopiesDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BookLoansDAO;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.dao.GenreDAO;
import com.gcit.lms.dao.LibraryBranchDAO;
import com.gcit.lms.dao.PublisherDAO;
import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookCopies;
import com.gcit.lms.entity.BookLoans;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.Genre;
import com.gcit.lms.entity.LibraryBranch;
import com.gcit.lms.entity.Publisher;

public class AdministratorService {
	
	@Autowired
	AuthorDAO aDAO;
	
	@Autowired
	BookDAO bDAO;
	
	@Autowired
	GenreDAO gDAO;
	
	@Autowired
	PublisherDAO pDAO;
	
	//------------------------------------------Inserting Info.------------------------------------------------------------
	//Adding author
	@Transactional
	public Integer createAuthorWithID(Author author) throws ClassNotFoundException, SQLException{
		return aDAO.addAuthorWithID(author);
	}
	
	//Adding book.
	@Transactional
	public Integer createBookWithID(Book book) throws ClassNotFoundException, SQLException{
			return bDAO.addBookWithID(book);
	}
	
	//Adding library branch.
		public Integer createBranchWithID(LibraryBranch branch) throws ClassNotFoundException, SQLException{
			ConnectionUtil c = new ConnectionUtil();
			Connection conn = c.getConnection();
			Integer branchId = null;
			try{
				LibraryBranchDAO brdao = new LibraryBranchDAO(conn);
				branchId = brdao.addBranchWithID(branch);
				conn.commit();
			}catch (Exception e){
				conn.rollback();
			}finally{
				conn.close();
			}
			return branchId;
		}
		
	//Adding Borrower.
		public Integer createBorrowerWithID(Borrower brr) throws ClassNotFoundException, SQLException{
			ConnectionUtil c = new ConnectionUtil();
			Connection conn = c.getConnection();
			Integer cardNo = null;
			try{
				BorrowerDAO brdao = new BorrowerDAO(conn);
				cardNo = brdao.addCardnoWithID(brr);
				conn.commit();
			}catch (Exception e){
				conn.rollback();
			}finally{
				conn.close();
			}
			return cardNo;
		}
	
	//------------------------------------------Fetching Info.------------------------------------------------------------
	
	//Fetching authors for each page.
	public List<Author> getAllAuthors(Integer pageNo) throws ClassNotFoundException, SQLException{
			List<Author> authors = aDAO.readAllAuthors(pageNo);
			if(authors!=null && authors.size()>0){
				for(Author a: authors){
					a.setBooks(bDAO.readBookByAuthorId(a.getAuthorId()));
				}
				return authors;
			}
		return null;
	}
	
	
	//Fetching author by authorId
	public Author getAuthorByID(Integer authorId) throws ClassNotFoundException, SQLException {
			Author author =  aDAO.readAuthorsByID(authorId);
			author.setBooks(bDAO.readBookByAuthorId(author.getAuthorId()));
			return author;
	}
	
	//Fetching books list.
	public List<Book> getAllBooks(Integer pageNo) throws ClassNotFoundException, SQLException{
			List<Book> book =  bDAO.readAllBooks();
			if (book!=null && book.size()>0) {
				for(Book b: book){
					b.setAuthors(aDAO.readAllAuthorsByBookId(b.getBookId()));
					b.setGenres(gDAO.readAllGenreByBookId(b.getBookId()));
					b.setGenres(pDAO.readAllPublisherByBookId(b.getBookId()));
				}
				return book;
			}
				
			return null;
	}
	
	//Fetching book by bookId
	public Book getBookByID(Integer bookId) throws ClassNotFoundException, SQLException {
			Book b = bDAO.readBookByID(bookId);
			if(b!=null){
			b.setAuthors(aDAO.readAllAuthorsByBookId(b.getBookId()));
			b.setGenres(gDAO.readAllGenreByBookId(b.getBookId()));
			b.setGenres(pDAO.readAllPublisherByBookId(b.getBookId()));
			return b;
		}
		return null;
	}
	
	//Fetching branch list.
	public List<LibraryBranch> getAllBranch(Integer pageNo) throws ClassNotFoundException, SQLException{
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try{
			LibraryBranchDAO brdao = new LibraryBranchDAO(conn);
			return brdao.readAllBranch();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return null;
	}
	
	//Fetching branch by branchId
	public LibraryBranch getBranchByID(Integer branchId) throws ClassNotFoundException, SQLException {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try{
			LibraryBranchDAO brdao = new LibraryBranchDAO(conn);
			return brdao.readBranchByID(branchId);
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return null;
	}
	
	//Fetching publishers list.
	public List<Publisher> getAllPublisher() throws ClassNotFoundException, SQLException{
			return pDAO.readAllPublisher();
	}
	
	
	//Fetching genre list.
	public List<Genre> getAllGenre() throws ClassNotFoundException, SQLException{
			return gDAO.readAllGenre();
	}
	
	//Fetching borrower list.
	public List<Borrower> getAllBorrower(Integer pageNo) throws ClassNotFoundException, SQLException{
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try{
			BorrowerDAO brdao = new BorrowerDAO(conn);
			return brdao.readAllBorrower();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return null;
	}

	//Fetching borrower by cardNo
	public Borrower getBorrowerByID(Integer cardNo) throws ClassNotFoundException, SQLException {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try{
			BorrowerDAO brdao = new BorrowerDAO(conn);
			return brdao.readBorrowerByID(cardNo);
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return null;
	}
	
	//Fetching book loans by cardNo
	public List<BookLoans> getBookLoansByID(Integer cardNo) throws ClassNotFoundException, SQLException {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try{
			BookLoansDAO bdao = new BookLoansDAO(conn);
			return bdao.readBookLoansByID(cardNo);
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return null;
	}
	
	//Fetching book copies by branchID
	public List<BookCopies> getBookCopiesByBranchID(Integer branchId) throws ClassNotFoundException, SQLException {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try{
			BookCopiesDAO bdao = new BookCopiesDAO(conn);
			return bdao.readBookCopiesByBranchID(branchId);
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return null;
	}

	
	//------------------------------------------Updating Info.------------------------------------------------------------
	//Editing author.
	@Transactional
	public Integer editAuthor(Author author) throws ClassNotFoundException, SQLException{
			return aDAO.updateAuthor(author);
	}
	
	//Edit book.
	@Transactional
	public Integer editBook(Book book) throws ClassNotFoundException, SQLException{
			return bDAO.updateBook(book);
	}
	
	//Edit Branch.
	public Integer editBranch(LibraryBranch branch) throws ClassNotFoundException, SQLException{
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		Integer branchId = null;
		try{
			LibraryBranchDAO bdao = new LibraryBranchDAO(conn);
			branchId = bdao.updateBranch(branch);
			conn.commit();
		}catch (Exception e){
			conn.rollback();
		}finally{
			conn.close();
		}
		return branchId;
	}
	
	//Editing borrower.
	public Integer editBorrower(Borrower brr) throws ClassNotFoundException, SQLException{
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		Integer cardNo = null;
		try{
			BorrowerDAO brdao = new BorrowerDAO(conn);
			cardNo = brdao.updateBorrower(brr);
			conn.commit();
		}catch (Exception e){
			conn.rollback();
		}finally{
			conn.close();
		}
		return cardNo;
	}

	//Editing dueDate.
		public void editDueDate(BookLoans bl) throws ClassNotFoundException, SQLException{
			ConnectionUtil c = new ConnectionUtil();
			Connection conn = c.getConnection();
			
			try{
				BookLoansDAO adao = new BookLoansDAO(conn);
				adao.updateDueDate(bl);
				conn.commit();
			}catch (Exception e){
				conn.rollback();
			}finally{
				conn.close();
			}
			return;
		}
	
	
	//------------------------------------------Deleting Info.------------------------------------------------------------
		@Transactional
		public void deleteAuthor(Author author) throws ClassNotFoundException, SQLException {
			aDAO.deleteAuthor(author);
	}
	
	public void deleteBook(Book book) throws ClassNotFoundException, SQLException {
			bDAO.deleteBook(book);
	}
	
	public void deleteBranch(LibraryBranch branch) throws ClassNotFoundException, SQLException {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try{
			LibraryBranchDAO libdao = new LibraryBranchDAO(conn);
			libdao.deleteBranch(branch);
			conn.commit();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		
	}
	
	public void deleteBorrower(Borrower brr) throws ClassNotFoundException, SQLException {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try{
			BorrowerDAO brdao = new BorrowerDAO(conn);
			brdao.deleteBorrower(brr);
			conn.commit();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		
	}
	
	
	//------------------------------------------Other operation.------------------------------------------------------------
	//Inserting into table with common data.
	public void createCommonTable(String tableName,int val1, int val2) throws ClassNotFoundException, SQLException {
		
			switch(tableName){
			
			case "tbl_book_authors" : aDAO.addBookAuthors(val1,val2);
									  break;
									  
			case "tbl_book_genres" : gDAO.addBookGenres(val1,val2); 
			  						 break;
				
			}
	}
	
	//Getting count of number of authors in the database.
	public Integer getAuthorCount() throws ClassNotFoundException, SQLException{
			return aDAO.totalAuthorCount();
	}
	
	//Getting count of number of books in the database.
		public Integer getBookCount() throws ClassNotFoundException, SQLException{
				return bDAO.totalBookCount();
		}
		
		//Getting count of number of library branch in the database.
		public Integer getBranchCount() throws ClassNotFoundException, SQLException{

			ConnectionUtil c = new ConnectionUtil();
			Connection conn = c.getConnection();
			Integer count = null;
			try{
				LibraryBranchDAO adao = new LibraryBranchDAO(conn);
				count = adao.totalBranchCount();
				conn.commit();
			}catch (Exception e){
				conn.rollback();
			}finally{
				conn.close();
			}

			return count;
		}
		
		//Getting count of number of borrowers in the database.
		public Integer getBorrowerCount() throws ClassNotFoundException, SQLException{

			ConnectionUtil c = new ConnectionUtil();
			Connection conn = c.getConnection();
			Integer count = null;
			try{
				BorrowerDAO adao = new BorrowerDAO(conn);
				count = adao.totalBorrowerCount();
				conn.commit();
			}catch (Exception e){
				conn.rollback();
			}finally{
				conn.close();
			}
				
			return count;
		}
	//-------------------------------------------------Search Info.-------------------------------------------------------
		public List<Author> getAllAuthorsByName(String searchString, Integer pageNo) throws ClassNotFoundException, SQLException{

				List<Author> author =  aDAO.readAuthorsByName(searchString, pageNo);
				if(author != null && author.size()>0){
					for(Author a: author){
						a.setBooks(bDAO.readBookByAuthorId(a.getAuthorId()));
					}
					return author;
				}
			return null;
		}
		
		public List<Book> getAllBooksByName(String searchString, Integer pageNo) throws ClassNotFoundException, SQLException{

				List<Book> book =  bDAO.readBooksByName(searchString, pageNo);
				if (book!=null && book.size()>0) {
					for(Book b: book){
						b.setAuthors(aDAO.readAllAuthorsByBookId(b.getBookId()));
						b.setGenres(gDAO.readAllGenreByBookId(b.getBookId()));
						b.setGenres(pDAO.readAllPublisherByBookId(b.getBookId()));
					}
					return book;
				}

			return null;
		}
		
		
		public List<LibraryBranch> getAllBranchByName(String searchString, Integer pageNo) throws ClassNotFoundException, SQLException{
			ConnectionUtil c = new ConnectionUtil();
			Connection conn = c.getConnection();
			try{
				LibraryBranchDAO adao = new LibraryBranchDAO(conn);
				return adao.readBranchByName(searchString, pageNo);
			}catch (Exception e){
				e.printStackTrace();
				//conn.rollback();
			}finally{
				conn.close();
			}
			return null;
		}
		
		
		public List<Borrower> getAllBorrowerByName(String searchString, Integer pageNo) throws ClassNotFoundException, SQLException{
			ConnectionUtil c = new ConnectionUtil();
			Connection conn = c.getConnection();
			try{
				BorrowerDAO adao = new BorrowerDAO(conn);
				return adao.readBorrowerByName(searchString, pageNo);
			}catch (Exception e){
				e.printStackTrace();
				//conn.rollback();
			}finally{
				conn.close();
			}
			return null;
		}
}
