<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Search List</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/searchView"
		method="post">
		<c:forEach items="${sessionScope.tedTalks}" var="talk">
			<iframe width="560" height="315" src="${talk.link}" frameborder="0"
				allowfullscreen></iframe>
			<table>
				<tr>
					<td><c:out value="${talk.title}" /></td>
					<td><c:out value="${talk.description}" /></td>
					<c:forEach items="${sessionScope.accounts}" var="account">
						<c:forEach items="${sessionScope.reviews}" var="review">
							<c:forEach items="${sessionScope.topics}" var="topic">
								<c:if test="${talk.topicId == topic.topicId}">
									<td><c:out value="${topic.topic}" /></td>
								</c:if>
							</c:forEach>
						</c:forEach>
					</c:forEach>
				</tr>
			</table>
		</c:forEach>
	</form>
</body>
</html>