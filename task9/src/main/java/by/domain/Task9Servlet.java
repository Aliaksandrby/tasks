/*
 * Задание 9:
 * Сделать простейший сервлет, подсчитывающий количество посещений. То есть
 * при каждом обращении к сервлету, следует увеличивать счетчик посещений, и выводить
 * его значение на страницу. Количество следует хранить в файле.(стр 70)
 * http://localhost:8080/task9
 */
package by.domain;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URI;

//TODO: @WebServlet("/") if don't make xml note.
public class Task9Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static int countVisit;
    private final static URI pathToFile = new URIMaker(
            Task9Servlet.class.
                    getClassLoader().
                    getResource("counter.properties")).
                    getPathToFile();
    static {
            countVisit = MyReader.readFromFile(pathToFile);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Visitor</title></head>");
        out.println("<body><h1>Count visit: " + (++countVisit) + "</h1>");
        out.println("</body></html>");
        MyWriter.writeToFile(pathToFile,countVisit);
    }
}