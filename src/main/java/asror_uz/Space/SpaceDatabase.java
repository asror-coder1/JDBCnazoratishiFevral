package asror_uz.Space;

import java.sql.*;

public class SpaceDatabase {

    String url = "jdbc:postgresql://localhost:5432/imtihon";
    String username = "postgres";
    String password = "root";

    // CREATE
    public void createSpace(Space space) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String query = "insert into space " +
                    "(id, name, color, workspace_id, initial_letter, icon_id, avatar_id, owner_id, access_type) values (" +
                    space.getId() + ",'" +
                    space.getName() + "','" +
                    space.getColor() + "'," +
                    space.getWorkspace_id() + ",'" +
                    space.getInitial_letter() + "'," +
                    space.getIcon_id() + "," +
                    space.getAvatar_id() + "," +
                    space.getOwner_id() + ",'" +
                    space.getAccess_type() +
                    "');";

            statement.execute(query);
            System.out.println("Saqlandi!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // READ
    public void read() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from space");

            while (resultSet.next()) {
                Space space = new Space(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getLong(4),
                        resultSet.getString(5),
                        resultSet.getLong(6),
                        resultSet.getLong(7),
                        resultSet.getLong(8),
                        resultSet.getString(9)
                );

                System.out.println(space);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // UPDATE
    public void update(Long id, String name) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String query = "update space set name='" + name + "' where id=" + id;
            statement.execute(query);

            System.out.println("Update bo‘ldi!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // DELETE
    public void delete(Long id) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String query = "delete from space where id=" + id;
            statement.execute(query);

            System.out.println("Deleted!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}