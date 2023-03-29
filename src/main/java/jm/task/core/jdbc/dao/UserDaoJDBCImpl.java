//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//    Connection connection = Util.getConnection();
//    public UserDaoJDBCImpl() {
//    }
//    public void createUsersTable() {
//
//        String createUsersTable = "CREATE TABLE IF NOT EXISTS Users (Id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL, name VARCHAR(100) NOT NULL, lastName VARCHAR(100) NOT NULL, age TINYINT NOT NULL)";
//
//        try (Statement st= connection.createStatement()) {
//            st.execute(createUsersTable);
//            System.out.println("Таблица юзеров создана, или уже существует.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
//    }
//
//    public void dropUsersTable() {
//
//        String dropUsersTable = "DROP TABLE IF EXISTS Users";
//
//        try (Statement st = connection.createStatement()){
//            st.executeUpdate(dropUsersTable);
//            System.out.println("База данных удалена, или ее не существует.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//
//        String saveUser = "INSERT INTO Users(name, lastName, age) VALUES (?, ?, ?)";
//
//        try (PreparedStatement preparedStatement = connection.prepareStatement(saveUser)) {
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3, age);
//            preparedStatement.executeUpdate();
//            System.out.println("User с именем – " + name + " добавлен в базу данных");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void removeUserById(long id)  {
//
//        String removeUserById = "DELETE FROM Users WHERE id = ?";
//
//        try (PreparedStatement preparedStatement = connection.prepareStatement(removeUserById)) {
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//            System.out.println("User с id " + id + " удален из базы");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<User> getAllUsers() {
//
//        List<User> userList = new ArrayList<>();
//        String getAllUsers = "SELECT * FROM users";
//
//        try (PreparedStatement preparedStatement = connection.prepareStatement(getAllUsers)) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                User user = new User();
//                System.out.println((resultSet.getLong("id")) + " " +
//                                   (resultSet.getString("name")) + " " +
//                                   (resultSet.getString("lastName")) + " " +
//                                   (resultSet.getByte("age")));
//                user.setId(resultSet.getLong("id"));
//                user.setAge(resultSet.getByte("age"));
//                user.setLastName(resultSet.getString("lastName"));
//                user.setName(resultSet.getString("name"));
//                userList.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return userList;
//    }
//
//    public void cleanUsersTable() {
//
//        String cleanUsersTable = "DELETE FROM Users";
//
//        try (Statement st = connection.createStatement()) {
//            st.executeUpdate(cleanUsersTable);
//            System.out.println("Все юзеры удалены");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
