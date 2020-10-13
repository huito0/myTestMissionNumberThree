package org.dexsys;

import java.sql.*;

public class Main {

    public static void main( String[] args ) {
        JdbcCheckUserAndAdd method = new JdbcCheckUserAndAdd();
        method.checkUserInTable("German", "Konrad", 25);

    }
}
