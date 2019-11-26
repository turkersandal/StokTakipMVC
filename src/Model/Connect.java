package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Connect {
	PreparedStatement ps=null;
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	
	public Connection getConnection() {
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/guru_staj?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	
	public void send(String query) {
		try {
			getConnection();
			ps=con.prepareStatement(query);
			ps.execute();
			con.close();
		} catch (SQLException e) {
			
			if(e.getErrorCode() == 1062)
				JOptionPane.showMessageDialog(null, "Bu Stok Kodunda Ürün Bulunmaktadýr!!!");
		}	
	}
	
	public ResultSet result(String query) {
		try {
			getConnection();
			stmt=getConnection().createStatement();  
			rs=stmt.executeQuery(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
}