package controllers.disceplines;

import datebase.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisciplineCreateController" , urlPatterns = "/discipline-create")
public class DisciplineCreateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("currentPage", "/WEB-INF/jsp/pages/disciplines/disciplineCreate.jsp");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String nameOfDiscipline = req.getParameter("discipName");
        DBManager.insertNewDiscipline(nameOfDiscipline);
        resp.sendRedirect("/disciplines");

    }
}
