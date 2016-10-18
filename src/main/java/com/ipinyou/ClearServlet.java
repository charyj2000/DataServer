package com.ipinyou;

import java.io.IOException;
import java.io.PrintWriter;

public class ClearServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String id = request.getParameter("id");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain; charset=utf-8");

        MemoryData.clean(id);
        PrintWriter printWriter = response.getWriter();

        String result = "flightHandler({\"state\": \"清空成功\"});";
        printWriter.write(result);

        printWriter.flush();
        printWriter.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request , response);
    }
}
