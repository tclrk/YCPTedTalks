<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.List" %>
<% //Source: https://www.aspsnippets.com/Articles/Show-Hide-DIV-with-TextBox-based-on-DropDownList-Selected-Value-Selection-using-JavaScript-and-jQuery.aspx %>
<html>
	<head>
		<title>Search</title>
		<link rel="stylesheet" href="searchPage.css">
	</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/searchPage" method="post">
		<select name="options" id="Type">
			<option value="author"> Search by Author</option>
			<option value="topic"> Search by Topic</option>
			<option value="title">Search by Title</option>
		</select>
		<input type="text" id ="search" name="search" size="36" value= "${model.search}"/>
		<input type="text" id="extraSearch" name="extraSearch" size="36" value="${model.extraSearch}"/>
		<input type="Submit" name="submit" value="Search!">
	</form>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script type="text/javascript">
		$(function () {
			$("#Type").change(function() {
				if($(this).val() == "author") {
					$("#extraSearch").show();
				} else {
					$("#extraSearch").hide();
				}
			});
		});
	</script>
</body>
</html>
