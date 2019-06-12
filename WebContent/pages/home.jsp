<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String imageURL = application.getInitParameter("imageURL");
%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="es.sommer.bookstore.model.Book"%>

<jsp:include page="header.jsp" flush="true" />
	<div class="container">
		<p></p>
		<div class="row">		
			<jsp:include page="leftColumn.jsp" flush="true" />
			<div class="col-md-10">
				<div class="card">
					<h5 class="card-header">Featured Books</h5>
					<div class="card-body">
						<div class="row">
						<%
				        	List<Book> books = (List<Book>) request.getAttribute("bookList");
				        	Iterator<Book> iterator = books.iterator();
				
				        	while (iterator.hasNext()) {
				          	Book book = (Book)iterator.next();
				  		%>
						<div class="col-md-2">
							<div class="card">
							  <img src="<%=imageURL%>/<%= book.getImagepath() %>" class="card-img-top" alt="...">
							  <div class="card-body">
							    <h6 class="card-title"><%= book.getBookTitle() %></h6>
							  </div>
							</div>
						</div>
						<%
	          				}
	  					%>
						</div>	
					</div>
				</div>
			</div>
		</div>	
		
	</div>
<jsp:include page="footer.jsp" flush="true" />
	