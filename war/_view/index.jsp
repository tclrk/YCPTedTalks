<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Index</title>
	</head>

	<body>
		<form action="${pageContext.servletContext.contextPath}/index" method="post">
			<input name="login" type="submit" value="Login" />
			<input name="reviewPage" type="submit" value="Write A Review" />
			<input name="readPage" type="submit" value="Read A Review" />
		</form>
	</body>
</html>
