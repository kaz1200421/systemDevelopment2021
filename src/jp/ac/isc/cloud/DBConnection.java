package jp.ac.isc.cloud;
import java.sql.*;

public final class DBConnection {
	private DBConnection () {}
	public static Connection openConnection() {
		String connectString = System.getenv("MYSQLCONNSTR_localdb");
		 String database = "localdb"; //データベース名を保管する変数
		 String port = "127.0.0.1:52770"; //データベースの場所を保管する変数
		 String username = "azure"; //ユーザ名を保管する変数
		 String password = "6#vWHD_$"; //パスワードを保管する変数
		 String[] strArray = connectString.split(";");
		 //各変数にそれぞれの値をセットする
		for (int i = 0; i < strArray.length; i++) {
		 String[] paramArray = strArray[i].split("=");
		 switch (i) {
		 case 0: database = paramArray[1];
		 continue;
		 case 1: port = paramArray[1];
		 continue;
		 case 2: username = paramArray[1];
		 continue;
		 case 3: password = paramArray[1];
		 continue;
		 }
		 }
		Connection users = null;
	 try {
	 Class.forName("com.mysql.jdbc.Driver");
	 users = DriverManager.getConnection("jdbc:mysql://" + port + "/" + database +
			 "?useUnicode=true&characterEncoding=utf8",username,password);
	 }catch(SQLException e) {
	 e.printStackTrace();
	 }catch(ClassNotFoundException e) {
	 e.printStackTrace();
	 }
	 return users;
	 }
	public static void closeConnection(Connection users,Statement state) {
	 try {
	 state.close();
	 users.close();
	 }catch(SQLException e) {
	 e.printStackTrace();
	 }
	 }
}
