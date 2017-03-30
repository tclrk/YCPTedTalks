<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Login</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		td.label {
			text-align: right;
		}
		</style>
	</head>

	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
		<form action="${pageContext.servletContext.contextPath}/createAccount" method="post">
			<%if(request.getAttribute("email") == null || request.getAttribute("password") == null
				|| request.getAttribute("reenteredPassword") == null || request.getAttribute("name") == null
				|| request.getAttribute("student_id") == null || request.getAttribute("major") == null) {%>
				<p>Please fill out all required fields!</p><%} %>
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
					<td class="label">Re-enter Password</td>
					<td><input type="password" name="reenteredPassword" size="12" value="${model.password}" /></td>
				</tr>
				<tr>
					<td class="label">Name</td>
					<td><input type="text" name="name" size="12" value="${model.name}" /></td>
				</tr>
				<tr>
					<td class="label">Student ID</td>
					<td><input type="text" name="student_id" size="12" value="${model.student_id}"></td>
				</tr>
				<tr>
					<td class="label">Major</td>
					<td><input type="text" name="major" size="12" value="${model.major}" /></td>
				</tr>
			</table>
			<input type="Submit" name="submit" value="Login">
		</form>
	</body>
</html>