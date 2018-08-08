package cn.cyikns.test;

import cn.cyikns.mapper.OrderMapper;
import cn.cyikns.mapper.UserMapper;
import cn.cyikns.pojo.Order;
import cn.cyikns.pojo.OrderUser;
import cn.cyikns.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author cyikns
 * @create 2018-08-08 17:15
 */
public class Single2MoreTest {

    @Test
    public void testQueryAllOrders() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

            List<OrderUser> orders = mapper.queryAllOrders();

            for (OrderUser order : orders) {
                System.out.println(order);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryOrderUseResultMap() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

            List<Order> orders = mapper.queryOrderUseResultMap1();
            for (Order order : orders) {
                System.out.println(order);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testQueryUserAndOrders() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            List<User> users = mapper.queryUserAndOrders();

            for (User user : users) {
                System.out.println(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
