package com.personal.web.spring.web.spring.dao;

import com.personal.web.spring.web.spring.models.Item;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.*;

@Repository("mySql")
public class ItemDaoImpl_mySql implements ItemDao {

    private static final String inputQuery =
            "INSERT INTO items VALUES\n" +
                    "\t(?, ?, ?, ?);";

    private static final String selectById =
            "SELECT id, name, price, availability\n" +
                    "FROM items\n" +
                    "WHERE id = ?;";

    Connection conn = null;
    Statement stmt = null;

    @PostConstruct
    private void initializeConnection() {

        try {
            // db parameters
            String url = "jdbc:mysql://localhost:3306/DB";
            String user = "root";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public int insertItem(Item item) {
        try {
//            stmt = conn.createStatement();

            PreparedStatement preparedStmt = conn.prepareStatement(inputQuery);
            preparedStmt.setInt(1, Integer.parseInt(item.getId()));
            preparedStmt.setString(2, item.getName());
            preparedStmt.setInt(3, item.getCost());
            preparedStmt.setBoolean(4, item.isAvailabilite());
            preparedStmt.execute();

            conn.close();
            System.out.println("from mysql");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public Item getItem(String id) {
        try {
            stmt = conn.createStatement();


            PreparedStatement preparedStatement = conn.prepareStatement(selectById);
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()) {
                return new Item(String.valueOf(result.getInt("id")), result.getNString(2), result.getInt(3), result.getBoolean(4));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
