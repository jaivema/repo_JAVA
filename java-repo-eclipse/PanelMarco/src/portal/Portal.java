package portal;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

@SuppressWarnings("serial")
public class Portal extends JFrame {

	public Portal(String titulo) {
		setTitle(titulo);
		
		setUndecorated(true);
	    getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
	    setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(800,300);
		setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.white);
		
		foto=new JLabel(new ImageIcon("images.jpg"));
		foto.setBounds(10, 7, 250, 250);
		
		bienvenido=new JLabel("Bienvenido");
		bienvenido.setBounds(280, 80, 180, 25);
		bienvenido.setFont(new Font("arial",Font.BOLD,25));
		
		texto=new JLabel("Programa creado por Jaime Verdejo Martí");
		texto.setBounds(280, 130, 400, 25);
		texto.setFont(new Font("arial",Font.BOLD,20));
		
		add(foto);
		add(bienvenido);
		add(texto);	
		
	}
	
	public static void main(String []args) {
		Portal portal1 = new Portal("Mi Portal");
		portal1.setVisible(true);
	}
	
	private JLabel foto,bienvenido,texto;
	
}
