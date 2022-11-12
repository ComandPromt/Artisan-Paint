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

import dibujante.MarcoDeFigura;
import util.Figura;

/**
 *
 * @author Berlis
 */
public class FlechaDerecha extends Figura {

	public FlechaDerecha(Point ubicacion, int anchura, int altura, Color color) {
		super(color);
		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura));
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

		int separacion = (int) (altura / (4));

		Point punto1 = new Point(x + anchura / 2, y);
		Point punto2 = new Point(x + anchura, y + altura / 2);
		Point punto3 = new Point(x + anchura / 2, y + altura);
		Point punto4 = new Point(x + anchura / 2, y + altura - separacion);
		Point punto5 = new Point(x, y + altura - separacion);
		Point punto6 = new Point(x, y + separacion);
		Point punto7 = new Point(x + anchura / 2, y + separacion);

		int[] puntosX = new int[] { punto1.x, punto2.x, punto3.x, punto4.x, punto5.x, punto6.x, punto7.x };
		int[] puntosY = new int[] { punto1.y, punto2.y, punto3.y, punto4.y, punto5.y, punto6.y, punto7.y };

		if (dibujarRellena()) {
			g2.setColor(getColorSecundario());
			g2.fillPolygon(puntosX, puntosY, 7);
		}

		g2.setStroke(new BasicStroke(getGrosor()));
		g2.setColor(getColor());
		g2.drawPolygon(puntosX, puntosY, 7);

	}

	@Override
	public void rotar(int grados) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
