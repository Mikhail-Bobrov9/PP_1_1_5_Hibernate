package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserServiceImpl();

        // создание таблицы
//        userService.createUsersTable();

        //удаление таблицы
//        userService.dropUsersTable();

        //добавляем юзера
//        userService.saveUser("Mikhail", "Bobrov", (byte)27);
//        userService.saveUser("Nikita", "Gaz", (byte) 21);
//        userService.saveUser("Andrey", "Voron", (byte) 35);
//        userService.saveUser("Anton", "Baykov", (byte) 11);

        //удаляем юзера по id
//        userService.removeUserById(2);

        //удалить всех юзеров
//        userService.cleanUsersTable();

        //показать всех юзеров
//        userService.getAllUsers();






    }
}

