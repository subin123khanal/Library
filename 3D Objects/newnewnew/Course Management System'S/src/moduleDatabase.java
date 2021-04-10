import Project.DBUtils;

import javax.swing.*;
import java.sql.*;

public class moduleDatabase {
    private Connection connection;

    public moduleDatabase(){


        try {
            connection = DBUtils.getDbConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void insert(int Module_ID, String Module_Name, String Level) {
        try {
            String insert = "INSERT INTO module(Module_ID, Module_Name, Level)" +
                    "VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(insert);
            statement.setInt(1, Module_ID);
            statement.setString(2, Module_Name);
            statement.setString(3, Level);

            statement.executeUpdate();
            System.out.println("New Module is successfully added in database...");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public ResultSet get(){
        String select = "SELECT * FROM modules";

        try {
            PreparedStatement statement = connection.prepareStatement(select);
            return statement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }



    void update(JTextField Module_ID, JTextField Module_Name, JComboBox M_Level) {
        try {
            String update = "UPDATE module SET Module_Name = ?, M_Level = ? WHERE Module_ID = ?";
            PreparedStatement statement = connection.prepareStatement(update);

            statement.setString(2, String.valueOf(Module_Name));
            statement.setString(3, String.valueOf(M_Level));
            statement.setInt(1, Integer.parseInt(String.valueOf(Module_ID)));


            statement.executeUpdate();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    void delete(int Module_ID ){
        String delete ="DELETE FROM modules WHERE Module_ID=?";

        try {
            PreparedStatement statement = connection.prepareStatement(delete);
            statement.setInt(1, Integer.parseInt(String.valueOf(Module_ID)));
            statement.execute();
            System.out.println("Student is successfully deleted from database...");

            statement.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new moduleDatabase();
    }
}