package orderManagement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class InsertProcess {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rslt;

	public InsertProcess(){
		init();
		conn = ConnectDB.connectDatabase();
	}

	//初期化
	public void init(){
		conn = null;
		stmt = null;
		rslt = null;
	}

	public void close(){
		try{
			if(rslt != null){
				rslt.close();
			}
		}catch(SQLException e){
			sqlError(e);
		}
		try {
			if(stmt != null){
				stmt.close();
			}
		}catch(SQLException e){
			sqlError(e);
		}
		try{
			if(conn != null){
				conn.close();
			}
		}catch(SQLException e){
			sqlError(e);
		}
	}

	public void sqlError(SQLException e){
		System.out.println("エラーコード:"+e.getErrorCode());
		System.out.println("SQL状態:"+e.getSQLState());
		e.printStackTrace();
		Alert.incorrectNumber();
	}

	public void insertOrder(Calendar cal,int customnum,int salesnum,ArrayList<Integer> itemnum,ArrayList<Integer> quantity, double totalamount, double salestax, double bill){
		String sql1,sql2;
		sql1 = "INSERT INTO order_title (order_no,order_date,custom_c,sales_c,total_amount,sales_tax,bill) values(?,?,?,?,?,?,?);";
		try{
			stmt = conn.prepareStatement(sql1);
			Date datecal = new java.sql.Date(cal.getTime().getTime());
			stmt.setInt(1,  0);
			stmt.setDate(2, datecal);
			stmt.setInt(3, customnum);
			stmt.setInt(4, salesnum);
			stmt.setDouble(5, totalamount);
			stmt.setDouble(6, salestax);
			stmt.setDouble(7, bill);
			stmt.executeUpdate();
			stmt = conn.prepareStatement("SELECT MAX(order_no) AS order_no FROM order_title;");
			ResultSet orderno =stmt.executeQuery();	//最新のオーダーナンバーの値

			stmt = conn.prepareStatement("INSERT INTO order_detail (order_no,item_c,quantity) values(?,?,?);");
			for(int i=0;i<itemnum.size();i++){
				stmt.setInt(1, orderno.getInt("order_no"));
				stmt.setInt(2, itemnum.get(i));
				stmt.setInt(3, quantity.get(i));
				stmt.executeUpdate();
			}
		}catch(SQLException e){
			sqlError(e);
		}finally{
			close();
		}
	}
}
