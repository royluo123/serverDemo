package com.example.demo.base;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
    static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名studb
    static final String DB_URL = "jdbc:mysql://localhost:3306/studb";
    //MySQL配置时的用户名
    static final String DB_USER = "luoxinwu";
    //MySQL配置时的密码
    static final String DB_PSWD = "royluo123";

    public ResultSet excuteSQL(String sql) {
        //声明Connection对象
        Connection con;
        //驱动程序名
        ResultSet rs = null;

        //遍历查询结果集
        try {

            //加载驱动程序
            Class.forName(DB_DRIVER);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(DB_URL,DB_USER,DB_PSWD);

            if(!con.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
            }

            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句


            //3.ResultSet类，用来存放获取的结果集！！
            rs = statement.executeQuery(sql);

            con.close();

        }catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();

        }finally{
            System.out.println("数据库数据成功获取！！");

        }

        return rs;
    }

}
