package com.gcit.lms;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookCopiesDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BookLoansDAO;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.dao.GenreDAO;
import com.gcit.lms.dao.LibraryBranchDAO;
import com.gcit.lms.dao.PublisherDAO;

@EnableTransactionManagement
@Configuration
public class LMSConfig {
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/library";
	private String user = "root";
	private String pass = "0706";
	
	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(pass);
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager txManager(){
		DataSourceTransactionManager tx = new DataSourceTransactionManager();
		tx.setDataSource(dataSource());
		return tx;
	}
	
	@Bean
	AuthorDAO aDAO(){
		AuthorDAO adao = new AuthorDAO();
		return adao;
	}
	
	@Bean
	BookDAO bDAO(){
		BookDAO bdao = new BookDAO();
		return bdao;
	}
	
	@Bean
	GenreDAO gDAO(){
		GenreDAO gdao = new GenreDAO();
		return gdao;
	}
	
	@Bean
	PublisherDAO pDAO(){
		PublisherDAO pdao = new PublisherDAO();
		return pdao;
	}
	
	@Bean
	LibraryBranchDAO libDAO(){
		LibraryBranchDAO libdao = new LibraryBranchDAO();
		return libdao;
	}
	
	@Bean
	BorrowerDAO brDAO(){
		BorrowerDAO brdao = new BorrowerDAO();
		return brdao;
	}
	
	@Bean
	BookCopiesDAO bcDAO(){
		BookCopiesDAO bcdao = new BookCopiesDAO();
		return bcdao;
	}
	
	@Bean
	BookLoansDAO blDAO(){
		BookLoansDAO bldao = new BookLoansDAO();
		return bldao;
	}

}
