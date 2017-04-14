<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
	<head>
		<title>Search</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		td.label {
			text-align: right;
		}
		input[type=text]{
			box-sizing: border-box;
			border: 2px solid #ff193d;
			height: 32px;
 			font-size: 16px;
 			font-family: Helvetica Neue;
		}
		
		input[type=submit]{
   		 background-color: white; 
   		 color: black; 
   		 border: 2px solid #E62B1E;
   		 padding: 6px 20px;
   		 text-align: center;
   		 text-decoration: none;
   		 display: inline-block;
    	 sfont-size: 16px;
   		 margin: 4px 2px;
   		 -webkit-transition-duration: 0.4s; /* for Safari */
    	transition-duration: 0.4s;
   		 cursor: pointer;
   		 font-size: 16px;
 		font-family: Helvetica Neue;
		}

		input[type=submit]:hover{
			background-color: #E62B1E;
   		    color: white;
		}
		body{
			text-align: center;
		}
		</style>
	</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/searchPage" method="post">
		<input type="text" name="search" size="36" value= "${model.search}"/>
		<input type="Submit" name="submit" value="Search!">
	</form>
</body>
</html>