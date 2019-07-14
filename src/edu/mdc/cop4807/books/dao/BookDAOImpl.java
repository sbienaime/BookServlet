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
		return DriverManager.getConnection("jdbc:mysql://localhost:80/books?serverTimezone=" + TimeZone.getDefault().getID(), "root", PASSWORD);
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
