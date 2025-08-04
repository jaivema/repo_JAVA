package formulario;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Formulario extends JFrame implements ActionListener{
//interfaz

	public Formulario() {						//constructor
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
		menu = new JMenu("Menu");
		
		rojo = new JMenuItem("Fondo rojo");
		verde = new JMenuItem("Fondo verde");
		azul = new JMenuItem("Fondo azul");
        salir= new JMenuItem("Salir");
        rojo.addActionListener(this);
        verde.addActionListener(this);
        azul.addActionListener(this);
        salir.addActionListener(this);
        
        menuBar.add(menu);
        menu.add(rojo);
        menu.add(verde);
        menu.add(azul);
        menu.add(salir);
        
        label1=new JLabel("Etiqueta1");
        label1.setBounds(10, 10, 75, 20);
        label1.setBackground(Color.pink);
        
        label2=new JLabel("Etiqueta2");
        label2.setBounds(95, 10, 75, 20);
        label2.setBackground(Color.pink);
        
        boton1 = new JButton("Cerrar");
		boton1.setBounds(10, 40, 75, 20);
		boton1.addActionListener(this);
		
		add(label1);
		add(label2);
		add(boton1);
	}
	
	public static void main(String[] args) {	//main
		// TODO Auto-generated method stub
		Formulario form1 =new Formulario();
		form1.setSize(500, 800);
		form1.setVisible(true);
		form1.setLocationRelativeTo(null);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 fondo = this.getContentPane();
		if (e.getSource() == boton1) {
			System.exit(0);
		}
		if (e.getSource()==rojo) {
			fondo.setBackground(new Color(255,0,0,180)); 
		}
		if (e.getSource()==verde) {
			fondo.setBackground(new Color(0,255,0,180)); 
		}
		if (e.getSource()==azul) {
			fondo.setBackground(new Color(0,0,255,180)); 
		}
	}
	
	JLabel label1; 
	JLabel label2;
	JButton boton1;	
	JButton boton2;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem salir, rojo, verde, azul;
	Container fondo;
}
