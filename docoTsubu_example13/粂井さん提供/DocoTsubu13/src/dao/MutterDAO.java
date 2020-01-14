package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {
    // データベース接続に使用する情報
    private final String DRIVER_NAME = "org.h2.Driver";
  //"jdbc:h2:file:C:/Users/81901/Documents/data/example";
    private final String JDBC_URL ="jdbc:h2:file:~/Documents/data/example";//成功例②embadedモードきちんとタクスバーにH2Databaseがない状態にする。
//成功例①Serverモード    		"jdbc:h2:tcp://localhost/~/Documents/data/example";//H2Databaseを起動しないといけない。

    private final String DB_USER = "sa";
    private final String DB_PASS = "";

    public List<Mutter> findAll() {
        Connection conn = null;
        List<Mutter> mutterList = new ArrayList<>();
        // データベース接続
        try{
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

            // SELECT文の準備
            String sql =
                    "SELECT ID,NAME,TEXT FROM MUTTER ORDER BY ID ASC";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            // SELECTを実行
            ResultSet rs = pStmt.executeQuery();

            // SELECT文の結果をArrayListに格納
            while(rs.next()) {
                int id = rs.getInt("ID");
                String userName = rs.getString("NAME");
                String text = rs.getString("TEXT");
                Mutter mutter = new Mutter(id,userName,text);
                mutterList.add(mutter);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }finally{
            // データベース切断
            if(conn != null) {
                try{
                    conn.close();
                }catch(SQLException e) {
                    e.printStackTrace();
                    return null;
                }

            }
        }
        return mutterList;
    }

    public boolean create(Mutter mutter) {
        Connection conn = null;
        // データベース接続
        try{
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            // INSERT文の準備(idは自動連番なので指定しなくてよい)
            String sql = "INSERT INTO MUTTER(NAME,TEXT) VALUES(?,?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            // INSERT文中に「?」に使用する値を設定しSQLを完成
            pStmt.setString(1, mutter.getUserName());
            pStmt.setString(2, mutter.getText());


            // INSERT文を実行(resultには追加された行数が代入される)
            int result = pStmt.executeUpdate();
            if(result != 1) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            // データベース切断
            if(conn != null) {
                try {
                    conn.close();

                }catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
