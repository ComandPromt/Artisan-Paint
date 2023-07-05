package dibujante;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;

import com.comboBox.comboSuggestion.ComboBoxSuggestion;
import com.spinner.simple.Spinner;

import net.java.dev.colorchooser.demo.CopyColor;

@SuppressWarnings("all")

public class Programa extends javax.swing.JFrame {
	private JTextField textField;

	public Programa() throws IOException {

		setTitle("");

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);

		initComponents();

		setVisible(true);

	}

	public static void main(String[] args) {

		try {

			new Programa().setVisible(true);

		}

		catch (Exception e) {

		}

	}

	public void initComponents() throws IOException {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		setResizable(false);

		JPanel jPanel2 = new JPanel();
		jPanel2.setPreferredSize(new Dimension(758, 125));
		jPanel2.setBackground(Color.WHITE);

		Spinner grosor = new Spinner();
		grosor.setValor(1);
		grosor.setMinValor(1);
		grosor.setMaxValor(100);
		grosor.setLabelText("Thickness");

		CopyColor color1 = new CopyColor(Color.BLACK, false);
		color1.setBackground(Color.WHITE);

		CopyColor color2 = new CopyColor(Color.WHITE, false);
		color2.setBackground(Color.WHITE);

		JLabel jToggleButton4_1 = new JLabel("");
		jToggleButton4_1.setIcon(new ImageIcon(Programa.class.getResource("/imagenes/text.png")));

		textField = new JTextField();
		textField.setColumns(10);

		Spinner anguloGiro = new Spinner();
		anguloGiro.setValor(90);
		anguloGiro.setMinValor(0);
		anguloGiro.setMaxValor(360);
		anguloGiro.setLabelText("Angle");

		JCheckBox dibujarRellena = new JCheckBox();
		dibujarRellena.setHorizontalAlignment(SwingConstants.RIGHT);
		dibujarRellena.setBackground(Color.WHITE);

		JCheckBox malla = new JCheckBox();
		malla.setHorizontalAlignment(SwingConstants.RIGHT);
		malla.setBackground(Color.WHITE);

		JLabel jLabel2_1_1 = new JLabel();

		JLabel jLabel3_1 = new JLabel();
		jLabel3_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel jLabel2_1 = new JLabel();

		Spinner moverAbajo = new Spinner();
		moverAbajo.setMinValor(0);

		Spinner moverArriba = new Spinner();
		moverArriba.setMinValor(0);

		JLabel jLabel2_1_2 = new JLabel();
		jLabel2_1_2.setIcon(new ImageIcon(Programa.class.getResource("/imagenes/radio.png")));
		jLabel2_1_2.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel jLabel6_1 = new JLabel();
		jLabel6_1.setIcon(new ImageIcon(Programa.class.getResource("/imagenes/lap.png")));
		jLabel6_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel dividir = new JLabel();
		dividir.setIcon(new ImageIcon(Programa.class.getResource("/imagenes/divide.png")));
		dividir.setHorizontalAlignment(SwingConstants.CENTER);

		Spinner radio = new Spinner();
		radio.setValor(100);
		radio.setMinValor(1);

		Spinner vueltas = new Spinner();
		vueltas.setMinValor(1);
		vueltas.setLabelText("Laps");

		JCheckBox verRegla = new JCheckBox();
		verRegla.setBackground(Color.WHITE);

		JLabel jLabel8_1 = new JLabel();
		jLabel8_1.setIcon(new ImageIcon(Programa.class.getResource("/imagenes/regla.png")));
		jLabel8_1.setHorizontalAlignment(SwingConstants.CENTER);

		JCheckBox redondear = new JCheckBox();
		redondear.setBackground(Color.WHITE);

		JLabel jLabel8_1_1 = new JLabel();
		jLabel8_1_1.setIcon(new ImageIcon(Programa.class.getResource("/imagenes/rounded.png")));
		jLabel8_1_1.setHorizontalAlignment(SwingConstants.LEFT);

		Spinner escala = new Spinner();
		escala.setMinValor(1);

		JCheckBox enCirculo = new JCheckBox();
		enCirculo.setBackground(Color.WHITE);

		JLabel jLabel8_1_1_1 = new JLabel();
		jLabel8_1_1_1.setIcon(new ImageIcon(Programa.class.getResource("/imagenes/en_circulo.png")));
		jLabel8_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);

		ComboBoxSuggestion efectoFigura = new ComboBoxSuggestion();

		ComboBoxSuggestion nombreFigura = new ComboBoxSuggestion();

		ComboBoxSuggestion subTipoFigura = new ComboBoxSuggestion();

		JLabel lblFigura = new JLabel();
		lblFigura.setHorizontalAlignment(SwingConstants.CENTER);
		lblFigura.setFont(new Font("Segoe UI", Font.BOLD, 11));

		JLabel previsualizarFigura_1 = new JLabel();
		previsualizarFigura_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_jPanel2 = new GroupLayout(jPanel2);
		gl_jPanel2.setHorizontalGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jPanel2.createSequentialGroup().addContainerGap()
						.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING, false)
								.addComponent(color1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(color2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(grosor, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE).addGap(126)
						.addGroup(gl_jPanel2
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jPanel2.createSequentialGroup().addGap(50)
										.addComponent(jToggleButton4_1, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
								.addGroup(gl_jPanel2.createSequentialGroup()
										.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_jPanel2.createSequentialGroup()
														.addComponent(dibujarRellena).addGap(6)
														.addComponent(malla, GroupLayout.PREFERRED_SIZE, 21,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jLabel2_1_1).addGap(60))
												.addGroup(gl_jPanel2.createSequentialGroup()
														.addComponent(anguloGiro, GroupLayout.PREFERRED_SIZE, 64,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)))
										.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
												.addComponent(jLabel3_1)
												.addComponent(jLabel2_1, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
												.addComponent(moverAbajo, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
												.addComponent(moverArriba, GroupLayout.PREFERRED_SIZE, 54,
														GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel6_1, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
								.addComponent(jLabel2_1_2, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
								.addComponent(dividir, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jPanel2.createSequentialGroup()
										.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING, false)
												.addComponent(radio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(vueltas, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_jPanel2.createSequentialGroup()
														.addComponent(verRegla, GroupLayout.PREFERRED_SIZE, 21,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED).addComponent(
																jLabel8_1, GroupLayout.PREFERRED_SIZE, 35,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_jPanel2.createSequentialGroup()
																.addComponent(redondear, GroupLayout.PREFERRED_SIZE, 21,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(jLabel8_1_1, GroupLayout.DEFAULT_SIZE, 35,
																		Short.MAX_VALUE))))
								.addGroup(gl_jPanel2.createSequentialGroup()
										.addComponent(escala, GroupLayout.PREFERRED_SIZE, 58,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(enCirculo, GroupLayout.PREFERRED_SIZE, 21,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(jLabel8_1_1_1)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
								.addComponent(efectoFigura, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
								.addComponent(nombreFigura, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(subTipoFigura, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblFigura, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(previsualizarFigura_1,
								GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_jPanel2.setVerticalGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel2.createSequentialGroup().addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFigura, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_jPanel2.createSequentialGroup().addGap(7).addGroup(gl_jPanel2
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jPanel2.createSequentialGroup().addGroup(gl_jPanel2
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_jPanel2.createSequentialGroup().addGroup(gl_jPanel2
												.createParallelGroup(Alignment.LEADING).addComponent(jToggleButton4_1)
												.addComponent(grosor, GroupLayout.PREFERRED_SIZE, 61,
														GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
										.addGroup(gl_jPanel2.createSequentialGroup().addGroup(
												gl_jPanel2.createParallelGroup(Alignment.TRAILING, false)
														.addGroup(Alignment.LEADING,
																gl_jPanel2.createSequentialGroup()
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(textField))
														.addComponent(jLabel6_1, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)))
										.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel2
												.createSequentialGroup()
												.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
														.addComponent(dibujarRellena, Alignment.LEADING,
																GroupLayout.PREFERRED_SIZE, 47,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(Alignment.LEADING, gl_jPanel2.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(jLabel2_1_2, GroupLayout.PREFERRED_SIZE,
																		48, GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE))
												.addComponent(jLabel2_1, GroupLayout.PREFERRED_SIZE, 48,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(moverArriba, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_jPanel2.createSequentialGroup()
														.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
																.addComponent(malla, GroupLayout.PREFERRED_SIZE, 48,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(jLabel2_1_1, GroupLayout.PREFERRED_SIZE,
																		48, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(
																anguloGiro, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
								.addComponent(jLabel3_1, Alignment.TRAILING)
								.addGroup(gl_jPanel2.createSequentialGroup().addGroup(gl_jPanel2
										.createParallelGroup(Alignment.LEADING)
										.addComponent(vueltas, GroupLayout.PREFERRED_SIZE, 44,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(nombreFigura, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(verRegla, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 42,
														Short.MAX_VALUE)
												.addComponent(jLabel8_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														42, Short.MAX_VALUE)))
										.addGap(18)
										.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
												.addComponent(subTipoFigura, Alignment.LEADING,
														GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
												.addGroup(Alignment.LEADING, gl_jPanel2
														.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(redondear, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(jLabel8_1_1, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(radio, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)))
										.addGap(18)
										.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel2
												.createParallelGroup(Alignment.LEADING)
												.addComponent(jLabel8_1_1_1, Alignment.TRAILING,
														GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(efectoFigura, GroupLayout.PREFERRED_SIZE, 47,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(Alignment.TRAILING, gl_jPanel2.createSequentialGroup()
														.addGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING)
																.addComponent(dividir, GroupLayout.PREFERRED_SIZE, 48,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(escala, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(moverAbajo, GroupLayout.PREFERRED_SIZE,
																		49, GroupLayout.PREFERRED_SIZE))
														.addGap(7)))
												.addGroup(Alignment.TRAILING,
														gl_jPanel2.createSequentialGroup().addComponent(enCirculo)
																.addGap(18)))))
								.addGap(25))
						.addGroup(gl_jPanel2.createSequentialGroup().addGap(72)
								.addComponent(color1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(color2,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addGap(16))
				.addGroup(gl_jPanel2.createSequentialGroup().addComponent(previsualizarFigura_1,
						GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE).addContainerGap()));
		jPanel2.setLayout(gl_jPanel2);

		PanelDeDibujo panel = new PanelDeDibujo();

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 1074, Short.MAX_VALUE).addContainerGap())
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE).addContainerGap()));

		getContentPane().setLayout(layout);

		setSize(new Dimension(1100, 776));

		setLocationRelativeTo(null);

	}

	public void actionPerformed(ActionEvent arg0) {

	}

	public void stateChanged(ChangeEvent e) {

	}
}
