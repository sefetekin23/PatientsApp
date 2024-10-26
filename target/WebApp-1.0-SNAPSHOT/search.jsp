
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="uk.ac.ucl.model.*" %>
<html>


<head>
    <title>Patient Data App</title>
    <link rel="stylesheet" href="search.css">
</head>
<body>
<jsp:include page="/header.jsp"/>

<div class="main">
    <h1>Search</h1>
    <form method="POST" action="/searchResult.html">
        <input type="text" name="searchstring" placeholder="Enter search keyword here"/>
        <input type="submit" value="Search"/>
    </form>
</div>
<jsp:include page="/footer.jsp"/>

</body>
</html>