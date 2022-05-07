package org.market.mp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Database {
	Connection con;
	PreparedStatement stmt;
	ResultSet res;
	String result;

	void makeConnection() {
		try {
			Class.forName("org.sqlite.JDBC").newInstance();
			String url = "jdbc:sqlite:./superMarket.db";
			con = DriverManager.getConnection(url);
			System.out.println("sql connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void disConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int importProducts(String proName, String proType, int proQuantity) {
		// TODO Auto-generated method stub
		int rel = -1;
		try {
			stmt = con.prepareStatement("insert into products values(?,?,?)");
			_____;
			_____;
			_____;
			rel = stmt.executeUpdate();
		} catch (SQLException e1) {
			System.out.println("exsiting products, then update");
			int new_quantity = get_quantity(proName, proType) + proQuantity;
			try {
				stmt = con.prepareStatement("_____");
				stmt.setInt(1, _____);
				stmt.setString(_____, proName);
				stmt.setString(3, proType);
				rel = stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rel;
	}
	
	public int get_quantity(String proName, String type) {
		int rel=-1;
		try {
			??????;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return rel;
		
	}

	public String sell(String proName, String proType, int proQuantity, String date) {
		// TODO Auto-generated method stub
		
		try {
			if(get_quantity(proName, proType)==0) {
				return "No " + proName + "-" + proType + "\n in our store";
			}else if(get_quantity(proName, proType)<proQuantity) {
				return "No Enough products!\n Please select a smaller quantity";
			}else {
				int remain_quantity = get_quantity(proName, proType) - proQuantity;
				stmt = con.prepareStatement("update products set quantity=? where name=? and type=?");
				????????
				
				stmt = con.prepareStatement("insert into sell_history values(?,?,?,?)");
				???????
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}

		return "success";
	}

	public ResultSet get_max_gross(String year, String month, String type) {
		// TODO Auto-generated method stub
		try {
			??????
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}


	public String show_result(ResultSet re) {
		// TODO Auto-generated method stub
		try {
			while(re.next()) {
				result += re.getString(1) + " " + re.getString(2) + " " + re.getString(3) + " " + re.getString(5)
				+ " " + re.getInt(8) +"\n";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String show_result(ResultSet re, int index) {
		// TODO Auto-generated method stub
		try {
			result = re.getString(index);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
