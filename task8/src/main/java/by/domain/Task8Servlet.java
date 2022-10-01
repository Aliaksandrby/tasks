/*
* Задание 8:
* Набрать приведенный выше пример, откомпилировать его, разместить на сервере
* (в т.ч. зарегистрировать в web.xml) и запустить из браузера.(стр 70)
* http://localhost:8080/task8
*/
package by.domain;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//TODO: @WebServlet("/") if don't make xml note.
public class Task8Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Task8 Servlet</title></head>");
        out.println("<body><h1>This is my Task8 Servlet</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
