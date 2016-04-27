package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.gcit.lms.entity.BookCopies;
import com.gcit.lms.entity.BookLoans;
import com.gcit.lms.entity.LibraryBranch;

public class LibraryBranchDAO extends BaseDAO implements ResultSetExtractor<List<LibraryBranch>>{

	public Integer addBranchWithID(LibraryBranch branch) throws ClassNotFoundException, SQLException {
		return saveWithID("insert into tbl_library_branch (branchName, branchAddress) values (?, ?)", new Object[] {branch.getBranchName(), branch.getBranchAddress()});
	}
	
	//Search function for branch by name.
	@SuppressWarnings("unchecked")
	public List<LibraryBranch> readBranchByName(String name, int pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		name = "%"+name+"%";
		return (List<LibraryBranch>) template.query("select * from tbl_library_branch where branchName like ?", new Object[] {name}, this);
	}

	@SuppressWarnings("unchecked")
	public List<LibraryBranch> readAllBranch() throws ClassNotFoundException, SQLException{
		return (List<LibraryBranch>) template.query("select * from tbl_library_branch", this);
	}
	
	//Reading branch by ID.
	public LibraryBranch readBranchByID(Integer branchId) throws ClassNotFoundException, SQLException{
		@SuppressWarnings("unchecked")
		List<LibraryBranch> branch = (List<LibraryBranch>) template.query("select * from tbl_library_branch where branchId = ?", new Object[] {branchId}, this);
		if(branch!=null && branch.size() >0){
			return branch.get(0);
		}
		return null;
	}
	
	//Deleting branch.
	public void deleteBranch(LibraryBranch branch) throws ClassNotFoundException, SQLException{
		template.update("delete from tbl_library_branch where branchId = ?", new Object[] {branch.getBranchId()});
	}
	
	//Updating branch by name.
	public Integer updateBranch(LibraryBranch branch) throws ClassNotFoundException, SQLException{
		return saveWithID("UPDATE tbl_library_branch SET branchName = ? WHERE branchId = ?", new Object[] {branch.getBranchName(),branch.getBranchId()});
		}
	

	public Integer totalBranchCount() throws ClassNotFoundException, SQLException {
		return getCount("select count(*) from tbl_library_branch;");
	}
	
	//@SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	@Override
	public List<LibraryBranch> extractData(ResultSet rs) throws SQLException {
		
		List<LibraryBranch> branch = new ArrayList<LibraryBranch>();
		while(rs.next()){
			LibraryBranch br = new LibraryBranch();
			br.setBranchId(rs.getInt("branchId"));
			br.setBranchName(rs.getString("branchName"));
			br.setBranchAddress(rs.getString("branchAddress"));
			branch.add(br);
		}
		return branch;
	}
}
