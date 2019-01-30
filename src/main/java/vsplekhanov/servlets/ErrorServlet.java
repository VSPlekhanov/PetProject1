package vsplekhanov.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        var code = (int) req.getAttribute("javax.servlet.error.status_code");
        resp.setContentType("text/html");
        var writer = resp.getWriter();

        writer.println(String.format("%s%s%s%s%s%s%s","<!DOCTYPE html>","<html>", "<head>", "<title>", "</title>", "</head>", "<body>"));
        writer.println(String.format("%s%s%s%s%d%s%s","<h1>","Information", "</h1>", "Code: ", code, "</body>", "</html>"));
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
