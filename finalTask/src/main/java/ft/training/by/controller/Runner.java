package ft.training.by.controller;

import ft.training.by.bean.*;
import ft.training.by.dao.*;
import ft.training.by.dao.exception.DAOException;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
//        try {
//            AbstractDAO studentDAO = new StudentDAO();
//            List<Student> list = studentDAO.findAll();
//            if (!list.isEmpty()) {
//                for (Student student : list) {
//                    System.out.println(student);
//                }
//            }
//        } catch (DAOException e) {
//            e.printStackTrace();
//        }

        try {
            AbstractDAO studentDAO = new StudentDAO();
            Student student = (Student) studentDAO.findEntityById(23);
            if (student != null) {
                System.out.println(student.getUser().getName());
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
