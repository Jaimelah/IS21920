package practica3;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Interfaz {

	private JFrame frame;
	private JTextField numberTF;
	private JTextField stateTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 268, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JButton button1 = new JButton("1");
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button1, numberTF);
			}
		});
		button1.setBounds(47, 94, 41, 41);
		frame.getContentPane().add(button1);
		
		
		final JButton button4 = new JButton("4");
		button4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button1, numberTF);
			}
		});
		button4.setBounds(47, 145, 41, 41);
		frame.getContentPane().add(button4);
		
		final JButton button7 = new JButton("7");
		button7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button7, numberTF);
			}
		});
		button7.setBounds(47, 196, 41, 41);
		frame.getContentPane().add(button7);
		
		final JButton button2 = new JButton("2");
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button2, numberTF);
			}
		});
		button2.setBounds(110, 94, 41, 41);
		frame.getContentPane().add(button2);
		
		final JButton button5 = new JButton("5");
		button5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button5, numberTF);
			}
		});
		button5.setBounds(110, 145, 41, 41);
		frame.getContentPane().add(button5);
		
		final JButton button8 = new JButton("8");
		button8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button8, numberTF);
			}
		});
		button8.setBounds(110, 196, 41, 41);
		frame.getContentPane().add(button8);
		
		final JButton button3 = new JButton("3");
		button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button3, numberTF);
			}
		});
		button3.setBounds(172, 94, 41, 41);
		frame.getContentPane().add(button3);
		
		final JButton button6 = new JButton("6");
		button6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button6, numberTF);
			}
		});
		button6.setBounds(172, 145, 41, 41);
		frame.getContentPane().add(button6);
		
		final JButton button9 = new JButton("9");
		button9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button9, numberTF);
			}
		});
		button9.setBounds(172, 196, 41, 41);
		frame.getContentPane().add(button9);
		
		final JButton button0 = new JButton("0");
		button0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button0, numberTF);
			}
		});
		button0.setBounds(110, 254, 41, 41);
		frame.getContentPane().add(button0);
		
		numberTF = new JTextField();
		numberTF.setEditable(false);
		numberTF.setBounds(47, 52, 166, 30);
		frame.getContentPane().add(numberTF);
		numberTF.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnAceptar.setBounds(45, 351, 85, 25);
		frame.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(130, 351, 85, 25);
		frame.getContentPane().add(btnCancelar);
		
		
		stateTF = new JTextField();
		stateTF.setEditable(false);
		stateTF.setColumns(10);
		stateTF.setBounds(47, 311, 166, 30);
		frame.getContentPane().add(stateTF);
		
		JLabel led= new JLabel("");
		led.setBounds(172, 247, 50, 50);
		frame.getContentPane().add(led);
		led.setOpaque(true);
		led.setBackground(Color.RED);
	}
	private void setNumber(JButton button, JTextField field) {
		String number=button.getText();
		String old=field.getText();
		number=old+number;
		field.setText(number);
		
	}
}

