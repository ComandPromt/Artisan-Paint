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

public class Flor extends Figura {

	public Flor(Point ubicacion, int anchura, int altura, Color color) {

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

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

//		for (int i = 0; i < VentanaPrincipal.saberVueltas(); i++) {
//
//			g2.rotate(90, 200, 200);
//
//			g.drawArc(100, 100, 80, 100, 0, -180);
//
//			g.drawArc(83, 85, 100, 200, 20, 50);
//
//			g.drawArc(100, 90, 100, 80, 90, 135);
//
//		}

	}

    @Override
    public void rotar(Graphics g, int grados) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
