<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Search Results</title>
</head>
<body>
	<form id=searchView
		action="${pageContext.servletContext.contextPath}/searchView"
		method="post">
		<c:if test="${sessionScope.login == true}">
		<ul>
			<li><b href="index">TEDTalk Reviews</b></li>
			<li class="active"><a href="index">Home</a></li>
			<li><a href="searchPage">Search</a></li>
			<li><a href="logout">Logout</a></li>
			<li><a href="about">About</a></li>
		</ul>
		</c:if>
		<c:if test="${sessionScope.login == false}">
		<ul>
			<li><b href="index">TEDTalk Reviews</b></li>
			<li class="active"><a href="index">Home</a></li>
			<li><a href="searchPage">Search</a></li>
			<li><a href="login">login</a></li>
			<li><a href="about">About</a></li>
		</ul>
		</c:if>
		<h1>Search Results:</h1>
		<c:if test="${sessionScope.results == false}">
			<h2>No search results found!</h2>
		</c:if>
		<c:if test="${sessionScope.results == true}">
			<table>
				<c:forEach items="${sessionScope.tedTalks}" var="talk">
					<tr>
						<td><a href="tedTalkView?tid=${talk.tedTalkId}"><c:out
									value="${talk.title}" /></a></td>
						<c:if test="${sessionScope.admin == true}">
							<td><a href="searchPage?delid=${talk.tedTalkId}">Delete this TEDTalk</a></td>
						</c:if>
					</tr>
					<br>
					<br>
				</c:forEach>
			</table>
		</c:if>
	</form>
</body>
</html>