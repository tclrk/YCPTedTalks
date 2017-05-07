<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert TedTalk Page</title>
<link rel="stylesheet" href="tedTalkPage.css">
</head>
<body>
	<ul class="nav navbar-nav">
		<li><b class="navbar-brand">Cicero</b></li>
		<li class="active"><a href="index">Home</a></li>
		<li><a href="searchPage">Search</a></li>
		<li><a href="tedTalkPage">Begin New TedTalk</a></li>
		<li style="float:right"><a href="accountManagement">My Account</a></li>
		<li><a href="logout">Logout</a></li>
		<li><a href="about">About</a></li>
	</ul>
	<h1>Insert TEDTalk Page</h1>
	<form id="tedForm" name="tedForm"
		action="${pageContext.servletContext.contextPath}/tedTalkPage"
		method="post">
		<c:if test="${sessionScope.login == true}">
			<div class="Link">
				<b><label for="link">TED Talk Link</label></b><br> <input type="text"
					name="link" id="link" size=12 value="${model.link}" />
			</div>

			<div class="Topic">
				<b><label for="topic">Topic</label></b><br> <input type="text"
					name="topic" id="topic" size=12 value="${model.topic}" />
			</div>

			<div class="Author">
				<b><label for="author">Speaker</label></b><br> <input type="text"
					name="author" id="author" size=12 value="${model.speaker}" />
			</div>

			<div class="Title">
				<b><label for="title">Title</label></b><br> <input type="text"
					name="title" id="title" size=12 value="${model.title}" />
			</div>

			<div class="Description">
				<b><label for="description">Description</label></b><br>
				<textarea name="description" id="description"
					placeholder="Please write a description for the TED Talk" size="12"
					value="${model.description}"></textarea>
			</div>
		</c:if>
		<c:if test="${sessionScope.login != true}">
			<h2>Please login before attempting to add a new TED Talk</h2>
		</c:if>
	</form>
		<div class="button">
			<input type="submit" value="Insert TEDTalk" onclick="check()">
		</div>
	<script>
			function check() {
				if (document.tedForm.link.value == ""
						|| document.tedForm.topic.value == ""
						|| document.tedForm.author.value == ""
						|| document.tedForm.description.value == ""
						|| document.tedForm.title.value == "") {
					alert("Complete all fields!");
				} else {
					alert("This Ted Talk will be put in the system.");
				}
			}
		</script>
</body>
</html>