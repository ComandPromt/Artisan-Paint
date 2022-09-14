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

public class DibujoLibre_1 extends Figura {

	public DibujoLibre_1(Point ubicacion, int anchura, int altura, Color color) {

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

		altura /= 2;

		altura -= 25;

		Point punto1 = new Point(x + anchura / 2, y + altura);

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		anchura /= 2;

		for (int i = 0; i < 40; i++) {

			g2.rotate(90, 200, 200);

			g.drawArc(punto1.x - anchura, punto1.y - altura, 80, 100, -50, 100);

			g.drawArc(punto1.x - anchura, punto1.y - altura, 80, 100, 130, 100);
		}

	}

    @Override
    public void rotar(Graphics g, int grados) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
