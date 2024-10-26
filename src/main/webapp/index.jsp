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
    <button onclick="sortGraph('populationGraph')">Sort</button>
    <div id="populationGraph" class="graph-container">
      <%
        Map<String, Integer> cityPopulation = (Map<String, Integer>) request.getAttribute("cityPopulation");
        if (cityPopulation != null && !cityPopulation.isEmpty()) {
          for (Map.Entry<String, Integer> entry : cityPopulation.entrySet()) {
            String cityName = entry.getKey();
            Integer population = entry.getValue();
      %>
      <div class="bar" data-value="<%= population %>" style="height: <%= (int) ((population.doubleValue() / Collections.max(cityPopulation.values())) * 100) %>%;" onmouseover="showTooltip(event, '<%= population %>')" onmouseout="hideTooltip()">
        <p><%= cityName %></p>
      </div>
      <%
          }
        }
      %>
    </div>

    <h4>Age Graph</h4>
    <button onclick="sortGraph('ageGraph')">Sort</button>
    <div id="ageGraph" class="graph-container">
      <%
        Map<String, Integer> age = (Map<String, Integer>) request.getAttribute("age");
        if (age != null && !age.isEmpty()) {
          for (Map.Entry<String, Integer> entry : age.entrySet()) {
            String ageName = entry.getKey();
            Integer ageNumber = entry.getValue();
      %>
      <div class="bar" data-value="<%= ageNumber %>" style="height: <%= (int) ((ageNumber.doubleValue() / Collections.max(age.values())) * 100) %>%;" onmouseover="showTooltip(event, '<%= ageNumber %>')" onmouseout="hideTooltip()">
        <p><%= ageName %></p>
      </div>
      <%
          }
        }
      %>
    </div>

    <h4>Ethnicity Graph</h4>
    <button onclick="sortGraph('ethnicityGraph')">Sort</button>
    <div id="ethnicityGraph" class="graph-container">
      <%
        Map<String, Integer> ethnicity = (Map<String, Integer>) request.getAttribute("ethnicity");
        if (ethnicity != null && !ethnicity.isEmpty()) {
          for (Map.Entry<String, Integer> entry : ethnicity.entrySet()) {
            String ethnicityName = entry.getKey();
            Integer ethnicityPeopleNumber = entry.getValue();
      %>
      <div class="bar" data-value="<%= ethnicityPeopleNumber %>" style="height: <%= (int) ((ethnicityPeopleNumber.doubleValue() / Collections.max(ethnicity.values())) * 100) %>%;" onmouseover="showTooltip(event, '<%= ethnicityPeopleNumber %>')" onmouseout="hideTooltip()">
        <p><%= ethnicityName %></p>
      </div>
      <%
          }
        }
      %>
    </div>

    <h4>Race Graph</h4>
    <button onclick="sortGraph('raceGraph')">Sort</button>
    <div id="raceGraph" class="graph-container">
      <%
        Map<String, Integer> race = (Map<String, Integer>) request.getAttribute("race");
        if (race != null && !race.isEmpty()) {
          for (Map.Entry<String, Integer> entry : race.entrySet()) {
            String raceName = entry.getKey();
            Integer racePeopleNumber = entry.getValue();
      %>
      <div class="bar" data-value="<%= racePeopleNumber %>" style="height: <%= (int) ((racePeopleNumber.doubleValue() / Collections.max(race.values())) * 100) %>%;" onmouseover="showTooltip(event, '<%= racePeopleNumber %>')" onmouseout="hideTooltip()">
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
  function sortGraph(graphId) {
    const graphContainer = document.getElementById(graphId);
    const bars = Array.from(graphContainer.getElementsByClassName('bar'));

    const currentOrder = graphContainer.getAttribute('data-order') || 'asc';
    const newOrder = currentOrder === 'asc' ? 'desc' : 'asc';

    bars.sort((a, b) => {
      const aValue = parseInt(a.getAttribute('data-value'));
      const bValue = parseInt(b.getAttribute('data-value'));
      return newOrder === 'asc' ? aValue - bValue : bValue - aValue;
    });

    bars.forEach(bar => graphContainer.appendChild(bar));
    graphContainer.setAttribute('data-order', newOrder);
  }

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
