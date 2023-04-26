
package figuras.mandalas;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.Figura;

public class MandalaCirculo extends Figura {

	public MandalaCirculo(Point ubicacion, int anchura, int altura) {

		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura, false));

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

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		g2.drawOval(x, y, anchura, altura);

		int angulo = getAngulo();

		int radio = anchura / 2;

		for (int i = 0; i < getVueltas(); i++) {

			if (angulo != 0) {

				g2.drawLine(x + radio, y + radio, (x + radio + (int) (Math.sin(angulo) * (radio))),
						(y + radio - (int) (Math.cos(angulo) * (radio))));

				g2.drawLine(x + radio, y + radio, (x + radio - (int) (Math.sin(angulo) * (radio))),
						(y + radio - (int) (Math.cos(angulo) * (radio))));

				angulo += angulo;

			}

			else {

				i = getVueltas();
			}

		}

	}

}
