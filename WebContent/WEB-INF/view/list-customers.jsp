
<!-- this makes your life easier -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Customer List</title>
		
		<!-- Link the css files -->
		<link type="text/css" 
			  rel="stylesheet" 
			  href="${pageContext.request.contextPath}/resources/css/style.css"/>
	</head>
	<body>
		<div id="header"> 
			<h2>Customer Relations Manager</h2>
		</div>
		
		<div id="content">
			<!-- add button -->
			<input type="button" value="Add Customer"
				   onClick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			
			
			<div id="table">
				<table>
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<!-- ${customers} is coming from the ModelAttribute -->
						<c:forEach var="tempCustomer" items="${customers}">
							
							<!-- construct and update link with customer id using the JSP tag url-->
							<c:url var="updateLink" value="/customer/showFormForUpdate"> 
								<c:param name="customerId" value="${tempCustomer.id}"></c:param>
							</c:url>
							
							<!--  -->
							<c:url var="deleteLink" value="/customer/delete">
								<c:param name="customerId" value="${tempCustomer.id}"></c:param>
							</c:url>
						
						
							<tr>
								<td>${tempCustomer.firstName}</td>
								<td>${tempCustomer.lastName}</td>
								<td>${tempCustomer.email}</td>
								<!-- display the update link -->
								<td>
									<!-- javascript magic trick -->
									<a href="${updateLink}">Update</a>
									|
									<a href="${deleteLink}"
									   onclick="if (!(confirm ('Delete Customer?'))) return false">
									   Delete
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
	
	</body>
</html>