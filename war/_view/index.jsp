<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Index</title>
<link rel="stylesheet" type="text/css" href="indexPage.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<form action="${pageContext.servletContext.contextPath}/index"
		method="post">
		<c:choose>
			<c:when test="${sessionScope.login == true}">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<div class="navbar-header">
							<ul class="nav navbar-nav">
								<li><b href="index">Cicero</b></li>
								<li class="active"><a href="index">Home</a></li>
								<li><a href="searchPage">Search</a></li>
								<li><a href="tedTalkPage">Begin New TedTalk</a></li>
								<li style="float: right"><a href="accountManagement">My
										Account</a></li>
								<li style="float: right"><b>Welcome,
										${sessionScope.name}!</b></li>
								<li><a href="logout">Logout</a></li>
								<li><a href="about">About</a></li>
							</ul>
						</div>
					</div>
				</nav>
			</c:when>
			<c:when test="${sessionScope.login != true}">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<div class="navbar-header">
							<ul class="nav navbar-nav">
								<li><b class="navbar-brand">Cicero</b></li>
								<li class="active"><a href="index">Home</a></li>
								<li><a href="searchPage">Search</a></li>
								<li><a href="accountCreation">Create Account</a></li>
								<li><a href="login">Login</a></li>
								<li><a href="about">About</a></li>
							</ul>
						</div>
					</div>
				</nav>
			</c:when>
		</c:choose>

		<h1>CICERO</h1>
		<p>Opinions worth sharing</p>
		<p class="usage">
			Usage only for Civil Engineering Department <br>of York College
			of Pennsylvania
		</p>
		<div class="recent_reviews">
			<table>
				<c:forEach items="${sessionScope.tedTalks}" var="talk">
					<h2>RECENTLY VISITED TEDTalks</h2>
					<tr>
						<td><b><c:out value="${talk.title}" /></b>
						<td>
					</tr>
					<c:forEach items="${sessionScope.accounts}" var="account">
						<c:forEach items="${sessionScope.reviews}" var="review">
							<c:if test="${review.accountId == account.accountId}">
								<c:if test="${review.tedTalkId == talk.tedTalkId}">
									<tr>
										<td>Rating: <b><c:out value="${review.rating}" /></b></td>
									</tr>
								</c:if>
								<tr>
									<td>Reviewer: <c:out value="${account.firstName}" /> <c:out
											value="${account.lastName}" /></td>
								</tr>
								<tr>
									<td><a href="searchPage">Search this Review</a>
									<td>
								</tr>
							</c:if>
						</c:forEach>
					</c:forEach>
				</c:forEach>
			</table>
		</div>
	</form>
</body>
</html>
