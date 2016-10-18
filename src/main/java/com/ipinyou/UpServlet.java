package com.ipinyou;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class UpServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        InputStream inputStream = request.getInputStream();

        String acceptStr = null;
        try {
            acceptStr = inputStreamTOString(inputStream, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null != acceptStr) {
            String id = request.getParameter("id");
            MemoryData.set(id, acceptStr.trim());
        }

        PrintWriter printWriter = response.getWriter();
        printWriter.write("ok");
        printWriter.flush();
        printWriter.close();
    }

    private String inputStreamTOString(InputStream in, String encoding) throws Exception{

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] data = new byte[256];
        int count ;
        while((count = in.read(data,0,256)) != -1)
            outStream.write(data, 0, count);

        return new String(outStream.toByteArray(), encoding);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // doPost(request , response);
    }
}
