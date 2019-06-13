<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="es.sommer.bookstore.model.entity.Book"%>

<%
	String imageURL = getServletContext().getInitParameter("imageURL");
%>
<jsp:include page="partials/header.jsp" flush="true" />
	<div class="container">
		<p></p>
		<div class="row">
		<jsp:include page="partials/leftColumn.jsp" flush="true" />
		
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
	
<jsp:include page="partials/footer.jsp" flush="true" />