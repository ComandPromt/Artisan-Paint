package figuras.geometria;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;
import dibujante.Figura;

public class Hexagono extends Figura {

	public Hexagono() {

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

		int anchura = getMarcoDeFigura().getAnchura();

		int altura = getMarcoDeFigura().getAltura();

		Point punto1 = new Point(x + anchura / 2, y);

		Point punto2 = new Point(x + anchura, y + (int) (altura / (6.0 / 1.5)));

		Point punto3 = new Point(x + anchura, y + altura - (int) (altura / (6.0 / 1.5)));

		Point punto4 = new Point(x + anchura / 2, y + altura);

		Point punto5 = new Point(x, y + altura - (int) (altura / (6.0 / 1.5)));

		Point punto6 = new Point(x, y + (int) (altura / (6.0 / 1.5)));

		int[] puntosX = { punto1.x, punto2.x, punto3.x, punto4.x, punto5.x, punto6.x };

		int[] puntosY = { punto1.y, punto2.y, punto3.y, punto4.y, punto5.y, punto6.y };

		if (dibujarRellena()) {

			g2.setColor(getColorSecundario());

			g2.fillPolygon(puntosX, puntosY, 6);

		}

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		g2.drawPolygon(puntosX, puntosY, 6);

	}

}
