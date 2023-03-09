package dibujante;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.buttons.simple.SimpleButton;
import com.comboBox.comboSuggestion.ComboBoxSuggestion;
import com.spinner.simple.Spinner;

import figuras.Anillo;
import figuras.Cadena;
import figuras.Imagen;
import net.java.dev.colorchooser.demo.CopyColor;
import util.Figura;

@SuppressWarnings("all")

public class VentanaPrincipal extends javax.swing.JFrame {

	public static Spinner moverArriba;

	public static PanelDeDibujo panelDeDibujo;

	private VentanaPrincipal ventanaPrincipal;

	JLabel lblFigura;

	public static CopyColor color1;

	public static CopyColor color2;

	public static Spinner vueltas;

	private Color colorSeleccionado;

	private JTextField textField;

	public static Spinner moverAbajo;

	public static JCheckBox verRegla;

	Spinner grosor;

	private JTextField textField_1;

	Spinner escala;

	public static JCheckBox enCirculo;

	private JCheckBox figuraRellena;

	public JCheckBox dibujarRellena;

	public static ComboBoxSuggestion efectoFigura;

	ComboBoxSuggestion nombreFigura;

	public static ComboBoxSuggestion subTipoFigura;

	LinkedList<String> listaFiguras;

	LinkedList<String> efectosFiguras;

	public static Spinner anguloGiro;

	JCheckBox malla;

	public static JCheckBox redondear;

	public static Spinner radio;

	public enum Language {

		ENGLISH, ESPAÑOL, FRANÇAIS, ITALIANO, PORTUGUÊS, DEUTSCH, РУССКИЙ, 中國人, HINDI, 日本, CATALÀ, বাংলা, عرب, EUSKARA,
		한국어, TIẾNG_VIỆT, POLSKIE, GALEGO;

	}

	public static int getRadio() {

		return radio.getValor();

	}

	private void verGruposFiguras() {

		limpiarSubFiguras();

		switch (nombreFigura.getSelectedItem().toString()) {

		case "Basicas":

			subTipoFigura.addItem("Cilindro");

			subTipoFigura.addItem("Corazon");

			subTipoFigura.addItem("Linea");

			subTipoFigura.addItem("Rectangulo");

			break;

		case "Circulo":

			subTipoFigura.addItem("Circulo");

			subTipoFigura.addItem("Rueda");

			break;

		case "Feria":

			subTipoFigura.addItem("Aro Feria");

			subTipoFigura.addItem("Clasico");

			break;

		case "Mandala":

			subTipoFigura.addItem("Flor");

			subTipoFigura.addItem("Mandala_1");

			subTipoFigura.addItem("Mandala_2");

			subTipoFigura.addItem("Mandala_3");

			subTipoFigura.addItem("Mandala_Circulo");

			subTipoFigura.addItem("Mandala Estrella");

			break;

		case "Geometria":

			subTipoFigura.addItem("Luna");

			subTipoFigura.addItem("Cometa");

			subTipoFigura.addItem("Rombo");

			subTipoFigura.addItem("Hexagono");

			subTipoFigura.addItem("Octagono");

			subTipoFigura.addItem("Paralelograma");

			subTipoFigura.addItem("Pentagono");

			subTipoFigura.addItem("Trapecio");

			break;

		case "Triangulo":

			subTipoFigura.addItem("Equilatero");

			subTipoFigura.addItem("Escaleno");

			subTipoFigura.addItem("Rectangulo");

			break;

		case "Trebol":

			subTipoFigura.addItem("3 hojas");

			subTipoFigura.addItem("4 hojas");

			break;

		case "Otros":

			listaFiguras.add("PacMan");

			subTipoFigura.addItem("Cruz");

			subTipoFigura.addItem("Anillo");

			subTipoFigura.addItem("Semi Circulo");

			subTipoFigura.addItem("Medio Circulo");

			break;

		case "Estrella":

			subTipoFigura.addItem("David Star");

			subTipoFigura.addItem("4 puntas");

			subTipoFigura.addItem("5 puntas");

			subTipoFigura.addItem("360");

			subTipoFigura.addItem("Free");

			break;

		case "Free":

			subTipoFigura.addItem("DibujoLibre_1");

			subTipoFigura.addItem("DibujoLibre_2");

			subTipoFigura.addItem("DibujoLibre_3");

			subTipoFigura.addItem("DibujoLibre_4");

			break;

		}

		// lblFigura.setText(botonSeleccionado);

	}

	public VentanaPrincipal() throws IOException {

		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imagenes/paint.png")));

		getContentPane().setBackground(Color.WHITE);

		setAlwaysOnTop(true);

		setTitle("Test");

		JMenuBar menuBar = new JMenuBar();

		setJMenuBar(menuBar);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");

		menuBar.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");

		menuBar.add(mntmNewMenuItem);

		initComponents();

		setVisible(true);

	}

