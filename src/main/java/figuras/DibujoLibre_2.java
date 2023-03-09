
package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;
import util.Figura;

public class DibujoLibre_2 extends Figura {

	private boolean malla;

	public DibujoLibre_2(Point ubicacion, int anchura, int altura, Color color, Color backgroundColor,
			boolean figuraRellena) {
		this.malla = figuraRellena;
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

		altura /= 2;

		altura -= 25;

		Point punto1 = new Point(x + anchura / 2, y + altura);

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		anchura /= 2;

		for (int i = 0; i < VentanaPrincipal.saberVueltas(); i++) {

			g2.rotate(VentanaPrincipal.saberAngulo(), 200, 200);

			g.drawArc(punto1.x - anchura, punto1.y - altura, 80, 100, -50, 100);

			g.drawArc(punto1.x - anchura, punto1.y - altura, 80, 100, 130, 100);

			if (malla) {
				g2.drawOval(x, y, anchura, altura);
			}

		}

	}

}
