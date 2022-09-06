package Enfrentamientos;
import java.awt.Dimension;
import javax.swing.*;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Pantalla extends JFrame implements ActionListener {
    public JLabel  titulo, ronda, p1, p2, p3, salud_p1, salud_p2, salud_p3, sactual_p1, sactual_p2, sactual_p3, poder, poder_ronda, atacante, atacado, versus;

    public ImageIcon atacante_actual, atacado_actual, korbi_img, megan_img, dittu_img;

    

    public Pantalla(){
        setLayout(null);
        setTitle("De la Rosa");
        //getContentPane().setBackground(new Color(0,0,0));
        bienvenida();
        ronda();
        datos_personajes();
        

        atacante_actual = new ImageIcon("imagenes/korbi.png");
        atacado_actual = new ImageIcon("imagenes/megan.png");
        korbi_img = new ImageIcon("imagenes/korbi.png");
        megan_img = new ImageIcon("imagenes/megan.png");
        dittu_img = new ImageIcon("imagenes/dittu.png");


        atacante = new JLabel(korbi_img);
        atacado = new JLabel(megan_img);
        versus = new JLabel("VS");
        atacante.setBounds(0,0, 400, 700);
        atacado.setBounds(400,0, 400, 700);
        versus.setBounds(390,0, 400, 700);
        add(atacante);
        add(atacado);
        add(versus);
    }

    public void bienvenida(){
      titulo = new JLabel("Bienvenido a las super Batallas");
      titulo.setBounds(300, 0, 300, 15);
      add(titulo);
    }

    public void ronda(){
        ronda = new JLabel("Ronda numero: ");
        ronda.setBounds(300, 0, 400, 50);
        add(ronda);
    }

    public void datos_personajes(){
        p1 = new JLabel("Korbi");
        p2 = new JLabel("Meganman");
        p3 = new JLabel("Dittu");

        p1.setBounds(100, 0, 400, 150);
        p2.setBounds(350, 0, 400, 150);
        p3.setBounds(600, 0, 400, 150);

        add(p1);
        add(p2);
        add(p3);

        salud_p1 = new JLabel("Salud: ");
        salud_p2 = new JLabel("Salud: ");
        salud_p3 = new JLabel("Salud: ");

        salud_p1.setBounds(50, 0, 400, 200);
        salud_p2.setBounds(300, 0, 400, 200);
        salud_p3.setBounds(550, 0, 400, 200);

        add(salud_p1);
        add(salud_p2);
        add(salud_p3);

        sactual_p1 = new JLabel("1000");
        sactual_p2 = new JLabel("1000");
        sactual_p3 = new JLabel("1000");

        sactual_p1.setBounds(100, 0, 400, 200);
        sactual_p2.setBounds(350, 0, 400, 200);
        sactual_p3.setBounds(600, 0, 400, 200);

        add(sactual_p1);
        add(sactual_p2);
        add(sactual_p3);


        poder = new JLabel("El poder de esta ronda es: ");
        poder_ronda = new JLabel("Este");

        poder.setBounds(220, 0, 400, 350);
        poder_ronda.setBounds(430, 0, 400, 350);

        add(poder);
        add(poder_ronda);


     
    }


    public void batalla_korbi_megan(){      

       
    }

    


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
  

}