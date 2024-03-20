<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="uk.ac.ucl.model.*" %>



<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="UTF-8">
  <title>Patient Data</title>
  <link rel="stylesheet" href="index.css">
</head>
<body>

<h2>Welcome to the Patient Data App</h2>

<nav>
  <ul>
    <li>
      <a href="patientList.html">View the Patient List</a>
    </li>
    <li>
      <a href="search.html">Search for Keywords</a>
    </li>
    <li>
      <form action="DownloadJsonServlet" method="post">
        <input type="submit" value="Download JSON" />
      </form>
    </li>
  </ul>

</nav>

<!-- Fun Facts Section -->
<div>
  <h3>Fun Stats</h3>
  <section class="funFacts">

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
    <h4>Population Graph</h4>
    <div class="graph-container">
      <%
        Map<String, Integer> cityPopulation = (Map<String, Integer>) request.getAttribute("cityPopulation");
        if (cityPopulation != null && !cityPopulation.isEmpty()) {
          int numCities = cityPopulation.size();
          int barWidth = Math.max(10, 8000 / numCities); // Dynamic width calculation
          int maxPopulation = Collections.max(cityPopulation.values());

          for (Map.Entry<String, Integer> entry : cityPopulation.entrySet()) {
            String cityName = entry.getKey();
            Integer population = entry.getValue();
            int heightPercentage = (int) ((population.doubleValue() / maxPopulation) * 100);
      %>
      <div class="bar" style="height: <%= heightPercentage %>%; width: <%= barWidth %>px;"
           onmouseover="showTooltip(event, '<%= population %>')"
           onmouseout="hideTooltip()">
        <p><%= cityName %></p>
      </div>
      <%
          }
        }
      %>
    </div>
    <h4>Age Graph</h4>
    <div class="graph-container">
      <%
        Map<String, Integer> age = (Map<String, Integer>) request.getAttribute("age");
        if (age != null && !age.isEmpty()) {
          int numCities = age.size();
          int barWidth = Math.max(10, 8000 / numCities); // Dynamic width calculation
          int maxAge = Collections.max(age.values());

          for (Map.Entry<String, Integer> entry : age.entrySet()) {
            String ageName = entry.getKey();
            Integer ageNumber = entry.getValue();
            int heightPercentage = (int) ((ageNumber.doubleValue() / maxAge) * 100);
      %>
      <div class="bar" style="height: <%= heightPercentage %>%; width: <%= barWidth %>px;"
           onmouseover="showTooltip(event, '<%= ageNumber %>')"
           onmouseout="hideTooltip()">
        <p><%= ageName %></p>
      </div>
      <%
          }
        }
      %>
    </div>
    <h4>Ethnicity Graph</h4>
    <div class="graph-container">
      <%
        Map<String, Integer> ethnicity = (Map<String, Integer>) request.getAttribute("ethnicity");
        if (ethnicity != null && !ethnicity.isEmpty()) {
          int numEthnicity = ethnicity.size();
          int barWidth = Math.max(10, 8000 / numEthnicity); // Dynamic width calculation
          int maxPeopleNumber = Collections.max(ethnicity.values());

          for (Map.Entry<String, Integer> entry : ethnicity.entrySet()) {
            String ethnicityName = entry.getKey();
            Integer ethnicityPeopleNumber = entry.getValue();
            int heightPercentage = (int) ((ethnicityPeopleNumber.doubleValue() / maxPeopleNumber) * 100);
      %>
      <div class="bar" style="height: <%= heightPercentage %>%; width: <%= barWidth %>px;"
           onmouseover="showTooltip(event, '<%= ethnicityPeopleNumber %>')"
           onmouseout="hideTooltip()">
        <p><%= ethnicityName %></p>
      </div>
      <%
          }
        }
      %>
    </div>

    <h4>Race Graph</h4>
    <div class="graph-container">
      <%
        Map<String, Integer> race = (Map<String, Integer>) request.getAttribute("race");
        if (race != null && !race.isEmpty()) {
          int numRace = race.size();
          int barWidth = Math.max(10, 8000 / numRace); // Dynamic width calculation
          int maxPeopleNumber = Collections.max(race.values());

          for (Map.Entry<String, Integer> entry : race.entrySet()) {
            String raceName = entry.getKey();
            Integer racePeopleNumber = entry.getValue();
            int heightPercentage = (int) ((racePeopleNumber.doubleValue() / maxPeopleNumber) * 100);
      %>
      <div class="bar" style="height: <%= heightPercentage %>%; width: <%= barWidth %>px;"
           onmouseover="showTooltip(event, '<%= racePeopleNumber %>')"
           onmouseout="hideTooltip()">
        <p><%= raceName %></p>
      </div>
      <%
          }
        }
      %>
    </div>

  </section>
</div>
<div id="tooltip" style="position: absolute; display: none; padding: 4px; background: black; color: white; border-radius: 4px; font-size: 12px;"></div>

<script>
  function showTooltip(e, text) {
    var tooltip = document.getElementById('tooltip');
    tooltip.style.display = 'block';
    tooltip.style.left = e.pageX + 'px';
    tooltip.style.top = e.pageY + 'px';
    tooltip.textContent = text;
  }

  function hideTooltip() {
    var tooltip = document.getElementById('tooltip');
    tooltip.style.display = 'none';
  }
</script>

<jsp:include page="/footer.jsp"/>
</body>

</html>
