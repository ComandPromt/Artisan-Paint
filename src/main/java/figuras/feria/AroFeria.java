package figuras.feria;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import util.Figura;

public class AroFeria extends Figura {

	public AroFeria(Point ubicacion, int anchura, int altura) {

		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura, false));

	}

	@Override

	public void actualizar(Point puntoActual) {

		getMarcoDeFigura().actualizarDimensiones(puntoActual);

	}

	@Override

	public void dibujar(Graphics g) {

		setDefaultMoverAbajo();

		getMarcoDeFigura().calcularDimensiones();

		Graphics2D g2 = (Graphics2D) g;

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		int x = getMarcoDeFigura().getX();

		int y = getMarcoDeFigura().getY();

		int anchura = getMarcoDeFigura().getAnchura();

		int moverY;

		int altura = getMarcoDeFigura().getAltura();

		altura /= 2;

		altura -= 25;

		Point punto1 = new Point(x + anchura / 2, y + altura);

		anchura /= 2;

		moverY = ((punto1.y - altura) + getMoverAbajo()) - 10;

		if (!dibujarRellena()) {

			g2.drawOval(punto1.x - anchura, punto1.y - altura, anchura * 2, (altura * 2) + 50);

			g2.drawOval((punto1.x - anchura) + (anchura / 2), moverY, anchura,
					((altura + (altura / 2)) - getMoverArriba()) + getRadio());

		}

		else {

			g2.setColor(getColorSecundario());

			g2.fillOval(punto1.x - anchura, punto1.y - altura, anchura * 2, (altura * 2) + 50);

			g2.setColor(Color.WHITE);

			g2.fillOval((punto1.x - anchura) + (anchura / 2), moverY, anchura,
					(altura + (altura / 2)) - getMoverArriba() + getRadio());

		}

	}

}