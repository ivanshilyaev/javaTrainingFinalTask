package ft.training.by.controller;

import ft.training.by.bean.Faculty;
import ft.training.by.bean.Group;
import ft.training.by.bean.Subgroup;
import ft.training.by.bean.User;
import ft.training.by.dao.*;
import ft.training.by.dao.exception.DAOException;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
//        try {
//            AbstractDAO subgroupDAO = new SubgroupDAO();
//            List<Subgroup> list = subgroupDAO.findAll();
//            if (!list.isEmpty()) {
//                for (Subgroup subgroup : list) {
//                    System.out.println(subgroup);
//                }
//            }
//        } catch (DAOException e) {
//            e.printStackTrace();
//        }

        try {
            AbstractDAO subgroupDAO = new SubgroupDAO();
            Subgroup subgroup = (Subgroup) subgroupDAO.findEntityById(2);
            if (subgroup != null) {
                System.out.println(subgroup.getSubgroupNumber());
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
