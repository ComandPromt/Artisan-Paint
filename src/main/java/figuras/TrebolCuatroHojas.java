
package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import dibujante.MarcoDeFigura;
import util.Figura;

public class TrebolCuatroHojas extends Figura {

	

	public TrebolCuatroHojas(Point ubicacion, int anchura, int altura, Color color) {

		

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

		Shape Trebol = crearFiguraDeTrebol(x, y, anchura, altura);

		if (dibujarRellena()) {

			g2.setColor(getColorSecundario());

			g2.fill(Trebol);

		}

		g2.setColor(getColor());

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.draw(Trebol);

	}

	private Shape crearFiguraDeTrebol(double x, double y, double anchura, double altura) {

		Ellipse2D hojaArriba = new Ellipse2D.Double(x + anchura / 4, y, anchura / 2, altura / 2);

		Ellipse2D hojaIzquierda = new Ellipse2D.Double(x + anchura - anchura / 2, y + altura / 4, anchura / 2,
				altura / 2);

		Ellipse2D hojaDerecha = new Ellipse2D.Double(x, y + altura / 4, anchura / 2, altura / 2);

		Ellipse2D hojaAbajo = new Ellipse2D.Double(x + anchura / 4, y + altura / 2, anchura / 2, altura / 2);

		Area area = new Area(hojaArriba);

		area.add(new Area(hojaAbajo));

		area.add(new Area(hojaDerecha));

		area.add(new Area(hojaIzquierda));

		return area;

	}



}
