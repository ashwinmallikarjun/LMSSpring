package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookCopies;
import com.gcit.lms.entity.LibraryBranch;

public class BookCopiesDAO extends BaseDAO implements ResultSetExtractor<List<BookCopies>>{
	
	//Reading borrower by cardNo.
	public List<BookCopies> readBookCopiesByBranchID(Integer branchId) throws ClassNotFoundException, SQLException{
		List<BookCopies> brr = (List<BookCopies>) template.query("select * from tbl_book_copies as bc inner join tbl_book as bk on bc.bookId = bk.bookId where branchId = ?", new Object[] {branchId}, this);
		if(brr!=null && brr.size() >0){
			return brr;
		}
		return null;
	}
	
	//Updating authors by name.
	public Integer updateBookCopies(BookCopies bc) throws ClassNotFoundException, SQLException{
		return saveWithID("UPDATE tbl_book_copies SET bookId = ?, branchId = ?, noOfCopies = ? WHERE bookId = ? AND branchId= ?", new Object[] {bc.getBooks().getBookId(),bc.getBranch().getBranchId(),bc.getNoOfCopies(),bc.getBooks().getBookId(),bc.getBranch().getBranchId()});
		}

	@Override
	public List<BookCopies> extractData(ResultSet rs) throws SQLException {
		List<BookCopies> bookcopies = new ArrayList<BookCopies>();
		
		while(rs.next()){
			BookCopies bc = new BookCopies();
			bc.setNoOfCopies(rs.getInt("noOfCopies"));
			
			Book bo = new Book();
			bo.setBookId(rs.getInt("bookId"));
			bc.setBooks(bo);
			
			LibraryBranch lib = new LibraryBranch();
			lib.setBranchId(rs.getInt("branchId"));
			bc.setBranch(lib);
			
			bookcopies.add(bc);
			
		}
		return bookcopies;
	}
}
