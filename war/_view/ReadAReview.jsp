<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<head>
	<title>Read_A_Review</title>
	<link rel="stylesheet" href="ReadAReviewPage.css">	
</head>

<body>
	<form action="${pageContext.servletContext.contextPath}/ReadAReview" method="get">
	<jsp:declaration>
		String name = "";
		String link = "";
		String title = "";
		String topic = "";
		String description = "";
		String review = "";
		String author = "";
	</jsp:declaration>
	
	<jsp:scriptlet>
		name = request.getParameter("name");
		link = request.getParameter("link");
		title = request.getParameter("title");
		topic = request.getParameter("topic");
		description = request.getParameter("description");
		review = request.getParameter("review");
		author = request.getParameter("author");
	</jsp:scriptlet>
	
	
	<table>
		<tr>
			<td> Name </td>
	
			<td><textarea name="Review_message" rows="1" cols="100">
				<jsp:expression>name</jsp:expression>
			</textarea> </td>
		
		</tr>
		<tr>
			<td>Link</td>
		
			<td><textarea name="Review_message" rows="1" cols="100">
				<jsp:expression>link</jsp:expression>
			</textarea>
			</td>
		
		</tr>
		<tr>
		<td>Title</td>
		
		<td> <textarea name="Review_message" rows="1" cols="100">
			<jsp:expression>title</jsp:expression>
		</textarea> </td>
		</tr>
		<tr>
			<td> Author </td>
	
		<td><textarea name="Review_message" rows="1" cols="100">
			<jsp:expression>author</jsp:expression>
		</textarea> </td>
		
		</tr>
		<tr>
			<td>Topic</td>
		<td> <textarea name="Review_message" rows="1" cols="100">
			<jsp:expression>topic</jsp:expression>
		</textarea></td>
		
		<tr>
			<td>Description</td>
		
		<td> <textarea name="Review_message" rows="10" cols="100">
			<jsp:expression>description</jsp:expression>
		</textarea></td>
		
			<td>Review</td>
		
			<td> <textarea name="Review_message" rows="15" cols="100">
				<jsp:expression>review</jsp:expression>
			</textarea> </td> 
		
		</tr>
	</table>
	</form>
	
</body>
