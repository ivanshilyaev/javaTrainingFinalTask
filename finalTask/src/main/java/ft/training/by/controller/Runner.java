package ft.training.by.controller;

import ft.training.by.bean.User;
import ft.training.by.dao.AbstractDAO;
import ft.training.by.dao.UserDAO;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        AbstractDAO userdao = new UserDAO();
        List<User> list = userdao.findAll();

        if (!list.isEmpty()) {
            for (User user : list) {
                System.out.println(user);
            }
        }
    }
}
