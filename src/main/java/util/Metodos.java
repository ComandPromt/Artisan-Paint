package util;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import dibujante.VentanaPrincipal;

public class Metodos {

	public static Connection connect;

	static ResultSet result;

	private static String saberIdioma(int idioma) {

		String language = "";

		switch (VentanaPrincipal.idioma.getLanguage()) {

		default:

		case ESPAÑOL:

			language = "SPANISH";

			break;

		case DEUTSCH:

			language = "ALEMAN";

			break;

		case ENGLISH:

			language = "INGLES";

			break;

		case FRANÇAIS:

			language = "FRANCES";

			break;

		case РУССКИЙ:

			language = "RUSO";

			break;

		case ITALIANO:

			language = "ITALIANO";

			break;

		case PORTUGUÊS:

			language = "PORTUGES";

			break;

		case 中國人:

			language = "CHINO";

			break;

		case HINDI:

			language = "HINDU";

			break;
		case 日本:

			language = "JAPONES";

			break;

		case CATALÀ:

			language = "CATALAN";

			break;

		case কোরিয়ান:

			language = "BENGALI";

			break;

		case عرب:

			language = "ARABE";

			break;

		case EUSKARA:

			language = "EUSKERA";

			break;

		case 한국어:

			language = "KOREANO";

			break;

		case TIẾNG_VIỆT:

			language = "VIETNAMITA";

			break;

		case POLSKIE:

			language = "POLACO";

			break;

		case GALEGO:

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

		}

		return connect;

	}

	public static int obtenerNumeroFigura(int idioma, int padre, String hijo) throws IOException, SQLException {

		LinkedList<Integer> lista = new LinkedList<Integer>();

		try {

			conexionBD();

			String tabla = saberIdioma(idioma);

			PreparedStatement st;

			ResultSet result2 = null;

			String consulta = "SELECT G.FIGURA AS 'ID' FROM FIGURAS_" + tabla
					+ " F JOIN GRUPOSFIGURAS G ON G.FIGURA=F.FIGURA WHERE G.GRUPO=" + padre + " AND TEXTO='" + hijo
					+ "'";

			st = connect.prepareStatement(consulta);

			result2 = st.executeQuery();

			while (result2.next()) {

				st = connect.prepareStatement(consulta);

				lista.add(Integer.parseInt(result2.getString("ID")));

			}

		}

		catch (Exception ex) {

		}

		finally {

			connect.close();

		}

		return lista.get(0);

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

		}

		finally {

			connect.close();

		}

		return lista;

	}

}
