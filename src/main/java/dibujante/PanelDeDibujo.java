package dibujante;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JPanel;

import util.Figura;

public class PanelDeDibujo extends JPanel {

	private static final long serialVersionUID = 1L;

	private ArrayList<Figura> figuras;

	private Stack<Figura> figurasDeshechas;

	private Figura figuraActual;

	private Color colorActual;

	private Color colorSecundarioActual;

	private int grosor;

	private VentanaPrincipal ventanaPrincipal;

	private int figuraSeleccionada;

	public void setFiguraSeleccionada(int figuraSeleccionada) {

		this.figuraSeleccionada = figuraSeleccionada;

	}

	public PanelDeDibujo() {

		figuras = new ArrayList<>();

		grosor = 1;

		figurasDeshechas = new Stack<>();

		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

		addMouseListener(new MouseAdapter() {

			@Override

			public void mousePressed(MouseEvent evento) {

				try {

					colorActual = VentanaPrincipal.color1.getColor();

					colorSecundarioActual = VentanaPrincipal.color2.getColor();

					grosor = ventanaPrincipal.getGrosorSeleccionado();

					if (figuraActual != null && figuraActual.contiene(evento.getPoint())) {

						figuraActual.setEstadoArrastrando();

						figuraActual.setPuntosDentroDeLaFigura(evento.getPoint());

						return;

					}

					if (figuraSeleccionada >= 0 && VentanaPrincipal.subTipoFigura.getItemCount() > 0
							&& VentanaPrincipal.subTipoFigura.getSelectedIndex() > 0) {

						try {

							figuraSeleccionada = VentanaPrincipal.subTipoFigura.getSelectedIndex();

						}

						catch (Exception e) {

						}

					}

					figuraActual = ventanaPrincipal.figuraADibujarse(figuraSeleccionada, evento.getPoint(), 0, 0,
							colorActual, colorSecundarioActual);

					if (figuraActual != null) {

						figuraActual.setGrosor(grosor);

						figuras.add(figuraActual);

					}

				}

				catch (Exception e) {
					e.printStackTrace();
				}

			}

			@Override
			public void mouseReleased(MouseEvent e) {

				try {

					if (getFiguraActual() != null) {

						Graphics g = PanelDeDibujo.this.getGraphics();

						g.setColor(new Color(0, 120, 215));

						getFiguraActual().dibujarMarcoDeSeleccion(g);

						g.setColor(colorActual);

					}

				}

				catch (Exception e1) {

				}

			}

		});

		addMouseMotionListener(new MouseAdapter() {

			int i = 0;

			@Override
			public void mouseDragged(MouseEvent evento) {

				if (figuraActual != null) {

					if (figuraActual.estaArrastrando()) {

						figuraActual.desplazarFigura(evento.getPoint());

					}

					else {

						figuraActual.actualizar(evento.getPoint());

					}

					repaint();

				}

			}

			@Override

			public void mouseMoved(MouseEvent e) {
				try {
					if (figuraActual != null) {

						setCursor(figuraActual.getCursor(e.getPoint()));

					}

				}

				catch (Exception e1) {

				}

			}

		});

	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		super.paintComponent(g2);

		this.setBackground(Color.WHITE);

		figuras.forEach(figura -> {

			figura.dibujar(g2);

			// figura.pintarRegla(g2);

		});

	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal2) {

		this.ventanaPrincipal = ventanaPrincipal2;

	}

	public void setColorActual(Color colorActual) {

		this.colorActual = colorActual;

	}

	public void setColorSecundarioActual(Color colorSecundarioActual) {

		this.colorSecundarioActual = colorSecundarioActual;

	}

	public void setFiguraActual(Figura figuraActual) {

		this.figuraActual = figuraActual;

	}

	public Figura getFiguraActual() {

		return figuraActual;

	}

	public ArrayList<Figura> getFiguras() {

		return figuras;

	}

	public Stack<Figura> getFigurasDeshechas() {

		return figurasDeshechas;

	}

}