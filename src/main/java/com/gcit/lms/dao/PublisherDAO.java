package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.gcit.lms.entity.Publisher;

public class PublisherDAO extends BaseDAO implements ResultSetExtractor<List<Publisher>>{

	//Reading publishers list.
	public List<Publisher> readAllPublisher() throws ClassNotFoundException, SQLException {
		return (List<Publisher>) template.query("select * from tbl_publisher", this);
	}

	@Override
	public List<Publisher> extractData(ResultSet rs) throws SQLException {
		List<Publisher> publisher = new ArrayList<Publisher>();
		
		while(rs.next()){
			Publisher b = new Publisher();
			b.setPublisherId(rs.getInt("publisherId"));
			b.setPublisherName(rs.getString("publisherName"));
			b.setPublisherAddress(rs.getString("publisherAddress"));
			b.setPublisherPhone(rs.getString("publisherPhone"));
			publisher.add(b);
		}
		return publisher;
	}
}
