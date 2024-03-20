package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/index.html")
public class StatServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();
        // Example call to get statistics; implement these methods in your model
        String oldestPerson = model.getOldestPerson();
        request.setAttribute("oldestPerson", oldestPerson);

        String popularPlace = model.getMostPopularPlace(); // Corrected method name if necessary
        request.setAttribute("popularPlace", popularPlace); // Corrected attribute name

        String popularZip = model.getMostPopularZIP(); // Corrected method name if necessary
        request.setAttribute("popularZip", popularZip); // Corrected attribute name

        Map<String, Integer> cityPopulation = model.getMapBasic("CITY");
        request.setAttribute("cityPopulation", cityPopulation); // Corrected attribute name

        Map<String, Integer> ethnicity = model.getMapBasic("ETHNICITY");
        request.setAttribute("ethnicity", ethnicity);

        Map<String, Integer> race = model.getMapBasic("RACE");
        request.setAttribute("race", race);

        Map<String, Integer> age = model.getMapAge();
        request.setAttribute("age", age);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/index.jsp");
        dispatch.forward(request, response);

    }
}
