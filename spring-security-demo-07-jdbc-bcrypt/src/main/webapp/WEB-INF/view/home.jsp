<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>luv2code Company Home Page</title>
</head>
<body>
	<h2>Company Home Page</h2>
	<hr>
	Welcome to home page!
	
	<!-- Display username and role -->
	
	<p>
		User:<security:authentication property="principal.username"/>
		<br><br>
		Role(s):<security:authentication property="principal.authorities"/>
	</p>
	
	<security:authorize access="hasRole('EMPLOYEE')">
	<!-- Add a link to point to /employees  ...this is for the managers -->
	<p>
		<a href="${pageContext.request.contextPath }/employees">Employees Meeting</a>
		Only for Employee page
	</p>
	</security:authorize>
	
	<security:authorize access="hasRole('MANAGER')">
	<!-- Add a link to point to /leaders  ...this is for the managers -->
	<p>
		<a href="${pageContext.request.contextPath }/leaders">Leadership Meeting</a>
		Only for Manager page
	</p>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	<!-- Add a link to point /systems  ...this is for the admins -->
	<p>
		<a href="${pageContext.request.contextPath}/systems">IT system meeting</a>
		(Only for Admin people)
	</p>
	</security:authorize>
	
	<hr>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
	
</body>
</html>


