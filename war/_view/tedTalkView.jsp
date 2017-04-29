<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<title>Ted Talk </title>
	<link rel="stylesheet" href="tedTalkView.css">
</head>
<body>
<form id="tedTalkoutput" name="tedPage" action="${pageContext.servletContext.contextPath}/tedTalkView" method="post">
				<h2>
					<c:out value="${talk.title}"/>
				</h2>
					<c:if test="${speaker.speakerId == talk.speakerId}">
						<h3>
							By:
							<c:out value="${speaker.firstname}" />
							<c:out value="${speaker.lastname}" />
						</h3>
					</c:if>
				<iframe width="560" height="315" src="${talk.link}" frameborder="0"
					allowfullscreen></iframe>
				<table>
					<tr>
						<td>Description: <c:out value="${talk.description}" /></td>
					</tr>
					<c:forEach items="${sessionScope.accounts}" var="account">
						<c:forEach items="${sessionScope.reviews}" var="review">
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
				</table>
				<button type="submit" value="Write a Review" onclick="location.href='reviewPage'">Write A Review!</button>
			</form>
		</body>
</html>