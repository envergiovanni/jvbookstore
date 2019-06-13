<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Hashtable"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="es.sommer.bookstore.model.entity.Book" %>
<%@ page import="es.sommer.bookstore.model.entity.Category" %>

<%
	String param1 = application.getInitParameter("param1");
%>
 
 <div class="col-md-2">
 	<ul class="list-group list-group-root well">
 		<li class="list-group-item"><h4>Sidebar</h4></li>
 		<a class="list-group-item" href="<%=param1%>"><i class="fa fa-home" aria-hidden="true"></i> 
 		Home</a>
 		<a class="list-group-item" href="<%=param1%>?action=allBooks"><i class="fa fa-book" aria-hidden="true"></i>
 		 Books List</a>
 		<a href="#item-1" class="list-group-item" data-toggle="collapse">
    		<i class="fa fa-angle-right" aria-hidden="true"></i>
    		 Categories
  		</a>
  		<div class="list-group collapse" id="item-1">
  		<%
			List<Category> categoryList1 = (List<Category>) getServletContext().getAttribute("categoryList");
			Iterator<Category> iterator1 = categoryList1.iterator();
			while (iterator1.hasNext()) {
			Category category1 = (Category) iterator1.next();
		%>
		<a href="<%=param1%>?action=category&categoryId=<%=category1.getId()%>&category=<%=category1.getCategoryDescription()%>" class="list-group-item">
			<%=category1.getCategoryDescription()%>
		</a>
		<%
			}
		%>
  		</div>
		<a href="#" class="list-group-item"> <i class="fa fa-envelope" aria-hidden="true"></i>
		 Contact Us</a>
 	</ul>
 </div>