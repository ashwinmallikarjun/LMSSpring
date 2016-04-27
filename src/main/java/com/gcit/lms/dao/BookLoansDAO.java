package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookLoans;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.LibraryBranch;

public class BookLoansDAO extends BaseDAO implements ResultSetExtractor<List<BookLoans>>{

	//Inserting new book loans.
	public void addBookLoans(BookLoans bc) throws ClassNotFoundException, SQLException {
		template.update("insert into tbl_book_loans (bookId, branchId, cardNo, dateOut, dueDate ) values( ?, ?, ?,CURDATE(),DATE_ADD(CURDATE(),INTERVAL 15 DAY))", new Object[] {bc.getBooks().getBookId(),bc.getBranch().getBranchId(),bc.getBorrower().getCardNo()});
		template.update("Update tbl_book_copies SET noOfCopies = noOfCopies-1 where bookId = ? AND branchID = ?", new Object[] {bc.getBooks().getBookId(),bc.getBranch().getBranchId()});
		return;
	}
	
	//Deleting from book loans.
	public void returnBook(BookLoans bc) throws ClassNotFoundException, SQLException {
		template.update("DELETE from tbl_book_loans where bookId = ? AND branchId = ? AND cardNo = ? AND dateIn IS NULL;", new Object[] {bc.getBooks().getBookId(),bc.getBranch().getBranchId(),bc.getBorrower().getCardNo()});
		template.update("Update tbl_book_copies SET noOfCopies = noOfCopies+1 where bookId = ? AND branchID = ?", new Object[] {bc.getBooks().getBookId(),bc.getBranch().getBranchId()});
		return;
	}
	
	//Updating due date.
	public void updateDueDate(BookLoans bl) throws ClassNotFoundException, SQLException{
		saveWithID("UPDATE tbl_book_loans SET dueDate = DATE_ADD(CURDATE(),INTERVAL 15 DAY) WHERE bookId = ? AND branchId = ? AND cardNo = ?;", new Object[] {bl.getBooks().getBookId(),bl.getBranch().getBranchId(),bl.getBorrower().getCardNo()});
		return;
		}
	
	//Reading bookLoans by cardNo.
	public List<BookLoans> readBookLoansByID(Integer cardNo) throws ClassNotFoundException, SQLException{
		List<BookLoans> brr = (List<BookLoans>) template.query("select * from tbl_book_loans where cardNo = ? AND dateIn IS NULL", new Object[] {cardNo}, this);
		if(brr!=null && brr.size() >0){
			return brr;
		}
		return null;
	}

	@Override
	public List<BookLoans> extractData(ResultSet rs) throws SQLException {
		List<BookLoans> bookLoans = new ArrayList<BookLoans>();
		
		while(rs.next()){
			BookLoans b = new BookLoans();
			b.setDateOut(rs.getDate("dateOut"));
			b.setDateIn(rs.getDate("dateIn"));
			b.setDueDate(rs.getDate("dueDate"));
			
			Borrower brr = new Borrower();
			brr.setCardNo(rs.getInt("cardNo"));
			b.setBorrower(brr);
			
			Book bo = new Book();
			bo.setBookId(rs.getInt("cardNo"));
			b.setBooks(bo);
			
			LibraryBranch lib = new LibraryBranch();
			lib.setBranchId(rs.getInt("branchId"));
			b.setBranch(lib);
			
			bookLoans.add(b);
		}
		return bookLoans;
	}
}
