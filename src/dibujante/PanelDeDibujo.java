/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dibujante;

import figuras.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author josearielpereyra
 */
public class PanelDeDibujo extends JPanel {

    private ArrayList<Figura> figuras;
    private Stack<Figura> figurasDeshechas;
    private Figura figuraActual;
    private Color colorActual;
    private Color colorSecundarioActual;
    private int grosor;
    private boolean dibujarRellena;
    private VentanaPrincipal ventanaPrincipal;

    public PanelDeDibujo() {
        figuras = new ArrayList<>();
        colorActual = Color.BLACK;
        colorSecundarioActual = Color.WHITE;
        grosor = 1;
        dibujarRellena = false;
        figurasDeshechas = new Stack<>();
        setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evento) {

                dibujarRellena = ventanaPrincipal.getSiseDibujaraRellena();
                grosor = ventanaPrincipal.getGrosorSeleccionado();
                
                if (figuraActual != null && figuraActual.contiene(evento.getPoint())) {
                    figuraActual.setEstadoArrastrando();
                    figuraActual.setPuntosDentroDeLaFigura(evento.getPoint());
                    return;
                }

                String figuraSeleccionada = ventanaPrincipal.getFiguraSeleccionada();

                //Si nuestro figura seleccionada es gotero retornamos
                if (figuraSeleccionada.equals("Gotero")) {
                    colorActual = ventanaPrincipal.obtenerColorEn(evento.getPoint());
                    return;
                }

                figuraActual = ventanaPrincipal.figuraADibujarse(
                        figuraSeleccionada,
                        evento.getPoint(),
                        0, 0, colorActual, false
                );

                //Anadimos estos atributos a nuestra figura
                figuraActual.setDibujarRellena(dibujarRellena);
                figuraActual.setGrosor(grosor);
                figuraActual.setColorSecundario(colorSecundarioActual);

                //Si es un clic derecho intercambiamos colores
                if (SwingUtilities.isRightMouseButton(evento)) {
                    figuraActual.setColor(colorSecundarioActual);
                    figuraActual.setColorSecundario(colorActual);
                }

                figuras.add(figuraActual);
                repaint();

            }

            ;
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println(ventanaPrincipal.getFiguraSeleccionada());
                if (getFiguraActual() != null) {
                    Graphics g = PanelDeDibujo.this.getGraphics();
                    g.setColor(new Color(0, 120, 215));
                    getFiguraActual().dibujarMarcoDeSeleccion(g);
                    g.setColor(colorActual);
                    //Creo que aqui tendre un bug;
                    /*
                    
                    05/01/2021 - No descomentar estas lineas.
                    Dara error con las figuras que no son bidimensionales.
                    Esto es solo un Log nada especial.
                    
                    System.out.println("");
                    System.out.println("Anchura = " + figuraActual.getMarcoDeFigura().getAnchura());
                    System.out.println("Altura = " + figuraActual.getMarcoDeFigura().getAltura());
                    System.out.println("Donde Esta X = " + figuraActual.getMarcoDeFigura().getX());
                    System.out.println("Donde Esta Y = " + figuraActual.getMarcoDeFigura().getY());
                    System.out.println("Anchura sin valor absoluto = " + figuraActual.getMarcoDeFigura().anchura);
                    System.out.println("Altura sin valor absoluto = " + figuraActual.getMarcoDeFigura().altura);
                     */
                }

            }

        });

        addMouseMotionListener(new MouseAdapter() {
            int i = 0;

            @Override
            public void mouseDragged(MouseEvent evento) {
                if (figuraActual != null) {
                    if (figuraActual.estaArrastrando()) {
                        figuraActual.desplazarFigura(evento.getPoint());
                    } else {
                        figuraActual.actualizar(evento.getPoint());
                    }
                    repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (figuraActual != null) {
                    setCursor(figuraActual.getCursor(e.getPoint()));
                }
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Me gusto el estilo "HD" que da la linea de arriba.

        super.paintComponent(g2);
        this.setBackground(Color.WHITE);

        figuras.forEach(figura -> {
            //System.out.print("Figuras[" + contador++ + "] ->");
            figura.dibujar(g2);
        });
    }

    //Getters Y Setters
    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public void setColorActual(Color colorActual) {
        this.colorActual = colorActual;
    }

    public void setColorSecundarioActual(Color colorSecundarioActual) {
        this.colorSecundarioActual = colorSecundarioActual;
    }

    public void setFiguraActual(Figura figuraActual) {
        this.figuraActual = figuraActual;
    }

    public Figura getFiguraActual() {
        return figuraActual;
    }

    public ArrayList<Figura> getFiguras() {
        return figuras;
    }

    public Stack<Figura> getFigurasDeshechas() {
        return figurasDeshechas;
    }

};
