<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Patient Data App</title>
  <link rel="stylesheet" href="searchResult.css">

</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h1>Search</h1>
  <form method="POST" action="/searchResult.html">
    <input type="text" name="searchstring" placeholder="Enter search keyword here"/>
    <input type="submit" value="Search"/>
  </form>

  <h1>Search Result</h1>
  <%
    List<String> searchResults = (List<String>) request.getAttribute("result");
    List<String> IDs = (List<String>) request.getAttribute("IDs");

    if (searchResults.size() !=0)
    {
    %>
    <ul>
      <%
        for (int i =0; i< searchResults.size();i++)
        {
          String href = "patientInfo.html?patientID=" + IDs.get(i);
      %>
      <li><a href="<%=href%>"><%=searchResults.get(i)%></a></li>
     <% }
    } else
    {%>
      <p>Nothing found</p>
  <%}%>
  </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>