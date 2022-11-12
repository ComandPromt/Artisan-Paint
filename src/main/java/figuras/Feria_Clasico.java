
package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import util.Figura;

public class Feria_Clasico extends Figura {

	private Graphics2D g2;

	private int grados = 0;

	public Feria_Clasico(Point ubicacion, int anchura, int altura, Color color, Color backgroundColor,
			boolean figuraRellena) {

		super(color, backgroundColor, figuraRellena);

		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura));

	}

	@Override

	public void actualizar(Point puntoActual) {

		getMarcoDeFigura().actualizarDimensiones(puntoActual);

	}

	@Override

	public void dibujar(Graphics g) {

		getMarcoDeFigura().calcularDimensiones();

		int x = getMarcoDeFigura().getX();

		int y = getMarcoDeFigura().getY();

		int anchura = getMarcoDeFigura().getAnchura();

		int altura = getMarcoDeFigura().getAltura();

		int moverY;

		g2 = (Graphics2D) g;

		if (this.grados > 0) {

			g2.rotate(-190, x + anchura / 2, y + altura);

			getMarcoDeFigura().calcularDimensiones();

			x = getMarcoDeFigura().getX();

			y = getMarcoDeFigura().getY();

		}

		altura /= 2;

		altura -= 25;

		Point punto1 = new Point(x + anchura / 2, y + altura);

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		anchura /= 2;

		moverY = (punto1.y - altura);

		moverY += getMoverAbajo();

		moverY -= getMoverArriba();

		g2.drawOval(punto1.x - anchura, punto1.y - altura, anchura * 2, (altura * 2) + 50);

		g2.drawOval((punto1.x - anchura) + (anchura / 2), moverY, anchura, altura + 50);

	}

	@Override
	public void rotar(int grados) {

		this.grados = grados;

	}

}
