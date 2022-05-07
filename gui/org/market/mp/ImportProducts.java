package org.market.mp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.market.mp.Database;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Date;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.ScrollPane;

public class ImportProducts extends JFrame {

	private JPanel contentPane;
	private JTextField txtProName;
	private JTextField txtProQuantity;
	private JTextField txtImpStatus;
	Database db = new Database();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportProducts frame = new ImportProducts();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public ImportProducts(){
		setTitle("Import Products");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel proName = new JLabel("Product Name");
		proName.setBounds(27, 44, 106, 14);
		contentPane.add(proName);

		JLabel proType = new JLabel("Product Type");
		proType.setBounds(27, 83, 106, 14);
		contentPane.add(proType);

		JLabel proQuantity = new JLabel("Product Quantity");
		proQuantity.setBounds(27, 124, 106, 14);
		contentPane.add(proQuantity);

		txtProName = new JTextField();
		txtProName.setBounds(145, 41, 79, 20);
		contentPane.add(txtProName);
		txtProName.setColumns(10);

		txtProQuantity = new JTextField();
		txtProQuantity.setBounds(145, 121, 79, 20);
		contentPane.add(txtProQuantity);
		txtProQuantity.setColumns(10);

		JLabel impStatus = new JLabel("Import Status");
		impStatus.setBounds(307, 101, 95, 27);
		contentPane.add(impStatus);

		txtImpStatus = new JTextField();
		txtImpStatus.setEditable(false);
		txtImpStatus.setBounds(289, 142, 139, 68);
		contentPane.add(txtImpStatus);
		txtImpStatus.setColumns(10);
		
		JComboBox<String> combType = new JComboBox<String>();
		combType.addItem("vegetable");
		combType.addItem("fruit");
		combType.addItem("meat");
		combType.addItem("bakery");
		combType.addItem("pet");
		combType.addItem("baby");
		combType.addItem("beauty");
		combType.setBounds(145, 78, 125, 27);
		contentPane.add(combType);
		
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String proName = txtProName.getText();
				String proType = combType.getSelectedItem().toString();
				int proQuantity = Integer.parseInt(txtProQuantity.getText());
				
				db.makeConnection();
				
				int rel = -1;
				rel = db.importProducts(proName, proType, proQuantity);
				if(rel==1) {
					txtImpStatus.setText("success");
				}else {
					txtImpStatus.setText("failure");
				}
				
				System.out.println("Insertion finished");
				db.disConnection();
			}
		});
		
		btnImport.setBounds(81, 200, 89, 23);
		contentPane.add(btnImport);

		JLabel lblNewLabel = new JLabel("Import Products");
		lblNewLabel.setBounds(148, 13, 158, 16);
		contentPane.add(lblNewLabel);
		
		
	}
}