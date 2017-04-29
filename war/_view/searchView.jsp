<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Search Results</title>
</head>
<body>
	<form id= searchView action="${pageContext.servletContext.contextPath}/searchView" method="post">
	<ul>
		<li><b href="index">TEDTalk Reviews</b></li>
		<li class="active"><a href="index">Home</a></li>
		<li><a href="searchPage">Search</a></li>
		<li><a href="login">Logout</a></li>
		<li><a href="about">About</a></li> 
	</ul>
		<h1>Search Results:</h1>
		<c:if test="${sessionScope.results == false}">
			<h2>No search results found!</h2>
		</c:if>
		<c:if test="${sessionScope.results == true}">
			<c:forEach items="${sessionScope.tedTalks}" var="talk">
				<a href="tedTalkView?tid=${talk.tedTalkId}"><c:out value="${talk.title}"/></a>
				<br>
				<br>
			</c:forEach>
		</c:if>
	</form>
</body>
</html>