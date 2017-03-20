<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<head>
	<title>Read_A_Review</title>
	<style> p {
	float: right;
	border: 3px solid #000080;
	padding: 10px;
	}
	</style>
	

	
</head>

<body>
	<form action="${pageContext.servletContext.contextPath}/ReadAReview" method="get">
	<table>
		<tr>
			<td>Review</td>
		
			<td> <textarea name="Review_message" rows="15" cols="100">
				${reviewText}
			</textarea> </td> 
		
		</tr>
		<tr>
			<td>Link</td>
		
			<td><textarea name="Review_message" rows="1" cols="100">
				${link}
			</textarea>
			</td>
		
		</tr>
		<tr>
		<td>Title</td>
		
		<td> <textarea name="Review_message" rows="1" cols="100">
			${title}
		</textarea> </td>
		</tr>
		<tr>
			<td> Author </td>
	
		<td><textarea name="Review_message" rows="1" cols="100">
			${author}
		</textarea> </td>
		
		</tr>
		<tr>
			<td>Topic</td>
		<td> <textarea name="Review_message" rows="1" cols="100">
			${topic}
		</textarea></td>
		
		<tr>
			<td>Description</td>
		
		<td> <textarea name="Review_message" rows="10" cols="100">
			${description}
		</textarea></td>
		
		<tr>
			<td> Rating</td>
		<td>Date posted: 
			${date}</td>
			</tr>
	</table>
	</form>
	
</body>