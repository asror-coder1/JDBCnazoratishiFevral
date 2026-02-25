package asror_uz.View;

import asror_uz.ClickAPPs.ClickAPPs;

import java.sql.*;

public class ViewDatabase {
    String url = "jdbc:postgresql://localhost:5432/imtihon";
    String username = "postgres";
    String password = "root";

//    CRUD

//    1 - Create

    public void createView(View view){
        try {
            Connection connection = DriverManager.getConnection(url , username  ,password);
            Statement statement = connection.createStatement();

            String query = "insert into view(id ,name , icon_id)values("+
                    view.getId() + ",'" + view.getName() + "'," + view.getIcon_id() +
                    ");";

            statement.execute(query);
            System.out.println("Saqlandi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    2 - Read

    public void readView(){
        try {
            Connection connection = DriverManager.getConnection(url , username  ,password);
            Statement statement = connection.createStatement();

            String query = "select * from view";
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

    public void updateView(Long id , String name){
        try {
            Connection connection = DriverManager.getConnection(url , username  ,password);
            Statement statement = connection.createStatement();


            String query = "update view set name='" + name + "' where id = " + id + ";";
            statement.execute(query);
            System.out.println("Update boldi !!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    4 - Delete

    public void deleteView(Long id){
        try {
            Connection connection = DriverManager.getConnection(url , username  ,password);
            Statement statement = connection.createStatement();

            String query = "delete from view where id = " + id + ";";

            statement.execute(query);
            System.out.println("Deleted Workspace_role");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
