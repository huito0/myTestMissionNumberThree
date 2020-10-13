package org.dexsys;

import java.sql.*;

public class JdbcCheckUserAndAdd {
    private static final String USER_NAME_DB = "postgres";
    private static final String PASS_DB = "WcG2010l";
    private static final String URI = "jdbc:postgresql://localhost:5432/student";

    public void checkUserInTable (String name, String secondName, int age) {
        boolean isUserHere = false;
        try {
            Connection connection = DriverManager.getConnection(URI, USER_NAME_DB, PASS_DB);
            Statement statement = connection.createStatement();
            try {
                ResultSet resultSet = statement.executeQuery(String.format(
                        "SELECT * FROM STUDENT WHERE NAME = '%s' AND SECONDNAME = '%s' AND AGE = '%s'", name, secondName, age));
                if (resultSet.next()) {
                    isUserHere = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (!isUserHere) {
                statement.execute(String.format(
                        "INSERT INTO STUDENT (NAME, SECONDNAME, AGE) VALUES ('%s', '%s', '%s')",
                        name, secondName, age));
                System.out.println("Пользователь ("+ name + " | " + secondName +  " | "  + age + ") добавлен в базу");
            } else {
                System.out.println("Пользователь ("+ name + " | " + secondName +  " | "  + age + ") уже присутствует в базе");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
