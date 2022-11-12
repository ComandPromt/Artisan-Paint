/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;

import dibujante.MarcoDeFigura;
import util.Figura;

public class Mandala_3 extends Figura {

	public boolean fancircle;

	public Mandala_3(Point ubicacion, int anchura, int altura, Color color, boolean fanCircle) {

		super(color);

		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura, false));

		this.fancircle = fanCircle;

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

		g2.translate(anchura / 2, altura / 2);

		int x1 = 56;

		int y1 = 0;

		int[] xPoints = { x1, x1 + 12, x1 + 54, x1 + 18, x1 + 28, x1, x1 - 28, x1 - 18, x1 - 54, x1 - 12 };

		int[] yPoints = { y1, y1 + 36, y1 + 36, y1 + 54, y1 + 96, y1 + 72, y1 + 96, y1 + 54, y1 + 36, y1 + 36 };

		GeneralPath star = new GeneralPath();

		star.moveTo(xPoints[0], yPoints[0]);

		for (int count = 1; count < xPoints.length; count++) {

			star.lineTo(xPoints[count], yPoints[count]);

		}

		star.closePath();

		for (int count = 1; count <= 20; count++) {

			g2.rotate(Math.PI / 10.0);

			g2.draw(star);

		}

		g2.translate(0, 0);

	}

	@Override
	public void rotar(int grados) {

	}

}
