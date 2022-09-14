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

public class Feria_1 extends Figura {
private Graphics2D g2;
private int grados=0;
	public Feria_1(Point ubicacion, int anchura, int altura, Color color) {

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
		
                int x = getMarcoDeFigura().getX();

		int y = getMarcoDeFigura().getY();
		int anchura = getMarcoDeFigura().getAnchura();

		int altura = getMarcoDeFigura().getAltura();
      
		g2 = (Graphics2D) g;
            System.out.println("X: "+x+" - "+y+" anchura: "+anchura+" - "+altura);
                if(this.grados>0){

                   
           
                  g2.rotate(-190,x+ anchura / 2,y+altura);
                          		getMarcoDeFigura().calcularDimensiones();
		
                 x = getMarcoDeFigura().getX();

		 y = getMarcoDeFigura().getY();
                }
                



		altura /= 2;

		altura -= 25;

		Point punto1 = new Point(x + anchura / 2, y + altura);

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		anchura /= 2;

		g2.drawOval(punto1.x - anchura, punto1.y - altura, anchura * 2, (altura * 2) + 50);

		g2.drawOval((punto1.x - anchura) + (anchura / 2), (punto1.y - altura), anchura, altura + 50);
                
	}
        
  public void rotar(int grados)
    {
        this.grados=grados;
        
    }


}
