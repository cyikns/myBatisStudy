package cn.cyikns.test;

import cn.cyikns.mapper.UserMapper;
import cn.cyikns.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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
}
