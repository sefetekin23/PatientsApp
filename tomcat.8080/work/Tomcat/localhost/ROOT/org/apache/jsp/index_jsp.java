/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.45
 * Generated at: 2024-10-26 00:46:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import uk.ac.ucl.model.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("uk.ac.ucl.model");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <title>Patient Data</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"index.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<h2>Welcome to the Patient Data App</h2>\n");
      out.write("\n");
      out.write("<nav>\n");
      out.write("  <ul>\n");
      out.write("    <li>\n");
      out.write("      <a href=\"patientList.html\">View the Patient List</a>\n");
      out.write("    </li>\n");
      out.write("    <li>\n");
      out.write("      <a href=\"search.html\">Search for Keywords</a>\n");
      out.write("    </li>\n");
      out.write("    <li>\n");
      out.write("      <form action=\"DownloadJsonServlet\" method=\"post\">\n");
      out.write("        <input type=\"submit\" value=\"Download JSON\" />\n");
      out.write("      </form>\n");
      out.write("    </li>\n");
      out.write("  </ul>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("<!-- Fun Facts Section -->\n");
      out.write("<div>\n");
      out.write("  <h3>Fun Stats</h3>\n");
      out.write("  <section class=\"funFacts\">\n");
      out.write("    ");

      String oldestPerson = (String) request.getAttribute("oldestPerson");
      String popularPlace = (String) request.getAttribute("popularPlace");
      String popularZip = (String) request.getAttribute("popularZip");
    
      out.write("\n");
      out.write("    <p>");
      out.print(oldestPerson);
      out.write("</p>\n");
      out.write("    <p>");
      out.print(popularPlace);
      out.write("</p>\n");
      out.write("    <p>");
      out.print(popularZip);
      out.write("</p>\n");
      out.write("  </section>\n");
      out.write("\n");
      out.write("  <!-- Graphs Section -->\n");
      out.write("  <section class=\"graphsContainer\">\n");
      out.write("    <h3>Graphs</h3>\n");
      out.write("    <h4>Population Graph</h4>\n");
      out.write("    <button onclick=\"sortGraph('populationGraph')\">Sort</button>\n");
      out.write("    <div id=\"populationGraph\" class=\"graph-container\">\n");
      out.write("      ");

        Map<String, Integer> cityPopulation = (Map<String, Integer>) request.getAttribute("cityPopulation");
        if (cityPopulation != null && !cityPopulation.isEmpty()) {
          for (Map.Entry<String, Integer> entry : cityPopulation.entrySet()) {
            String cityName = entry.getKey();
            Integer population = entry.getValue();
      
      out.write("\n");
      out.write("      <div class=\"bar\" data-value=\"");
      out.print( population );
      out.write("\" style=\"height: ");
      out.print( (int) ((population.doubleValue() / Collections.max(cityPopulation.values())) * 100) );
      out.write("%;\" onmouseover=\"showTooltip(event, '");
      out.print( population );
      out.write("')\" onmouseout=\"hideTooltip()\">\n");
      out.write("        <p>");
      out.print( cityName );
      out.write("</p>\n");
      out.write("      </div>\n");
      out.write("      ");

          }
        }
      
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <h4>Age Graph</h4>\n");
      out.write("    <button onclick=\"sortGraph('ageGraph')\">Sort</button>\n");
      out.write("    <div id=\"ageGraph\" class=\"graph-container\">\n");
      out.write("      ");

        Map<String, Integer> age = (Map<String, Integer>) request.getAttribute("age");
        if (age != null && !age.isEmpty()) {
          for (Map.Entry<String, Integer> entry : age.entrySet()) {
            String ageName = entry.getKey();
            Integer ageNumber = entry.getValue();
      
      out.write("\n");
      out.write("      <div class=\"bar\" data-value=\"");
      out.print( ageNumber );
      out.write("\" style=\"height: ");
      out.print( (int) ((ageNumber.doubleValue() / Collections.max(age.values())) * 100) );
      out.write("%;\" onmouseover=\"showTooltip(event, '");
      out.print( ageNumber );
      out.write("')\" onmouseout=\"hideTooltip()\">\n");
      out.write("        <p>");
      out.print( ageName );
      out.write("</p>\n");
      out.write("      </div>\n");
      out.write("      ");

          }
        }
      
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <h4>Ethnicity Graph</h4>\n");
      out.write("    <button onclick=\"sortGraph('ethnicityGraph')\">Sort</button>\n");
      out.write("    <div id=\"ethnicityGraph\" class=\"graph-container\">\n");
      out.write("      ");

        Map<String, Integer> ethnicity = (Map<String, Integer>) request.getAttribute("ethnicity");
        if (ethnicity != null && !ethnicity.isEmpty()) {
          for (Map.Entry<String, Integer> entry : ethnicity.entrySet()) {
            String ethnicityName = entry.getKey();
            Integer ethnicityPeopleNumber = entry.getValue();
      
      out.write("\n");
      out.write("      <div class=\"bar\" data-value=\"");
      out.print( ethnicityPeopleNumber );
      out.write("\" style=\"height: ");
      out.print( (int) ((ethnicityPeopleNumber.doubleValue() / Collections.max(ethnicity.values())) * 100) );
      out.write("%;\" onmouseover=\"showTooltip(event, '");
      out.print( ethnicityPeopleNumber );
      out.write("')\" onmouseout=\"hideTooltip()\">\n");
      out.write("        <p>");
      out.print( ethnicityName );
      out.write("</p>\n");
      out.write("      </div>\n");
      out.write("      ");

          }
        }
      
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <h4>Race Graph</h4>\n");
      out.write("    <button onclick=\"sortGraph('raceGraph')\">Sort</button>\n");
      out.write("    <div id=\"raceGraph\" class=\"graph-container\">\n");
      out.write("      ");

        Map<String, Integer> race = (Map<String, Integer>) request.getAttribute("race");
        if (race != null && !race.isEmpty()) {
          for (Map.Entry<String, Integer> entry : race.entrySet()) {
            String raceName = entry.getKey();
            Integer racePeopleNumber = entry.getValue();
      
      out.write("\n");
      out.write("      <div class=\"bar\" data-value=\"");
      out.print( racePeopleNumber );
      out.write("\" style=\"height: ");
      out.print( (int) ((racePeopleNumber.doubleValue() / Collections.max(race.values())) * 100) );
      out.write("%;\" onmouseover=\"showTooltip(event, '");
      out.print( racePeopleNumber );
      out.write("')\" onmouseout=\"hideTooltip()\">\n");
      out.write("        <p>");
      out.print( raceName );
      out.write("</p>\n");
      out.write("      </div>\n");
      out.write("      ");

          }
        }
      
      out.write("\n");
      out.write("    </div>\n");
      out.write("  </section>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"tooltip\" style=\"position: absolute; display: none; padding: 4px; background: black; color: white; border-radius: 4px; font-size: 12px;\"></div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("  function sortGraph(graphId) {\n");
      out.write("    const graphContainer = document.getElementById(graphId);\n");
      out.write("    const bars = Array.from(graphContainer.getElementsByClassName('bar'));\n");
      out.write("\n");
      out.write("    const currentOrder = graphContainer.getAttribute('data-order') || 'asc';\n");
      out.write("    const newOrder = currentOrder === 'asc' ? 'desc' : 'asc';\n");
      out.write("\n");
      out.write("    bars.sort((a, b) => {\n");
      out.write("      const aValue = parseInt(a.getAttribute('data-value'));\n");
      out.write("      const bValue = parseInt(b.getAttribute('data-value'));\n");
      out.write("      return newOrder === 'asc' ? aValue - bValue : bValue - aValue;\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    bars.forEach(bar => graphContainer.appendChild(bar));\n");
      out.write("    graphContainer.setAttribute('data-order', newOrder);\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  function showTooltip(e, text) {\n");
      out.write("    var tooltip = document.getElementById('tooltip');\n");
      out.write("    tooltip.style.display = 'block';\n");
      out.write("    tooltip.style.left = e.pageX + 'px';\n");
      out.write("    tooltip.style.top = e.pageY + 'px';\n");
      out.write("    tooltip.textContent = text;\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  function hideTooltip() {\n");
      out.write("    var tooltip = document.getElementById('tooltip');\n");
      out.write("    tooltip.style.display = 'none';\n");
      out.write("  }\n");
      out.write("</script>\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/footer.jsp", out, false);
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
