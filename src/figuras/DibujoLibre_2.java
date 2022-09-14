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

import dibujante.VentanaPrincipal;

public class DibujoLibre_2 extends Figura {

	public boolean fancircle;

	public DibujoLibre_2(Point ubicacion, int anchura, int altura, Color color, boolean fanCircle) {

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

		int x = 50;

		if (fancircle) {

			x = 100;

		}

//		for (int i = 0; i < VentanaPrincipal.saberVueltas(); i++) {
//
//			g2.rotate(VentanaPrincipal.saberAngulo(), 100, 100);
//
//			g.drawArc(x, 29, 80, 100, 45, 180);
//
//		}

	}

    @Override
    public void rotar(Graphics g, int grados) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
