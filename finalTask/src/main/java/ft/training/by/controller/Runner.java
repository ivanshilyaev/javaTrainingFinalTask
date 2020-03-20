package ft.training.by.controller;

import ft.training.by.bean.Faculty;
import ft.training.by.bean.User;
import ft.training.by.dao.AbstractDAO;
import ft.training.by.dao.FacultyDAO;
import ft.training.by.dao.UserDAO;
import ft.training.by.dao.exception.DAOException;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        try {
            AbstractDAO facultyDAO = new FacultyDAO();
            List<Faculty> list = facultyDAO.findAll();
            if (!list.isEmpty()) {
                for (Faculty faculty : list) {
                    System.out.println(faculty);
                }
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
