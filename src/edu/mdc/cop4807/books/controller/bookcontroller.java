package edu.mdc.cop4807.books.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;

import edu.mdc.cop4807.books.dao.BookDAO;
import edu.mdc.cop4807.books.dao.BookDAOImpl;
import edu.mdc.cop4807.books.model.Book;
import edu.mdc.cop4807.books.model.Category;

/**
 * Servlet implementation class Bookcontroller
 */
@WebServlet(
		name = "BookServlet",
		urlPatterns = {"/books"},
		initParams={
				@WebInitParam(name="base", value="/BooksStore/books"),
				@WebInitParam(name="imageURL", value="/BooksStore/images")
		}
		
		)
public class bookcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String base = "/jsp/"; 
		String url = base + "home.jsp"; 
		String action = request.getParameter("action"); 
		String category = request.getParameter("category"); 
		String keyWord = request.getParameter("keyWord"); 
		if (action != null) { 
				switch (action) { 
				case "allBooks": 
					findAllBooks(request, response); 
					url = base + "listOfBooks.jsp"; 
					break; 
				case "category": 
					findAllBooks(request, response); 
					url = base + "category.jsp?category=" + category; 
					break; 
				case "search": 
					searchBooks(request, response, keyWord); 
					url = base + "searchResult.jsp"; 
					break; 
							 
					} 
			} 
		RequestDispatcher requestDispatcher = getServletContext() 
		.getRequestDispatcher(url); 
		requestDispatcher.forward(request, response);
	}
	
	
	
	private void findAllBooks(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException { 
		try { 
			BookDAO bookDao = new BookDAOImpl(); 
			List<Book> bookList = bookDao.findAllBooks(); 
			request.setAttribute("bookList", bookList); 
			 
			} catch (Exception e) { 
				System.out.println(e); 
				} 
		}
	
	//Step 2 and Step 3: Accessing DB via DAO to Get the Categories from the Database and Setting the Categories in the Model
		public void init(ServletConfig config) throws ServletException { 
			super.init(config); 
			BookDAO bookDao = new BookDAOImpl(); 
			// calling DAO method to retrieve bookList from Database
			List<Category> categoryList = bookDao.findAllCategories(); 
			ServletContext context = config.getServletContext(); 
			context.setAttribute("categoryList", categoryList); 
			}
	
	private void searchBooks(HttpServletRequest request, 
			HttpServletResponse response, String keyWord) 
	throws ServletException, IOException { 
		try { 
			BookDAO bookDao = new BookDAOImpl(); 
			List<Book> bookList = bookDao.searchBooksByKeyword(keyWord); 
			 
			request.setAttribute("bookList", bookList); 
			 
			} catch (Exception e) { 
				System.out.println(e); 
				} 
		}
	

}
