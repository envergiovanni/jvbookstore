package es.sommer.bookstore.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.sommer.bookstore.model.entity.Author;
import es.sommer.bookstore.model.entity.Book;
import es.sommer.bookstore.model.entity.Category;
import es.sommer.bookstore.model.entity.DatabaseConnection;

public class BookDAOImpl implements BookDAO {
			
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
		
	@Override
	public List<Book> findAllBooks() {
		List<Book> result = new ArrayList<Book>();
		List<Author> authorList = new ArrayList<Author>();
		
		String sql = "SELECT * FROM book INNER JOIN author ON book.id = author.book_id";
			
		try {
			conn = new DatabaseConnection().getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				Author author = new Author();
				book.setId(rs.getLong("id"));
				book.setBookTitle(rs.getString("book_title"));
				book.setCategoryId(rs.getLong("category_id"));
				book.setImagename(rs.getString("imagepath"));
				author.setBookId(rs.getLong("book_id"));
				author.setFirstName(rs.getString("first_name"));
				author.setLastName(rs.getString("last_name"));
				authorList.add(author);
				book.setAuthors(authorList);
				result.add(book);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

	@Override
	public List<Book> searchBooksByKeyword(String keyword) {
		List<Book> result = new ArrayList<Book>();
		List<Author> authorList = new ArrayList<Author>();
		
		String sql = "SELECT * FROM book INNER JOIN author ON book.id = author.book_id"
					+ " WHERE book_title LIKE '%"
					+ keyword.trim()
					+ "%'"
					+ " OR first_name LIKE '%"
					+ keyword.trim()
					+ "%'"
					+ " OR last_name LIKE '%" + keyword.trim() + "%'";
				
		try {
			conn = new DatabaseConnection().getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				Author author = new Author();
				book.setId(rs.getLong("id"));
				book.setBookTitle(rs.getString("book_title"));
				//book.setImagepath(rs.getString("imagepath"));
				author.setFirstName(rs.getString("first_name"));
				author.setLastName(rs.getString("last_name"));
				author.setBookId(rs.getLong("book_id"));
				authorList.add(author);
				book.setAuthors(authorList);
				result.add(book);
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

	@Override
	public List<Category> findAllCategories() {
		List<Category> result = new ArrayList<>();
		String sql = "SELECT * FROM category";
		
		try {
			conn = new DatabaseConnection().getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Category category = new Category();
				category.setId(rs.getLong("id"));
				category.setCategoryDescription(rs.getString("category_description"));
				result.add(category);
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

	@Override
	public void insert(Book book) {
		
		try {
			conn = new DatabaseConnection().getConnection();
			stmt = conn.prepareStatement("INSERT INTO book (book_title) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, book.getBookTitle());
			stmt.execute();
			
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if(generatedKeys.next()) {
				book.setId(generatedKeys.getLong(1));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			close();
		}
		
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long bookId) {

		try {
			conn = new DatabaseConnection().getConnection();
			stmt = conn.prepareStatement("DELETE FROM book WHERE id = ?");
			stmt.setLong(1, bookId);
			stmt.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close();
		}
	}
	
	private void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException sqle) {}
	}

}
