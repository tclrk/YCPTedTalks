<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>Account Creation</title>
<link rel="stylesheet" type="text/css" href="accountManagement.css">
</head>
<body>
	<c:if test="${sessionScope.login != true}">
		<ul>
			<li><b href="index">Cicero</b></li>
			<li class="active"><a href="index">Home</a></li>
			<li><a href="searchPage">Search</a></li>
			<li><a href="login">Login</a></li>
			<li><a href="about">About</a></li>
		</ul>
		<h1>Please log in before attempting to manage an account!</h1>
	</c:if>
	<c:if test="${sessionScope.login == true}">
		<ul>
			<li><b href="index">Cicero</b></li>
			<li class="active"><a href="index">Home</a></li>
			<li><a href="searchPage">Search</a></li>
			<li><a href="tedTalkPage">Begin New TedTalk</a></li>
			<li style="float:right"><a href="accountManagement">My Account</a></li>
			<li><a href="logout">Logout</a></li>
			<li><a href="about">About</a></li>
		</ul>
		<h1>Change Email</h1>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
		<form
			action="${pageContext.servletContext.contextPath}/accountManagement"
			method="post">
			<table>
				<tr>
					<td class="label">Old Email:</td>
					<td><input type="text" name="oldEmail" size="12" /></td>
				</tr>
				<tr>
					<td class="label">New Email:</td>
					<td><input type="text" name="email" size="12"
						value="${model.email}" /></td>
				</tr>
				<tr>
					<td class="label">Re-enter New Email:</td>
					<td><input type="text" name="reenteredEmail" size="12" /></td>
				</tr>
				<tr>
					<td />
					<td><input type="Submit" name="submit" value="Change Email"></td>
				</tr>
			</table>
		</form>
	</c:if>
</body>
</html>