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
import com.colourpicker.ScreenColor;
import com.comboBox.comboSuggestion.ComboBoxSuggestion;
import com.guilanguage.JComboBoxLanguage;
import com.spinner.simple.Spinner;

import checkbox.CheckBoxCustom;
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
import figuras.letras.A;
import figuras.mandalas.Mandala1;
import figuras.mandalas.Mandala2;
import figuras.mandalas.Mandala3;
import figuras.mandalas.Mandala4;
import figuras.mandalas.Mandala5;
import figuras.mandalas.Mandala6;
import figuras.mandalas.MandalaCirculo;
import figuras.mandalas.MandalaEstrella;
import figuras.marcas.Nike;
import figuras.numeros.Numero1;
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
import figuras.utils.Lapiz;
import figuras.utils.Spray;
import net.java.dev.colorchooser.demo.CopyColor;
import util.Metodos;

@SuppressWarnings("all")

public class VentanaPrincipal extends javax.swing.JFrame {

	private short figuraGiro;

	private JLabel orientacion;

	public static Spinner moverArriba;

	public static PanelDeDibujo panelDeDibujo;

	private VentanaPrincipal ventanaPrincipal;

	public static CopyColor color1;

	public static CopyColor color2;

	public static Spinner vueltas;

	private Color colorSeleccionado;

	private JTextField textField;

	public static Spinner moverAbajo;

	public static CheckBoxCustom verRegla;

	Spinner grosor;

	private JTextField textField_1;

	public static CheckBoxCustom enCirculo;

	private CheckBoxCustom figuraRellena;

	public CheckBoxCustom dibujarRellena;

	public static ComboBoxSuggestion efectoFigura;

	private int idIdioma;

	public static ComboBoxSuggestion nombreFigura;

	private int idCategoria;

	private short gradosFigura;

	public static ComboBoxSuggestion subTipoFigura;

	public static JComboBoxLanguage idioma;

	LinkedList<String> listaFiguras;

	LinkedList<String> efectosFiguras;

	public static Spinner anguloGiro;

	CheckBoxCustom malla;

	public static CheckBoxCustom redondear;

	public static Spinner radio;

	private Spinner sumarAngulo;

	private Spinner angulo2;

	private Spinner angulo3;

	private Spinner angulo4;

	private Spinner angulo5;

	private SimpleButton panel_3;

	public static JLabel alto;

	public static JLabel ancho;

	private JLabel lblNewLabel;

	private JLabel lblNewLabel_1;

	private void reset() {

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

		figuraGiro = gradosFigura;

		orientacion.setIcon(
				new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/flecha_" + gradosFigura + ".png")));

	}

	public static int getRadio() {

		return radio.getValor();

	}

	public VentanaPrincipal() throws IOException {

		idioma = new JComboBoxLanguage(null, null);

		idioma.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				ponerNombresFiguras(idioma.getSelectedIndex());

			}

		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imagenes/paint.png")));

		getContentPane().setBackground(Color.WHITE);

		setTitle("Test");

		JMenuBar menuBar = new JMenuBar();

		setJMenuBar(menuBar);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				guardarImagen();
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mntmNewMenuItem_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/export.png")));

		menuBar.add(mntmNewMenuItem_1);

		initComponents();

		reset();

		ponerNombresFiguras(0);

		calcularFigura();

		setVisible(true);

	}

	private void calcularFigura() {

		try {

			dibujarFigura(Metodos.obtenerNumeroFigura(idioma.getSelectedIndex(), nombreFigura.getSelectedIndex() + 1,
					subTipoFigura.getSelectedItem().toString()));

		}

		catch (Exception e1) {

		}

	}

	public static void main(String[] args) {

		try {

			new VentanaPrincipal().setVisible(true);

		}

		catch (Exception e) {

		}

	}

