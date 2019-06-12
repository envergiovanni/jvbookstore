package es.sommer.bookstore.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.sommer.bookstore.dao.BookDAO;
import es.sommer.bookstore.dao.BookDAOImpl;
import es.sommer.bookstore.model.Book;
import es.sommer.bookstore.model.Category;

@WebServlet("/books")
public class BookController extends HttpServlet {
	
	public BookController() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		BookDAOImpl bookDAO = new BookDAOImpl();
		List<Category> categoryList = bookDAO.findAllCategories();
		ServletContext context = config.getServletContext();
		context.setAttribute("categoryList", categoryList);
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String base = "/pages/";
		String url = base + "home.jsp";
		findAllBooks(request, response);
		
		String action = request.getParameter("action");
		String category = request.getParameter("category");
		String keyword = request.getParameter("keyword");
				
		if(action != null) {
			switch(action) {
			case "allBooks":
				findAllBooks(request, response);
				url = base + "listOfBooks.jsp";
				break;
			case "category":
				findAllBooks(request, response);
				url = base + "category.jsp?category=" + category;
				break;
			case "search":
				searchBooks(request, response, keyword);
				url = base + "searchResult.jsp";
				break;
			}
		}
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
		
	}
	
	private void findAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			BookDAOImpl bookDAO = new BookDAOImpl();
			List<Book> bookList = bookDAO.findAllBooks();
			request.setAttribute("bookList", bookList);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	private void searchBooks(HttpServletRequest request, HttpServletResponse response, String keyword) throws ServletException, IOException {
		try {
			BookDAOImpl bookDAO = new BookDAOImpl();
			List<Book> bookList = bookDAO.searchBooksByKeyword(keyword);
			request.setAttribute("bookList", bookList);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	protected String getContextParameter(String name) {
	    return getServletContext().getInitParameter(name);
	}
	
}
