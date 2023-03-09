package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;
import util.Figura;

public class Rectangulo extends Figura {

	public Rectangulo(Point ubicacion, int anchura, int altura, Color color) {

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

		if (dibujarRellena()) {

			g2.setColor(getColorSecundario());

			g2.fillRect(x, y, anchura, altura);

		}

		g2.setColor(getColor());

		g2.setStroke(new BasicStroke(getGrosor()));

		if (VentanaPrincipal.redondear.isSelected()) {

			g2.drawRoundRect(x, y, anchura, altura, anchura / 2, altura / 2);

		}

		else {

			g2.drawRect(x, y, anchura, altura);

		}

	}

	/*
	 * g.drawArc(x, y, anchuraAbsoluta, alturaAbsoluta, 0, 287); g.drawArc(x, y +
	 * alturaAbsoluta, anchuraAbsoluta, alturaAbsoluta, 75, 287); g.drawArc(x +
	 * anchuraAbsoluta, y + alturaAbsoluta, anchuraAbsoluta, alturaAbsoluta, 175,
	 * 287); g.drawArc(x + anchuraAbsoluta, y, anchuraAbsoluta, alturaAbsoluta, 250,
	 * 287);
	 */
	// Trebol
	/*
	 * g.drawArc(x, y,Math.abs(anchura), Math.abs(altura),0,287); g.drawArc(x,
	 * y+altura,Math.abs(anchura), Math.abs(altura),75,287); g.drawArc(x+anchura,
	 * y+altura,Math.abs(anchura), Math.abs(altura),175,287); g.drawArc(x+anchura,
	 * y, anchura,altura,250,287);
	 * 
	 */

}
