package controllers.times;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Time;
import utils.DBUtil;

/**
 * Servlet implementation class TimesShowServlet
 */
@WebServlet("/times/show")
public class TimesShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimesShowServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Time t = em.find(Time.class, Integer.parseInt(request.getParameter("id")));

        request.setAttribute("time", t);

        request.getSession().setAttribute("time_id", t.getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/times/show.jsp");
        rd.forward(request, response);
    }

}
