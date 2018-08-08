package cn.cyikns.mapper;

import cn.cyikns.pojo.Order;
import cn.cyikns.pojo.OrderUser;

import java.util.List;

/**
 * @author cyikns
 * @create 2018-08-08 14:41
 */
public interface OrderMapper {

    List<Order> queryOrderAll();

    List<OrderUser> queryAllOrders();

    List<Order> queryOrderUseResultMap1();
}