	void obtenerFiguras() {

		efectosFiguras.add("Circulo");

		listaFiguras.add("Otros");

		Collections.sort(listaFiguras);

		Collections.sort(efectosFiguras);

	}

	public static void main(String[] args) {

		try {

			new VentanaPrincipal().setVisible(true);

		}

		catch (Exception e) {

		}

	}

	public Figura figuraADibujarse(int figuraSeleccionada, Point puntoActual, int anchura, int altura,
			Color colorPrimario, Color colorSecundario) {

		boolean relleno = dibujarRellena.isSelected();

		Figura figuraActual = null;

		if (efectoFigura.getSelectedIndex() > 0) {

			int figura;

			if (subTipoFigura.getItemCount() > 0) {

				figura = 1;

			}

			else {

				figura = 1;

			}

			figuraActual = new Cadena(figura, puntoActual, anchura, altura, colorPrimario, colorSecundario, relleno);

			figuraActual.setVueltas(saberVueltas());

		}

		System.out.println(figuraSeleccionada);

		switch (figuraSeleccionada) {

		case 1:

			figuraActual = new Anillo(puntoActual, anchura, altura, colorPrimario, colorSecundario, relleno);

			figuraActual.setDibujarRellena(dibujarRellena.isSelected());

			figuraActual.setVueltas(vueltas.getValor());

			figuraActual.setMainColor(color1.getColor());

			figuraActual.setBackgroundColor(color2.getColor());

			break;

		/*
		 * case "Rectangulo":
		 * 
		 * figuraActual = new Rectangulo(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Circulo":
		 * 
		 * figuraActual = new Circulo(puntoActual, anchura, altura, colorPrimario,
		 * colorSecundario, relleno);
		 * 
		 * break;
		 * 
		 * case "Rombo":
		 * 
		 * figuraActual = new Rombo(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Triangulo":
		 * 
		 * figuraActual = new Triangulo(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Triangulo Rectangulo":
		 * 
		 * figuraActual = new TrianguloRectangulo(puntoActual, anchura, altura,
		 * colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Escaleno":
		 * 
		 * figuraActual = new Escaleno(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Trapecio":
		 * 
		 * figuraActual = new Trapecio(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Free":
		 * 
		 * figuraActual = new StarFree(puntoActual, anchura, altura, colorPrimario,
		 * colorSecundario, relleno);
		 * 
		 * figuraActual.setVueltas(saberVueltas());
		 * 
		 * break;
		 * 
		 * case "5 puntas":
		 * 
		 * figuraActual = new Estrella(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Clasico":
		 * 
		 * figuraActual = new Feria_Clasico(puntoActual, anchura, altura, colorPrimario,
		 * colorSecundario, relleno);
		 * 
		 * figuraActual.setMoverAbajo(saberMoverAbajo());
		 * 
		 * figuraActual.setMoverArriba(saberMoverArriba());
		 * 
		 * break;
		 * 
		 * case "Pentagono":
		 * 
		 * figuraActual = new Pentagono(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Cometa":
		 * 
		 * figuraActual = new Cometa(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Semi Circulo":
		 * 
		 * figuraActual = new SemiCirculo(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Medio Circulo":
		 * 
		 * figuraActual = new MedioCirculo(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * break;
		 * 
		 * case "PacMan":
		 * 
		 * figuraActual = new PacMan(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Paralelograma":
		 * 
		 * figuraActual = new Paralelograma(puntoActual, anchura, altura,
		 * colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Luna":
		 * 
		 * figuraActual = new Luna(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Mandala Estrella":
		 * 
		 * figuraActual = new MandalaEstrella(puntoActual, anchura, altura,
		 * colorPrimario);
		 * 
		 * figuraActual.setVueltas(saberVueltas()); break;
		 * 
		 * case "David Star":
		 * 
		 * figuraActual = new DavidStar(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * figuraActual.setVueltas(saberVueltas());
		 * 
		 * break;
		 * 
		 * case "Hexagono":
		 * 
		 * figuraActual = new Hexagono(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Mandala_1":
		 * 
		 * figuraActual = new Mandala_1(puntoActual, anchura, altura, colorPrimario,
		 * tieneMalla());
		 * 
		 * break;
		 * 
		 * case "Mandala_2":
		 * 
		 * figuraActual = new Mandala_2(puntoActual, anchura, altura, colorPrimario,
		 * tieneMalla());
		 * 
		 * break;
		 * 
		 * case "Mandala_Circulo":
		 * 
		 * figuraActual = new Mandala_Circulo(puntoActual, anchura, altura,
		 * colorPrimario);
		 * 
		 * figuraActual.setVueltas(saberVueltas());
		 * 
		 * break;
		 * 
		 * case "Rueda":
		 * 
		 * figuraActual = new Rueda(puntoActual, anchura, altura, colorPrimario,
		 * colorSecundario, relleno);
		 * 
		 * figuraActual.setVueltas(saberVueltas());
		 * 
		 * break;
		 * 
		 * case "Mandala_3":
		 * 
		 * figuraActual = new Mandala_3(puntoActual, anchura, altura, colorPrimario,
		 * tieneMalla());
		 * 
		 * break;
		 * 
		 * case "DibujoLibre_1":
		 * 
		 * figuraActual = new DibujoLibre_1(puntoActual, anchura, altura, colorPrimario,
		 * tieneMalla());
		 * 
		 * break;
		 * 
		 * case "DibujoLibre_2":
		 * 
		 * figuraActual = new DibujoLibre_2(puntoActual, anchura, altura, colorPrimario,
		 * tieneMalla());
		 * 
		 * break;
		 * 
		 * case "DibujoLibre_3":
		 * 
		 * figuraActual = new DibujoLibre_3(puntoActual, anchura, altura, colorPrimario,
		 * tieneMalla());
		 * 
		 * break;
		 * 
		 * case "DibujoLibre_4":
		 * 
		 * figuraActual = new DibujoLibre_4(puntoActual, anchura, altura, colorPrimario,
		 * tieneMalla());
		 * 
		 * break;
		 * 
		 * case "Flor":
		 * 
		 * figuraActual = new Flor(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Cilindro":
		 * 
		 * figuraActual = new Cilindro(puntoActual, anchura, altura, colorPrimario,
		 * colorSecundario, relleno);
		 * 
		 * figuraActual.setRadio(saberRadio());
		 * 
		 * break;
		 * 
		 * case "Anillo":
		 * 
		 * figuraActual = new Anillo(puntoActual, anchura, altura, colorPrimario,
		 * colorSecundario, relleno);
		 * 
		 * ponerMovimiento(figuraActual);
		 * 
		 * figuraActual.setVueltas(saberVueltas());
		 * 
		 * break;
		 * 
		 * case "Aro Feria":
		 * 
		 * figuraActual = new AroFeria(puntoActual, anchura, altura, colorPrimario,
		 * colorSecundario, relleno);
		 * 
		 * break;
		 * 
		 * case "Octagono":
		 * 
		 * figuraActual = new Octagono(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Cruz":
		 * 
		 * figuraActual = new Cruz(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Corazon":
		 * 
		 * figuraActual = new Corazon(puntoActual, anchura, altura, colorPrimario,
		 * colorSecundario, relleno);
		 * 
		 * break;
		 * 
		 * case "Cubeta":
		 * 
		 * figuraActual = new Cubeta(puntoActual, colorPrimario, panelDeDibujo);
		 * 
		 * break;
		 * 
		 * case "3 hojas":
		 * 
		 * figuraActual = new TrebolTresHojas(puntoActual, anchura, altura,
		 * colorPrimario);
		 * 
		 * break;
		 * 
		 * case "4 hojas":
		 * 
		 * figuraActual = new TrebolCuatroHojas(puntoActual, anchura, altura,
		 * colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Borrador":
		 * 
		 * figuraActual = new Borrador(puntoActual);
		 * 
		 * break;
		 * 
		 * case "Lapiz":
		 * 
		 * figuraActual = new DibujoLibre(puntoActual, colorPrimario);
		 * 
		 * break;
		 * 
		 * default:
		 * 
		 * case "Gotero":
		 * 
		 * figuraActual = null;
		 * 
		 * break;
		 * 
		 * case "Flecha Derecha":
		 * 
		 * figuraActual = new FlechaDerecha(puntoActual, anchura, altura,
		 * colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Flecha Izquierda":
		 * 
		 * figuraActual = new FlechaIzquierda(puntoActual, anchura, altura,
		 * colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Flecha Arriba":
		 * 
		 * figuraActual = new FlechaArriba(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Flecha Abajo":
		 * 
		 * figuraActual = new FlechaAbajo(puntoActual, anchura, altura, colorPrimario);
		 * 
		 * break;
		 * 
		 * case "Linea":
		 * 
		 * if (relleno) {
		 * 
		 * figuraActual = new LineaRedimensionable(new Point((anchura 4) / 6, (altura 4)
		 * / 6),
		 * 
		 * new Point((anchura 4), (altura 4)), colorPrimario);
		 * 
		 * }
		 * 
		 * else {
		 * 
		 * figuraActual = new LineaRedimensionable(puntoActual, puntoActual,
		 * colorPrimario);
		 * 
		 * }
		 * 
		 * break;
		 */
		}

		return figuraActual;

	}

