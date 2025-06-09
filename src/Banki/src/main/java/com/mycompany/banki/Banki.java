package com.mycompany.banki;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banki {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = connection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT NOW() as fecha");
            if (rs.next()) {
                System.out.println("Fecha actual en DB: " + rs.getString("fecha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close(rs, stmt, conn);
        }
    }
}