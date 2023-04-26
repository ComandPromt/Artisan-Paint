package util;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.comboBox.comboSuggestion.ComboBoxSuggestion;

public class Metodos {

	public static Connection connect;

	static ResultSet result;

	private static String saberIdioma(int idioma) {

		String language = "";

		switch (idioma) {

		default:
		case 0:
			language = "SPANISH";
			break;

		case 1:
			language = "ALEMAN";
			break;

		case 2:
			language = "INGLES";
			break;

		case 3:
			language = "FRANCES";
			break;

		case 4:
			language = "RUSO";
			break;

		case 5:
			language = "ITALIANO";
			break;

		case 6:
			language = "PORTUGES";
			break;

		case 7:
			language = "CHINO";
			break;

		case 8:
			language = "HINDU";
			break;
		case 9:
			language = "JAPONES";
			break;

		case 10:
			language = "CATALAN";
			break;
		case 11:
			language = "BENGALI";
			break;

		case 12:
			language = "ARABE";
			break;

		case 13:
			language = "EUSKERA";
			break;

		case 14:
			language = "KOREANO";
			break;

		case 15:
			language = "VIETNAMITA";
			break;

		case 16:
			language = "POLACO";
			break;

		case 17:
			language = "GALEGO";
			break;

		}

		return language;

	}

	public static Connection conexionBD() {

		try {

			connect = DriverManager.getConnection(
					"jdbc:sqlite:" + new File(".").getCanonicalPath() + Mthos.saberSeparador() + "db.db");

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

		return connect;

	}

	public static LinkedList<Integer> obtenerNumeroFigura(int idioma, int padre) throws IOException, SQLException {

		LinkedList<Integer> lista = new LinkedList<Integer>();

		try {

			conexionBD();

			String tabla = saberIdioma(idioma);

			PreparedStatement st;

			ResultSet result2 = null;

			String consulta = "SELECT G.FIGURA AS 'ID' FROM FIGURAS_" + tabla
					+ " F JOIN GRUPOSFIGURAS G ON G.FIGURA=F.FIGURA WHERE G.GRUPO=" + padre;

			st = connect.prepareStatement(consulta);

			result2 = st.executeQuery();
			System.out.println(consulta);
			while (result2.next()) {

				st = connect.prepareStatement(consulta);

				lista.add(Integer.parseInt(result2.getString("ID")));

			}

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

		finally {

			connect.close();

		}

		return lista;

	}

	public static LinkedList<String> obtenerGrupos(int idioma, int padre, boolean subGrupo)
			throws IOException, SQLException {

		LinkedList<String> lista = new LinkedList<String>();

		try {

			conexionBD();

			String tabla = saberIdioma(idioma);

			PreparedStatement st;

			ResultSet result2 = null;

			String consulta = "";

			if (subGrupo && padre > -1) {

				consulta = "SELECT TEXTO FROM FIGURAS_" + tabla
						+ " F JOIN GRUPOSFIGURAS G ON G.FIGURA=F.FIGURA WHERE G.GRUPO=" + padre;

				st = connect.prepareStatement(consulta);

				result2 = st.executeQuery();

				while (result2.next()) {

					st = connect.prepareStatement(consulta);

					lista.add(result2.getString("TEXTO"));

				}

			}

			else {

				st = connect.prepareStatement("SELECT NOMBRE FROM GRUPOS");

				result = st.executeQuery();

				while (result.next()) {

					st = connect.prepareStatement(
							"SELECT TEXTO FROM " + tabla + " WHERE ACCION='" + result.getString("NOMBRE") + "'");

					result2 = st.executeQuery();

					result2.next();

					lista.add(result2.getString("TEXTO"));

				}

			}

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

		finally {

			connect.close();

		}

		return lista;

	}

	public static ComboBoxSuggestion<String> insertarTexto(ComboBoxSuggestion<?> nombreFigura2,
			LinkedList<String> lista) {

		ComboBoxSuggestion<String> combo = new ComboBoxSuggestion<String>();

		for (String dato : lista) {

			combo.addItem(dato);

		}

		return combo;

	}

}
