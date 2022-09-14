/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author Berlis
 */
public class Imagen extends Figura{
    
    private BufferedImage bimg;
        
    public Imagen(Point ubicacion, int anchura, int altura, Color color,BufferedImage bimg){
        super(color);
        this.bimg  = bimg;
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
       
       //g2.drawImage(bimg, x, y, null);
       g2.drawImage(bimg, x, y, anchura, altura, null);
          
    }

    @Override
    public void rotar(Graphics g, int grados) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
