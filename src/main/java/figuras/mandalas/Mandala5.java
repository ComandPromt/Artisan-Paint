
package figuras.mandalas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;
import util.Figura;

public class Mandala5 extends Figura {

	public Mandala5(Point ubicacion, int anchura, int altura) {
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

		for (int i = 0; i < VentanaPrincipal.saberVueltas(); i++) {

			g2.rotate(90, 200, 200);

			g.drawArc(100, 100, 80, 100, 0, -180);

			g.drawArc(83, 85, 100, 200, 20, 50);

			g.drawArc(100, 90, 100, 80, 90, 135);

		}

	}

}
