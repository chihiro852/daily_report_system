package controllers.times;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import models.Time;
import utils.DBUtil;

/**
 * Servlet implementation class TimesCreateServlet
 */
@WebServlet("/times/create")
public class TimesCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimesCreateServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            EntityManager em = DBUtil.createEntityManager();

            Time t = new Time();

            t.setEmployee((Employee)request.getSession().getAttribute("login_employee"));

            Date time_date = new Date(System.currentTimeMillis());
            t.setTime_date(time_date);

            t.setClock_in(new Timestamp(System.currentTimeMillis()));

            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            request.getSession().setAttribute("flush", "出勤しました。");
            em.close();

            response.sendRedirect(request.getContextPath() + "/times/index");

    }
}
