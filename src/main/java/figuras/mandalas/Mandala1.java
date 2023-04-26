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

import dibujante.MarcoDeFigura;
import dibujante.Figura;

public class Mandala1 extends Figura {

	public Mandala1(Point ubicacion, int anchura, int altura) {

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

		g2.setColor(getColor());

		int x = getMarcoDeFigura().getX();

		int y = getMarcoDeFigura().getY();

		int anchura = getMarcoDeFigura().getAnchura();

		int altura = getMarcoDeFigura().getAltura();

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		int angulo = 0;

		int equis = x + (anchura / 2);

		int ye = y + (altura / 2);

		int ancho = 80;

		int vueltas = getVueltas();

		if (getAngulo() == 90) {

			vueltas = 4;

		}

		int mitad = anchura / 2;

		int angulo2 = getAngulo2();

		int angulo3 = getAngulo3();

		int angulo4 = getAngulo4();

		int angulo5 = getAngulo5();

		for (int i = 0; i < vueltas; i++) {

			angulo += getAngulo();

			int posX = (int) Math.round(mitad * Math.cos(Math.toRadians(angulo)));

			int posY = (int) Math.round(mitad * Math.sin(Math.toRadians(angulo)));

			g.drawArc((equis + posX) - ancho, (ye - posY) - (ancho / 2), ancho, 100, angulo2, angulo3);

			g.drawArc((equis + posX) - (int) (ancho / 2.7), (ye - posY) - (ancho / 2), ancho, 100, angulo4, angulo5);

			angulo += getSumarAngulo();

			angulo2 += getSumarAngulo();

			angulo3 += getSumarAngulo();

			angulo4 += getSumarAngulo();

			angulo5 += getSumarAngulo();

		}

	}

}
