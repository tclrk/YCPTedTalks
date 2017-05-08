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
		action="${pageContext.servletContext.contextPath}/tedTalkView"
		method="post">
		<c:if test="${sessionScope.login == true}">
		<div class="header">
			<ul>
				<li><b class="navbar-brand" href="index">Cicero</b></li>
				<li class="active"><a href="index">Home</a></li>
				<li><a href="searchPage">Search</a></li>
				<li><a href="tedTalkPage">Begin New TedTalk</a></li>
				<li style="float:right"><a href="accountManagement">My Account</a></li>
				<li><a href="logout">Logout</a></li>
				<li><a href="about">About</a></li>
			</ul>
		</div>
		</c:if>
		<c:if test="${sessionScope.login != true}">
		<div class="header">
			<ul>
				<li><b class="navbar-brand" href="index">Cicero</b></li>
				<li class="active"><a href="index">Home</a></li>
				<li><a href="searchPage">Search</a></li>
				<li><a href="accountCreation">Create Account</a></li>
				<li><a href="login">Login</a></li>
				<li><a href="about">About</a></li>
			</ul>
		</div>
		</c:if>
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
				<td><c:out value="${talk.description}" /></td>
			</tr>
			<c:if
				test="${sessionScope.talk.topicId == sessionScope.topic.topicId}">
				<tr>
					<td>Related Topics: <b><c:out value="${sessionScope.topic.topic}" /></b></td>
				</tr>
				<tr>
					<td />
				</tr>
			</c:if>
		</table>
		<h2 class="reviews">Reviews</h2>
			<div class="avg">Average Rating: <b><c:out value="${sessionScope.avg}"/></b></div>
		<table class="rev">
			<c:forEach items="${sessionScope.accounts}" var="account">
				<c:forEach items="${sessionScope.reviews}" var="review">
					<c:if test="${review.accountId == account.accountId}">
						<tr>
							<td>Rating: <b><c:out value="${review.rating}" /></b></td>
						</tr>
						<tr>
							<td>Reviewed By: <c:out value="${account.firstName}" /> <c:out
									value="${account.lastName}" />
									<c:if test="${sessionScope.admin == true}">
								<td><a href="tedTalkView?delid=${review.reviewId}">Delete
										this review</a>
							</c:if></td>
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
		<br>
		<input type="submit" name="reviewPage" value="Write A Review!"></>
	</form>
</body>
</html>