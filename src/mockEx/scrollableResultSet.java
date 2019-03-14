package mockEx;

import java.sql.*;

class ScrollableTest {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@John-pc:1521:xe", "system", "system");
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("select * from student");

		// reading from button to top
		rs.afterLast();
		while (rs.previous()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  "
					+ rs.getInt(3));
		}

		// move the cursor to 3rd record
		rs.absolute(3);
		System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  "
				+ rs.getInt(3));

		// move the cursor to 2nd record using relative()
		rs.relative(-1);
		System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  "
				+ rs.getInt(3));
		int i = rs.getRow(); // get cursor position
		System.out.println("cursor position=" + i);

		// cleanup
		rs.close();
		stmt.close();
		con.close();
	}
}