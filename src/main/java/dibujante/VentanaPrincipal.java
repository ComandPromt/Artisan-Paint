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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.buttons.simple.SimpleButton;
import com.colourpicker.ScreenColor;
import com.comboBox.comboSuggestion.ComboBoxSuggestion;
import com.guilanguage.JComboBoxLanguage;
import com.spinner.simple.Spinner;

import checkbox.CheckBoxLabel;
import efectos.Cadena;
import figuras.basicas.Line;
import figuras.basicas.Punto;
import figuras.circulos.Anillo;
import figuras.circulos.Circulo;
import figuras.circulos.MedioCirculo;
import figuras.circulos.Rueda;
import figuras.circulos.SemiCirculo;
import figuras.dibujos.DibujoLibre1;
import figuras.dibujos.DibujoLibre2;
import figuras.dibujos.DibujoLibre3;
import figuras.dibujos.DibujoLibre4;
import figuras.dibujos.DibujoLibre5;
import figuras.dibujos.DibujoLibre6;
import figuras.dibujos.DibujoLibre7;
import figuras.estrellas.DavidStar;
import figuras.estrellas.Star;
import figuras.estrellas.Star5P;
import figuras.feria.AroFeria;
import figuras.geometria.Cilindro;
import figuras.geometria.Cuadrado;
import figuras.geometria.Hexagono;
import figuras.geometria.Octogono;
import figuras.geometria.Paralelogramo;
import figuras.geometria.Pentagono;
import figuras.geometria.Poligono;
import figuras.geometria.Rectangulo;
import figuras.geometria.Rombo;
import figuras.geometria.Trapecio;
import figuras.geometria.triangulos.Escaleno;
import figuras.geometria.triangulos.Triangulo;
import figuras.geometria.triangulos.TrianguloRectangulo;
import figuras.geometria.triangulos.TrianguloRectangulo1;
import figuras.geometria.triangulos.TrianguloRectangulo2;
import figuras.geometria.triangulos.TrianguloRectangulo3;
import figuras.juegos.Cometa;
import figuras.juegos.PacMan;
import figuras.mandalas.Mandala1;
import figuras.mandalas.Mandala2;
import figuras.mandalas.Mandala3;
import figuras.mandalas.Mandala4;
import figuras.mandalas.Mandala5;
import figuras.mandalas.Mandala6;
import figuras.mandalas.MandalaCirculo;
import figuras.mandalas.MandalaEstrella;
import figuras.marcas.Nike;
import figuras.plantas.Trebol;
import figuras.plantas.TrebolCuatroHojas;
import figuras.plantas.TrebolTresHojas;
import figuras.simbolos.Carta;
import figuras.simbolos.Carta2;
import figuras.simbolos.Corazon;
import figuras.simbolos.Cruz;
import figuras.simbolos.Luna;
import figuras.simbolos.YingYang;
import figuras.simbolos.flechas.FlechaAbajo;
import figuras.simbolos.flechas.FlechaArriba;
import figuras.simbolos.flechas.FlechaDerecha;
import figuras.simbolos.flechas.FlechaIzquierda;
import figuras.utils.Borrador;
import figuras.utils.Imagen;
import figuras.utils.Lapiz;
import figuras.utils.Spray;
import net.java.dev.colorchooser.demo.CopyColor;
import util.Metodos;

@SuppressWarnings("all")

public class VentanaPrincipal extends javax.swing.JFrame {

	Spinner radio;

	private int idCategoria;

	private int idIdioma;

	public static Spinner moverArriba;

	public static PanelDeDibujo panelDeDibujo;

	private VentanaPrincipal ventanaPrincipal;

	public static CopyColor color1;

	public static CopyColor color2;

	public static Spinner vueltas;

	private Color colorSeleccionado;

	private JTextField textField;

	public static Spinner moverAbajo;

	private JTextField textField_1;

	Spinner angulo3;

	public static CheckBoxLabel enCirculo;

	private JCheckBox figuraRellena;

	public CheckBoxLabel dibujarRellena;

	public static ComboBoxSuggestion efectoFigura;

	public static ComboBoxSuggestion nombreFigura;

	private int indice;

	public static ComboBoxSuggestion subTipoFigura;

	LinkedList<String> listaFiguras;

	LinkedList<String> efectosFiguras;

	public static Spinner anguloGiro;

	public static CheckBoxLabel redondear;

	public static Spinner angulo2;

	public static Spinner grosor;

	private short gradosFigura;

	private JLabel orientacion;

	private Spinner angulo4;

	private Spinner angulo5;

	private Spinner sumarAngulo;

	public static JComboBoxLanguage idioma;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JLabel lblNewLabel;
	public static JLabel ancho;
	private JLabel lblNewLabel_2;
	public static JLabel alto;

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

