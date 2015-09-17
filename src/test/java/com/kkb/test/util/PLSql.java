package com.kkb.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kkb.test.steps.BaseStep;

/**
 * Created by ws.wang on 15-1-28.
 */
public class PLSql {
    private static String driver = "org.postgresql.Driver";
    private static String url = BaseStep.p.getProperty("jdbc.url");//"jdbc:postgresql://192.168.30.56:5432/cms_production"
    private static String username = BaseStep.p.getProperty("jdbc.username");;
    private static String password = BaseStep.p.getProperty("jdbc.password");;

    private final static Logger logger = LoggerFactory
			.getLogger(PLSql.class);
    
    public static synchronized  Connection getCon(String driver, String url, String username, String password) {
        if (driver == null || driver.isEmpty()) {
            return null;
        } else if (url == null || url.isEmpty() || url.equalsIgnoreCase("")) {
            return null;
        } else if (username == null || username.equalsIgnoreCase("") || username.isEmpty()) {
            return null;
        } else if (password == null || password.equalsIgnoreCase("") || password.isEmpty()) {
            return null;
        }

        try {
            Class.forName(driver).newInstance();
            Connection con = DriverManager.getConnection(url, username, password);
            logger.info("获取数据库连接");
            return con;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    //查询结果
    public static ResultSet select(String sql )
    {
        Connection connection;
        try {
            //connection = plsql.getCon("org.postgresql.Driver", "jdbc:postgresql://192.168.30.46:5432/"+dbName, "postgres", "123456");
            connection = getCon(driver, url, username, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            st.close();
            connection.close();
            return rs;
        } catch (Exception e) {
        	logger.error("查询异常！");
            e.printStackTrace();
        }
        return null;
    }
    //执行sql语句
    public static synchronized int execSql(String sql) {
        try {
           // Connection connection = plsql.getCon("org.postgresql.Driver", "jdbc:postgresql://192.168.30.46:5432/"+dbName, "postgres", "123456");
            Connection connection = getCon(driver, url, username, password);
            logger.info("执行sql:[{}]",sql);
            Statement st = connection.createStatement();
            int num = st.executeUpdate(sql);
            st.close();
            connection.close();
            return num;
        } catch (SQLException e) {
            logger.error("执行异常，检查sql");
            e.printStackTrace();
        } 
        return 0;
    }

    

    /*public static void test() throws SQLException {
        int addNum=add("insert into sale_students(school_id,sale_name,no) values (7,'swang','123456')","cms_production");
        System.out.println();

        ResultSet rs=select("select * from sale_students where sale_name='swang' and no='123456'");
        List list=new ArrayList();
        while (rs.next())
        {
            System.out.print(rs.getInt(1));
            list.add(rs.getInt( 1 ));
        }
        System.out.println();
    }*/

}
