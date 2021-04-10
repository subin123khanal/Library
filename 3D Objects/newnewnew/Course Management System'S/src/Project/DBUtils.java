
package Project;

import  java.sql.*;

public class DBUtils {

    public static  Connection getDbConnection() throws SQLException {
        String connectionString = "jdbc:mysql://"+Config.dbHost+":"+Config.dbport+
                "/"+Config.dbName+"/"+Config.DbName;


        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());


        return  DriverManager.getConnection(connectionString,Config.dbUser,Config.dbPass);
    }

}


