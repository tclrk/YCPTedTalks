<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Ted Talk</title>
<link rel="stylesheet" href="tedTalkView.css">
</head>
<body>
	<form id="tedTalkoutput" name="tedPage"
		action="${pageContext.servletContext.contextPath}/tedTalkView" method="post">
		<h2>
			<c:out value="${sessionScope.talk.title}" />
		</h2>
		<c:if
			test="${sessionScope.speaker.speakerId == sessionScope.talk.speakerId}">
			<h3>
				By:
				<c:out value="${sessionScope.speaker.firstname}" />
				<c:out value="${sessionScope.speaker.lastname}" />
			</h3>
		</c:if>
		<iframe width="560" height="315" src="${talk.link}" frameborder="0"
			allowfullscreen></iframe>
		<table>
			<tr>
				<td>Description: <c:out value="${talk.description}" /></td>
			</tr>
			<c:if test="${sessionScope.talk.topicId == sessionScope.topic.topicId}">
				<tr>
					<td>Related Topics: <c:out value="${sessionScope.topic.topic}" /></td>
				</tr>
				<tr>
					<td />
				</tr>
			</c:if>
			<c:forEach items="${sessionScope.accounts}" var="account">
				<c:forEach items="${sessionScope.reviews}" var="review">
					<tr>
						<td>Rating: <c:out value="${review.rating}" /></td>
					</tr>
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
		<input type="submit" name="reviewPage" value="Write A Review!"></>
	</form>
</body>
</html>