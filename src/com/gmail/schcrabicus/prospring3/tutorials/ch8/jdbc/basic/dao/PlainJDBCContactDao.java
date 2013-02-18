package com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.basic.dao;

import com.gmail.schcrabicus.prospring3.tutorials.ch8.jdbc.rowMapper.Contact;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 24.01.13
 * Time: 8:07
 * To change this template use File | Settings | File Templates.
 */
public class PlainJDBCContactDao implements IContactDao {

    private static Logger log = Logger.getLogger(PlainJDBCContactDao.class);

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            log.fatal("mysql jdbc driver not found...");
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/prospring3", "root", "pass");
    }

    private void closeConnection(Connection connection){
        if ( connection == null )
            return;

        try {
            connection.close();
        } catch (SQLException e) {
            log.warn("Failed to close connection : " + e.getMessage());
        }
    }
    @Override
    public List<Contact> findByFirstName(String firstName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Contact> findAll() {
        List<Contact> result = new ArrayList<Contact>();

        Connection connection = null;
        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM contact");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Contact contact = new Contact();
                contact.setId(resultSet.getLong("id"));
                contact.setFirstName(resultSet.getString("first_name"));
                contact.setLastName(resultSet.getString("last_name"));
                contact.setBirthDate(resultSet.getDate("birth_date"));

                result.add(contact);
            }

        } catch (SQLException e) {
            log.warn("SQLException on connection retieving...");
        } finally {
            closeConnection(connection);
        }

        return result;
    }

    @Override
    public void create(Contact object) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.
                    prepareStatement("insert into contact (first_name, last_name, birth_date) values ( ? , ? , ?)",
                            Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, object.getFirstName());
            preparedStatement.setString(2, object.getLastName());
            preparedStatement.setDate(3, object.getBirthDate());

            preparedStatement.execute();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                object.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void delete(Contact object) {
        Connection connection = null;

        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("delete from contact where id = ?");
            preparedStatement.setLong(1, object.getId());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Contact object) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
