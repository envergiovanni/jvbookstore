<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="es.sommer.bookstore.model.entity.Book"%>
<%@ page import="es.sommer.bookstore.model.entity.Author"%>

<jsp:include page="partials/header.jsp" flush="true" />
	<div class="container">
		
		<p></p>
		<div class="row">
			<jsp:include page="partials/leftColumn.jsp" flush="true" />
			<div class="col-md-10">
				<div class="card">
				<%
					String category = request.getParameter("category");
					String categoryId = request.getParameter("categoryId");
					if (category != null) {
				%>
					<h5 class="card-header">List of <%=category%> Books</h5>
				<%
					}
				%>
					<div class="card-body">
						<table class="table table-bordered">
							<thead class="thead-dark">
								<tr>
									<th id="th-title">Book Title</th>
									<th id="th-author">Author</th>
								</tr>
							</thead>
							<tbody>
								<%
									List<Book> books = (List<Book>) request.getAttribute("bookList");
									Iterator<Book> iterator = books.iterator();
									while (iterator.hasNext()) {
										Book book = (Book) iterator.next();
										if (book.getCategoryId().toString().equals(categoryId)) {
											Long bookId = book.getId();
											List<Author> authors = book.getAuthors();
								%>
								<tr>
									<th scope="row" id="r100"><%=book.getBookTitle()%></th>
									<%
										for (Author author : authors) {
													if (book.getId().equals(author.getBookId())) {
									%><td><%=author.getFirstName() + "  "
													+ author.getLastName()%></td>
				
									<%
										}
												}
									%>
				
								</tr>
				
								<%
									}
									}
								%>
							</tbody>
				
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="partials/footer.jsp" flush="true" />