package jm.task.core.jdbc.dao;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;



import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    Transaction transaction;
    private User user;
    private  static final SessionFactory sessionFactory = Util.getSessionFactory();
    public UserDaoHibernateImpl() {
    }
    @Override
    public void createUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            String createUsersTable = "CREATE TABLE IF NOT EXISTS Users (Id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL, name VARCHAR(100) NOT NULL, lastName VARCHAR(100) NOT NULL, age TINYINT NOT NULL)";
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(createUsersTable);
            query.executeUpdate();
            transaction.commit();
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            String dropUsersTable = "DROP TABLE IF EXISTS Users";
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(dropUsersTable);
            query.executeUpdate();
            transaction.commit();
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getSessionFactory().openSession()) {
            user = new User(name, lastName, age);
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        }  catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            user = session.load(User.class, id);
            session.delete(user);
            transaction.commit();
            System.out.println("Юзер удален");
        }  catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            userList = session.createQuery("from User").getResultList();
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String cleanUsersTable = ("DELETE User ");
            Query query = session.createQuery(cleanUsersTable);
            query.executeUpdate();
            transaction.commit();
            System.out.println("Таблица удалена");
        }  catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
