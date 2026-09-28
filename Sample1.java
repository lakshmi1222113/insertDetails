//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.*;
public class Sample1 {
   public static void main(String[] args) {
      String url="jdbc:mysql://localhost:3306/student";
      String user = "root";
      String password = "Max@1234";
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection(url, user, password);
         Statement st=con.createStatement();
         String query="insert into student(RollNo,Name,dept) values(?,?,?)";
         PreparedStatement ps=con.prepareStatement(query);
         ps.setInt(1,3);
         ps.setString(2,"maxi");
         ps.setString(3,"MECH");
         ps.executeUpdate();
         ResultSet rs=st.executeQuery("select * from student");
         while(rs.next())
         {
            System.out.println(rs.getInt("RollNo")+"|"+rs.getString("Name"));
         }
         con.close();
         st.close();
      } catch (Exception e) {
         e.printStackTrace();

      }
   }
}
