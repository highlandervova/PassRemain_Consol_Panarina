package dao;

import bean.Record;

import java.sql.*;

public class RecordDao {

    private static final String DRIVER          ="org.postgresql.Driver";
    private static final String URL             = "jdbc:postgresql://localhost:5432/postgres";
    private static final String LOGIN           ="postgres";
    private static final String PASS            ="postgres";
    private static final String ADD             = "INSERT INTO record (id , address, login , pass ,data, comment ) VALUES( ( SELECT COALESCE(MAX(id)+1,1) from record ), ?,?,?,?,?)";
    private static final String SELECTALL       = "SELECT id , address , login , pass ,comment , data FROM RECORD";
    private static final String CREATE          = "CREATE TABLE IF NOT EXISTS record (id INT PRIMARY KEY, address VARCHAR(50), login VARCHAR(50), pass VARCHAR(50),comment VARCHAR(50),data VARCHAR(50))";
// comment
    static {
        try {
            Class.forName(DRIVER) ;
        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void add (Record r){
         try (Connection c=getConnection()){
       PreparedStatement ps=preparedStatement(c,ADD);
             ps.setString(1, r.getAddress());
             ps.setString(2, r.getLogin());
             ps.setString(3, r.getPass());
             ps.setString(4, r.getData());
             ps.setString(5, r.getComment());
             ps.executeUpdate();
             ps.close();

         }catch (Exception ex){
             ex.printStackTrace();
         }
    }


    public static void view (Record r){
        try (Connection c=getConnection()) {
            PreparedStatement ps=preparedStatement(c,SELECTALL);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                System.out.println("ID " + rs.getInt("id"));
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));

                        }
            ps.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }

    public static void createRecord (Record r){
        try (Connection c=getConnection()){
            PreparedStatement ps=preparedStatement(c,CREATE);
            ps.executeUpdate();
            ps.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    public static String viewS (Record r){
        try (Connection c=getConnection()) {
            PreparedStatement ps=preparedStatement(c,SELECTALL);
            ResultSet rs=ps.executeQuery();
            String s=null;
            while (rs.next()){
                System.out.println("ID " + rs.getInt("id"));
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
                s=s+" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6);
            }
            ps.close();
            return s;
        }catch (Exception ex){
            ex.printStackTrace();
        }


        return null;
    }



    private static Connection getConnection() throws SQLException  {
    return DriverManager.getConnection(URL, LOGIN, PASS);

    }

    private static PreparedStatement preparedStatement(Connection c, String  sql) throws SQLException {
        return c.prepareStatement(sql);

    }

}
