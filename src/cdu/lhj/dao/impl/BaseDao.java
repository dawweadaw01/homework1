package cdu.lhj.dao.impl;

import java.sql.*;

public class BaseDao {



    String driver="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/mydb?user=root&password=123456";
    String jdbcUser="root";
    String jbcPwd="179220";
    protected Connection conn=null;
    protected Statement stmt=null;
    protected PreparedStatement pstmt=null;
    protected ResultSet rs=null;
    public  BaseDao(){
        connect();}
    public void connect(){
        try {
            Class.forName(driver).newInstance();
            conn= DriverManager.getConnection(url);
        }catch (Exception e){
            e.printStackTrace();
        }
    };
    void close(){
        try {
            if(rs!=null&&!rs.isClosed()){
                rs.close();
            }
            if(conn!=null&&!conn.isClosed()){
                conn.close();
            }
            if(pstmt!=null&&!pstmt.isClosed()){
                pstmt.close();
            }
            if(stmt!=null&&!stmt.isClosed()){
                stmt.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
