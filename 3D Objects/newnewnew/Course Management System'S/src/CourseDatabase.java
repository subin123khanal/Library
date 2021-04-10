import Project.DBUtils;

import javax.swing.*;
import java.sql.*;

public class CourseDatabase {
    private Connection connection;

    public CourseDatabase(){


        try {
            connection = DBUtils.getDbConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ResultSet get(){
        String select = "SELECT * FROM courses";

        try {
            PreparedStatement statement = connection.prepareStatement(select);
            return statement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    void insert(int Serial_No, int Student_ID, String Module_Name, int Marks, String Result) {
        try {
            String insert = "INSERT INTO marks(Serial_No, Student_Id, Module_Name, Marks, Result)" +
                    "VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(insert);
            statement.setInt(1, Serial_No);
            statement.setInt(2, Student_ID);
            statement.setString(3, Module_Name);
            statement.setInt(4, Marks);
            statement.setString(5, Result);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    void update(int Course_ID, String Course_Name, JComboBox Course_Level) {
        try {
            String update = "UPDATE module SET Course_Name = ?, Course_Level = ? WHERE Course_ID = ?";
            PreparedStatement statement = connection.prepareStatement(update);

            statement.setString(2, Course_Name);
            statement.setString(3, String.valueOf(Course_Level));
            statement.setInt(1, Course_ID);


            statement.executeUpdate();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    void delete(int Module_ID ){
        String delete ="DELETE FROM courses WHERE Module_ID=?";

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