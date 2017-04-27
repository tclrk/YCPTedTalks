<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Index</title>
		<h1> TEDTalk Reviews </h1>
		 <link rel="stylesheet" type="text/css" href="indexPage.css">
	</head>

	<body>
	<c:if test="${sessionScope.login != null}"><h1>Welcome, <c:out value="${sessionScope.name}"/>!</h1></c:if>
		<form action="${pageContext.servletContext.contextPath}/index" method="post">
	<c:choose>
		<c:when test="${sessionScope.login == true}"><input name="logout" type="submit" value="Logout" />
			<input name="tedTalkPage" type="submit" value="Begin New TedTalk Page" />
			<input name="searchPage" type="submit" value="Search"/></c:when>
		<c:when test="${sessionScope.login != true}">
			<input name="login" type="submit" value="Login" />
			<input name="createAccount" type="submit" value="Create An Account" />
		</c:when>
	</c:choose>
		</form>
		<br>
	<div class="recent">
		<h2>Recent Ted Talks</h2>
	</div>
	</body>
</html>
