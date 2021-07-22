package controllers.times;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Time;
import utils.DBUtil;

/**
 * Servlet implementation class TimesCreateServlet
 */
@WebServlet("/times/breakstart")
public class TimesBreakStartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimesBreakStartServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            EntityManager em = DBUtil.createEntityManager();

            Time t = em.find(Time.class, (Integer)(request.getSession().getAttribute("time_id")));

            Timestamp break_start = new Timestamp(System.currentTimeMillis());
            t.setBreak_start(break_start);

            em.getTransaction().begin();
            em.getTransaction().commit();
            request.getSession().setAttribute("flush", "休憩開始しました。");
            em.close();

            request.getSession().removeAttribute("time_id");

            response.sendRedirect(request.getContextPath() + "/times/index");

    }
}
