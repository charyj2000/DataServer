package com.ipinyou;

import java.io.IOException;
import java.io.PrintWriter;

public class GetServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String id = request.getParameter("id");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("flightHandler(" + MemoryData.get(id) + ");");
        printWriter.flush();
        printWriter.close();

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request , response);
    }
}
