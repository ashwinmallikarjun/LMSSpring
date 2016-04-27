package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gcit.lms.dao.BookCopiesDAO;
import com.gcit.lms.dao.LibraryBranchDAO;
import com.gcit.lms.entity.BookCopies;
import com.gcit.lms.entity.LibraryBranch;

public class LibrarianService {
	
	
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
//----------------------------------------------UPDATE FUNCTIONS-------------------------------------------------
		
		//Editing book copies.
			public void editBookCopies(BookCopies bc) throws ClassNotFoundException, SQLException{
				ConnectionUtil c = new ConnectionUtil();
				Connection conn = c.getConnection();
				try{
					BookCopiesDAO adao = new BookCopiesDAO(conn);
					adao.updateBookCopies(bc);
					conn.commit();
				}catch (Exception e){
					conn.rollback();
				}finally{
					conn.close();
				}
				return;
			}
}
