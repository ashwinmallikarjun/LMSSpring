package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;

public class AuthorDAO extends BaseDAO implements ResultSetExtractor<List<Author>>{

	//Inserting new author.
	public Integer addAuthorWithID(Author author) throws ClassNotFoundException, SQLException {
		return saveWithID("insert into tbl_author (authorName) values (?)", new Object[] {author.getAuthorName()});
	}

	//Search function for author.
	@SuppressWarnings("unchecked")
	public List<Author> readAuthorsByName(String name, int pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		name = "%"+name+"%";
		return (List<Author>) template.query("select * from tbl_author where authorName like ?", new Object[] {name}, this);
	}
	
	//Reading authors list.
	@SuppressWarnings("unchecked")
	public List<Author> readAllAuthors(Integer pageNo) throws ClassNotFoundException, SQLException {
		if(pageNo!=null){
		setPageNo(pageNo);
		return (List<Author>) template.query("select * from tbl_author", this);
		}else{
		return (List<Author>) template.query("select * from tbl_author", this);
		}
	}
	
	public Integer totalAuthorCount() throws ClassNotFoundException, SQLException {
		return getCount("select count(*) from tbl_author;");
	}
	
	//Reading author by ID.
	public Author readAuthorsByID(Integer authorId) throws ClassNotFoundException, SQLException{
		@SuppressWarnings("unchecked")
		List<Author> authors = (List<Author>) template.query("select * from tbl_author where authorId = ?", new Object[] {authorId}, this);
		if(authors!=null && authors.size() >0){
			return authors.get(0);
		}
		return null;
	}
	
	//Reading authors by name.
	@SuppressWarnings("unchecked")
	public List<Author> readAuthorsByName(String name) throws ClassNotFoundException, SQLException{
		return (List<Author>) template.query("select * from tbl_author where authorName like ?", new Object[] {name}, this);
	}
	
	//Deleting author.
	public void deleteAuthor(Author author) throws ClassNotFoundException, SQLException{
		template.update("delete from tbl_author where authorId = ?", new Object[] {author.getAuthorId()});
	}
	
	//Inserting into tbl_book_authors
	public void addBookAuthors(int bookId, int authorId) throws ClassNotFoundException, SQLException {
		template.update("insert into tbl_book_authors (bookId,authorId) values (?,?)", bookId, authorId);
	}
	
	//Updating authors by name.
	public Integer updateAuthor(Author author) throws ClassNotFoundException, SQLException{
		return saveWithID("UPDATE tbl_author SET authorName = ? WHERE authorId = ?", new Object[] {author.getAuthorName(),author.getAuthorId()});
		}
	
	@Override
	public List<Author> extractData(ResultSet rs) throws SQLException {
		List<Author> authors = new ArrayList<Author>();
		while(rs.next()){
			Author a = new Author();
			a.setAuthorId(rs.getInt("authorId"));
			a.setAuthorName(rs.getString("authorName"));
			authors.add(a);
		}
		return authors;
	}

}
