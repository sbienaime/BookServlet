package edu.mdc.cop4807.books.dao;
import java.util.List;
import edu.mdc.cop4807.books.model.*;

public interface BookDAO {
	public List<Book> findAllBooks();
	public List<Book> searchBooksByKeyword(String keyword);
	public List<Category> findAllCategories();
	public void insert(Book book);
	public void update(Book book);
	public void delete(Long bookId);

}
