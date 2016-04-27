package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.gcit.lms.entity.BookLoans;
import com.gcit.lms.entity.Borrower;

public class BorrowerDAO extends BaseDAO implements ResultSetExtractor<List<Borrower>>{

	public Integer addCardnoWithID(Borrower brr) throws ClassNotFoundException, SQLException {
		return saveWithID("insert into tbl_borrower (name,address,phone) values (?,?,?)", new Object[] {brr.getName(),brr.getAddress(),brr.getPhone()});
	}
	
	@SuppressWarnings("unchecked")
	public List<Borrower> readAllBorrower() throws ClassNotFoundException, SQLException{
		return  (List<Borrower>) template.query("select * from tbl_borrower", this);
	}
	
	//Search function for borrower by name.
	@SuppressWarnings("unchecked")
	public List<Borrower> readBorrowerByName(String name, int pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		name = "%"+name+"%";
		return (List<Borrower>) template.query("select * from tbl_borrower where name like ?", new Object[] {name}, this);
	}
	
	//Reading borrower by cardNo.
	public Borrower readBorrowerByID(Integer cardNo) throws ClassNotFoundException, SQLException{
		@SuppressWarnings("unchecked")
		List<Borrower> brr = (List<Borrower>) template.query("select * from tbl_borrower where cardNo = ?", new Object[] {cardNo}, this);
		if(brr!=null && brr.size() >0){
			return brr.get(0);
		}
		return null;
	}
	
	//Deleting borrower.
	public void deleteBorrower(Borrower brr) throws ClassNotFoundException, SQLException{
		template.update("delete from tbl_borrower where cardNo = ?", new Object[] {brr.getCardNo()});
	}
	
	//Updating borrower details.
	public Integer updateBorrower(Borrower brr) throws ClassNotFoundException, SQLException{
		return saveWithID("UPDATE tbl_borrower SET name = ?, address = ?, phone = ? WHERE cardNo = ?", new Object[] {brr.getName(),brr.getAddress(),brr.getPhone(),brr.getCardNo()});
		}
	
	//Counting total number of borrowers in database
	public Integer totalBorrowerCount() throws ClassNotFoundException, SQLException {
		return getCount("select count(*) from tbl_borrower;");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Borrower> extractData(ResultSet rs) throws SQLException {
		
		List<Borrower> borrower = new ArrayList<Borrower>();
		
		while(rs.next()){
			Borrower br = new Borrower();
			br.setCardNo(rs.getInt("cardNo"));
			br.setName(rs.getString("name"));
			br.setAddress(rs.getString("address"));
			br.setPhone(rs.getString("phone"));
			borrower.add(br);
		}
		return borrower;
	}
}
