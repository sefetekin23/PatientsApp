package uk.ac.ucl.servlets;

import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.Model;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/DownloadJsonServlet")
public class DownloadJsonServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the response content type to JSON
        response.setContentType("application/json");

        // Set the Content-Disposition header to attachment, with the desired file name
        response.setHeader("Content-Disposition", "attachment;filename=data.json");

        // Sample JSON data
        Model model = ModelFactory.getModel();
        String jsonData = model.toJson();


        // Write the JSON data to the response
        PrintWriter out = response.getWriter();
        out.print(jsonData);
        out.flush();
        out.close();
    }
}
