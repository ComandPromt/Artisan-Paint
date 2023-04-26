
package figuras.dibujos;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;
import dibujante.Figura;

public class DibujoLibre1 extends Figura {

	public DibujoLibre1(Point ubicacion, int anchura, int altura) {

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

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		g2.translate(x + anchura / 2, y + altura / 2);

		for (int i = 0; i < VentanaPrincipal.saberVueltas(); i++) {

			g2.rotate(VentanaPrincipal.saberAngulo(), 200, 200);

			g.drawArc(x, y, 80, 100, 0, -180);

			g.drawArc(x, y, 110, 130, -20, 90);

			g.drawArc(x, y, 110, 130, 100, 100);

			if (dibujarRellena()) {

				g2.drawOval(x + anchura / 2, y + altura / 2, anchura, altura);

			}

		}

	}

}
