<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Write A Review!</title>
		<link rel="stylesheet" href="CS320_reviewPage.css">
	</head>
	<body>
		<form id="reviewForm" name="reviewForm" action="${pageContext.servletContext.contextPath}/reviewPage" method="post">
			<div class="Name">
				<label="name">Name</label>
				<input type="text" name ="name" id="name" size=12 value ="${name}"/><span id="nameError"></span>
			</div>
		
			<div class="Link">
				<label="ted_talk">TED Talk link</label>
				<input type="text" name ="link" id="link" size=12 value ="${link}"/><span id="linkError"></span>
			</div>
		
			<div class="Topic">
				<label="topic">Topic</label>
				<input type="text" name ="topic" id="topic" size=12 value ="${topic}"/><span id="topicError"></span>
			</div>
		
			<div class="Author">
				<label="author">Author</label>
				<input type="text" name = "author" id="author" size=12 value ="${author}"/><span id="authorError"></span>
			</div>
		
			<div class="Description">
				<label="descript">Description</label><br>
				<textarea name= "descript" id="descript" size=12 value ="${descript}"></textarea><span id="descriptError"></span>
			</div>
			
			<span class="starRating">
				 <label="rating">Rating</label><br>
 				 <input id="rating5" type="radio" name="rating" value="${rating}">
  				 <label for="rating5">5</label>
 				 <input id="rating4" type="radio" name="rating" value="${rating}">
  				 <label for="rating4">4</label>
 				 <input id="rating3" type="radio" name="rating" value="${rating}">
  				 <label for="rating3">3</label>
 				 <input id="rating2" type="radio" name="rating" value="${rating}">
 				 <label for="rating2">2</label>
 				 <input id="rating1" type="radio" name="rating" value="${rating}">
 				 <label for="rating1">1</label>
			</span>
			</div>
		
			<div class="Review">
				<label="review">Review</label><br>
				<textarea name= "review" id="review" size=12 value ="${review}"></textarea><span id="reviewError"></span>
			</div>
			
			<div class="Recommendations"><br>
				<label="recommendations" id="recommendations">Recommendations (Optional)</label><br>
				<input type="checkbox" name="Awesome!">Awesome!<br>
				<input type="checkbox" name="Horrible">1/10, do not recommend<br>
				<input type="checkbox" name="Good">A nice watch, but wouldn't watch it again</>
			</div>
			<button onclick="check()">Submit Review!</button>

	</form>
		<script> 
		function check(){
			if(document.reviewForm.name.value == "" || document.reviewForm.link.value == "" || document.reviewForm.topic.value == "" ||
					document.reviewForm.author.value == "" || document.reviewForm.descript.value == "" || document.reviewForm.review.value == ""){
				alert("Complete all required fields");
			}
			else{
				alert("Your review was submitted!");
			}
		}
		</script>
	</body>
</html>