package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;





public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

//        userService.createUsersTable();
//
//        userService.dropUsersTable();
//
//        userService.saveUser("Nikita", "Gaz", (byte) 21);
//        userService.saveUser("Andrey", "Voron", (byte) 35);
//        userService.saveUser("Artur", "Nosov", (byte) 13);
//        userService.saveUser("NoName", "NoNameov", (byte) 99);
//        userService.saveUser("Ashot", "Guramov", (byte) 64);
//
//        userService.removeUserById(2);
//
        userService.cleanUsersTable();
//
        userService.getAllUsers();
    }
}

