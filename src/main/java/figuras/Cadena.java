
package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;
import util.Figura;

public class Cadena extends Figura {

	private int figura;

	public Cadena(int figura, Point ubicacion, int anchura, int altura, Color color, Color backgroundColor,
			boolean figuraRellena) {

		this.figura = figura;

		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura, true));

	}

	@Override

	public void actualizar(Point puntoActual) {

		getMarcoDeFigura().actualizarDimensiones(puntoActual);

	}

	@Override

	public void dibujar(Graphics g) {

		System.out.println("Figura: " + figura);

		if (VentanaPrincipal.verRegla.isSelected()) {

			pintarRegla(g);

		}

		getMarcoDeFigura().calcularDimensiones();

		Graphics2D g2 = (Graphics2D) g;

		int x = getMarcoDeFigura().getX();

		int y = getMarcoDeFigura().getY();

		int anchura = getMarcoDeFigura().getAnchura();

		int altura = getMarcoDeFigura().getAltura();

		if (VentanaPrincipal.enCirculo.isSelected() && !dibujarRellena()) {

			g2.drawOval(x, y, anchura, altura);

		}

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		int vueltas = getVueltas();

		if (vueltas % 2 == 0) {

			altura /= (getVueltas() / 2) + 0.5;

		}

		else {

			altura /= (getVueltas() / 2) + 1;

		}

		int mitad = altura / 2;

		System.out.println(vueltas);

		for (int i = 0; i < vueltas; i++) {

			switch (figura) {

			case 0:

				if (dibujarRellena()) {

					if (i % 2 != 0) {

						g2.setColor(getColorSecundario());

						g2.fillOval(x, y, anchura, altura);

					}

					else {

						g2.setColor(Color.WHITE);

						g2.fillOval(x, y, anchura, altura);

						g2.setColor(getColor());

						g2.drawOval(x, y, anchura, altura);

					}

				}

				else {

					g2.drawOval(x, y, anchura, altura);

				}

				y -= getMoverArriba();

				y += getMoverAbajo();

				break;

			case 1:

				if (dibujarRellena()) {

					if (i % 2 != 0) {

						g2.setColor(getColorSecundario());

						g2.fillOval(x, y, anchura, altura);

					}

					else {

						// g2.setColor(Color.WHITE);

						g2.fillOval(x, y, anchura, altura);

						g2.setColor(getColor());

						g2.drawOval(x, y, anchura, altura);
					}

				}

				else {

					g2.drawOval(x, y, anchura, altura);

				}

				y -= getMoverArriba();

				y += getMoverAbajo();

				break;

			}

			y += mitad;

		}

	}

}
