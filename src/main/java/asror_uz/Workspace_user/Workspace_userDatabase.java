package asror_uz.Workspace_user;

import java.sql.*;

public class Workspace_userDatabase {

    String url = "jdbc:postgresql://localhost:5432/imtihon";
    String username = "postgres";
    String password = "root";

    // 1 - CREATE
    public void createUser(Workspace_user workspaceUser) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String query = "insert into workspace_user(id, workspace_id, user_id, workspace_role_id, date_invited, date_joined) values(" +
                    workspaceUser.getId() + "," +
                    workspaceUser.getWorkspace_id() + "," +
                    workspaceUser.getUser_id() + "," +
                    workspaceUser.getWorkspace_role_id() + ",'" +
                    workspaceUser.getDate_invited() + "','" +
                    workspaceUser.getDate_joined() + "');";

            statement.execute(query);
            System.out.println("Saqlandi");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 2 - READ
    public void readUser() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String query = "select * from workspace_user";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                long id = resultSet.getLong(1);
                long workspace_id = resultSet.getLong(2);
                long user_id = resultSet.getLong(3);
                long workspace_role_id = resultSet.getLong(4);
                String date_invited = resultSet.getString(5);
                String date_joined = resultSet.getString(6);

                Workspace_user workspaceUser =
                        new Workspace_user(id, workspace_id, user_id,
                                workspace_role_id, date_invited, date_joined);

                System.out.println(workspaceUser);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 3 - UPDATE
    public void updateUser(Long id, String date_invited) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String query = "update workspace_user set date_invited='" +
                    date_invited + "' where id=" + id + ";";

            statement.execute(query);
            System.out.println("Update boldi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 4 - DELETE
    public void deleteUser(Long id) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String query = "delete from workspace_user where id=" + id + ";";

            statement.execute(query);
            System.out.println("Deleted Workspace_user");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}