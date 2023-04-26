package figuras.plantas;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.Figura;

public class Trebol extends Figura {

	public Trebol(Point ubicacion, int anchura, int altura) {

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

		g2.setStroke(new BasicStroke(getGrosor()));

		int x = getMarcoDeFigura().getX();

		int y = getMarcoDeFigura().getY();

		int anchura = getMarcoDeFigura().getAnchura();

		int altura = getMarcoDeFigura().getAltura();

		anchura /= 2;

		altura /= 2;

		g.setColor(getColor());

		g.drawArc(x, y, Math.abs(anchura), Math.abs(altura), 0, 270);

		g.drawArc(x, y + altura, Math.abs(anchura), Math.abs(altura), 90, 270);

		g.drawArc(x + anchura, y + altura, Math.abs(anchura), Math.abs(altura), 180, 270);

		g.drawArc(x + anchura, y, anchura, altura, 270, 270);

		if (dibujarRellena()) {

			g.setColor(getColorSecundario());

			g.fillRect(x + anchura / 2, y + altura / 2, anchura + 5, altura + 5);

			g.fillArc(x, y, Math.abs(anchura), Math.abs(altura), 0, 270);

			g.fillArc(x, y + altura, Math.abs(anchura), Math.abs(altura), 90, 270);

			g.fillArc(x + anchura, y + altura, Math.abs(anchura), Math.abs(altura), 180, 270);

			g.fillArc(x + anchura, y, anchura, altura, 270, 270);

		}

	}

}
