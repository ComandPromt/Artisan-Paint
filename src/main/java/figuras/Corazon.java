package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import util.Figura;

public class Corazon extends Figura {

	private int grados = 0;

	public Corazon(Point ubicacion, int anchura, int altura, Color color, Color backgroundColor,
			boolean figuraRellena) {

		super(color, backgroundColor, figuraRellena);

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

		int width = getMarcoDeFigura().getAnchura();

		int height = getMarcoDeFigura().getAltura();

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		g.drawLine(x + (width / 30), (int) (y + height / 2.7), x + width / 2, y + height);

		g.drawLine((x + width) - (width / 28), (int) (y + height / 2.7), x + width / 2, y + height);

		g.drawArc(x, y, width / 2, height / 2, -355, 225);

		g.drawArc((x + width) - (width / 2), y, width / 2, height / 2, 175, -220);

	}

	@Override

	public void rotar(int grados) {
		this.grados = grados;
	}

}