	private void girarFigura(boolean giroHorario) {

		if (giroHorario) {

			gradosFigura--;

			if (gradosFigura == 0) {

				gradosFigura = 4;

			}

		}

		else {

			gradosFigura++;

			if (gradosFigura == 5) {

				gradosFigura = 1;

			}

		}

		orientacion.setIcon(
				new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/flecha_" + gradosFigura + ".png")));

	}

	public static int getRadio() {

		return angulo2.getValor();

	}

	private void verNombresFiguras() {

		try {

			limpiarSubFiguras();

			for (String dato : Metodos.obtenerGrupos(idioma.getSelectedIndex(), nombreFigura.getSelectedIndex() + 1,
					true)) {

				subTipoFigura.addItem(dato);

			}

		}

		catch (Exception e) {

		}

	}

	private void ponerNombresFiguras(int index) {

		try {

			nombreFigura.removeAllItems();

			for (String dato : Metodos.obtenerGrupos(index, 0, false)) {

				nombreFigura.addItem(dato);

			}

			verNombresFiguras();

		}

		catch (Exception e1) {

		}

	}

	public VentanaPrincipal() throws IOException {

		orientacion = new JLabel("");

		orientacion.setHorizontalAlignment(SwingConstants.CENTER);

		gradosFigura = 1;

		grosor = new Spinner();

		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imagenes/paint.png")));

		getContentPane().setBackground(Color.WHITE);

		setTitle("Test");

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);

		setJMenuBar(menuBar);

		mnNewMenu = new JMenu("Menu");
		mnNewMenu.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/menu.png")));
		mnNewMenu.setBackground(Color.WHITE);

		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Export");
		mntmNewMenuItem.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/export.png")));
		mntmNewMenuItem.setBackground(Color.WHITE);

		mntmNewMenuItem.addMouseListener(new MouseAdapter() {

			@Override

			public void mousePressed(MouseEvent e) {

				guardarImagen();

			}

		});

		mntmNewMenuItem_1 = new JMenuItem("New");
		mntmNewMenuItem_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/new.png")));

		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override

			public void mousePressed(MouseEvent e) {

				funcionBtnNuevo();

			}

		});

		mntmNewMenuItem_1.setBackground(Color.WHITE);

		mnNewMenu.add(mntmNewMenuItem_1);

		JSeparator separator = new JSeparator();

		mnNewMenu.add(separator);

		mnNewMenu.add(mntmNewMenuItem);

		initComponents();

		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

		reset();

		ponerNombresFiguras(0);

		calcularFigura();

		setVisible(true);

	}

	private void reset() {

		try {
			anguloGiro.setValor(90);

			angulo2.setValor(-50);

			angulo3.setValor(100);

			angulo4.setValor(130);

			angulo5.setValor(100);

			sumarAngulo.setValor(0);

			grosor.setValor(1);

			vueltas.setValor(1);

			radio.setValor(0);

			moverArriba.setValor(0);

			moverAbajo.setValor(0);
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {

		try {

			new VentanaPrincipal().setVisible(true);

		}

		catch (Exception e) {

		}

	}

	private void calcularFigura() {

		try {

			dibujarFigura(Metodos.obtenerNumeroFigura(idioma.getSelectedIndex(), nombreFigura.getSelectedIndex() + 1,
					subTipoFigura.getSelectedItem().toString()));

		}

		catch (Exception e1) {

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

			figuraActual = new Cadena(figura, puntoActual, anchura, altura);

			figuraActual.setVueltas(saberVueltas());

		}

		if (colorPrimario.equals(Color.WHITE)) {

			colorPrimario = Color.BLACK;

			color1.setColor(colorPrimario);

		}

		switch (figuraSeleccionada) {

		case -4:

			figuraActual = new Spray(puntoActual);

			break;

		case -3:

			break;

		case -2:

			figuraActual = new Lapiz(puntoActual);

			break;

		case -1:

			figuraActual = new Borrador(puntoActual);

			break;

		case 0:

			figuraActual = new Cadena(3, puntoActual, anchura, altura);

			break;

		case 1:
			figuraActual = new Circulo(puntoActual, anchura, altura);

			break;

		case 2:
			figuraActual = new Anillo(puntoActual, anchura, altura);

			break;

		case 3:
			figuraActual = new AroFeria(puntoActual, anchura, altura);

			break;

		case 4:
			figuraActual = new Cilindro(puntoActual, anchura, altura);

			break;

		case 5:
			figuraActual = new Cometa(puntoActual, anchura, altura);

			break;

		case 6:
			figuraActual = new Corazon(puntoActual, anchura, altura);

			break;

		case 7:
			figuraActual = new Trebol(puntoActual, anchura, altura);

			break;

		case 8:
			figuraActual = new Cruz(puntoActual, anchura, altura);

			break;

		case 9:
			figuraActual = new DavidStar(puntoActual, anchura, altura);

			break;

		case 10:
			figuraActual = new Escaleno(puntoActual, anchura, altura);

			break;

		case 11:
			figuraActual = new Luna(puntoActual, anchura, altura);

			break;

		case 12:
			figuraActual = new Line(puntoActual);

			break;

		case 13:
			figuraActual = new Punto(puntoActual);

			break;

		case 14:
			figuraActual = new YingYang(puntoActual, anchura, altura);

			break;

		case 15:
			figuraActual = new MedioCirculo(puntoActual, anchura, altura);

			break;

		case 16:
			figuraActual = new Rueda(puntoActual, anchura, altura);

			break;

		case 17:
			figuraActual = new SemiCirculo(puntoActual, anchura, altura);

			break;

		case 18:
			figuraActual = new DibujoLibre1(puntoActual, anchura, altura);

			break;

		case 19:
			figuraActual = new DibujoLibre2(puntoActual, anchura, altura);

			break;

		case 20:
			figuraActual = new DibujoLibre3(puntoActual, anchura, altura);

			break;

		case 21:
			figuraActual = new DibujoLibre4(puntoActual, anchura, altura);

			break;

		case 22:
			figuraActual = new DibujoLibre5(puntoActual, anchura, altura);

			break;

		case 23:
			figuraActual = new DibujoLibre6(puntoActual, anchura, altura);

			break;

		case 24:
			figuraActual = new DibujoLibre7(puntoActual, anchura, altura);

			break;

		case 25:
			figuraActual = new Star(puntoActual, anchura, altura);

			break;

		case 26:
			figuraActual = new Star5P(puntoActual, anchura, altura);

			break;

		case 27:

			switch (gradosFigura) {

			default:
			case 1:

				figuraActual = new FlechaArriba(puntoActual, anchura, altura);

				break;

			case 2:
				figuraActual = new FlechaIzquierda(puntoActual, anchura, altura);

				break;

			case 3:
				figuraActual = new FlechaAbajo(puntoActual, anchura, altura);

				break;

			case 4:
				figuraActual = new FlechaDerecha(puntoActual, anchura, altura);

				break;

			}

			break;

		case 28:

			figuraActual = new Carta2(puntoActual, anchura, altura);

			break;

		case 29:
			break;
		case 30:
			break;
		case 31:
			figuraActual = new Triangulo(puntoActual, anchura, altura);

			break;

		case 32:
			figuraActual = new Cuadrado(puntoActual, anchura, altura);

			break;

		case 33:
			figuraActual = new Hexagono(puntoActual, anchura, altura);

			break;

		case 34:
			figuraActual = new Octogono(puntoActual, anchura, altura);

			break;

		case 35:
			figuraActual = new Paralelogramo(puntoActual, anchura, altura);

			break;

		case 36:
			figuraActual = new Pentagono(puntoActual, anchura, altura);

			break;

		case 37:
			figuraActual = new Poligono(puntoActual, anchura, altura);

			break;

		case 38:
			figuraActual = new Rectangulo(puntoActual, anchura, altura);

			break;

		case 39:
			figuraActual = new Rombo(puntoActual, anchura, altura);

			break;

		case 40:
			figuraActual = new Trapecio(puntoActual, anchura, altura);

			break;

		case 41:
			switch (gradosFigura) {

			default:
			case 1:

				figuraActual = new TrianguloRectangulo1(puntoActual, anchura, altura);

				break;

			case 2:
				figuraActual = new TrianguloRectangulo2(puntoActual, anchura, altura);

				break;

			case 3:
				figuraActual = new TrianguloRectangulo3(puntoActual, anchura, altura);

				break;

			case 4:

				figuraActual = new TrianguloRectangulo(puntoActual, anchura, altura);

				break;

			}

			break;

		case 42:
			figuraActual = new Carta(puntoActual, anchura, altura);

			break;

		case 43:
			figuraActual = new PacMan(puntoActual, anchura, altura);

			break;

		case 44:
			figuraActual = new Mandala1(puntoActual, anchura, altura);

			break;

		case 45:
			figuraActual = new Mandala2(puntoActual, anchura, altura);

			break;

		case 46:
			figuraActual = new Mandala3(puntoActual, anchura, altura);

			break;

		case 47:
			figuraActual = new Mandala4(puntoActual, anchura, altura);

			break;

		case 48:
			figuraActual = new Mandala5(puntoActual, anchura, altura);

			break;

		case 49:
			figuraActual = new Mandala6(puntoActual, anchura, altura);

			break;

		case 50:
			figuraActual = new MandalaCirculo(puntoActual, anchura, altura);

			break;

		case 51:
			figuraActual = new MandalaEstrella(puntoActual, anchura, altura);

			break;

		case 52:
			figuraActual = new TrebolTresHojas(puntoActual, anchura, altura);

			break;

		case 53:
			figuraActual = new TrebolCuatroHojas(puntoActual, anchura, altura);

			break;

		case 54:
			figuraActual = new Lapiz(puntoActual);

			break;

		case 55:
			figuraActual = new Borrador(puntoActual);

			break;

		case 56:
			figuraActual = new Spray(puntoActual);

			break;

		case 57:

			figuraActual = new Nike(puntoActual, anchura, altura);

			break;

		}

		if (figuraActual != null) {

			figuraActual.setMoverArriba(moverArriba.getValor());

			figuraActual.setMoverAbajo(moverAbajo.getValor());

			figuraActual.setRedondear(redondear.isSelected());

			figuraActual.setRadio(radio.getValor());

			figuraActual.setSumarAngulo(sumarAngulo.getValor());

			figuraActual.setAngulo2(angulo2.getValor());

			figuraActual.setAngulo3(angulo3.getValor());

			figuraActual.setAngulo4(angulo4.getValor());

			figuraActual.setAngulo5(angulo5.getValor());

			figuraActual.setAngulo(anguloGiro.getValor());

			figuraActual.setEstadoGiro(gradosFigura);

			figuraActual.setVueltas(vueltas.getValor());

			figuraActual.setMainColor(color1.getColor());

			figuraActual.setBackgroundColor(color2.getColor());

			figuraActual.setDibujarRellena(dibujarRellena.isSelected());

		}

		return figuraActual;

	}

	private void ponerMovimiento(Figura figuraActual) {

		figuraActual.setMoverArriba(moverArriba.getValor());

		figuraActual.setMoverAbajo(moverAbajo.getValor());

	}

	private int saberEscala() {

		return angulo3.getValor();

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

				BufferedImage bi = new BufferedImage(panelDeDibujo.getWidth(), panelDeDibujo.getHeight(),
						BufferedImage.TYPE_INT_ARGB);

				Graphics2D g = bi.createGraphics();

				panelDeDibujo.paint(g);

				ImageIO.write(bi, "PNG", new File(archivoAGuardar.getAbsolutePath() + extension));

			}

			catch (IOException ex) {

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

				bimg = ImageIO.read(new File(archivoSeleccionado.getAbsolutePath()));

			}

			catch (IOException ex) {

			}

			return bimg;

		}

		return bimg;

	}

	private void insertarImagenMovible() {

		BufferedImage bimg = abrirImagen();

		if (bimg != null) {

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

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {

		this.ventanaPrincipal = ventanaPrincipal;

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

			idCategoria = -1;

			idioma = new JComboBoxLanguage(null, null);

			idioma.setSize(100, 100);

			idioma.setFont(new Font("Tahoma", Font.PLAIN, 14));

			idioma.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {

					try {

						nombreFigura.removeAllItems();

						for (String dato : Metodos.obtenerGrupos(idioma.getSelectedIndex(), -1, false)) {

							nombreFigura.addItem(dato);

						}

						verNombresFiguras();

					}

					catch (Exception e1) {

					}

				}

			});

			listaFiguras = new LinkedList<>();

			color1 = new CopyColor(Color.BLACK, false);

			color1.setLineBorderColor(Color.WHITE);

			color1.setColor(Color.BLACK);

			color2 = new CopyColor(Color.WHITE, false);

			color2.setLineBorderColor(Color.WHITE);

			vueltas = new Spinner();

			radio = new Spinner();

			sumarAngulo = new Spinner();

			angulo5 = new Spinner();

			angulo5.setNegativo(true);

			angulo4 = new Spinner();

			angulo4.setNegativo(true);

			enCirculo = new CheckBoxLabel(
					new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/en_circulo.png")));

			angulo3 = new Spinner();

			angulo3.setNegativo(true);

			angulo3.setLabelText("Angle 3");

			angulo3.setValor(100);

			figuraRellena = new JCheckBox();

			figuraRellena.setHorizontalAlignment(SwingConstants.RIGHT);

			redondear = new CheckBoxLabel(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/rounded.png")));

			angulo2 = new Spinner();

			angulo2.setNegativo(true);

			angulo2.setLabelText("Angle 2");

			angulo2.setValor(-50);

			moverArriba = new Spinner();

			moverArriba.setMinValor(0);

			efectosFiguras = new LinkedList();

			efectoFigura = new ComboBoxSuggestion();

			nombreFigura = new ComboBoxSuggestion();

			subTipoFigura = new ComboBoxSuggestion();

			subTipoFigura.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {

					if (subTipoFigura.getItemCount() > 0) {

						if (efectosFiguras.contains(subTipoFigura.getSelectedItem().toString())) {

							efectoFigura.addItem("Cadena");

						}

					}

					calcularFigura();
				}

			});

			efectoFigura.addItem("Ninguno");

			efectoFigura.addItem("cadena");

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			vueltas.setMinValor(1);

			vueltas.setLabelText("Laps");

			setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

			panelDeDibujo = new PanelDeDibujo();

			panelDeDibujo.setBackground(Color.WHITE);

			getContentPane().add(panelDeDibujo, BorderLayout.CENTER);

			panelDeDibujo.setVentanaPrincipal(this);

			JPanel jPanel2 = new JPanel();

			jPanel2.setPreferredSize(new Dimension(758, 125));

			jPanel2.setBackground(Color.WHITE);

			color1.setBackground(Color.WHITE);

			color2.setBackground(Color.WHITE);

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

			anguloGiro.setNegativo(true);

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

			JLabel jToggleButton4_1 = new JLabel("");
			jToggleButton4_1.setHorizontalAlignment(SwingConstants.CENTER);

			jToggleButton4_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/text.png")));

			textField_1 = new JTextField();
			textField_1.setHorizontalAlignment(SwingConstants.CENTER);

			textField_1.setColumns(10);

			JLabel jLabel6_1 = new JLabel();

			jLabel6_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/lap.png")));

			jLabel6_1.setHorizontalAlignment(SwingConstants.CENTER);

			dibujarRellena = new CheckBoxLabel(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/fill.png")));

			JLabel jLabel2_1 = new JLabel();

			jLabel2_1.setHorizontalAlignment(SwingConstants.CENTER);

			jLabel2_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/move_top.png")));

			JLabel jLabel3_1 = new JLabel();

			jLabel3_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/move_down.png")));

			jLabel3_1.setHorizontalAlignment(SwingConstants.CENTER);

			nombreFigura.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {

					int indice = nombreFigura.getSelectedIndex() + 1;

					if ((idIdioma == idioma.getSelectedIndex() && idCategoria != indice)
							|| (idIdioma != idioma.getSelectedIndex() && idCategoria != indice)) {

						idIdioma = idioma.getSelectedIndex();

						idCategoria = indice;

						verNombresFiguras();

					}

					calcularFigura();

				}

			});

			grosor.setMinValor(1);

			grosor.setLabelText("Thickness");

			grosor.setValor(1);

			ScreenColor picker = new ScreenColor(Color.BLACK);
			picker.color.setBackground(Color.PINK);
			picker.setLineBorderColor(Color.BLACK);
			picker.setColor(Color.RED);
			picker.setBackground(Color.WHITE);

			JButton btnNewButton = new JButton("");
			btnNewButton.setBorder(null);
			btnNewButton.setOpaque(true);
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					color1.setColor(picker.getColor());

				}

			});

			btnNewButton.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/flecha.png")));

			JButton btnNewButton_1 = new JButton("");

			btnNewButton_1.setBorder(null);

			btnNewButton_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					color2.setColor(picker.getColor());

				}

			});

			btnNewButton_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/flecha.png")));

			btnNewButton_1.setOpaque(true);

			btnNewButton_1.setContentAreaFilled(false);

			orientacion.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/flecha_1.png")));

			angulo4.setValor(130);

			angulo4.setLabelText("Angle 4");

			angulo5.setValor(100);

			angulo5.setLabelText("Angle 5");

			sumarAngulo.setLabelText("+ Angle");

			radio.setLabelText("Radius");

			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);

			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);

			JPanel panel_1_1 = new JPanel();
			panel_1_1.setBackground(Color.WHITE);

			SimpleButton centrar_1_1 = new SimpleButton("");

			centrar_1_1.addActionListener(new ActionListener() {

				@Override

				public void actionPerformed(ActionEvent e) {

					girarFigura(true);

				}

			});

			centrar_1_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/rotate_180_r.png")));

			centrar_1_1.setOpaque(true);

			centrar_1_1.setContentAreaFilled(false);

			panel_1_1.add(centrar_1_1);

			SimpleButton btnNewButton_2 = new SimpleButton("");

			btnNewButton_2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					new CubicCurveMouse();

				}

			});

			btnNewButton_2.setBorderColor(Color.PINK);
			btnNewButton_2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/curva.png")));

			SimpleButton btnNewButton_2_1 = new SimpleButton("");

			btnNewButton_2_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					reset();

				}

			});
			btnNewButton_2_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/reset.png")));
			btnNewButton_2_1.setBorderColor(Color.PINK);

			lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/width.png")));

			ancho = new JLabel("");
			ancho.setFont(new Font("Tahoma", Font.PLAIN, 20));
			ancho.setHorizontalAlignment(SwingConstants.CENTER);

			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/height.png")));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);

			alto = new JLabel("");
			alto.setHorizontalAlignment(SwingConstants.CENTER);
			alto.setFont(new Font("Tahoma", Font.PLAIN, 20));

			SimpleButton btn24_1_1_1 = new SimpleButton("");
			btn24_1_1_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					nuevo();

					calcularFigura();

				}

			});
			btn24_1_1_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/Recycle_Bin_Full.png")));
			btn24_1_1_1.setToolTipText("Borrador");
			btn24_1_1_1.setPreferredSize(new Dimension(37, 30));
			btn24_1_1_1.setOpaque(true);
			btn24_1_1_1.setContentAreaFilled(false);

			SimpleButton btn24_1_1_2 = new SimpleButton("");
			btn24_1_1_2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					rehacer();
				}
			});
			btn24_1_1_2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/rehacer.png")));
			btn24_1_1_2.setToolTipText("Borrador");
			btn24_1_1_2.setPreferredSize(new Dimension(37, 30));
			btn24_1_1_2.setOpaque(true);
			btn24_1_1_2.setContentAreaFilled(false);

			SimpleButton deshacer_1 = new SimpleButton("");
			deshacer_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					deshacer();
				}
			});
			deshacer_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/deshacer.png")));
			deshacer_1.setBorderColor(Color.WHITE);

			GroupLayout gl_jPanel2 = new GroupLayout(jPanel2);
			gl_jPanel2.setHorizontalGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel2
					.createSequentialGroup().addContainerGap()
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_jPanel2.createSequentialGroup()
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_jPanel2.createSequentialGroup()
													.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 28,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
													.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 28,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED))
											.addGroup(gl_jPanel2.createSequentialGroup()
													.addComponent(idioma, GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
													.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(10))
							.addGroup(gl_jPanel2.createSequentialGroup()
									.addComponent(picker, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_jPanel2.createSequentialGroup()
									.addComponent(color2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
											Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_jPanel2.createSequentialGroup()
									.addComponent(color1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
											Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_jPanel2.createSequentialGroup()
									.addComponent(anguloGiro, GroupLayout.PREFERRED_SIZE, 71,
											GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(angulo2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_jPanel2.createSequentialGroup()
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
											.addComponent(deshacer_1, GroupLayout.PREFERRED_SIZE, 47,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 47,
													GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING, false)
											.addGroup(gl_jPanel2.createSequentialGroup()
													.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 46,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED).addComponent(panel_1_1,
															GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_jPanel2.createSequentialGroup()
													.addComponent(btn24_1_1_2, GroupLayout.DEFAULT_SIZE,
															GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(btn24_1_1_1, GroupLayout.PREFERRED_SIZE, 37,
															GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED).addComponent(orientacion,
											GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_jPanel2.createSequentialGroup()
									.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 71,
											GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(radio, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
							.addComponent(angulo3, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
							.addComponent(sumarAngulo, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
							.addGroup(gl_jPanel2.createSequentialGroup()
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
											.addComponent(enCirculo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)
											.addComponent(dibujarRellena, GroupLayout.DEFAULT_SIZE,
													GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
											.addComponent(redondear, GroupLayout.PREFERRED_SIZE, 72,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(grosor, GroupLayout.PREFERRED_SIZE, 84,
													GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING, false)
							.addComponent(angulo4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_jPanel2.createSequentialGroup().addGroup(gl_jPanel2
									.createParallelGroup(Alignment.LEADING)
									.addComponent(jLabel6_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING, false)
											.addComponent(jLabel3_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)
											.addComponent(jLabel2_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
											.addComponent(moverAbajo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
													GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(moverArriba, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 53,
													Short.MAX_VALUE)
											.addComponent(vueltas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
							.addComponent(jToggleButton4_1, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
							.addComponent(angulo5, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
							.addComponent(efectoFigura, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
							.addGroup(gl_jPanel2.createSequentialGroup()
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(ancho, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)
											.addComponent(alto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)
											.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
											.addComponent(subTipoFigura, GroupLayout.PREFERRED_SIZE, 293,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(nombreFigura, GroupLayout.DEFAULT_SIZE, 293,
													Short.MAX_VALUE))))
					.addGap(297)));
			gl_jPanel2.setVerticalGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_jPanel2.createSequentialGroup().addContainerGap()
							.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_jPanel2.createSequentialGroup().addGroup(gl_jPanel2
											.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel2
													.createSequentialGroup()
													.addComponent(nombreFigura, GroupLayout.PREFERRED_SIZE, 61,
															GroupLayout.PREFERRED_SIZE)
													.addGap(29)
													.addComponent(subTipoFigura, GroupLayout.PREFERRED_SIZE, 59,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED))
											.addGroup(gl_jPanel2.createSequentialGroup().addGroup(gl_jPanel2
													.createParallelGroup(Alignment.LEADING)
													.addComponent(orientacion, GroupLayout.DEFAULT_SIZE, 116,
															Short.MAX_VALUE)
													.addGroup(gl_jPanel2.createSequentialGroup().addGroup(gl_jPanel2
															.createParallelGroup(Alignment.TRAILING, false)
															.addComponent(panel_1_1, Alignment.LEADING,
																	GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																	Short.MAX_VALUE)
															.addComponent(panel_1, Alignment.LEADING,
																	GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																	Short.MAX_VALUE)
															.addComponent(
																	panel_2, Alignment.LEADING,
																	GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																	Short.MAX_VALUE))
															.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
																	.addGroup(gl_jPanel2.createSequentialGroup()
																			.addPreferredGap(ComponentPlacement.RELATED)
																			.addComponent(deshacer_1,
																					GroupLayout.DEFAULT_SIZE, 68,
																					Short.MAX_VALUE))
																	.addGroup(gl_jPanel2.createSequentialGroup().addGap(
																			14)
																			.addGroup(gl_jPanel2
																					.createParallelGroup(
																							Alignment.TRAILING, false)
																					.addComponent(btn24_1_1_1,
																							Alignment.LEADING,
																							GroupLayout.DEFAULT_SIZE,
																							GroupLayout.DEFAULT_SIZE,
																							Short.MAX_VALUE)
																					.addComponent(btn24_1_1_2,
																							Alignment.LEADING,
																							GroupLayout.DEFAULT_SIZE,
																							46, Short.MAX_VALUE))
																			.addPreferredGap(ComponentPlacement.RELATED,
																					14, Short.MAX_VALUE))))
													.addGroup(gl_jPanel2.createSequentialGroup().addGroup(gl_jPanel2
															.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel2
																	.createSequentialGroup()
																	.addComponent(dibujarRellena,
																			GroupLayout.PREFERRED_SIZE,
																			GroupLayout.DEFAULT_SIZE,
																			GroupLayout.PREFERRED_SIZE)
																	.addGap(15))
															.addGroup(
																	gl_jPanel2
																			.createSequentialGroup().addComponent(
																					jLabel6_1, GroupLayout.DEFAULT_SIZE,
																					64, Short.MAX_VALUE)
																			.addPreferredGap(
																					ComponentPlacement.RELATED))
															.addGroup(gl_jPanel2.createSequentialGroup()
																	.addComponent(
																			grosor, GroupLayout.DEFAULT_SIZE, 64,
																			Short.MAX_VALUE)
																	.addPreferredGap(ComponentPlacement.RELATED)))
															.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
																	.addComponent(jLabel2_1, GroupLayout.DEFAULT_SIZE,
																			46, Short.MAX_VALUE)
																	.addComponent(
																			redondear, GroupLayout.PREFERRED_SIZE,
																			GroupLayout.DEFAULT_SIZE,
																			GroupLayout.PREFERRED_SIZE)
																	.addGroup(gl_jPanel2.createSequentialGroup()
																			.addComponent(enCirculo,
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(
																					ComponentPlacement.RELATED))))
													.addGroup(gl_jPanel2.createSequentialGroup().addGroup(gl_jPanel2
															.createParallelGroup(Alignment.LEADING)
															.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 50,
																	Short.MAX_VALUE)
															.addComponent(vueltas, GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addGroup(gl_jPanel2.createSequentialGroup().addGap(8)
																	.addComponent(
																			ancho, GroupLayout.PREFERRED_SIZE, 34,
																			GroupLayout.PREFERRED_SIZE)))
															.addPreferredGap(ComponentPlacement.RELATED)
															.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
																	.addGroup(gl_jPanel2.createSequentialGroup()
																			.addGroup(gl_jPanel2.createParallelGroup(
																					Alignment.TRAILING).addComponent(
																							alto,
																							GroupLayout.DEFAULT_SIZE,
																							50, Short.MAX_VALUE)
																					.addComponent(lblNewLabel_2,
																							Alignment.LEADING))
																			.addGap(10))
																	.addGroup(gl_jPanel2.createSequentialGroup()
																			.addComponent(moverArriba,
																					GroupLayout.PREFERRED_SIZE, 54,
																					Short.MAX_VALUE)
																			.addGap(6)))))
													.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
															.addGroup(gl_jPanel2.createSequentialGroup().addGap(
																	2).addComponent(jLabel3_1, GroupLayout.DEFAULT_SIZE,
																			52, Short.MAX_VALUE)
																	.addGap(6))
															.addGroup(gl_jPanel2.createSequentialGroup()
																	.addPreferredGap(ComponentPlacement.RELATED)
																	.addGroup(gl_jPanel2
																			.createParallelGroup(Alignment.TRAILING)
																			.addGroup(gl_jPanel2
																					.createParallelGroup(
																							Alignment.BASELINE)
																					.addComponent(radio,
																							GroupLayout.DEFAULT_SIZE,
																							GroupLayout.DEFAULT_SIZE,
																							Short.MAX_VALUE)
																					.addComponent(
																							sumarAngulo,
																							GroupLayout.DEFAULT_SIZE,
																							GroupLayout.DEFAULT_SIZE,
																							Short.MAX_VALUE)
																					.addGroup(gl_jPanel2
																							.createSequentialGroup()
																							.addGap(2)
																							.addComponent(
																									jToggleButton4_1,
																									GroupLayout.PREFERRED_SIZE,
																									42,
																									GroupLayout.PREFERRED_SIZE)
																							.addGap(10)))
																			.addComponent(btnNewButton_2_1,
																					GroupLayout.DEFAULT_SIZE, 54,
																					Short.MAX_VALUE)
																			.addComponent(moverAbajo,
																					GroupLayout.PREFERRED_SIZE, 50,
																					GroupLayout.PREFERRED_SIZE)
																			.addComponent(textField_1,
																					GroupLayout.PREFERRED_SIZE, 52,
																					GroupLayout.PREFERRED_SIZE))
																	.addPreferredGap(ComponentPlacement.RELATED))))
											.addGroup(gl_jPanel2.createSequentialGroup().addGroup(gl_jPanel2
													.createParallelGroup(Alignment.LEADING).addComponent(idioma,
															GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
															GroupLayout.PREFERRED_SIZE)
													.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 43,
															GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(picker, GroupLayout.PREFERRED_SIZE, 40,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
															.addComponent(btnNewButton).addComponent(btnNewButton_1))
													.addGap(34)))
											.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_jPanel2.createSequentialGroup()
															.addPreferredGap(ComponentPlacement.RELATED)
															.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
																	.addGroup(gl_jPanel2.createSequentialGroup()
																			.addGroup(gl_jPanel2
																					.createParallelGroup(
																							Alignment.BASELINE)
																					.addComponent(anguloGiro,
																							GroupLayout.PREFERRED_SIZE,
																							51,
																							GroupLayout.PREFERRED_SIZE)
																					.addComponent(angulo2,
																							GroupLayout.DEFAULT_SIZE,
																							54, Short.MAX_VALUE)
																					.addComponent(angulo3,
																							GroupLayout.DEFAULT_SIZE,
																							54, Short.MAX_VALUE)
																					.addComponent(angulo5,
																							GroupLayout.DEFAULT_SIZE,
																							52, Short.MAX_VALUE)
																					.addComponent(angulo4,
																							GroupLayout.DEFAULT_SIZE,
																							54, Short.MAX_VALUE))
																			.addGap(49))
																	.addGroup(gl_jPanel2.createSequentialGroup()
																			.addComponent(efectoFigura,
																					GroupLayout.PREFERRED_SIZE, 52,
																					GroupLayout.PREFERRED_SIZE)
																			.addContainerGap())))
													.addGroup(gl_jPanel2.createSequentialGroup().addGap(12)
															.addComponent(color2, GroupLayout.PREFERRED_SIZE, 32,
																	GroupLayout.PREFERRED_SIZE)
															.addContainerGap())))
									.addGroup(
											gl_jPanel2
													.createSequentialGroup().addComponent(color1,
															GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
													.addGap(102)))));

			SimpleButton girarIzquierda_1 = new SimpleButton("");
			panel_2.add(girarIzquierda_1);

			girarIzquierda_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					girarFigura(false);

				}

			});

			girarIzquierda_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/rotate_180.png")));

			girarIzquierda_1.setOpaque(true);

			girarIzquierda_1.setContentAreaFilled(false);

			SimpleButton centrar_1 = new SimpleButton("");

			panel_1.add(centrar_1);

			centrar_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					gradosFigura = 2;

					girarFigura(true);

				}

			});

			centrar_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/center.png")));

			centrar_1.setOpaque(true);

			centrar_1.setContentAreaFilled(false);

			jPanel2.setLayout(gl_jPanel2);

			javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
			layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
									.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 1333, Short.MAX_VALUE)
									.addComponent(panelDeDibujo, GroupLayout.DEFAULT_SIZE, 1323, Short.MAX_VALUE))
							.addContainerGap()));
			layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
					layout.createSequentialGroup()
							.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panelDeDibujo, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE)));

			getContentPane().setLayout(layout);

			setSize(new Dimension(1348, 872));

			setLocationRelativeTo(null);

		}

		catch (Exception e) {

		}

	}

	private void dibujarFigura(int figuraSeleccionada) {

		panelDeDibujo.setFiguraSeleccionada(figuraSeleccionada);

	}

	public static int getIncrementoAbajo() {

		return moverAbajo.getValor();

	}

	public static int getIncrementoArriba() {

		return moverArriba.getValor();

	}

	public static int saberRadio() {

		return angulo2.getValor();

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

	public int getGrosorSeleccionado() {

		return grosor.getValor();

	}
}
