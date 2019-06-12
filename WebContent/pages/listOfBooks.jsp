<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="es.sommer.bookstore.model.Book"%>

<%
	String imageURL = getServletContext().getInitParameter("imageURL");
%>
<jsp:include page="header.jsp" flush="true" />
	<div class="container">
		<p></p>
		<div class="row">
		<jsp:include page="leftColumn.jsp" flush="true" />
		
		<div class="col-md-10">
			<div class="card">
				<h5 class="card-header">List of All Books</h5>
				<div class="card-body">
					<jsp:include page="list.jsp" flush="true" />
				</div>
			</div>
		</div>
		</div>
		
	</div>
	
<jsp:include page="footer.jsp" flush="true" />