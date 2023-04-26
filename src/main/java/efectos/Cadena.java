
package efectos;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;

public class Cadena extends dibujante.Figura {

	private int figura;

	private int tipo;

	public void setTipo(int tipo) {

		this.tipo = tipo;

	}

	public Cadena(int figura, Point ubicacion, int anchura, int altura) {

		this.figura = figura;

		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura, true));

	}

	@Override

	public void actualizar(Point puntoActual) {

		getMarcoDeFigura().actualizarDimensiones(puntoActual);

	}

	@Override

	public void dibujar(Graphics g) {

		getMarcoDeFigura().calcularDimensiones();

		Graphics2D g2 = (Graphics2D) g;

		int x = getMarcoDeFigura().getX();

		int y = getMarcoDeFigura().getY();

		int anchura = getMarcoDeFigura().getAnchura();

		int altura = getMarcoDeFigura().getAltura();

		int vueltas = getVueltas();

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		if (figura == 3) {

			int anch = anchura;

			int alt = altura;

			int newX;

			int newWidth;

			int newHeight;

			if (vueltas <= 2) {

				vueltas = 2;

				newX = (x + anch / 2) - (((anch / 3) / 2));

				newWidth = (anch / 3);

				newHeight = (alt / 3);

				g2.drawOval(newX, y, newWidth, newHeight);

				y += alt / 3;

				g2.drawOval(x + ((anch * 20) / 120), y, newWidth * 2, newHeight * 2);

			}

			else {

				newX = (x + anch / 2) - (((anch / 5) / 2));

				newWidth = (anch / 5);

				newHeight = (alt / 5);

				if (newWidth > newHeight) {

					newHeight = newWidth;

				}

				else if (newHeight > newWidth) {

					newWidth = newHeight;

				}

				g2.drawOval(newX, y, newWidth, newHeight);

				y += newHeight;

				newWidth *= 2;

				newHeight *= 2;

				g2.drawOval((x + newWidth) - (newWidth / 4), y, newWidth, newHeight);

				newWidth *= 2;

				newHeight *= 2;

				y += newHeight / 2;

				g2.drawOval((x + newWidth) - (int) (newWidth / 1.15f), y, newWidth, newHeight);

			}

		}

		if (VentanaPrincipal.enCirculo.isSelected() && !dibujarRellena()) {

			g2.drawOval(x, y, anchura, altura);

		}

		switch (figura) {

		case 1:

			if (vueltas % 2 == 0) {

				altura /= (getVueltas() / 2) + 0.5;

			}

			else {

				altura /= (getVueltas() / 2) + 1;

			}

			break;

		default:
		case 2:

			altura /= getVueltas();

			break;

		}

		int mitad = altura / 2;

		if (vueltas == 1) {

			vueltas = 2;

		}

		for (int i = 0; i < vueltas; i++) {

			switch (figura) {

			case 1:

			default:

				if (dibujarRellena()) {

					if (i % 2 != 0) {

						g2.setColor(getColorSecundario());

					}

					else {

						g2.setColor(getColor());

					}

					g2.fillOval(x, y, anchura, altura);

				}

				else {

					g2.drawOval(x, y, anchura, altura);

				}

				y -= getMoverArriba();

				y += getMoverAbajo();

				y += mitad;

				break;

			case 2:

				if (dibujarRellena()) {

					if (i % 2 != 0) {

						g2.setColor(getColorSecundario());

						g2.fillOval(x, y, anchura, altura);

					}

					else {

						g2.setColor(getColor());

						g2.fillOval(x, y, anchura, altura);

					}

				}

				else {

					g2.drawOval(x, y, anchura, altura);

				}

				y -= getMoverArriba();

				y += getMoverAbajo();

				y += mitad * 2;

				break;

			case 3:

				break;

			}

		}

	}

}
