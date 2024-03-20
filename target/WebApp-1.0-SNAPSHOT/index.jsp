<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="uk.ac.ucl.model.*" %>



<!DOCTYPE html>
<html lang="en">

<head>
  <jsp:include page="/meta.jsp"/>
  <meta charset="UTF-8">
  <title>Patient Data</title>
  <link rel="stylesheet" href="index.css">
</head>
<body>

<h2>Welcome to the Patient Data App</h2>

<nav>
  <ul>
    <li>
      <a href="patientList.html">View the Patient Name List</a>
    </li>
    <li>
      <a href="search.html">Search for Keywords</a>
    </li>
  </ul>
</nav>

<!-- Fun Facts Section -->
<div>
  <section class="funFacts">
    <h3>Fun Stats</h3>
    <%
      String oldestPerson = (String) request.getAttribute("oldestPerson");
      String popularPlace = (String) request.getAttribute("popularPlace");
      String popularZip = (String) request.getAttribute("popularZip");

    %>
    <p><%=oldestPerson%></p>
    <p><%=popularPlace%></p>
    <p><%=popularZip%></p>
  </section>

  <!-- Graphs Section -->
  <section class="graphsContainer">
    <h3>Graphs</h3>
    <!-- Placeholder or script for rendering graphs -->
  </section>
</div>

<jsp:include page="/footer.jsp"/>
</body>

</html>
