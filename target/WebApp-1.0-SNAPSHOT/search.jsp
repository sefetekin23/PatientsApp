
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
<div>
    <h1 style="margin: 0; padding: 0; text-align: center;">
        <a href="index.html" style="display: inline-block; background: #0d6efd; color: #fff; padding: 10px 15px; border-radius: 5px; text-decoration: none; transition: all 0.3s ease; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);">Patient Data App</a>
    </h1>
    <div style="clear: both;"></div>
</div>

<div class="main">
    <h1>Search</h1>
    <form method="POST" action="/runsearch.html">
        <input type="text" name="searchstring" placeholder="Enter search keyword here"/>
        <input type="submit" value="Search"/>
    </form>
</div>
<jsp:include page="/footer.jsp"/>

</body>
</html>