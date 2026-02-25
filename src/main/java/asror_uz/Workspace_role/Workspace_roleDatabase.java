package asror_uz.Workspace_role;

import java.sql.*;

public class Workspace_roleDatabase {
    String url = "jdbc:postgresql://localhost:5432/imtihon";
    String username = "postgres";
    String password = "root";

//    CRUD

//    1 - Create

    public void create(Workspace_role workspaceRole){
        try {
            Connection connection = DriverManager.getConnection(url , username  ,password);
            Statement statement = connection.createStatement();

            String query = "insert into workspace_role(id , wokspace_id , name , exends_role)values("+
                   workspaceRole.getId() + "," + workspaceRole.getWorksapce_id() + ",'" + workspaceRole.getName() + "','" + workspaceRole.getExtends_role() + "');";

            statement.execute(query);
            System.out.println("Saqlandi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    2 - Read

    public void read(){
        try {
            Connection connection = DriverManager.getConnection(url , username  ,password);
            Statement statement = connection.createStatement();

            String query = "select * from workspace_role";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Long id = resultSet.getLong(1);
                Long workspace = resultSet.getLong(2);
                String name = resultSet.getString(3);
                String extends_role = resultSet.getString(4);

                Workspace_role workspaceRole = new Workspace_role(id, workspace, name, extends_role);
                System.out.println(workspaceRole);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    3 - Update

    public void update(Long id , String name){
        try {
            Connection connection = DriverManager.getConnection(url , username  ,password);
            Statement statement = connection.createStatement();


            String query = "update workspace_role set name='" + name + "' where id = " + id + ";";
            statement.execute(query);
            System.out.println("Update boldi !!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    4 - Delete

    public void delete(Long id){
        try {
            Connection connection = DriverManager.getConnection(url , username  ,password);
            Statement statement = connection.createStatement();

            String query = "delete from workspace_role where id = " + id + ";";

            statement.execute(query);
            System.out.println("Deleted Workspace_role");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
