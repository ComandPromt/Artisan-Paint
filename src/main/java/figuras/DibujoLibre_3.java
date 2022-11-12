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
import dibujante.VentanaPrincipal;
import util.Figura;

public class DibujoLibre_3 extends Figura {

	public boolean fancircle;

	public DibujoLibre_3(Point ubicacion, int anchura, int altura, Color color, boolean fanCircle) {

		super(color);

		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura));

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

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());
		int x = getMarcoDeFigura().getX();

		int y = getMarcoDeFigura().getY();

		for (int i = 0; i < VentanaPrincipal.saberVueltas(); i++) {

			g2.rotate(VentanaPrincipal.saberAngulo(), 200, 200);

			g.drawArc(x, y, 80, 100, -50, 100);

			g.drawArc(x, y, 80, 100, 130, 100);

		}

	}

	public void rotar(int grados) {

	}

}
