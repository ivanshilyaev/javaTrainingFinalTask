package ft.training.by.controller;

import ft.training.by.bean.Role;
import ft.training.by.bean.User;
import ft.training.by.service.ConnectorDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();

        Connection connection = null;
        try {
            connection = ConnectorDB.getConnection();
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery("SELECT * FROM user");
                    while (resultSet.next()) {
                        int id = resultSet.getInt(1);
                        String login = resultSet.getString(2);
                        char[] password = resultSet.getString(3).toCharArray();
                        int ch = resultSet.getInt(4);
                        Role role = null;
                        switch (ch) {
                            case 0: {
                                role = Role.STUDENT;
                                break;
                            }
                            case 1: {
                                role = Role.LEADER;
                                break;
                            }
                            case 2: {
                                role = Role.ADMINISTRATOR;
                                break;
                            }
                            case 3: {
                                role = Role.TUTOR;
                                break;
                            }
                            default:
                                break;
                        }
                        String surname = resultSet.getString(5);
                        String name = resultSet.getString(6);
                        String patronymic = resultSet.getString(7);
                        list.add(new User(id, login, password, role,
                                surname, name, patronymic));
                    }
                } finally {
                    if (resultSet != null) {
                        resultSet.close();
                    } else {
                        System.err.println("Ошибка во время чтения из БД");
                    }
                }
            } finally {
                if (statement != null) {
                    statement.close();
                } else {
                    System.err.println("Statement не создан");
                }
            }
        } catch (SQLException e) {
            System.err.println("DB connection error: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
        }

        if (!list.isEmpty()) {
            for (User user : list) {
                System.out.println(user);
            }
        }
    }
}
