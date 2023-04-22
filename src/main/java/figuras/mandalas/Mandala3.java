/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras.mandalas;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;
import util.Figura;

public class Mandala3 extends Figura {

	public Mandala3(Point ubicacion, int anchura, int altura) {

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

		g2.translate(anchura / 2, altura / 2);

		int x1 = 56;

		int y1 = 0;

		int[] xPoints = { x1, x1 + 12, x1 + 54, x1 + 18, x1 + 28, x1, x1 - 28, x1 - 18, x1 - 54, x1 - 12 };

		int[] yPoints = { y1, y1 + 36, y1 + 36, y1 + 54, y1 + 96, y1 + 72, y1 + 96, y1 + 54, y1 + 36, y1 + 36 };

		GeneralPath star = new GeneralPath();

		g2.setStroke(new BasicStroke(VentanaPrincipal.grosor.getValor()));

		star.moveTo(xPoints[0], yPoints[0]);

		for (int count = 1; count < xPoints.length; count++) {

			star.lineTo(xPoints[count], yPoints[count]);

		}

		star.closePath();

		g2.translate(x + anchura / 2, y + altura / 2);

		for (int count = 1; count <= VentanaPrincipal.saberVueltas(); count++) {

			g2.rotate(Math.PI / VentanaPrincipal.anguloGiro.getValor());

			g2.draw(star);

		}

		g2.translate(x + anchura / 2, y + altura / 2);

	}

}
