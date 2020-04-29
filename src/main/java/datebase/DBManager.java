package datebase;


import entity.Account;
import entity.Term;
import entity.disciplines.Discipline;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DBManager {

    private static Connection connection;

    private static PreparedStatement deleteDisceplines;
    private static PreparedStatement getAccountbyPasswordRole;
    private static PreparedStatement getAllActiveTerm;

    static {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_crm?serverTimezone=UTC", "root", "avenue2020");

            getAccountbyPasswordRole = connection.prepareStatement(
                    "SELECT * FROM user_role\n" +
                            "left join user on user_role.id_user = user.id\n" +
                            "where user.login = ? and user.password = ? and user_role.id_role = ? ;"
            );

            getAllActiveTerm = connection.prepareStatement(
                    "SELECT * FROM term_discipline as td\n" +
                            "left join term as t on td.id_term = t.id\n" +
                            "left join discipline as d on td.id_discipline = d.id\n" +
                            "where t.status = 1 and d.status = 1 order by td.id_term");
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static List<Discipline> getAllActiveDisciplines() {

        LinkedList<Discipline> disciplines = new LinkedList<Discipline>();

        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("select * from discipline WHERE status = 1");

            while (rs.next()) {

                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));

                disciplines.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return disciplines;

    }

    public static Discipline getDisciplineById(String id) {

        Discipline discipline = new Discipline();
        try {

            Statement stm = connection.createStatement();
            ResultSet result = stm.executeQuery("select * from discipline WHERE status = 1 AND id = " + id);

            while (result.next()) {
                discipline.setId(result.getInt("id"));
                discipline.setDiscipline(result.getString("discipline"));
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return discipline;

    }

    public static void insertNewDiscipline(String newDiscipline) {
        try {
            Statement stm = connection.createStatement();
            stm.execute("INSERT INTO `discipline` (`discipline`) VALUES ('" + newDiscipline + "');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editDiscipline(String id, String disciplineName) {
        try {
            PreparedStatement stm = connection.prepareStatement("UPDATE `discipline` SET `discipline` = ? WHERE (`id` = ?);");
            stm.setString(1, disciplineName);
            stm.setString(2, id);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteDisciplines(String ids) {
        try {
            Statement stm = connection.createStatement();
            stm.execute("UPDATE `discipline` SET `status` = '0' WHERE (`id` in (" + ids + "));");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static boolean getAccountByPasswordRole(String login, String password, String role) {


        try {
            getAccountbyPasswordRole.setString(1, login);
            getAccountbyPasswordRole.setString(2, password);
            getAccountbyPasswordRole.setString(3, role);
            ResultSet rs = getAccountbyPasswordRole.executeQuery();

            while (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;

    }

    public static List<Term> getAllActiveTerm() {
        LinkedList<Term> terms = new LinkedList<Term>();

        try {

            ResultSet rs = getAllActiveTerm.executeQuery();

            int lastTermId = -1;
            while (rs.next()) {

                if (lastTermId == -1) {
                    Term term = new Term();
                    term.setId(rs.getInt("id_term"));
                    term.setName(rs.getString("name"));
                    term.setDuration(rs.getString("duration"));

                    Discipline discipline = new Discipline();
                    discipline.setId(rs.getInt("id_discipline"));
                    discipline.setDiscipline(rs.getString("discipline"));

                    term.addDiscipline(discipline);
                    terms.add(term);

                    lastTermId = rs.getInt("id_term");

                } else {

                    int currentTermId = rs.getInt("id_term");
                    if (currentTermId == lastTermId) {

                        Discipline discipline = new Discipline();
                        discipline.setId(rs.getInt("id_discipline"));
                        discipline.setDiscipline(rs.getString("discipline"));
                        Term lastTerm = terms.removeLast();
                        lastTerm.addDiscipline(discipline);
                        terms.add(lastTerm);
                        lastTermId = rs.getInt("id_term");
                    } else {

                        Term term = new Term();
                        term.setId(rs.getInt("id_term"));
                        term.setName(rs.getString("name"));
                        term.setDuration(rs.getString("duration"));

                        Discipline discipline = new Discipline();
                        discipline.setId(rs.getInt("id_discipline"));
                        discipline.setDiscipline(rs.getString("discipline"));

                        term.addDiscipline(discipline);
                        terms.add(term);

                        lastTermId = rs.getInt("id_term");

                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return terms;
    }


}
