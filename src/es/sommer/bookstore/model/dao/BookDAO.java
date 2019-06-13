package es.sommer.bookstore.model.dao;

import java.util.List;

import es.sommer.bookstore.model.entity.Book;
import es.sommer.bookstore.model.entity.Category;

public interface BookDAO {
	
	public List<Book> findAllBooks();
	
	public List<Book> searchBooksByKeyword(String keyword);
	
	public List<Category> findAllCategories();
	
	public void insert(Book book);
	
	public void update(Book book);
	
	public void delete(Long bookId);

}
