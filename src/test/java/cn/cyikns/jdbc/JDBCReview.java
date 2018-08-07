package cn.cyikns.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 回顾JDBC连接数据库
 *
 * @author cyikns
 * @create 2018-08-07 16:07
 */
public class JDBCReview {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;


        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

            //通过驱动管理类获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://115.159.73.93:3306/mybatis?characterEncoding=utf-8", "test", "Cyikns@1234");
            //SQL语句
            String str = "select * from tb_user where id = ?";
            //预编译
            statement = conn.prepareStatement(str);
            statement.setInt(1, 3);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                System.out.println(resultSet.getString("username"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (conn != null) conn.close();
        }

    }
}
