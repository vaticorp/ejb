package servlet;

import ejb.UserBean;
import orm.models.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * This class represents main servlet.
 * @author Svyatoslav Sabirov.
 * @since 17.11.2018
 * @version 9.
 */

@WebServlet("/list")
public class MainServlet extends HttpServlet {

    @EJB
    private UserBean userBean;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        // Получаем список пользователей
        List<User> allUser = userBean.getAll();
        // добавляем полученный список в request,
        // который отправится на jsp
        req.setAttribute("users", allUser);
        // отправляем request на jsp
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}
