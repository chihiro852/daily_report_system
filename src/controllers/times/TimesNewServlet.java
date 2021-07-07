package controllers.times;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Time;

/**
 * Servlet implementation class TimesNewServlet
 */
@WebServlet("/times/new")
public class TimesNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimesNewServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("time", new Time());

        Time t = new Time();
        t.setTime_date(new Date(System.currentTimeMillis()));
        request.setAttribute("time", t);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/times/new.jsp");
        rd.forward(request, response);
    }

}
