package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.gcit.lms.entity.Genre;

public class GenreDAO extends BaseDAO implements ResultSetExtractor<List<Genre>>{

	//Reading genre list.
	public List<Genre> readAllGenre() throws ClassNotFoundException, SQLException {
		return (List<Genre>) template.query("select * from tbl_genre", this);
	}
	
	//Inserting into tbl_book_genres
	public void addBookGenres(int genre_id, int bookId) throws ClassNotFoundException, SQLException {
		template.update("insert into tbl_book_genres (genre_id,bookId) values (?,?)", genre_id, bookId);
	}

	@Override
	public List<Genre> extractData(ResultSet rs) throws SQLException {
		List<Genre> genre = new ArrayList<Genre>();
		
		while(rs.next()){
			Genre b = new Genre();
			b.setGenre_id(rs.getInt("genre_id"));
			b.setGenre_name(rs.getString("genre_name"));
			genre.add(b);
		}
		return genre;
	}
}
