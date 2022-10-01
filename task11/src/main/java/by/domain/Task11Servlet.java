/*
* Сделать сервлет, который по-содержимому User-Agent будет определять
* с помощью какого браузера зашел пользователь, и выводить сообщение вида:
* "Приветствую пользователя Firefox".(стр 73)
* http://localhost:8080/task11
*/

package by.domain;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class Task11Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BrowserBean browserBean = new BrowserBean();
        String infoBrowser = req.getHeader("User-Agent");
        browserBean.setInfo(BrowserChecker.checkBrowser(infoBrowser));
        req.setAttribute("browserBean",browserBean);
        getServletContext().getRequestDispatcher("/jsp/infoBrowser.jsp").forward(req,resp);
    }
}
