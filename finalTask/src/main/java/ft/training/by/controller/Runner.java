package ft.training.by.controller;

import ft.training.by.bean.Faculty;
import ft.training.by.bean.Group;
import ft.training.by.bean.User;
import ft.training.by.dao.AbstractDAO;
import ft.training.by.dao.FacultyDAO;
import ft.training.by.dao.GroupDAO;
import ft.training.by.dao.UserDAO;
import ft.training.by.dao.exception.DAOException;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
//        try {
//            AbstractDAO groupDAO = new GroupDAO();
//            List<Group> list = groupDAO.findAll();
//            if (!list.isEmpty()) {
//                for (Group group : list) {
//                    System.out.println(group);
//                }
//            }
//        } catch (DAOException e) {
//            e.printStackTrace();
//        }

        try {
            AbstractDAO groupDAO = new GroupDAO();
            Group group = (Group) groupDAO.findEntityById(1);
            if (group != null) {
                System.out.println(group.getGroupNumber());
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
