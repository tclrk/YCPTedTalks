<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<title>Ted Talk </title>
	<link rel="stylesheet" href="tedTalkPage.css">
</head>
<body>
<form id="tedForm" name="tedForm" action="${pageContext.servletContext.contextPath}/tedTalkPage" method="post">
			<div class="Link">
				<label for="link">TED Talk Link</label><br>
				<input type="text" name ="link" id="link" size=12 value ="${model.link}"/>
			</div>
			
			<div class="Topic">
				<label for="topic">Topic</label><br>
				<input type="text" name ="topic" id="topic" size=12 value ="${model.topic}"/>
			</div>
		
			<div class="Author">
				<label for="author">Author</label><br>
				<input type="text" name ="author" id="author" size=12 value ="${model.speaker_id}"/>
			</div>
			
			<div class="Title">
				<label for="title">Title</label><br>
				<input type="text" name ="title" id="title" size=12 value ="${model.title}"/>
			</div>
			
			<div class ="Description">
				<label for="description">Description</label><br>
				<textarea name= "descript" id="descript" placeholder="Please write a description for the TED Talk" size = "12" value ="${model.description}"></textarea>
			</div>	
			<input type="submit" value="Start Ted Talk Page" onclick ="check()"/>
			
<script>
	function check(){
		if(document.tedForm.link.value == "" || document.tedForm.topic.value == "" || document.tedForm.author.value == "" || document.tedForm.description.value == "" 
				|| document.tedForm.title.value == ""){
				alert("Complete all fields!");
		}
		else{
			alert("This Ted Talk will be put in the system");
		}
	}
</script>
</form>
</body>
</html>