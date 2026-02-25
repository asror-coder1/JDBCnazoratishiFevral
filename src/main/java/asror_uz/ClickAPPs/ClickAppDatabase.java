package asror_uz.ClickAPPs;

import asror_uz.Workspace_role.Workspace_role;

import java.sql.*;

public class ClickAppDatabase {
    String url = "jdbc:postgresql://localhost:5432/imtihon";
    String username = "postgres";
    String password = "root";

//    CRUD

//    1 - Create

    public void createApps(ClickAPPs clickAPPs){
        try {
            Connection connection = DriverManager.getConnection(url , username  ,password);
            Statement statement = connection.createStatement();

            String query = "insert into click_apps(id ,name , icon_id)values("+
                   clickAPPs.getId() + ",'" + clickAPPs.getName() + "'," + clickAPPs.getIcon_id() +
                    ");";

            statement.execute(query);
            System.out.println("Saqlandi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    2 - Read

    public void readApps(){
        try {
            Connection connection = DriverManager.getConnection(url , username  ,password);
            Statement statement = connection.createStatement();

            String query = "select * from click_apps";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                long icon_id = resultSet.getLong(3);

                ClickAPPs clickAPPs = new ClickAPPs(id , name , icon_id);
                System.out.println(clickAPPs);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    3 - Update

    public void updateApps(Long id , String name){
        try {
            Connection connection = DriverManager.getConnection(url , username  ,password);
            Statement statement = connection.createStatement();


            String query = "update click_apps set name='" + name + "' where id = " + id + ";";
            statement.execute(query);
            System.out.println("Update boldi !!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    4 - Delete

    public void deleteApps(Long id){
        try {
            Connection connection = DriverManager.getConnection(url , username  ,password);
            Statement statement = connection.createStatement();

            String query = "delete from click_apps where id = " + id + ";";

            statement.execute(query);
            System.out.println("Deleted Workspace_role");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
