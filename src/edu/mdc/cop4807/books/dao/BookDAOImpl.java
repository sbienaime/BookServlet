package edu.mdc.cop4807.books.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import edu.mdc.cop4807.books.model.Book;
import edu.mdc.cop4807.books.model.Category;
import edu.mdc.cop4807.books.model.Author;

public class BookDAOImpl implements BookDAO {
	private String PASSWORD = "password";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.err.println("JDBC Driver Not loaded!");
		}
	}
	
	private Connection getConnection() throws SQLException  {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/books?serverTimezone=" + TimeZone.getDefault().getID(), "root", PASSWORD);
	}
	
	private void closeConnection(Connection connection) {
		if(connection == null)
			return;
		try {
			connection.close();
		} catch(SQLException ex) {
			System.err.println("Error closing connection");
		}
	}
	
	
	@SuppressWarnings("unused")
	public void addBook(String title , String firstname, String lastname, String publisher) {
		
		
		String values= title+firstname+lastname+publisher;
		
		try {
			if (!title.isEmpty() && !firstname.isEmpty()  && !lastname.isEmpty()) {
			
			int Book_id=0;
			String sql = "SELECT * FROM book INNER JOIN author ON book.id = author.book_id";
			String bookidQuery="SELECT MAX(BOOK_ID) FROM author";
			String insert1 ="INSERT INTO `book`( `CATEGORY_ID`, `BOOK_TITLE`, `PUBLISHER`) VALUES ( '1','"+title+"','"+publisher+"')";
			
					
					
					//"INSERT INTO author ('BOOK_ID','FIRST_NAME', 'LAST_NAME') VALUES ('14','"+firstname+"','"+lastname+"')";
			Connection connection = null;
			
			
			
			try {
				connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(insert1);
				PreparedStatement statement1 = connection.prepareStatement(bookidQuery);
			
				
				
				 statement.executeUpdate();
				 ResultSet result= statement1.executeQuery();
				 result.next();
				 Book_id=result.getInt(1);
				 Book_id++;
				 String insert3 ="INSERT INTO author (BOOK_ID, FIRST_NAME, LAST_NAME) VALUES ('"+Book_id+"', '"+firstname+"' , '"+lastname+"')";
			     PreparedStatement statement2 = connection.prepareStatement(insert3);
				 System.out.println(Book_id);
				 statement2.executeUpdate();

			} catch(SQLException ex) {
				ex.printStackTrace();
			} finally {
				closeConnection(connection);
			}

			
			
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}

	}

	@Override
	public List<Book> findAllBooks() {
		List<Book> result = new ArrayList<>();
		List<Author> authorList = new ArrayList<>();
		
		String sql = "SELECT * FROM book INNER JOIN author ON book.id = author.book_id";
		
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Book book = new Book();
				Author author = new Author();
				book.setId(resultSet.getLong("id"));
				book.setBookTitle(resultSet.getString("book_title"));
				book.setCategoryId(resultSet.getLong("category_id"));
				author.setBookId(resultSet.getLong("book_id"));
				author.setFirstName(resultSet.getString("first_name"));
				author.setLastName(resultSet.getString("last_name"));
				authorList.add(author);
				book.setAuthors(authorList);
				book.setPublisherName(resultSet.getString("publisher"));
				result.add(book);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
		
	}

	@Override
	public List<Book> searchBooksByKeyword(String keyword) {
		List<Book> result = new ArrayList<>();
		List<Author> authorList = new ArrayList<>();
		
		String sql = "SELECT * FROM book INNER JOIN author ON book.id = author.book_id"
					+ " WHERE book_title LIKE '%"
					+ keyword.trim()
					+ "%'"
					+ " or first_name LIKE '%"
					+ keyword.trim()
					+ "%'"
					+ " or last_name LIKE '%" + keyword.trim() + "%'";
		
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				Author author = new Author();
				book.setId(resultSet.getLong("id"));
				book.setBookTitle(resultSet.getString("book_title"));
				book.setPublisherName(resultSet.getString("publisher"));
				author.setFirstName(resultSet.getString("first_name"));
				author.setLastName(resultSet.getString("last_name"));
				author.setBookId(resultSet.getLong("book_id"));
				authorList.add(author);
				book.setAuthors(authorList);
				result.add(book);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public List<Category> findAllCategories() {
		List<Category> result = new ArrayList<>();
		String sql = "select * from category";
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Category category = new Category();
				category.setId(resultSet.getLong("id"));
				category.setCategoryDescription(resultSet.getString("category_description"));
				result.add(category);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public void insert(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long bookId) {
		// TODO Auto-generated method stub
		
	}

}
