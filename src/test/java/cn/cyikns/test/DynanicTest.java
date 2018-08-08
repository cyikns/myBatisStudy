package cn.cyikns.test;

import cn.cyikns.mapper.OrderMapper;
import cn.cyikns.mapper.UserMapper;
import cn.cyikns.pojo.Order;
import cn.cyikns.pojo.QueryVo;
import cn.cyikns.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用Mapper动态开发
 *
 * @author cyikns
 * @create 2018-08-08 10:32
 */
public class DynanicTest {

    @Test
    public void testQueryUserById() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectUserById(10);

            System.out.println(user);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testInsertUser() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sessionFactory.openSession();

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User user = new User();
            user.setUsername("岳不群");
            user.setPassword("辟邪剑法");
            user.setAddress("天狗县辟邪镇");

            mapper.addUser(user);

            System.out.println(user);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //测试输入对象是QueryVo
    @Test
    public void testQueryUserByQueryVo() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            QueryVo vo = new QueryVo();

            User user1 = new User();
            user1.setUsername("张");

            vo.setUser(user1);

            List<User> users = mapper.queryUserByQueryVo(vo);

            for (User user : users) {

                System.out.println(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //测试输入对象是QueryVo
    @Test
    public void testQueryUserByUser() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);


            User user2 = new User();
            user2.setUsername("张");

            user2.setPassword("1234");

            List<User> users = mapper.queryUserList(user2);

            for (User user : users) {

                System.out.println(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //测试查询order所有信息
    @Test
    public void testQueryOrderAll() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

            List<Order> orders = mapper.queryOrderAll();

            for (Order order : orders) {
                System.out.println(order);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testQueryUserMore() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            List<Integer> a = new ArrayList<>();
            a.add(1);
            a.add(13);
            a.add(26);


            List<User> users = mapper.queryUserForeach(a);
            for (User user : users) {
                System.out.println(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
