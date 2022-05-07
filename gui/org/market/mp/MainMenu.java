package org.market.mp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainMenu extends JFrame {

	
private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 266, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnImport = new JButton("Import Products");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImportProducts insertFrame = new ImportProducts();
				insertFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				insertFrame.setVisible(true);
			}
		});
		btnImport.setBounds(69, 89, 123, 49);
		contentPane.add(btnImport);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(69, 168, 117, 29);
		contentPane.add(btnNewButton);
		
		
	}
}
