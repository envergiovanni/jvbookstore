<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="es.sommer.bookstore.model.Book"%>

<jsp:include page="header.jsp" flush="true" />
	<div class="container">
		<div class="row">
			<jsp:include page="leftColumn.jsp" flush="true" />
			<div class="col-md-10">
				<div class="card">
					<h5 class="card-header">Search Results</h5>
					<div class="card-body">
						<jsp:include page="list.jsp" flush="true" />
					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp" flush="true" />