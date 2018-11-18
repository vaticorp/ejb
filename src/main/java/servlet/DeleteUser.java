package servlet;

import ejb.UserBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class represents servlet for delete user.
 * @author Svyatoslav Sabirov.
 * @since 17.11.2018
 * @version 7.
 */
@WebServlet("/delete")
public class DeleteUser extends HttpServlet {

    @EJB
    private UserBean userBean;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null && req.getParameter("id") != "") {
            long id = Long.valueOf(req.getParameter("id"));
            userBean.delete(id);
        }
        resp.sendRedirect("list");
    }
}
