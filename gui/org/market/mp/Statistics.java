package org.market.mp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.market.mp.Database;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
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
import javax.swing.JScrollBar;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;

public class Statistics extends JFrame {

	private JPanel contentPane;
	Database db = new Database();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistics frame = new Statistics();
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
	public Statistics() {
		setTitle("Selling Statistics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblScore = new JLabel("Selling Statistics");
		lblScore.setBounds(172, 21, 107, 16);
		contentPane.add(lblScore);
		
		JLabel lblSubject = new JLabel("Type");
		lblSubject.setBounds(60, 73, 61, 16);
		contentPane.add(lblSubject);
		
		JLabel lblOption = new JLabel("Option");
		lblOption.setBounds(60, 163, 61, 16);
		contentPane.add(lblOption);
		
		JList list = new JList();
		list.setBounds(198, 129, 1, 1);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(210, 142, 1, 1);
		contentPane.add(list_1);
		
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(172, 69, 124, 27);
		comboBox_3.addItem("vegetable");
		comboBox_3.addItem("fruit");
		comboBox_3.addItem("meat");
		comboBox_3.addItem("bakery");
		comboBox_3.addItem("pet");
		comboBox_3.addItem("baby");
		comboBox_3.addItem("beauty");
		contentPane.add(comboBox_3);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(179, 161, 155, 23);
		comboBox.addItem("Max_Gross");
		comboBox.addItem("Min_Gross");
		comboBox.addItem("Max_NO_TXN");
		comboBox.addItem("Min_NO_TXN");
		contentPane.add(comboBox);
		
		JLabel lblMonth = new JLabel("month");
		lblMonth.setBounds(60, 135, 61, 16);
		contentPane.add(lblMonth);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(60, 101, 61, 16);
		contentPane.add(lblYear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 197, 377, 115);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(182, 101, 47, 26);
		contentPane.add(yearChooser);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(179, 129, 137, 26);
		contentPane.add(monthChooser);
		
		JButton btnNewButton = new JButton("Show");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					String type = (String) comboBox_3.getSelectedItem();
					String year = Integer.toString(yearChooser.getYear());
					String month = Integer.toString(monthChooser.getMonth()+1);
					String option = comboBox.getSelectedItem().toString();
					
					db.makeConnection();
						
					String result = "";
					ResultSet res;
					switch(option) {
					case "Max_Gross":
						res = db.get_max_gross(year,month,type);
						result = db.show_result(res,1);
						break;
					case "Min_Gross":
						break;
					case "Max_NO_TXN":
						break;
					case "Min_NO_TXN":
						break;
					default:
						// result = "???"; Redundant
					}
					textArea.setText(result);
			}
		});
		btnNewButton.setBounds(210, 324, 117, 29);
		contentPane.add(btnNewButton);

	}
}
