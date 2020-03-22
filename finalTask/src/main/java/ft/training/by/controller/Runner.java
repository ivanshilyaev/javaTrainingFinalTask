package ft.training.by.controller;

import ft.training.by.bean.*;
import ft.training.by.dao.exception.DAOException;
import ft.training.by.dao.mysql.AbstractDAO;
import ft.training.by.dao.mysql.StudentDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        List<Student> list = null;
        try {
            AbstractDAO studentDAO = new StudentDAO();
            list = studentDAO.findAll();
            if (!list.isEmpty()) {
                for (Student student : list) {
                    System.out.println(student);
                }
            }
        } catch (DAOException e) {
            LOGGER.info("failure", e);
        }

//        try {
//            AbstractDAO studentDAO = new StudentDAO();
//            Student student = (Student) studentDAO.findEntityById(23);
//            if (student != null) {
//                System.out.println(student.getUser().getName());
//            }
//        } catch (DAOException e) {
//            e.printStackTrace();
//        }
    }
}