	private void ponerMovimiento(Figura figuraActual) {

		figuraActual.setMoverArriba(moverArriba.getValor());

		figuraActual.setMoverAbajo(moverAbajo.getValor());

	}

	private int saberEscala() {

		return escala.getValor();

	}

	private boolean tieneMalla() {

		return malla.isSelected();

	}

	private void funcionBtnNuevo() {

		if (!panelDeDibujo.getFiguras().isEmpty()) {

			int resultado = JOptionPane.showConfirmDialog(this, "Deseas guardar los cambios ?", this.getTitle(),
					JOptionPane.YES_NO_CANCEL_OPTION);

			if (resultado == 0) {

				if (guardarImagen() == 0) {

					nuevo();

				}

			}

			else {

				nuevo();

			}
		}

		else {

			nuevo();

		}

	}

	private void nuevo() {

		panelDeDibujo.getFiguras().clear();

		panelDeDibujo.getFigurasDeshechas().clear();

		panelDeDibujo.setBackground(Color.WHITE);

		panelDeDibujo.repaint();

	}

	private int guardarImagen() {

		JFileChooser f = new JFileChooser();

		String extension = ".png";

		f.setAcceptAllFileFilterUsed(false);

		f.addChoosableFileFilter(new FileNameExtensionFilter(".png", "png", "jpg"));

		f.addChoosableFileFilter(new FileNameExtensionFilter(".jpg", "jpg", "png"));

		f.setDialogTitle("Guardar proyecto");

		int resultado = f.showSaveDialog(this);

		if (resultado == JFileChooser.APPROVE_OPTION) {

			try {

				File archivoAGuardar = f.getSelectedFile();

				extension = f.getFileFilter().getDescription();

				System.out.println("Guardar Como: " + archivoAGuardar.getAbsolutePath());

				BufferedImage bi = new BufferedImage(panelDeDibujo.getWidth(), panelDeDibujo.getHeight(),
						BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = bi.createGraphics();
				panelDeDibujo.paint(g);
				ImageIO.write(bi, "PNG", new File(archivoAGuardar.getAbsolutePath() + extension));
				System.out.println(archivoAGuardar.getName());
			} catch (IOException ex) {

			}
		}

		return resultado;
	}

	private BufferedImage abrirImagen() {

		JFileChooser f = new JFileChooser();
		BufferedImage bimg = null;

		f.setFileFilter(new FileNameExtensionFilter("Solo Aceptan Archivos JPG o PNG", "jpg", "png"));
		f.setCurrentDirectory(new File(System.getProperty("user.home")));
		f.setAcceptAllFileFilterUsed(false);

		int resultado = f.showOpenDialog(this);
		if (resultado == JFileChooser.APPROVE_OPTION) {
			try {
				File archivoSeleccionado = f.getSelectedFile();
				System.out.println("Archivo Seleccionado: " + archivoSeleccionado.getAbsolutePath());

				bimg = ImageIO.read(new File(archivoSeleccionado.getAbsolutePath()));

			} catch (IOException ex) {
				ex.printStackTrace();
			}

			return bimg;
		}
		return bimg;
	}

	private void insertarImagenMovible() {

		BufferedImage bimg = abrirImagen();

		if (bimg != null) {

			// lblFigura.setText(botonSeleccionado);

			panelDeDibujo.setFiguraActual(new Imagen(new Point(0, 0), 100, 100, Color.BLACK, bimg));

			panelDeDibujo.getFiguras().add(panelDeDibujo.getFiguraActual());

			panelDeDibujo.repaint();

		}

	}

	private void preguntarAntesDeCerrar() {

		if (!panelDeDibujo.getFiguras().isEmpty()) {

			int resultado = JOptionPane.showConfirmDialog(this, "Deseas guardar los cambios ?",
					"Dibujante - " + this.getTitle(), JOptionPane.YES_NO_CANCEL_OPTION);

			if (resultado == 0) {

				if (guardarImagen() == 0) {

					System.exit(0);

				}

			}

			else {

				System.exit(0);
			}

		}

		else {

			System.exit(0);

		}

	}

	public Color obtenerColorEn(Point puntoActual) {

		BufferedImage image = new BufferedImage(panelDeDibujo.getWidth(), panelDeDibujo.getHeight(),

				BufferedImage.TYPE_4BYTE_ABGR);

		Graphics2D g2 = image.createGraphics();

		panelDeDibujo.paint(g2);

		Color colorObjetivo = new Color(image.getRGB(puntoActual.x, puntoActual.y));

		color1.setColor(colorObjetivo);

		panelDeDibujo.setFiguraActual(null);

		return colorObjetivo;

	}

	private void seleccionarColorPrimario() {

		colorSeleccionado = JColorChooser.showDialog(this, "Selecciona un color.", colorSeleccionado);

		if (colorSeleccionado != null) {

			panelDeDibujo.setColorActual(colorSeleccionado);

			color1.setBackground(colorSeleccionado);

		}

	}

	private void seleccionarColorSecundario() {

		colorSeleccionado = JColorChooser.showDialog(this, "Selecciona un color.", colorSeleccionado);

		if (colorSeleccionado != null) {

			panelDeDibujo.setColorSecundarioActual(colorSeleccionado);

			color2.setBackground(colorSeleccionado);

		}

	}

	private void deshacer() {

		Stack<Figura> figurasDeshechas = panelDeDibujo.getFigurasDeshechas();

		ArrayList<Figura> figuras = panelDeDibujo.getFiguras();

		if (!figuras.isEmpty()) {

			figurasDeshechas.push(figuras.remove(figuras.size() - 1));

			panelDeDibujo.repaint();

			panelDeDibujo.setFiguraActual(null);

			panelDeDibujo.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

		}

	}

	private void rehacer() {

		Stack<Figura> figurasDeshechas = panelDeDibujo.getFigurasDeshechas();

		ArrayList<Figura> figuras = panelDeDibujo.getFiguras();

		if (!figurasDeshechas.isEmpty()) {

			figuras.add(figurasDeshechas.remove(figurasDeshechas.size() - 1));

			panelDeDibujo.repaint();

		}

	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {

		this.ventanaPrincipal = ventanaPrincipal;

	}

	public int getGrosorSeleccionado() {

		return grosor.getValor();

	}

	public boolean getSiseDibujaraRellena() {

		return verRegla.isSelected();

	}

	private void limpiarEfectosFiguras() {

		efectoFigura.removeAllItems();

		efectoFigura.addItem("None");

	}

	private void limpiarSubFiguras() {

		subTipoFigura.removeAllItems();

	}

	public static int saberAngulo() {

		return anguloGiro.getValor();

	}

	public void initComponents() {

		try {

			enCirculo = new JCheckBox();

			enCirculo.setBackground(Color.WHITE);

			escala = new Spinner();

			escala.setMinValor(1);

			figuraRellena = new JCheckBox();

			figuraRellena.setHorizontalAlignment(SwingConstants.RIGHT);

			redondear = new JCheckBox();

			radio = new Spinner();

			radio.setMinValor(1);

			radio.setValor(100);

			moverArriba = new Spinner();

			moverArriba.setMinValor(0);

			efectosFiguras = new LinkedList();

			malla = new JCheckBox();

			efectoFigura = new ComboBoxSuggestion();

			nombreFigura = new ComboBoxSuggestion();

			subTipoFigura = new ComboBoxSuggestion();

			subTipoFigura.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {

					limpiarEfectosFiguras();

					if (subTipoFigura.getItemCount() > 0) {

						if (efectosFiguras.contains(subTipoFigura.getSelectedItem().toString())) {

							efectoFigura.addItem("Cadena");

						}

						dibujarFigura(subTipoFigura.getSelectedIndex());

					}

				}

			});

			listaFiguras = new LinkedList<>();

			lblFigura = new JLabel();

			lblFigura.setHorizontalAlignment(SwingConstants.CENTER);

			lblFigura.setFont(new Font("Segoe UI", Font.BOLD, 11));

			verRegla = new JCheckBox();

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			color1 = new CopyColor(Color.BLACK, false);

			color2 = new CopyColor(Color.WHITE, false);

			setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

			grosor = new Spinner();

			grosor.setMinValor(1);

			grosor.setMaxValor(100);

			grosor.setLabelText("Thickness");

			grosor.setValor(1);

			vueltas = new Spinner();

			vueltas.setMinValor(1);

			vueltas.setLabelText("Laps");

			obtenerFiguras();

			for (String nombreListaFigura : listaFiguras) {

				nombreFigura.addItem(nombreListaFigura);

			}

			panelDeDibujo = new PanelDeDibujo();

			panelDeDibujo.setBackground(Color.WHITE);

			getContentPane().add(panelDeDibujo, BorderLayout.CENTER);

			panelDeDibujo.setVentanaPrincipal(this);

			JPanel jPanel2 = new JPanel();

			jPanel2.setPreferredSize(new Dimension(758, 125));

			jPanel2.setBackground(Color.WHITE);

			color1.setBackground(Color.WHITE);

			color2.setBackground(Color.WHITE);

			verGruposFiguras();

			if (subTipoFigura.getItemCount() > 0) {

				dibujarFigura(subTipoFigura.getSelectedIndex());

			}

			else {

				dibujarFigura(nombreFigura.getSelectedIndex());

			}

			JToggleButton girarIzquierda = new JToggleButton();

			girarIzquierda.setOpaque(true);

			girarIzquierda.setContentAreaFilled(false);

			JToggleButton centrar = new JToggleButton();

			centrar.setOpaque(true);

			centrar.setContentAreaFilled(false);

			JToggleButton girarDerecha = new JToggleButton();

			girarDerecha.setOpaque(true);

			girarDerecha.setContentAreaFilled(false);

			JToggleButton btn20 = new JToggleButton();

			btn20.setToolTipText("Cubeta");

			btn20.setPreferredSize(new Dimension(37, 30));

			btn20.setOpaque(true);

			btn20.setContentAreaFilled(false);

			JToggleButton btn23 = new JToggleButton();

			btn23.setToolTipText("Gotero");

			btn23.setPreferredSize(new Dimension(37, 30));

			btn23.setOpaque(true);

			btn23.setContentAreaFilled(false);

			JToggleButton spray = new JToggleButton();

			spray.setOpaque(true);

			spray.setContentAreaFilled(false);

			JToggleButton btn22 = new JToggleButton();

			btn22.setToolTipText("Lapiz");

			btn22.setPreferredSize(new Dimension(37, 30));

			btn22.setOpaque(true);

			btn22.setContentAreaFilled(false);

			JToggleButton btn24 = new JToggleButton();

			btn24.setToolTipText("Borrador");

			btn24.setPreferredSize(new Dimension(37, 30));

			btn24.setOpaque(true);

			btn24.setContentAreaFilled(false);

			JToggleButton limpiarTodo = new JToggleButton();

			limpiarTodo.setOpaque(true);

			limpiarTodo.setContentAreaFilled(false);

			JToggleButton jToggleButton1 = new JToggleButton();

			jToggleButton1.setToolTipText("Insertar imagen.");

			jToggleButton1.setOpaque(true);

			jToggleButton1.setContentAreaFilled(false);

			JToggleButton jToggleButton4 = new JToggleButton();

			jToggleButton4.setOpaque(true);

			jToggleButton4.setContentAreaFilled(false);

			textField = new JTextField();

			textField.setColumns(10);

			JLabel jLabel6 = new JLabel();

			jLabel6.setHorizontalAlignment(SwingConstants.CENTER);

			JLabel jLabel4 = new JLabel();

			jLabel4.setHorizontalAlignment(SwingConstants.CENTER);

			JLabel jLabel9 = new JLabel();

			anguloGiro = new Spinner();

			anguloGiro.setMinValor(0);

			anguloGiro.setMaxValor(360);

			anguloGiro.setLabelText("Angle");

			anguloGiro.setValor(90);

			JLabel jLabel2 = new JLabel();

			JLabel jLabel3 = new JLabel();

			jLabel3.setHorizontalAlignment(SwingConstants.CENTER);

			moverAbajo = new Spinner();

			moverAbajo.setMinValor(0);

			JLabel jLabel8 = new JLabel();

			jLabel8.setHorizontalAlignment(SwingConstants.CENTER);

			JLabel previsualizarFigura = new JLabel();

			previsualizarFigura.setHorizontalAlignment(SwingConstants.RIGHT);

			SimpleButton girarIzquierda_1 = new SimpleButton("");
			
			girarIzquierda_1.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
			
					panelDeDibujo.getFiguraActual().rotar(panelDeDibujo.getGraphics(),
							panelDeDibujo.getFiguraActual(), 180,
							panelDeDibujo.getFiguraActual().getMarcoDeFigura().getX()
									+ (panelDeDibujo.getFiguraActual().getWidth() / 2),
							panelDeDibujo.getFiguraActual().getMarcoDeFigura().getY()
									+ (panelDeDibujo.getFiguraActual().getHeight() / 2)

					);
					
				}
		
			});

			girarIzquierda_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/rotate_180.png")));

			girarIzquierda_1.setOpaque(true);

			girarIzquierda_1.setContentAreaFilled(false);

			SimpleButton centrar_1 = new SimpleButton("");

			centrar_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/center.png")));

			centrar_1.setOpaque(true);

			centrar_1.setContentAreaFilled(false);

			SimpleButton girarDerecha_1 = new SimpleButton("");

			girarDerecha_1.addActionListener(new ActionListener() {

				@Override

				public void actionPerformed(ActionEvent e) {

				}

			});

			girarDerecha_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/rotate_180_r.png")));

			girarDerecha_1.setOpaque(true);

			girarDerecha_1.setContentAreaFilled(false);

			SimpleButton btn20_1 = new SimpleButton("");

			btn20_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/cubeta.png")));

			btn20_1.setToolTipText("Cubeta");

			btn20_1.setPreferredSize(new Dimension(37, 30));

			btn20_1.setOpaque(true);

			btn20_1.setContentAreaFilled(false);

			SimpleButton btn23_1 = new SimpleButton("");
			btn23_1.addActionListener(new ActionListener() {

				@Override

				public void actionPerformed(ActionEvent e) {

					dibujarFigura(-1);

				}

			});

			btn23_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/goteros.png")));

			btn23_1.setToolTipText("Gotero");

			btn23_1.setPreferredSize(new Dimension(37, 30));

			btn23_1.setOpaque(true);

			btn23_1.setContentAreaFilled(false);

			SimpleButton spray_1 = new SimpleButton("");

			spray_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/spray.png")));

			spray_1.setOpaque(true);

			spray_1.setContentAreaFilled(false);

			SimpleButton btn22_1 = new SimpleButton("");

			btn22_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/lapiz.png")));

			btn22_1.setToolTipText("Lapiz");

			btn22_1.setPreferredSize(new Dimension(37, 30));

			btn22_1.setOpaque(true);

			btn22_1.setContentAreaFilled(false);

			SimpleButton btn24_1 = new SimpleButton("");

			btn24_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/borrador.png")));

			btn24_1.setToolTipText("Borrador");

			btn24_1.setPreferredSize(new Dimension(37, 30));

			btn24_1.setOpaque(true);

			btn24_1.setContentAreaFilled(false);

			SimpleButton limpiarTodo_1 = new SimpleButton("");

			limpiarTodo_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/Recycle_Bin_Full.png")));

			limpiarTodo_1.setOpaque(true);

			limpiarTodo_1.setContentAreaFilled(false);

			SimpleButton jToggleButton1_1 = new SimpleButton("");

			jToggleButton1_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/imagen.png")));

			jToggleButton1_1.setToolTipText("Insertar imagen.");

			jToggleButton1_1.setOpaque(true);

			jToggleButton1_1.setContentAreaFilled(false);

			JLabel jToggleButton4_1 = new JLabel("");

			jToggleButton4_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/text.png")));

			textField_1 = new JTextField();

			textField_1.setColumns(10);

			JLabel jLabel6_1 = new JLabel();

			jLabel6_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/lap.png")));

			jLabel6_1.setHorizontalAlignment(SwingConstants.CENTER);

			dibujarRellena = new JCheckBox();

			dibujarRellena.setBackground(Color.WHITE);

			dibujarRellena.setHorizontalAlignment(SwingConstants.RIGHT);

			JLabel jLabel4_1 = new JLabel();

			jLabel4_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/fill.png")));

			jLabel4_1.setHorizontalAlignment(SwingConstants.CENTER);

			JLabel jLabel9_1 = new JLabel();

			jLabel9_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/angle.png")));

			JLabel jLabel2_1 = new JLabel();

			jLabel2_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/move_top.png")));

			JLabel jLabel3_1 = new JLabel();

			jLabel3_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/move_down.png")));

			jLabel3_1.setHorizontalAlignment(SwingConstants.CENTER);

			verRegla.setBackground(Color.WHITE);

			JLabel jLabel8_1 = new JLabel();

			jLabel8_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/regla.png")));

			jLabel8_1.setHorizontalAlignment(SwingConstants.CENTER);

			nombreFigura.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {

					verGruposFiguras();

				}

			});

			JLabel previsualizarFigura_1 = new JLabel();

			previsualizarFigura_1.setHorizontalAlignment(SwingConstants.RIGHT);

			malla.setHorizontalAlignment(SwingConstants.RIGHT);

			malla.setBackground(Color.WHITE);

			JLabel jLabel2_1_1 = new JLabel();

			jLabel2_1_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/malla.png")));

			JLabel jLabel2_1_2 = new JLabel();

			jLabel2_1_2.setHorizontalAlignment(SwingConstants.CENTER);

			jLabel2_1_2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/radio.png")));

			redondear.setBackground(Color.WHITE);

			JLabel jLabel8_1_1 = new JLabel();

			jLabel8_1_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/rounded.png")));

			jLabel8_1_1.setHorizontalAlignment(SwingConstants.LEFT);

			JLabel dividir = new JLabel();

			dividir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/divide.png")));

			dividir.setHorizontalAlignment(SwingConstants.CENTER);

			JLabel jLabel8_1_1_1 = new JLabel();
			jLabel8_1_1_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/en_circulo.png")));
			jLabel8_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);

			ComboBoxSuggestion lblNewLabel = new ComboBoxSuggestion();

			for (Language idioma : Language.values()) {

				lblNewLabel.addItem(idioma);

			}

			// Arrays.asList(Language.values()).forEach(season ->
			// lblNewLabel.addItem(season.toString()));

			GroupLayout gl_jPanel2 = new GroupLayout(jPanel2);
			gl_jPanel2.setHorizontalGroup(
				gl_jPanel2.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_jPanel2.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING, false)
							.addComponent(grosor, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addComponent(color1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(color2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_jPanel2.createSequentialGroup()
								.addGap(10)
								.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
									.addComponent(girarIzquierda_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addComponent(btn22_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_jPanel2.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btn20_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_jPanel2.createSequentialGroup()
								.addComponent(btn24_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(limpiarTodo_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_jPanel2.createSequentialGroup()
								.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING, false)
									.addComponent(centrar_1, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
									.addComponent(btn23_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 37, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
									.addComponent(spray_1, GroupLayout.PREFERRED_SIZE, 55, Short.MAX_VALUE)
									.addComponent(girarDerecha_1, GroupLayout.PREFERRED_SIZE, 55, Short.MAX_VALUE))))
						.addGap(6)
						.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_jPanel2.createSequentialGroup()
								.addComponent(jToggleButton1_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(jToggleButton4_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
							.addGroup(gl_jPanel2.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_jPanel2.createSequentialGroup()
										.addComponent(jLabel9_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(anguloGiro, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_jPanel2.createSequentialGroup()
										.addComponent(dibujarRellena)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jLabel4_1)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(malla, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jLabel2_1_1)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
									.addComponent(jLabel3_1)
									.addComponent(jLabel2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
									.addComponent(moverAbajo, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
									.addComponent(moverArriba, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jLabel2_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel6_1, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
							.addComponent(dividir, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_jPanel2.createSequentialGroup()
								.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING, false)
									.addComponent(radio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(vueltas, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_jPanel2.createSequentialGroup()
										.addComponent(verRegla, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jLabel8_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_jPanel2.createSequentialGroup()
										.addComponent(redondear, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel8_1_1))))
							.addGroup(gl_jPanel2.createSequentialGroup()
								.addComponent(escala, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(enCirculo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel8_1_1_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
							.addComponent(efectoFigura, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
							.addComponent(nombreFigura, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
							.addComponent(subTipoFigura, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_jPanel2.createSequentialGroup()
								.addComponent(lblFigura, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addGap(6)
								.addComponent(previsualizarFigura_1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
			);
			gl_jPanel2.setVerticalGroup(
				gl_jPanel2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_jPanel2.createSequentialGroup()
						.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
							.addComponent(lblFigura, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addComponent(previsualizarFigura_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_jPanel2.createSequentialGroup()
								.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_jPanel2.createSequentialGroup()
										.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_jPanel2.createSequentialGroup()
												.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
													.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
														.addComponent(jToggleButton1_1, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
														.addComponent(jToggleButton4_1, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
													.addComponent(btn24_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
												.addGap(6))
											.addGroup(gl_jPanel2.createSequentialGroup()
												.addComponent(limpiarTodo_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)))
										.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_jPanel2.createSequentialGroup()
												.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
													.addGroup(gl_jPanel2.createSequentialGroup()
														.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
															.addComponent(spray_1, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
															.addComponent(btn20_1, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
															.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(jLabel4_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btn23_1, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
																.addComponent(dibujarRellena, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
															.addComponent(girarDerecha_1, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
															.addComponent(centrar_1, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
															.addComponent(girarIzquierda_1, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
															.addComponent(jLabel9_1, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)))
													.addGroup(gl_jPanel2.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
															.addGroup(gl_jPanel2.createSequentialGroup()
																.addComponent(jLabel2_1_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
																.addComponent(dividir, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
															.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING, false)
																.addComponent(efectoFigura, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(enCirculo, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
																.addComponent(escala, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jLabel8_1_1_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
																.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
												.addPreferredGap(ComponentPlacement.RELATED))
											.addComponent(malla, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
											.addComponent(jLabel2_1_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
											.addComponent(jLabel2_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
											.addComponent(moverArriba, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_jPanel2.createSequentialGroup()
										.addGap(7)
										.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_jPanel2.createSequentialGroup()
												.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
													.addComponent(jLabel6_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
													.addGroup(gl_jPanel2.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)))
												.addGap(73)
												.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
													.addComponent(moverAbajo, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
													.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(jLabel3_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(anguloGiro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
											.addGroup(gl_jPanel2.createSequentialGroup()
												.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
													.addComponent(vueltas, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
													.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(nombreFigura, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(verRegla, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
														.addComponent(jLabel8_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)))
												.addGap(18)
												.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
													.addComponent(jLabel8_1_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
													.addGroup(gl_jPanel2.createSequentialGroup()
														.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
															.addComponent(subTipoFigura, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
															.addComponent(redondear, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
															.addComponent(radio, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addGap(66)))))))
								.addGap(25))
							.addGroup(gl_jPanel2.createSequentialGroup()
								.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_jPanel2.createSequentialGroup()
										.addContainerGap()
										.addComponent(grosor, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
									.addComponent(btn22_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(color1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(color2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(16))
			);

			jPanel2.setLayout(gl_jPanel2);

			javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
			layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
					.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 1207, Short.MAX_VALUE)
					.addComponent(panelDeDibujo, GroupLayout.DEFAULT_SIZE, 1207, Short.MAX_VALUE));
			layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
							.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelDeDibujo, GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)));

			getContentPane().setLayout(layout);

			setSize(new Dimension(1223, 872));

			setLocationRelativeTo(null);

		}

		catch (Exception e) {

		}

	}

	private void dibujarFigura(int figuraSeleccionada) {

		panelDeDibujo.setFiguraSeleccionada(figuraSeleccionada);

		// lblFigura.setText(figuraSeleccionada);

	}

	public static int getIncrementoAbajo() {

		return moverAbajo.getValor();

	}

	public static int getIncrementoArriba() {

		return moverArriba.getValor();

	}

	public static int saberRadio() {

		return radio.getValor();

	}

	public static int saberMoverAbajo() {

		return moverAbajo.getValor();

	}

	public static int saberMoverArriba() {

		return moverArriba.getValor();

	}

	public static int saberVueltas() {

		return vueltas.getValor();

	}
}
