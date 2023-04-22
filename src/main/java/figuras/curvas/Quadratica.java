package figuras.curvas;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Path2D;

import dibujante.MarcoDeFigura;
import util.Figura;

public class Quadratica extends Figura {

	public Quadratica(Point ubicacion, int anchura, int altura) {

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

		Path2D p = new Path2D.Double();
		g.drawLine(10, 100, 290, 100);
		g.drawLine(150, 10, 150, 190);

		p.moveTo(50, 150);

		p.quadTo(150, 0, 250, 100);

		g2.draw(p);

	}

}
