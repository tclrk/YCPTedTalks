<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Account Creation</title>
 	<link rel="stylesheet" type="text/css" href="accountCreation.css">
	</head>
	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
		<h1>Create An Account</h1>
		<form action="${pageContext.servletContext.contextPath}/createAccount" method="post">
			<%if((Boolean)request.getSession().getAttribute("bad_info") != null) {%>
				<p>Please fill out all required fields!</p><%} %>
			<%if((Boolean)request.getSession().getAttribute("no_pw_match") != null) {%>
				<p>Passwords do not match!</p><%} %>
			<table>
				<tr>
					<td class="label">Email:</td>
					<td><input type="text" name="email" size="12" value="${model.email}" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><input type="password" name="password" size="12" value="${model.password}" /></td>
				</tr>
				<tr>
					<td class="label">Re-enter Password:</td>
					<td><input type="password" name="reenteredPassword" size="12" value="${model.password}" /></td>
				</tr>
				<tr>
					<td class="label">First Name:</td>
					<td><input type="text" name="firstname" size="12" value="${model.firstName}" /></td>
				</tr>
				<tr>
					<td class="label">Last Name:</td>
					<td><input type="text" name="lastname" size="12" value="${model.lastName}" /></td>
				</tr>
				<tr>
					<td class="label">Student ID:</td>
					<td><input type="text" name="ycp_id" size="12" value="${model.ycp_id}"></td>
				</tr>
				<tr>
					<td class="label">Administrator Key:</td>
					<td><input type="text" name="admin_key" size="12"></td>
				</tr>
				<tr>
					<td class="label">Major:</td>
					<td><input type="text" name="major" size="12" value="${model.major}" /></td>
				</tr>
				<tr>
					<td />
					<td><input type="Submit" name="submit" value="Login"></td>
				</tr>
			</table>
		</form>
	</body>
</html>