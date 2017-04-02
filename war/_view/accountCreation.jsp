<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Account Creation</title>
		<style type="text/css">
		.error {
			color: red;
		}
		td.label {
			text-align: top;
		}
		body {
			background-color: green;
			}
		p {
			font-weight:bold;
			}
		submit {
			text-align: right;
			}
		</style>
	</head>
	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
		<form action="${pageContext.servletContext.contextPath}/createAccount" method="post">
			<%if((Boolean)request.getSession().getAttribute("bad_info") != null) {%>
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
					<td class="label">Re-enter Password:</td>
					<td><input type="password" name="reenteredPassword" size="12" value="${model.password}" /></td>
				</tr>
				<tr>
					<td class="label">Name:</td>
					<td><input type="text" name="name" size="12" value="${model.name}" /></td>
				</tr>
				<tr>
					<td class="label">Student ID:</td>
					<td><input type="text" name="student_id" size="12" value="${model.student_id}"></td>
				</tr>
				<tr>
					<td class="label">Professor ID:</td>
					<td><input type="text" name="professor_id" size="12" value="${model.professor_id}"></td>
				</tr>
				<tr>
					<td class="label">Major:</td>
					<td><input type="text" name="major" size="12" value="${model.major}" /></td>
				</tr>
				<tr>
					<td class="label">Year:</td>
					<td><input type="text" name="year" size="12" value="${model.year}" /></td>
				</tr>
				<tr>
					<td />
					<td><input type="Submit" name="submit" value="Login"></td>
				</tr>
			</table>
		</form>
	</body>
</html>