package controllers.disceplines;

import datebase.DBManager;
import entity.disciplines.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisceplineEditController", urlPatterns = "/discipline-edit")
public class DisceplineEditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idDisc = req.getParameter("idModifyDisc");

        Discipline discipline = DBManager.getDisciplineById(idDisc);
        req.setAttribute("discipline", discipline);

        req.setAttribute("currentPage", "/WEB-INF/jsp/pages/disciplines/disciplineEdit.jsp");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idEditDiscipline = req.getParameter("idEditDiscipline");
        String nameEditDiscipline = req.getParameter("discipName");

        DBManager.editDiscipline(idEditDiscipline, nameEditDiscipline);
        resp.sendRedirect("/discipline-edit?idModifyDisc=" + idEditDiscipline);
    }
}
