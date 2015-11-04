package orderManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Insert {

	public Insert(){
		Scanner stdIn = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try{
			conn = ConnectDB.connectDatabase();
			stmt = conn.prepareStatement("");
			System.out.println("受注年を入力してください");
			//年の入力
			int year = stdIn.nextInt();
			System.out.println("受注月を入力してください");
			//月の入力
			int month = stdIn.nextInt();
			System.out.println("受注日を入力してください");
			//日の入力
			int day = stdIn.nextInt();
			int i = 1;


			System.out.println("顧客を選択してください");
			//顧客一覧表示
			stmt = conn.prepareStatement("SELECT custom.custom_c,custom.custom_nam FROM custom");
			rset = stmt.executeQuery();
			i = 1;
			while (rset.next()) {
				System.out.print(i+" ");
				System.out.print(rset.getString("custom.custom_nam"));
				System.out.println("("+rset.getInt("custom.custom_c")+")");
				i++;
			}
			int customnum = stdIn.nextInt();

			System.out.println("担当者を選択してください");
			//担当者一覧表示
			stmt = conn.prepareStatement("SELECT sales.sales_c,sales.sales_nam FROM sales");
			rset = stmt.executeQuery();
			i = 1;
			while (rset.next()){
				System.out.print(i);
				System.out.print(rset.getString("sales.sales_nam"));
				System.out.println("("+rset.getInt("sales.sales_c")+")");
				i++;
			}
			int salesnum = stdIn.nextInt();

			System.out.println("商品を選択してください");
			//商品一覧表示]
			stmt = conn.prepareStatement("SELECT item.item_c,item.item_nam FROM item ORDER BY item_nam");
			rset = stmt.executeQuery();
			i = 1;
			while (rset.next()){
				System.out.printf("%3d ", i);
				System.out.printf("%-14.14S", rset.getString("item.item_nam"));
				System.out.printf("(%3d)", rset.getInt("item.item_c"));
				if (i%2==0) System.out.println();
				else System.out.print("\t");
				i++;
			}
			ArrayList<Integer> itemnum = new ArrayList<Integer>();
			ArrayList<Integer> quantity = new ArrayList<Integer>();
			boolean flag = true;
			int num;
			
			while(flag){
				System.out.print("商品の一連番号（0の入力で選択終了):");
				num = stdIn.nextInt();
				if(num == 0){
					break;
				}
				itemnum.add(num);
				System.out.print("数量:");
				num = stdIn.nextInt();
				quantity.add(num);
			}

			stmt = conn.prepareStatement("INSERT INTO order_title (order_date,custom_c,sales_c) values(?,?,?);");
			stmt.setString(1, year+"-"+month+"-"+day);
			stmt.setInt(2, customnum);
			stmt.setInt(3, salesnum);

			stmt.executeUpdate();

			stmt = conn.prepareStatement("SELECT MAX(order_no) FROM order_title;");
			ResultSet orderno =stmt.executeQuery();	//最新のオーダーナンバーの値

			stmt = conn.prepareStatement("INSERT INTO order_detail (order_no,item_c,quantity) values(?,?,?);");

			for(int j=0;j<itemnum.size();j++){
				stmt.setInt(1,orderno.getInt("order_no") );
				stmt.setInt(2, itemnum.get(j));
				stmt.setInt(3, quantity.get(j));

				stmt.executeUpdate();

			}
			System.out.println("受注を登録しました");

		}
		catch(SQLException ex){
			System.out.println("エラーコード：" + ex.getErrorCode());
			System.out.println("SQL状態：" + ex.getSQLState());
			ex.printStackTrace();
		}
		finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
