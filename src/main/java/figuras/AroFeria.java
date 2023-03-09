package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;
import util.Figura;

public class AroFeria extends Figura {

	Point punto;

	public AroFeria(Point ubicacion, int anchura, int altura, Color color, Color backgroundColor,
			boolean figuraRellena) {

		punto = ubicacion;

		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura, true));

	}

	@Override

	public void actualizar(Point puntoActual) {

		getMarcoDeFigura().actualizarDimensiones(puntoActual);

	}

	@Override

	public void dibujar(Graphics g) {

		if (VentanaPrincipal.verRegla.isSelected()) {

			pintarRegla(g);

		}

		Graphics2D g2 = (Graphics2D) g;

		getMarcoDeFigura().calcularDimensiones();

		int x = getMarcoDeFigura().getX();

		int y = getMarcoDeFigura().getY();

		int anchura = getMarcoDeFigura().getAnchura();

		int moverY;

		int altura = getMarcoDeFigura().getAltura();

		g2 = (Graphics2D) g;

		altura /= 2;

		altura -= 25;

		Point punto1 = new Point(x + anchura / 2, y + altura);

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		anchura /= 2;

		moverY = (punto1.y - altura);

		moverY += VentanaPrincipal.getIncrementoAbajo();

		moverY -= VentanaPrincipal.getIncrementoArriba();

		g2.drawOval(punto1.x - anchura, punto1.y - altura, anchura * 2, (altura * 2) + 50);

		g2.drawOval((punto1.x - anchura) + (anchura / 2), moverY, anchura, altura + (altura / 2));

	}

}