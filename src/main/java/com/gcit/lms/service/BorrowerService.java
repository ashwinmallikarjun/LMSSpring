package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BookLoansDAO;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookLoans;
import com.gcit.lms.entity.Borrower;

public class BorrowerService {
	
	//Fetching borrower by cardNo
	public Borrower getValidateCardNo(Integer cardNo) throws ClassNotFoundException, SQLException {
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
	
	//Fetching check out book list.
		public List<Book> checkOutBookList(BookLoans bc) throws ClassNotFoundException, SQLException {
			ConnectionUtil c = new ConnectionUtil();
			Connection conn = c.getConnection();
			try{
				BookDAO brdao = new BookDAO(conn);
				return brdao.checkOutBookList(bc);
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				conn.close();
			}
			return null;
		
		}
		
		//Fetching return book list.
		public List<Book> returnBookList(BookLoans bc) throws ClassNotFoundException, SQLException {
			ConnectionUtil c = new ConnectionUtil();
			Connection conn = c.getConnection();
			try{
				BookDAO brdao = new BookDAO(conn);
				return brdao.returnBookLoanList(bc);
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				conn.close();
			}
			return null;
		
		}
		
		//Fetching check out book list.
		public void createBookLoans(BookLoans bc) throws ClassNotFoundException, SQLException {
			ConnectionUtil c = new ConnectionUtil();
			Connection conn = c.getConnection();
			try{
				BookLoansDAO brdao = new BookLoansDAO(conn);
				brdao.addBookLoans(bc);
				conn.commit();
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				conn.close();
			}
			return;

		}
		
		//Update Book List.
		public void returnBookLoans(BookLoans bc) throws ClassNotFoundException, SQLException {
			ConnectionUtil c = new ConnectionUtil();
			Connection conn = c.getConnection();
			try{
				BookLoansDAO brdao = new BookLoansDAO(conn);
				brdao.returnBook(bc);
				conn.commit();
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				conn.close();
			}
			return;

		}
		
}
