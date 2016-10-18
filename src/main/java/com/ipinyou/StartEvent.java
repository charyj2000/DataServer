package com.ipinyou;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class StartEvent extends HttpServlet {

    private static final long serialVersionUID = -9045451275234606838L;

    // Servlet's init method will be ran at Tomcat staring;
    @Override
    public void init() throws ServletException {

        Runnable task = new Runnable() {

            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                afterStart();
            }
        };

        new Thread(task).start();
    }

    // hope this method ran after Tomcat started
    private void afterStart() {
        System.out.println("end start");
        MemoryData.start();
    }


}
