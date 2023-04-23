package dibujante;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import com.comboBox.language.ComboBoxLanguage;
import com.spinner.simple.Spinner;

import checkbox.CheckBoxLabel;
import efectos.Cadena;
import figuras.geometria.Rectangulo;
import figuras.utils.Borrador;
import figuras.utils.Cubeta;
import figuras.utils.Imagen;
import figuras.utils.Lapiz;
import figuras.utils.Spray;
import net.java.dev.colorchooser.demo.CopyColor;
import util.Board;
import util.Figura;
import util.Metodos;

@SuppressWarnings("all")

public class VentanaPrincipal extends javax.swing.JFrame {

	Spinner radio;

	private int idCategoria;

	private int idIdioma;

	private boolean regla;

	public static Spinner moverArriba;

	public static PanelDeDibujo panelDeDibujo;

	private VentanaPrincipal ventanaPrincipal;

	private JPanel vistaFigura;

	public static CopyColor color1;

	public static CopyColor color2;

	public static Spinner vueltas;

	private Color colorSeleccionado;

	private JTextField textField;

	public static Spinner moverAbajo;

	public static CheckBoxLabel verRegla;

	private JTextField textField_1;

	Spinner angulo3;

	public static CheckBoxLabel enCirculo;

	private JCheckBox figuraRellena;

	public CheckBoxLabel dibujarRellena;

	public static ComboBoxSuggestion efectoFigura;

	ComboBoxSuggestion nombreFigura;

	private int indice;

	public static ComboBoxSuggestion subTipoFigura;

	LinkedList<String> listaFiguras;

	LinkedList<String> efectosFiguras;

	public static Spinner anguloGiro;

	CheckBoxLabel malla;

	public static CheckBoxLabel redondear;

	public static Spinner angulo2;

	public static Spinner grosor;

	private short gradosFigura;

	private JLabel orientacion;

	private Spinner angulo4;

	private Spinner angulo5;

	private Spinner sumarAngulo;

	private ComboBoxLanguage comboBox;

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

			for (String dato : Metodos.obtenerGrupos(comboBox.getSelectedIndex(), nombreFigura.getSelectedIndex() + 1,
					true)) {

				subTipoFigura.addItem(dato);

			}

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

	public VentanaPrincipal() throws IOException {

		vistaFigura = new Board();

		vistaFigura.setBackground(Color.WHITE);

		regla = false;

		orientacion = new JLabel("");

		gradosFigura = 1;

		grosor = new Spinner();

		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imagenes/paint.png")));

		getContentPane().setBackground(Color.WHITE);

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

			figuraActual = new Cubeta(puntoActual, panelDeDibujo);

			break;

		case -2:

			figuraActual = new Lapiz(puntoActual);

			break;

		case -1:

			figuraActual = new Borrador(puntoActual);

			break;

		case 0:

			// figuraActual = new Cadena(3, puntoActual, anchura, altura);

			figuraActual = new Rectangulo(puntoActual, anchura, altura);

			break;

		}

		if (figuraActual != null) {

			if (!regla && verRegla.isSelected()) {

				regla = true;

				figuraActual.pintarRegla(getGraphics());

			}

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

	public static void deshacer() {

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

			comboBox = new ComboBoxLanguage(this, null, null);

			comboBox.setSize(100, 100);

			comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));

