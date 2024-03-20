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

@WebServlet("/SortServlet")
public class SortServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sortByColumn = request.getParameter("sortByColumn");
        Model model = ModelFactory.getModel();
        if (sortByColumn == null || sortByColumn.isEmpty()) {
            sortByColumn = "ID";
        }
        model.sortByColumn(sortByColumn); // Sorts the data and updates the model's state



        List<String> columnNames = model.getColumnNames();
        List<String>[] patientNamesIDs = model.getPatientNamesIDs(sortByColumn);
        List<String> patientNames = patientNamesIDs[0];
        List<String> patientID = patientNamesIDs[1];
        List<String> sortInfo = patientNamesIDs[2];

        // Then add the data to the request object that will be sent to the Java Server Page, so that
        // the JSP can access the data (a Java data structure).
        request.setAttribute("patientNames",patientNames);
        request.setAttribute("patientID",patientID);
        request.setAttribute("columnNames",columnNames);
        request.setAttribute("sortInfo",sortInfo);
        request.getSession().setAttribute("sortByColumn", sortByColumn);



        // Assuming you have a method to fetch column names and set attributes for them
        // Redirect or forward to patientList.jsp with the sorted data
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/patientList.jsp");
        dispatch.forward(request, response);
    }
}
