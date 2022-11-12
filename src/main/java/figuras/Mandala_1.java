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

public class Mandala_1 extends Figura {

	public boolean fancircle;

	public Mandala_1(Point ubicacion, int anchura, int altura, Color color, boolean fanCircle) {

		super(color);

		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura, true));

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

		for (int i = 0; i < VentanaPrincipal.saberVueltas(); i++) {

			g2.rotate(VentanaPrincipal.saberAngulo(), 200, 200);

			g.drawArc(50, 100, 80, 100, -50, 100);

			g.drawArc(102, 100, 80, 100, 130, 100);

		}

	}

	@Override
	public void rotar(int grados) {

	}

}
