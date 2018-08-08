package cn.cyikns.mapper;

import cn.cyikns.pojo.User;

/**
 * @author cyikns
 * @create 2018-08-08 10:12
 */
public interface UserMapper {

    void addUser(User user);

    User selectUserById(int id);
}
