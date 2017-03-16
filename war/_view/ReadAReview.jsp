<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<head>
	<style> p {
	float: right;
	border: 3px solid #000080;
	padding: 10px;
	}
	</style>
	<title>Read_A_Review</title>

	
</head>

<body>
	<form action="${pageContext.servletContext.contextPath}/ReadAReview" method="get">
	
	<div>
		Review
	</div>
	<p>
	<textarea name="Review_message" rows="15" cols="100">
		${reviewText} 
	</textarea>
	</p>
	<div>
		Link
	</div>
	<p>
	<textarea name="Review_message" rows="1" cols="100">
		${link}
	</textarea>
	</p>
	<div>
		Title
	</div>
	<p>
	<textarea name="Review_message" rows="1" cols="100">
		${title}
	</textarea>
	</p>
	<div>
		Author
	</div>
	<p>
	<textarea name="Review_message" rows="1" cols="100">
		${author}
	</textarea>
	</p>
	<div>
		Topic
	</div>
	<p>
	<textarea name="Review_message" rows="1" cols="100">
		${topic}
	</textarea>
	</p>
	<div>
		Description
	</div>
	<p>
	<textarea name="Review_message" rows="10" cols="100">
		${description}
	</textarea>
	</p>
	<div> Rating
	</div>
	<div>Date posted: 
		${date}</div>
	</form>
</body>