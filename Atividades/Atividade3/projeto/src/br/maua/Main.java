package br.maua;

import java.sql.*;

public class Main {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:res/otakuDB.db");
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery("SELECT * FROM animes");
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (resultSet.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1) System.out.print(",  ");
					String columnValue = resultSet.getString(i);
					System.out.print(rsmd.getColumnName(i) + " : " + columnValue);
				}
				System.out.println("");
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
}
