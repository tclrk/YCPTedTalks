<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Search Results</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/searchView"
		method="post">
		<ul>
			<li><b class="navbar-brand" href="index">Ted Talk Reviews</b></li>
			<li class="active"><a href="index">Home</a></li>
			<li><a href="searchPage">Search</a></li>
			<li><a href="login">Login</a></li>
			<li><a href="about">About</a></li> 
		</ul>
		<h1>Search Results:</h1>
		<c:if test="${sessionScope.results == false}">
			<h2>No search results found!</h2>
		</c:if>
		<c:if test="${sessionScope.results == true}">
			<c:forEach items="${sessionScope.tedTalks}" var="talk">
			/*Make title link to tedTalkView jsp to display,
			 then save necessary tedTalk info into session information. 
			 Redirect to the JSP for displaying a tedtalk and its review*/
				<h2>
					<c:out value="${talk.title}" />
				</h2>
				<c:forEach items="${sessionScope.speakers}" var="speaker">
					<c:if test="${speaker.speakerId == talk.speakerId}">
						<h3>
							By:
							<c:out value="${speaker.firstname}" />
							<c:out value="${speaker.lastname}" />
						</h3>
					</c:if>
				</c:forEach>
				<iframe width="560" height="315" src="${talk.link}" frameborder="0"
					allowfullscreen></iframe>
				<table>
					<tr>
						<td>Description: <c:out value="${talk.description}" /></td>
					</tr>
					<c:forEach items="${sessionScope.accounts}" var="account">
						<c:forEach items="${sessionScope.reviews}" var="review">
							<c:forEach items="${sessionScope.topics}" var="topic">
								<c:if test="${talk.topicId == topic.topicId}">
									<tr>
										<td>Related Topics: <c:out value="${topic.topic}" /></td>
									</tr>
									<tr>
										<td />
									</tr>
								</c:if>
							</c:forEach>
							<c:if test="${review.tedTalkId == talk.tedTalkId}">
								<tr>
									<td>Rating: <c:out value="${review.rating}" /></td>
								</tr>
							</c:if>
							<c:if test="${review.accountId == account.accountId}">
								<tr>
									<td>Reviewed By: <c:out value="${account.firstName}" /> <c:out
											value="${account.lastName}" /></td>
								</tr>
								<tr>
									<td>Written On: <c:out value="${review.date}" /></td>
								</tr>
								<tr>
									<td><c:out value="${review.review}" /></td>
								</tr>
								<tr>
									<td />
								</tr>
							</c:if>
						</c:forEach>
					</c:forEach>
				</table>
			</c:forEach>
		</c:if>
	</form>
</body>
</html>