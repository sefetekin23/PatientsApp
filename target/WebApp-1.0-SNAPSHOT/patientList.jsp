<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <title>Patient Data App</title>
  <link rel="stylesheet" href="patientList.css">

</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h2>Patients:</h2>
  <form action="SortServlet" method="get">
    <div class="dropdownWrapper">
      <select name="sortByColumn" onchange="this.form.submit()" class="sortByColumn">
        <option value="">Sort</option>
        <%
          String currentSort = (String) session.getAttribute("sortByColumn");
          List<String> columnNames = (List<String>) request.getAttribute("columnNames");
          for(String columnName : columnNames) {
            // Check if the current option is the current sort criterion
            String selected = columnName.equals(currentSort) ? "selected" : "";
        %>
        <option <%=selected%> value="<%=columnName%>"><%=columnName%></option>
        <%
          }
        %>
      </select>
    </div>
  </form>
  <ul>
    <%
      List<String> patients = (List<String>) request.getAttribute("patientNames");
      List<String> ID = (List<String>) request.getAttribute("patientID"); // Note the lowercase 'd' in "patientId"
      List<String> sortInfo = (List<String>) request.getAttribute("sortInfo");
      for (int i=0; i< patients.size();i++)
      {
        String href = "patientInfo.html?patientID=" + ID.get(i);
    %>
    <li><a href="<%=href%>"><%=patients.get(i) + ": "+sortInfo.get(i)%></a> </li>
    <% } %>
  </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
