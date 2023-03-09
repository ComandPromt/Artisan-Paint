package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import util.Figura;

public class Cruz extends Figura {

	MarcoDeFigura marcoDeLaFigura;

	

	public Cruz(Point ubicacion, int anchura, int altura, Color color) {

		

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

		int separacionX = (int) (anchura / 3);

		int separacionY = (int) (altura / 3);

		Point punto1 = new Point(x + separacionX, y);

		Point punto2 = new Point(x + anchura - separacionX, y);

		Point punto3 = new Point(x + anchura - separacionX, y + separacionY);

		Point punto4 = new Point(x + anchura, y + separacionY);

		Point punto5 = new Point(x + anchura, y + altura - separacionY);

		Point punto6 = new Point(x + anchura - separacionX, y + altura - separacionY);

		Point punto7 = new Point(x + anchura - separacionX, y + altura);

		Point punto8 = new Point(x + separacionX, y + altura);

		Point punto9 = new Point(x + separacionX, y + altura - separacionY);

		Point punto10 = new Point(x, y + altura - separacionY);

		Point punto11 = new Point(x, y + separacionY);

		Point punto12 = new Point(x + separacionX, y + separacionY);

		int[] puntosX = { punto1.x, punto2.x, punto3.x, punto4.x, punto5.x, punto6.x, punto7.x, punto8.x, punto9.x,
				punto10.x, punto11.x, punto12.x };

		int[] puntosY = { punto1.y, punto2.y, punto3.y, punto4.y, punto5.y, punto6.y, punto7.y, punto8.y, punto9.y,
				punto10.y, punto11.y, punto12.y };

		if (dibujarRellena()) {

			g2.setColor(getColorSecundario());

			g2.fillPolygon(puntosX, puntosY, 12);

		}

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		g2.drawPolygon(puntosX, puntosY, 12);

	}



}
