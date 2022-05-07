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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;

import javax.swing.JComboBox;
import java.awt.ScrollPane;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JDayChooser;

public class SellProducts extends JFrame {

	private JPanel contentPane;
	private JTextField txtProName;
	private JTextField txtProQuantity;
	private JButton btnSell;
	private JLabel title;
	Database db = new Database();
	private JTextField txtDetails;
	private JLabel lblType;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellProducts frame = new SellProducts();
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
	public SellProducts() {
		setTitle("Sell Products");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel proName = new JLabel("Product Name");
		proName.setBounds(17, 63, 89, 14);
		contentPane.add(proName);

		txtProName = new JTextField();
		txtProName.setBounds(146, 60, 206, 20);
		contentPane.add(txtProName);
		txtProName.setColumns(10);

		JLabel proQuantity = new JLabel("Product Quantity");
		proQuantity.setBounds(17, 105, 106, 14);
		contentPane.add(proQuantity);

		txtProQuantity = new JTextField();
		txtProQuantity.setBounds(146, 102, 206, 20);
		contentPane.add(txtProQuantity);
		txtProQuantity.setColumns(10);
		
		
		comboBox = new JComboBox<String>();
		comboBox.addItem("vegetable");
		comboBox.addItem("fruit");
		comboBox.addItem("meat");
		comboBox.addItem("bakery");
		comboBox.addItem("pet");
		comboBox.addItem("baby");
		comboBox.addItem("beauty");
		comboBox.setBounds(146, 145, 206, 27);
		contentPane.add(comboBox);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(156, 179, 47, 26);
		contentPane.add(yearChooser);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(215, 179, 137, 26);
		contentPane.add(monthChooser);
		
		btnSell = new JButton("Sell");

		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String proName = txtProName.getText();
				int proQuantity = Integer.parseInt(txtProQuantity.getText());
				String proType = comboBox.getSelectedItem().toString();
				
			    String date = Integer.toString(yearChooser.getYear()) + Integer.toString(monthChooser.getMonth()+1);

			    db.makeConnection();

				String x = db.sell(proName, proType, proQuantity, date);
			
				txtDetails.setText(x);
				
				db.disConnection();
			}
		});
		
		btnSell.setBounds(233, 256, 119, 23);
		contentPane.add(btnSell);

		title = new JLabel("Sell Products");
		title.setBounds(233, 6, 119, 32);
		contentPane.add(title);
		
		txtDetails = new JTextField();
		txtDetails.setBounds(392, 90, 130, 115);
		contentPane.add(txtDetails);
		txtDetails.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(413, 62, 61, 16);
		contentPane.add(lblStatus);
		
		JLabel sellDate = new JLabel("Selling Date");
		sellDate.setBounds(17, 179, 106, 26);
		contentPane.add(sellDate);
		
		lblType = new JLabel("Product Type");
		lblType.setBounds(17, 149, 89, 16);
		contentPane.add(lblType);
		
	}
}
