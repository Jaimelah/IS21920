package practica3;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Interfaz {

	private JFrame frame;
	public JTextField numberTF;
	public JTextField stateTF;
	public JButton alarmOn;
	public JButton AlarmOff;
	
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
		
		final AlarmaHogar alarm=new AlarmaHogar();
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
				setNumber(button4, numberTF);
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
		final JLabel led= new JLabel("");
		led.setBounds(172, 247, 50, 50);
		frame.getContentPane().add(led);
		led.setOpaque(true);
		led.setBackground(Color.RED);
		
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
		
		alarmOn = new JButton("Encender");
		alarmOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alarm.alarmaOn();
				
				
			}
		});
		alarmOn.setBounds(45, 351, 85, 25);
		frame.getContentPane().add(alarmOn);
		
		AlarmOff = new JButton("Apagar");
		AlarmOff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alarm.alarmaOff(numberTF.getText());
				
			}
		});
		AlarmOff.setBounds(130, 351, 85, 25);
		frame.getContentPane().add(AlarmOff);
		
		
		stateTF = new JTextField();
		stateTF.setEditable(false);
		stateTF.setColumns(10);
		stateTF.setBounds(47, 311, 166, 30);
		frame.getContentPane().add(stateTF);
		
		class ledTask extends TimerTask{

			public void run() {
				switch(alarm.getPiloto().getState()) {
				case 0://Apagado
					stateTF.setText("Estamos en el estado apagado");
					
					led.setBackground(Color.WHITE);
				break;
				case 1://Encendido
					stateTF.setText("Estamos en el estado encendido");
					led.setBackground(Color.RED);
				break;
				case 2://parpadeando
					stateTF.setText("Estamos en el estado parapdeando");
					if(led.getBackground().equals(Color.GREEN))
						led.setBackground(Color.YELLOW);
					else
						led.setBackground(Color.GREEN);
				break;
				default:
					System.out.println("Alarma rota");
				break;
				
				}
				System.out.println(alarm.getPiloto().getState());
				System.out.println(alarm.getState());
				
			}
			
		}
		
		Timer timer=new Timer();
		timer.schedule(new ledTask(),0, 500);
		
		
	}
	private void setNumber(JButton button, JTextField field) {
		String number=button.getText();
		String old=field.getText();
		number=old+number;
		field.setText(number);
		
	}
}