	private void ponerMovimiento(Figura figuraActual) {

		figuraActual.setMoverArriba(moverArriba.getValor());

		figuraActual.setMoverAbajo(moverAbajo.getValor());

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

			idCategoria = -1;

			enCirculo = new CheckBoxCustom();

			figuraRellena = new CheckBoxCustom();

			figuraRellena.setHorizontalAlignment(SwingConstants.RIGHT);

			redondear = new CheckBoxCustom();

			radio = new Spinner();

			radio.setMinValor(1);

			radio.setValor(100);

			moverArriba = new Spinner();

			moverArriba.setMinValor(0);

			efectosFiguras = new LinkedList();

			malla = new CheckBoxCustom();

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

					}

					calcularFigura();

				}

			});

			listaFiguras = new LinkedList<>();

			verRegla = new CheckBoxCustom();

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			color1 = new CopyColor(Color.BLACK, false);
			color1.setLineBorderColor(Color.WHITE);
			color1.setForeground(Color.WHITE);
			color1.setColor(Color.BLACK);

			color2 = new CopyColor(Color.WHITE, false);
			color2.setLineBorderColor(Color.WHITE);
			color2.setForeground(Color.WHITE);

			setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

			grosor = new Spinner();

			grosor.setMinValor(1);

			grosor.setMaxValor(100);

			grosor.setLabelText("Thickness");

			grosor.setValor(1);

			vueltas = new Spinner();

			vueltas.setMinValor(1);

			vueltas.setLabelText("Laps");

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

				@Override
				public void actionPerformed(ActionEvent e) {

					girarFigura(false);

				}

			});

			girarIzquierda_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/rotate_180.png")));

			girarIzquierda_1.setOpaque(true);

			girarIzquierda_1.setContentAreaFilled(false);

			SimpleButton centrar_1 = new SimpleButton("");
			centrar_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					gradosFigura = 0;

					orientacion.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/flecha_1.png")));

				}
			});

			centrar_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/center.png")));

			centrar_1.setOpaque(true);

			centrar_1.setContentAreaFilled(false);

			SimpleButton girarDerecha_1 = new SimpleButton("");

			girarDerecha_1.addActionListener(new ActionListener() {

				@Override

				public void actionPerformed(ActionEvent e) {

					girarFigura(true);

				}

			});

			girarDerecha_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/rotate_180_r.png")));

			girarDerecha_1.setOpaque(true);

			girarDerecha_1.setContentAreaFilled(false);

			SimpleButton btn24_1 = new SimpleButton("");

			btn24_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					rehacer();

				}

			});

			btn24_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/rehacer.png")));

			btn24_1.setToolTipText("");

			btn24_1.setPreferredSize(new Dimension(37, 30));

			btn24_1.setOpaque(true);

			btn24_1.setContentAreaFilled(false);

			SimpleButton limpiarTodo = new SimpleButton("");
			limpiarTodo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					nuevo();
					calcularFigura();

				}
			});

			limpiarTodo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/Recycle_Bin_Full.png")));

			limpiarTodo.setOpaque(true);

			limpiarTodo.setContentAreaFilled(false);

			JLabel jToggleButton4_1 = new JLabel("");
			jToggleButton4_1.setHorizontalAlignment(SwingConstants.RIGHT);

			jToggleButton4_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/text.png")));

			textField_1 = new JTextField();

			textField_1.setColumns(10);

			JLabel jLabel6_1 = new JLabel();

			jLabel6_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/lap.png")));

			jLabel6_1.setHorizontalAlignment(SwingConstants.RIGHT);

			dibujarRellena = new CheckBoxCustom();

			JLabel jLabel4_1 = new JLabel();

			jLabel4_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/fill.png")));

			jLabel4_1.setHorizontalAlignment(SwingConstants.LEFT);

			JLabel jLabel9_1 = new JLabel();
			jLabel9_1.setHorizontalAlignment(SwingConstants.RIGHT);

			jLabel9_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/angle.png")));

			JLabel jLabel2_1 = new JLabel();

			jLabel2_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/move_top.png")));

			JLabel jLabel3_1 = new JLabel();

			jLabel3_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/move_down.png")));

			jLabel3_1.setHorizontalAlignment(SwingConstants.CENTER);

			JLabel jLabel8_1 = new JLabel();

			jLabel8_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/regla.png")));

			jLabel8_1.setHorizontalAlignment(SwingConstants.CENTER);

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

			JLabel jLabel2_1_1 = new JLabel();

			jLabel2_1_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/malla.png")));

			JLabel jLabel2_1_2 = new JLabel();

			jLabel2_1_2.setHorizontalAlignment(SwingConstants.CENTER);

			jLabel2_1_2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/radio.png")));

			JLabel jLabel8_1_1 = new JLabel();

			jLabel8_1_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/rounded.png")));

			jLabel8_1_1.setHorizontalAlignment(SwingConstants.LEFT);

			JLabel jLabel8_1_1_1 = new JLabel();
			jLabel8_1_1_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/en_circulo.png")));
			jLabel8_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);

			ScreenColor picker = new ScreenColor();
			picker.color.setBackground(Color.PINK);
			picker.setColor(Color.RED);
			picker.setBackground(Color.WHITE);

			SimpleButton panel_1 = new SimpleButton("");
			panel_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					color1.setColor(picker.getColor());
				}
			});
			panel_1.setBorderColor(Color.WHITE);
			panel_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/flecha.png")));

			SimpleButton panel_1_1 = new SimpleButton("");
			panel_1_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					color2.setColor(picker.getColor());
				}
			});
			panel_1_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/flecha.png")));
			panel_1_1.setBorderColor(Color.WHITE);

			sumarAngulo = new Spinner();
			sumarAngulo.setValor(90);
			sumarAngulo.setMinValor(0);
			sumarAngulo.setMaxValor(360);
			sumarAngulo.setLabelText("+Angle");

			angulo2 = new Spinner();
			angulo2.setMinValor(1);
			angulo2.setLabelText("Angle 2");

			angulo3 = new Spinner();
			angulo3.setMinValor(1);
			angulo3.setLabelText("Angle 3");

			angulo4 = new Spinner();
			angulo4.setMinValor(1);
			angulo4.setLabelText("Angle 4");

			angulo5 = new Spinner();
			angulo5.setMinValor(1);
			angulo5.setLabelText("Angle 5");

			SimpleButton panel = new SimpleButton("");
			panel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					reset();

				}

			});

			panel.setBorderColor(Color.BLACK);

			panel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/reset.png")));

			SimpleButton panel_2 = new SimpleButton("");
			panel_2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					new CubicCurveMouse().setVisible(true);

				}
			});
			panel_2.setBorderColor(Color.BLACK);
			panel_2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/curva.png")));

			orientacion = new JLabel("");

			orientacion.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/flecha_1.png")));

			panel_3 = new SimpleButton("");
			panel_3.setBorderColor(Color.WHITE);

			panel_3.addActionListener(new ActionListener() {

				@Override

				public void actionPerformed(ActionEvent e) {

					deshacer();

				}

			});

			panel_3.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/deshacer.png")));

			ancho = new JLabel("");
			ancho.setFont(new Font("Tahoma", Font.PLAIN, 16));
			ancho.setHorizontalAlignment(SwingConstants.CENTER);

			alto = new JLabel("");
			alto.setFont(new Font("Tahoma", Font.PLAIN, 16));
			alto.setHorizontalAlignment(SwingConstants.CENTER);

			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/height.png")));

			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/width.png")));

			GroupLayout gl_jPanel2 = new GroupLayout(jPanel2);
			gl_jPanel2.setHorizontalGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING).addGroup(gl_jPanel2
					.createSequentialGroup()
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
							.addComponent(picker, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
							.addGroup(gl_jPanel2.createSequentialGroup()
									.addComponent(idioma, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
									.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addComponent(grosor, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(
							gl_jPanel2.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_jPanel2.createSequentialGroup()
											.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
													.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 45,
															Short.MAX_VALUE)
													.addComponent(panel_1_1, Alignment.TRAILING,
															GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
													.addComponent(color2, GroupLayout.DEFAULT_SIZE, 115,
															Short.MAX_VALUE)
													.addComponent(color1, GroupLayout.DEFAULT_SIZE, 115,
															Short.MAX_VALUE)))
									.addGroup(gl_jPanel2.createSequentialGroup()
											.addComponent(btn24_1, GroupLayout.PREFERRED_SIZE, 33,
													GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(limpiarTodo, GroupLayout.PREFERRED_SIZE,
													GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
											.addComponent(orientacion)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
							.addComponent(dibujarRellena, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 18,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(jLabel2_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 26,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel2
							.createSequentialGroup()
							.addComponent(moverArriba, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED).addComponent(jLabel3_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(moverAbajo, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jLabel2_1_2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_jPanel2.createSequentialGroup()
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING, false)
											.addGroup(gl_jPanel2.createSequentialGroup()
													.addComponent(girarIzquierda_1, GroupLayout.PREFERRED_SIZE, 47,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(centrar_1, GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_jPanel2.createSequentialGroup().addComponent(jLabel4_1)
													.addPreferredGap(ComponentPlacement.RELATED,
															GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(jLabel9_1, GroupLayout.PREFERRED_SIZE, 40,
															GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_jPanel2.createSequentialGroup()
													.addComponent(girarDerecha_1, GroupLayout.PREFERRED_SIZE, 43,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(jToggleButton4_1, GroupLayout.PREFERRED_SIZE, 38,
															GroupLayout.PREFERRED_SIZE))
											.addComponent(anguloGiro, GroupLayout.PREFERRED_SIZE, 68,
													GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel2
							.createSequentialGroup()
							.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(radio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
											GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(sumarAngulo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 61,
											Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
									.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 53,
											Short.MAX_VALUE)
									.addComponent(jLabel6_1, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
									.addComponent(ancho, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
											.addComponent(alto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)
											.addComponent(vueltas, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 60,
													GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
									.addComponent(angulo4, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addComponent(angulo2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_jPanel2.createSequentialGroup()
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 95,
											GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(verRegla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
											Short.MAX_VALUE)
									.addComponent(jLabel8_1).addGap(12)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_jPanel2.createSequentialGroup().addGap(6)
									.addComponent(redondear, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED).addComponent(jLabel8_1_1).addGap(12)
									.addComponent(enCirculo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED).addComponent(jLabel8_1_1_1).addGap(12)
									.addComponent(malla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED).addComponent(jLabel2_1_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(efectoFigura, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
							.addGroup(gl_jPanel2.createSequentialGroup().addGap(10)
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
											.addComponent(angulo5, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
											.addComponent(angulo3, GroupLayout.PREFERRED_SIZE, 65,
													GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING, false)
											.addComponent(subTipoFigura, GroupLayout.DEFAULT_SIZE,
													GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(nombreFigura, GroupLayout.DEFAULT_SIZE, 327,
													Short.MAX_VALUE))))
					.addContainerGap()));
			gl_jPanel2.setVerticalGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING).addGroup(gl_jPanel2
					.createSequentialGroup()
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_jPanel2.createSequentialGroup().addContainerGap().addComponent(idioma,
									GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
							.addComponent(centrar_1, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(girarIzquierda_1, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(girarDerecha_1, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(jToggleButton4_1, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(verRegla, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(redondear, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(jLabel8_1_1, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(orientacion, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(jLabel8_1_1_1, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(enCirculo, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(malla, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addGroup(gl_jPanel2.createSequentialGroup().addContainerGap()
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
											.addComponent(efectoFigura, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
													52, Short.MAX_VALUE)
											.addComponent(jLabel2_1_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 52,
													Short.MAX_VALUE)))
							.addComponent(limpiarTodo, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(btn24_1, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
							.addComponent(jLabel8_1, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
					.addGap(13)
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_jPanel2.createSequentialGroup().addGap(9).addComponent(picker,
									GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_jPanel2.createSequentialGroup().addGap(14).addGroup(gl_jPanel2
									.createParallelGroup(Alignment.LEADING)
									.addComponent(
											dibujarRellena, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addComponent(jLabel4_1)
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
											.addComponent(jLabel9_1, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
											.addComponent(color1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
													GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(9))
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
							.addGroup(gl_jPanel2.createSequentialGroup().addGap(6)
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_jPanel2.createSequentialGroup()
													.addComponent(jLabel6_1, GroupLayout.DEFAULT_SIZE, 58,
															Short.MAX_VALUE)
													.addGap(6))
											.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING, false)
													.addGroup(gl_jPanel2.createParallelGroup(Alignment.BASELINE)
															.addComponent(
																	anguloGiro, GroupLayout.DEFAULT_SIZE,
																	GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
															.addComponent(sumarAngulo, GroupLayout.DEFAULT_SIZE, 54,
																	Short.MAX_VALUE))
													.addGroup(gl_jPanel2.createParallelGroup(Alignment.BASELINE)
															.addComponent(vueltas, GroupLayout.DEFAULT_SIZE, 54,
																	Short.MAX_VALUE)
															.addComponent(angulo2, GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(angulo3, GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(nombreFigura, GroupLayout.PREFERRED_SIZE, 51,
																	GroupLayout.PREFERRED_SIZE))))
									.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_jPanel2.createSequentialGroup().addGap(13).addComponent(color2,
									GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
							.addComponent(jLabel2_1_2, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
							.addComponent(radio, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
							.addComponent(jLabel2_1, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
							.addGroup(gl_jPanel2.createParallelGroup(Alignment.BASELINE)
									.addComponent(angulo4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addComponent(angulo5, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
							.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
							.addComponent(grosor, GroupLayout.PREFERRED_SIZE, 61, Short.MAX_VALUE)
							.addComponent(moverArriba, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
							.addComponent(moverAbajo, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
							.addGroup(gl_jPanel2.createSequentialGroup().addGap(1).addComponent(jLabel3_1,
									GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
							.addComponent(lblNewLabel, Alignment.TRAILING)
							.addComponent(subTipoFigura, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addComponent(alto, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30,
									GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
					.addGroup(gl_jPanel2.createSequentialGroup().addContainerGap(144, Short.MAX_VALUE)
							.addComponent(ancho, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE).addGap(55))
					.addGroup(gl_jPanel2.createSequentialGroup().addContainerGap(142, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(65)));

			jPanel2.setLayout(gl_jPanel2);

			javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
			layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
									.addComponent(panelDeDibujo, GroupLayout.DEFAULT_SIZE, 1239, Short.MAX_VALUE)
									.addGroup(layout.createSequentialGroup().addGap(10).addComponent(jPanel2,
											GroupLayout.PREFERRED_SIZE, 1197, Short.MAX_VALUE)))
							.addContainerGap()));
			layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING)
					.addGroup(layout.createSequentialGroup().addContainerGap()
							.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panelDeDibujo, GroupLayout.PREFERRED_SIZE, 623, GroupLayout.PREFERRED_SIZE)));

			getContentPane().setLayout(layout);

			setSize(new Dimension(1223, 872));

			setLocationRelativeTo(null);

		}

		catch (Exception e) {

		}

	}

	public Figura figuraADibujarse(int figuraSeleccionada, Point puntoActual, int anchura, int altura,
			Color colorPrimario, Color colorSecundario) {

		gradosFigura = 1;

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

			switch (figuraGiro) {

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

			figuraActual = new A(puntoActual, anchura, altura);

			break;

		case 30:

			figuraActual = new Numero1(puntoActual, anchura, altura);

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

			switch (figuraGiro) {

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

		gradosFigura = figuraGiro;

		if (figuraActual != null) {

			figuraActual.setGrosor(grosor.getValor());

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

	private void dibujarFigura(int index) {

		panelDeDibujo.setFiguraSeleccionada(index);

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
