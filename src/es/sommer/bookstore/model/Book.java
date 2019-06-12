package es.sommer.bookstore.model;

import java.util.List;

public class Book {
	
	private Long id;
	private Long categoryId;
	private String bookTitle;
	private List<Author> authors;
	private String imagepath;
	
	public Book() {
	}

	public Book(Long id, Long categoryId, String bookTitle, List<Author> authors) {
		this.id = id;
		this.categoryId = categoryId;
		this.bookTitle = bookTitle;
		this.authors = authors;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", categoryId=" + categoryId + ", bookTitle=" + bookTitle + ", authors=" + authors
				+ "]";
	}
	
}
