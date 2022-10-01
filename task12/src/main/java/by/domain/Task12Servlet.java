/*
* Изменить счетчик из задания 2 так, чтобы значение выводилось в виде
* изображения.(стр 76)
* http://localhost:8080/task12
*/

package by.domain;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

public class Task12Servlet extends HttpServlet {
    private static int countVisit;
    private final static URI pathToFile = new URIMaker(
            Task12Servlet.class.
                    getClassLoader().
                    getResource("counter.properties")).
                    getPathToFile();
    static {
        countVisit = MyReader.readFromFile(pathToFile);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpeg");

        ++countVisit;
        ImageCreator image = new ImageCreator(countVisit);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image.getImage(),"jpeg",out);
        MyWriter.writeToFile(pathToFile,countVisit);
    }
}
