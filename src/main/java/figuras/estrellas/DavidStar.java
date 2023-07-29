package figuras.estrellas;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;
import dibujante.Figura;

public class DavidStar extends Figura {

	Point p2;

	public DavidStar() {

		setMarcoDeFigura(new MarcoDeFigura(VentanaPrincipal.fake.getPosicion(), VentanaPrincipal.fake.getAncho(), VentanaPrincipal.fake.getAlto(), true));

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

		g.setColor(getColor());

		int centroY = height / 2;

		int centerY = centroY / 2;

		g.drawLine(x + width / 2, y, x, y + centroY + centerY);

		g.drawLine(x + width / 2, y, x + width, y + centroY + centerY);

		g.drawLine(x, y + centroY + centerY, x + width, y + centroY + centerY);

		g.drawLine(x + width / 2, y + height, x, y + centerY);

		g.drawLine(x + width / 2, y + height, x + width, y + centerY);

		g.drawLine(x, y + centerY, x + width, y + centerY);

	}

}
