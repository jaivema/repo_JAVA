package ventana;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class ventana extends JFrame implements ActionListener {
	
	public ventana(String title) {
		setTitle(title);
		
		this.setUndecorated(true);
	    this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 	//cuando cierra la ventana, el programa finaliza
		
		//setLocation(500,300);						//señala donde abre la ventana
		//setSize(1000, 500); 						//agregamos tamaño a la ventana
		setBounds(500, 300, 500, 800);				//Size y Location juntos
		setLocationRelativeTo(null);				//posicion relativa

		//this.getContentPane().setBackground(Color.BLUE);		//color establecido
		//Color colorRosa=new Color(255, 175, 175, 180);			//color por RGB y alfa
		//this.getContentPane().setBackground(colorRosa);		
		
		//Image icon = new ImageIcon(getClass().getResource("images.jpg")).getImage();
		//setIconImage(icon);
		setIconImage(new ImageIcon("images.jpg").getImage());	//cambia el icono de la ventana
		
		setResizable(false);	//bloquea el marco
		
		JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        
		salir = new JMenuItem("Salir");
        salir.addActionListener(this);
        
        menuBar.add(menu);
        menu.add(salir);
        
        this.setJMenuBar(menuBar);
        
        iniciarpanel();
	}
	
	private void iniciarpanel() {
		JPanel panel1 = new JPanel(); //creacion de un panel
		panel1.setBackground(Color.red);
		this.getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JLabel foto=new JLabel(new ImageIcon("images.jpg"));
		foto.setBounds(200, 250, 250, 250);
		panel1.add(foto);
		
		JLabel etiqueta1 =new JLabel("Etiqueta 1");
		etiqueta1.setBounds(200, 150, 150, 20);
		etiqueta1.setOpaque(true);          
		etiqueta1.setBackground(Color.yellow);
		etiqueta1.setHorizontalAlignment(SwingConstants.LEFT);
		panel1.add(etiqueta1);
		
		JLabel etiqueta2 =new JLabel("Etiqueta 2");
		etiqueta2.setBounds(200, 175, 150, 20);
		etiqueta2.setOpaque(true);          
		etiqueta2.setBackground(Color.yellow);
		etiqueta2.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta2.setFont(new Font("arial",Font.BOLD,30));
		panel1.add(etiqueta2);
		
		JLabel etiqueta3 =new JLabel("Etiqueta 3");
		etiqueta3.setBounds(200, 200, 150, 20);
		etiqueta3.setOpaque(true);          
		etiqueta3.setBackground(Color.yellow);
		etiqueta3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1.add(etiqueta3);
		
		Comp1 = new JButton("Cerrar");
		Comp1.setBounds(10, 10, 150, 20);
		Comp1.setBackground(Color.orange);
		panel1.add(Comp1);
		Comp1.addActionListener(this);
		
		Comp2 = new JToggleButton("Alternar boton2");
		Comp2.setBounds(10, 40, 150, 20);
		Comp2.setBackground(Color.pink);
		panel1.add(Comp2);
		
		JRadioButton Comp3=new JRadioButton("botonRadio");
		Comp3.setSelected(false);
		Comp3.setBounds(200, 10, 150, 20);
		panel1.add(Comp3);
		
		JCheckBox Comp4=new JCheckBox("Validar");
		Comp4.setBounds(200, 40, 150, 20);
		Comp4.setSelected(true);
		panel1.add(Comp4);
		
		Comp5=new JButton(encendido);
		Comp5.setBounds(10, 80, 150, 20);
		Comp5.setEnabled(true);
		Comp5.setBackground(Color.green);
		panel1.add(Comp5);
		Comp5.addActionListener(this);
		
		Comp6=new JButton(apagado);
		Comp6.setBounds(200, 80, 150, 20);
		Comp6.setEnabled(false);
		Comp6.setBackground(Color.black);
		panel1.add(Comp6);
		Comp6.addActionListener(this);
		
		JLabel LabelComboBox = new JLabel("Selecciona tu bebida");
		LabelComboBox.setBounds(10, 150, 150, 20);
		LabelComboBox.setForeground(Color.white);
		LabelComboBox.setOpaque(true);
		LabelComboBox.setBackground(Color.pink);
		LabelComboBox.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		panel1.add(LabelComboBox);
		String [] bebidas= {"Bebidas","agua","cola","batido","licor"};
		combo=new JComboBox(bebidas);
		combo.setBounds(10, 180, 110, 20);
		combo.setBackground(Color.pink);
		panel1.add(combo);
		
		JTable tabla=new JTable();
		panel1.add(tabla);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==Comp1||e.getSource()==salir) {
			System.exit(0);
		}
		if (e.getSource()==Comp5) {
			Comp5.setEnabled(false);
			Comp5.setText(apagado);
			Comp5.setBackground(Color.black);
			Comp6.setEnabled(true);
			Comp6.setText(encendido);
			Comp6.setBackground(Color.green);
		}
		
		if (e.getSource()==Comp6) {
			Comp5.setEnabled(true);
			Comp5.setText(encendido);
			Comp5.setBackground(Color.green);
			Comp6.setEnabled(false);
			Comp6.setText(apagado);
			Comp6.setBackground(Color.black);
		}
		
	}
	
	private String encendido="ON";
	private String apagado="OFF";
	private JToggleButton Comp2;
	private JButton Comp1, Comp5, Comp6;
	private JComboBox combo;
	private JMenuItem salir;
	
}