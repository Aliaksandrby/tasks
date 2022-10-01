/*
* Создать форму с вводом имени, телефона и электронной почты. Создать сервлет,
* который будет получать эти данные, и распечатывать на странице. Если пользователь
* не ввел имя, или одновременно пропущены телефон и электронная почта, следует
* выводить сообщение об ошибке.(стр 72)
* http://localhost:8080/task10
*/

package by.domain;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/show")
public class Task10Servlet extends HttpServlet {
    private List<PersonBean> persons;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PersonBean personBean = new PersonBean();
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String password = req.getParameter("email");
        if(name.equals("") || (phone.equals("") && password.equals("")))
            getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(req,resp);
        else {
            personBean.setName(name);
            personBean.setPhone(phone);
            personBean.setEmail(password);
            persons.add(personBean);
            req.setAttribute("persons",persons);
            getServletContext().getRequestDispatcher("/jsp/infoPersons.jsp").forward(req,resp);
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        persons = new ArrayList<>();
    }
}
