package cn.cyikns.mapper;

import cn.cyikns.pojo.QueryVo;
import cn.cyikns.pojo.User;

import java.util.List;

/**
 * @author cyikns
 * @create 2018-08-08 10:12
 */
public interface UserMapper {

    void addUser(User user);

    User selectUserById(int id);

    List<User> queryUserByQueryVo(QueryVo vo);

    List<User> queryUserList(User user);

    List<User> queryUserForeach(List ids);

    List<User> queryUserAndOrders();
}
