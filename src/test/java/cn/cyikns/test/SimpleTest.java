package cn.cyikns.test;

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
 * 测试类
 *
 * @author cyikns
 * @create 2018-08-07 20:23
 */
public class SimpleTest {

    //根据用户id查询用户
    @Test
    public void queryUserById() {
        //获取资源文件
        String resource = "sqlMapConfig.xml";
        try {
            //获得输入流
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //获取sessionFactory
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //打开sqlSession
            SqlSession sqlSession = sessionFactory.openSession();
            //查询
            User user = sqlSession.selectOne("queryUserById", 1);
            //输出结果
            System.out.println(user);

            sqlSession.commit();

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //模糊查询
    @Test
    public void queryUser() {
        //获取资源文件
        String resource = "sqlMapConfig.xml";
        try {
            //获得输入流
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //获取sessionFactory
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //打开sqlSession
            SqlSession sqlSession = sessionFactory.openSession();
            //查询
            List<User> users = sqlSession.selectList("queryUser", "张");

            for (User user : users) {

                //输出结果
                System.out.println(user);
            }

            sqlSession.commit();

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //根据ID修改数据
    @Test
    public void updateUser() {
        //获取资源文件
        String resource = "sqlMapConfig.xml";
        try {
            //获得输入流
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //获取sessionFactory
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //打开sqlSession
            SqlSession sqlSession = sessionFactory.openSession();
            //查询
            User user = new User();
            user.setId(3);
            user.setUsername("东方不败");
            user.setPassword("aabb");
            user.setAddress("湖北省武汉市黄梅县一天门村");

            int count = sqlSession.update("updateUserById", user);
            System.out.println(count + "--->" + user);
            sqlSession.commit();

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //根据ID删除数据
    @Test
    public void delUser() {
        //获取资源文件
        String resource = "sqlMapConfig.xml";
        try {
            //获得输入流
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //获取sessionFactory
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //打开sqlSession
            SqlSession sqlSession = sessionFactory.openSession();

            sqlSession.delete("delUserById", 12);
            sqlSession.commit();

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    //    增加一条数据
    @Test
    public void addOneUser() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sessionFactory.openSession();

            User user = new User();
            user.setUsername("东xi不败");
            user.setPassword("aabb");
            user.setAddress("湖北省武汉市黄梅县一天门村");

            int insert = sqlSession.insert("addUser", user);
            System.out.println(user);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
