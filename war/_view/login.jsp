<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Login</title>
		 <link rel="stylesheet" type="text/css" href="loginPage.css">
	</head>

	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
		<form action="${pageContext.servletContext.contextPath}/login" method="post">
			<%Boolean invalidLogin = (Boolean)request.getSession().getAttribute("login_failure"); 
				if(invalidLogin != null) {%><p>Invalid user name and/or password</p><%} %>
		<div class="header">
			<ul>
			<li><a class="name">TEDTalk Reviews</a></li>
			<li><a href="index"> Home</a></li>
			<li><a href="about"> About</a></li>
			<li><a href="searchPage">Search</a></li>
			</ul>
		</div>
		<div class="loginForm">
				<h1>Login</h1>
			<table>
				<tr>
					<td class="label">Email:</td>
					<td><input type="text" name="email" size="12" value="${model.email}" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><input type="password" name="password" size="12" value="${model.password}" /></td>
				</tr>
			</table>
			<div class="button">
				<input type="Submit" name="submit" value="Login">
			</div>
			</div>
		</form>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<div class="footer">
		<ul>
			<li><p>Copyright © 2017 All Rights Reserved</p></li>
		</ul>
		</div>
	</body>
</html>