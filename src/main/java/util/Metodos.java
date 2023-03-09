package util;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Metodos {

	public static Connection connect;

	static ResultSet result;

	public static Connection conexionBD() {

		try {

			connect = DriverManager.getConnection("jdbc:sqlite:" + new File(".").getCanonicalPath() + "\\webcamx.db");

		}

		catch (Exception ex) {

		}

		return connect;

	}

	public static LinkedList<String> saberGrupos(boolean padre) throws IOException {

		LinkedList<String> lista = new LinkedList<String>();

		String sql = "";

		try {

			sql = "";

			if (!padre) {

				sql = "";

			}

			PreparedStatement st = connect.prepareStatement("SELECT EMAIL,WEB,TELEFONO,PASS FROM CONFIG");

			result = st.executeQuery();

			result.next();

			lista.add(result.getString("EMAIL"));

			lista.add(result.getString("WEB"));

			lista.add(result.getString("TELEFONO"));

			lista.add(result.getString("PASS"));

		}

		catch (SQLException ex) {

		}

		return lista;

	}

}