			comboBox.getBox().addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {

					try {

						nombreFigura.removeAllItems();

						for (String dato : Metodos.obtenerGrupos(comboBox.getSelectedIndex(), -1, false)) {

							nombreFigura.addItem(dato);

						}

						verNombresFiguras();

					}

					catch (Exception e1) {

					}

				}

			});

			((Board) vistaFigura).setAncho(100);

			((Board) vistaFigura).setAlto(100);

			listaFiguras = new LinkedList<>();

			verRegla = new CheckBoxLabel(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/regla.png")));

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

			enCirculo.setBackground(Color.WHITE);

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

			malla = new CheckBoxLabel(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/malla.png")));

			efectoFigura = new ComboBoxSuggestion();

			nombreFigura = new ComboBoxSuggestion();

			subTipoFigura = new ComboBoxSuggestion();

			verGrupos();

			subTipoFigura.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {

					limpiarEfectosFiguras();

					((Board) vistaFigura).setFigure(subTipoFigura.getSelectedIndex());

					vistaFigura.repaint();

					if (subTipoFigura.getItemCount() > 0) {

						if (efectosFiguras.contains(subTipoFigura.getSelectedItem().toString())) {

							efectoFigura.addItem("Cadena");

						}

						dibujarFigura(subTipoFigura.getSelectedIndex());

					}

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

			jToggleButton4_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/text.png")));

			textField_1 = new JTextField();

			textField_1.setColumns(10);

			JLabel jLabel6_1 = new JLabel();

			jLabel6_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/lap.png")));

			jLabel6_1.setHorizontalAlignment(SwingConstants.CENTER);

			dibujarRellena = new CheckBoxLabel(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/fill.png")));

			dibujarRellena.setBackground(SystemColor.textHighlight);

			JLabel jLabel9_1 = new JLabel();

			jLabel9_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/angle.png")));

			JLabel jLabel2_1 = new JLabel();

			jLabel2_1.setHorizontalAlignment(SwingConstants.CENTER);

			jLabel2_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/move_top.png")));

			JLabel jLabel3_1 = new JLabel();

			jLabel3_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/move_down.png")));

			jLabel3_1.setHorizontalAlignment(SwingConstants.CENTER);

			verRegla.setBackground(Color.WHITE);

			nombreFigura.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {

					int indice = nombreFigura.getSelectedIndex() + 1;

					if ((idIdioma == comboBox.getSelectedIndex() && idCategoria != indice)
							|| (idIdioma != comboBox.getSelectedIndex() && idCategoria != indice)) {

						idIdioma = comboBox.getSelectedIndex();

						idCategoria = indice;

						verNombresFiguras();

					}

				}

			});

			malla.setBackground(SystemColor.textHighlight);

			redondear.setBackground(Color.WHITE);

			JLabel jLabel8_1_1 = new JLabel();

			jLabel8_1_1.setIcon(null);

			jLabel8_1_1.setHorizontalAlignment(SwingConstants.LEFT);

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

			SimpleButton btn24_1_1 = new SimpleButton("");
			btn24_1_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/Recycle_Bin_Full.png")));
			btn24_1_1.setToolTipText("Borrador");
			btn24_1_1.setPreferredSize(new Dimension(37, 30));
			btn24_1_1.setOpaque(true);
			btn24_1_1.setContentAreaFilled(false);
			panel_1_1.add(btn24_1_1);

			SimpleButton btn23_1_1 = new SimpleButton("");
			btn23_1_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					panelDeDibujo.setFiguraSeleccionada(-3);

				}

			});

			btn23_1_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/lapiz.png")));
			btn23_1_1.setToolTipText("Gotero");
			btn23_1_1.setPreferredSize(new Dimension(37, 30));
			btn23_1_1.setOpaque(true);
			btn23_1_1.setContentAreaFilled(false);
			panel_1_1.add(btn23_1_1);

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

			btnNewButton_2.setBorderColor(Color.BLACK);
			btnNewButton_2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/curva.png")));

			SimpleButton btnNewButton_2_1 = new SimpleButton("");

			btnNewButton_2_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

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

			});
			btnNewButton_2_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/reset.png")));
			btnNewButton_2_1.setBorderColor(Color.BLACK);

			CheckBoxLabel enCirculo_1 = new CheckBoxLabel(
					new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/puntos.png")));

			enCirculo_1.setBackground(Color.WHITE);

			GroupLayout gl_jPanel2 = new GroupLayout(jPanel2);
			gl_jPanel2
					.setHorizontalGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING).addGroup(gl_jPanel2
							.createSequentialGroup().addContainerGap().addGroup(gl_jPanel2
									.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel2.createSequentialGroup()
											.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 28,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(
													ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
											.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 28,
													GroupLayout.PREFERRED_SIZE))
									.addComponent(color2, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
									.addComponent(picker, GroupLayout.PREFERRED_SIZE, 114,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(color1, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel2
									.createSequentialGroup()
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addGap(11)
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING, false)
											.addGroup(gl_jPanel2.createSequentialGroup()
													.addComponent(jToggleButton4_1, GroupLayout.PREFERRED_SIZE, 32,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 116,
															GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_jPanel2.createSequentialGroup()
													.addComponent(dibujarRellena, GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED).addComponent(malla,
															GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
															Short.MAX_VALUE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(radio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)
											.addComponent(sumarAngulo, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_jPanel2.createSequentialGroup().addGap(4)
													.addComponent(jLabel2_1, GroupLayout.PREFERRED_SIZE, 22,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED).addComponent(
															moverArriba, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
											.addGroup(gl_jPanel2.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED).addComponent(grosor,
															GroupLayout.PREFERRED_SIZE, 84,
															GroupLayout.PREFERRED_SIZE))))
									.addGroup(gl_jPanel2.createSequentialGroup()
											.addComponent(jLabel9_1, GroupLayout.PREFERRED_SIZE, 30,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(anguloGiro, GroupLayout.PREFERRED_SIZE, 71,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(angulo2, GroupLayout.PREFERRED_SIZE, 70,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(angulo3, GroupLayout.PREFERRED_SIZE, 69,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(angulo4, GroupLayout.PREFERRED_SIZE, 68,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(angulo5, GroupLayout.PREFERRED_SIZE, 68,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton_2_1,
													GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING, false).addGroup(gl_jPanel2
									.createSequentialGroup()
									.addComponent(jLabel6_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED).addComponent(
											vueltas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
											Short.MAX_VALUE))
									.addGroup(gl_jPanel2.createSequentialGroup()
											.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
													.addComponent(jLabel3_1, GroupLayout.DEFAULT_SIZE, 34,
															Short.MAX_VALUE)
													.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
													.addComponent(moverAbajo, GroupLayout.DEFAULT_SIZE,
															GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(enCirculo_1, GroupLayout.PREFERRED_SIZE, 68,
															GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
									.addComponent(enCirculo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
											Short.MAX_VALUE)
									.addComponent(redondear, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
											GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(verRegla, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 68,
											Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_jPanel2.createSequentialGroup().addComponent(jLabel8_1_1)
											.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
													.addComponent(nombreFigura, GroupLayout.DEFAULT_SIZE, 253,
															Short.MAX_VALUE)
													.addComponent(subTipoFigura, GroupLayout.DEFAULT_SIZE, 253,
															Short.MAX_VALUE)))
									.addComponent(efectoFigura, GroupLayout.PREFERRED_SIZE, 253,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED).addComponent(orientacion).addGap(18)
							.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addGroup(
											gl_jPanel2.createSequentialGroup()
													.addComponent(vistaFigura, GroupLayout.PREFERRED_SIZE, 143,
															GroupLayout.PREFERRED_SIZE)
													.addGap(77)))
							.addContainerGap()));
			gl_jPanel2.setVerticalGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel2
					.createSequentialGroup()
					.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel2
							.createSequentialGroup()
							.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel2
									.createSequentialGroup()
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
											.addComponent(jToggleButton4_1, GroupLayout.DEFAULT_SIZE, 71,
													Short.MAX_VALUE)
											.addGroup(gl_jPanel2.createSequentialGroup().addContainerGap()
													.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
															.addComponent(grosor, GroupLayout.DEFAULT_SIZE, 60,
																	Short.MAX_VALUE)
															.addComponent(sumarAngulo, GroupLayout.DEFAULT_SIZE, 60,
																	Short.MAX_VALUE)
															.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 60,
																	GroupLayout.PREFERRED_SIZE)
															.addGroup(gl_jPanel2.createSequentialGroup()
																	.addComponent(jLabel6_1, GroupLayout.DEFAULT_SIZE,
																			54, Short.MAX_VALUE)
																	.addPreferredGap(ComponentPlacement.RELATED))
															.addGroup(gl_jPanel2.createSequentialGroup()
																	.addGroup(gl_jPanel2
																			.createParallelGroup(Alignment.TRAILING)
																			.addComponent(verRegla, Alignment.LEADING,
																					GroupLayout.DEFAULT_SIZE, 54,
																					Short.MAX_VALUE)
																			.addComponent(vueltas, Alignment.LEADING,
																					GroupLayout.DEFAULT_SIZE, 54,
																					Short.MAX_VALUE)
																			.addComponent(nombreFigura,
																					Alignment.LEADING,
																					GroupLayout.DEFAULT_SIZE, 54,
																					Short.MAX_VALUE)
																			.addComponent(orientacion,
																					Alignment.LEADING))
																	.addPreferredGap(ComponentPlacement.RELATED)))))
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel2
											.createSequentialGroup().addGap(7)
											.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
													.addComponent(radio, GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(malla, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
													.addComponent(jLabel2_1, Alignment.TRAILING,
															GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
													.addComponent(dibujarRellena, Alignment.TRAILING,
															GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
													.addComponent(moverArriba, Alignment.TRAILING,
															GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)))
											.addGroup(gl_jPanel2.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
															.addComponent(jLabel8_1_1, Alignment.TRAILING,
																	GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
															.addComponent(subTipoFigura, Alignment.TRAILING,
																	GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
															.addGroup(Alignment.TRAILING, gl_jPanel2
																	.createParallelGroup(Alignment.LEADING, false)
																	.addComponent(moverAbajo, Alignment.TRAILING,
																			GroupLayout.DEFAULT_SIZE,
																			GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																	.addComponent(redondear, Alignment.TRAILING,
																			GroupLayout.DEFAULT_SIZE, 53,
																			Short.MAX_VALUE))
															.addComponent(jLabel3_1, Alignment.TRAILING,
																	GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)))))
									.addGroup(
											gl_jPanel2.createSequentialGroup().addGap(46).addComponent(picker,
													GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED).addGroup(gl_jPanel2
															.createParallelGroup(Alignment.LEADING, false).addComponent(
																	btnNewButton_1, GroupLayout.DEFAULT_SIZE,
																	GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
															.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE,
																	GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE).addComponent(
											panel_1_1, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
									.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel2
									.createSequentialGroup()
									.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_jPanel2.createSequentialGroup()
													.addComponent(color2, GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(7))
											.addGroup(gl_jPanel2.createSequentialGroup().addGroup(gl_jPanel2
													.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_jPanel2.createParallelGroup(Alignment.BASELINE)
															.addComponent(anguloGiro, GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(angulo2, GroupLayout.DEFAULT_SIZE, 54,
																	Short.MAX_VALUE)
															.addComponent(angulo3, GroupLayout.DEFAULT_SIZE, 54,
																	Short.MAX_VALUE)
															.addComponent(angulo4, GroupLayout.DEFAULT_SIZE, 54,
																	Short.MAX_VALUE)
															.addComponent(angulo5, GroupLayout.DEFAULT_SIZE, 52,
																	Short.MAX_VALUE))
													.addComponent(jLabel9_1, Alignment.TRAILING,
															GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
													.addGap(7))
											.addGroup(gl_jPanel2.createSequentialGroup().addGroup(gl_jPanel2
													.createParallelGroup(Alignment.LEADING)
													.addComponent(btnNewButton_2, Alignment.TRAILING,
															GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
													.addComponent(enCirculo, Alignment.TRAILING,
															GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
															GroupLayout.PREFERRED_SIZE)
													.addComponent(efectoFigura, Alignment.TRAILING,
															GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
													.addComponent(enCirculo_1, Alignment.TRAILING,
															GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
													.addGap(16)))
									.addGap(39)).addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 54,
											GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_jPanel2.createSequentialGroup().addContainerGap().addGroup(gl_jPanel2
									.createParallelGroup(Alignment.LEADING)
									.addComponent(vistaFigura, GroupLayout.PREFERRED_SIZE, 100,
											GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_jPanel2.createSequentialGroup()
											.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
											.addGap(115)
											.addComponent(color1, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE)
											.addGap(73)))))
					.addGap(3)));

			SimpleButton btn22_1 = new SimpleButton("");
			panel_2.add(btn22_1);

			btn22_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					panelDeDibujo.setFiguraSeleccionada(-2);
				}
			});

			btn22_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/lapiz.png")));

			btn22_1.setToolTipText("Lapiz");

			btn22_1.setPreferredSize(new Dimension(37, 30));

			btn22_1.setOpaque(true);

			btn22_1.setContentAreaFilled(false);

			SimpleButton btn20_1 = new SimpleButton("");
			btn20_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					panelDeDibujo.setFiguraSeleccionada(-4);
				}
			});
			panel_2.add(btn20_1);

			btn20_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/spray.png")));

			btn20_1.setToolTipText("Cubeta");

			btn20_1.setPreferredSize(new Dimension(37, 30));

			btn20_1.setOpaque(true);

			btn20_1.setContentAreaFilled(false);

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

			SimpleButton btn24_1 = new SimpleButton("");

			btn24_1.addActionListener(new ActionListener() {

				@Override

				public void actionPerformed(ActionEvent e) {

					panelDeDibujo.setFiguraSeleccionada(-1);

				}

			});

			panel_1.add(btn24_1);

			btn24_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/borrador.png")));

			btn24_1.setToolTipText("Borrador");

			btn24_1.setPreferredSize(new Dimension(37, 30));

			btn24_1.setOpaque(true);

			btn24_1.setContentAreaFilled(false);

			SimpleButton btn23_1 = new SimpleButton("");

			panel_1.add(btn23_1);

			btn23_1.addActionListener(new ActionListener() {

				@Override

				public void actionPerformed(ActionEvent e) {

					dibujarFigura(-1);

				}

			});

			btn23_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/lapiz.png")));

			btn23_1.setToolTipText("Gotero");

			btn23_1.setPreferredSize(new Dimension(37, 30));

			btn23_1.setOpaque(true);

			btn23_1.setContentAreaFilled(false);

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
					.addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING)
							.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 1322, Short.MAX_VALUE)
							.addComponent(panelDeDibujo, GroupLayout.PREFERRED_SIZE, 1280, GroupLayout.PREFERRED_SIZE))
							.addContainerGap()));
			layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
							.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelDeDibujo, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)));

			getContentPane().setLayout(layout);

			setSize(new Dimension(1348, 872));

			setLocationRelativeTo(null);

		}

		catch (Exception e) {

		}

	}

	private void verGrupos() {

		try {

			nombreFigura = Metodos.insertarTexto(nombreFigura, Metodos.obtenerGrupos(0, -1, false));

			verNombresFiguras();

		}

		catch (Exception e) {
			e.printStackTrace();
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
