package cn.cyikns.pojo;

import java.io.Serializable;

/**
 * @author cyikns
 * @create 2018-08-07 19:53
 */
public class Order implements Serializable {
    private int id;
    private int userId;
    private String shoppingName;
    private int status;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getShoppingName() {
        return shoppingName;
    }

    public void setShoppingName(String shoppingName) {
        this.shoppingName = shoppingName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", shoppingName='" + shoppingName + '\'' +
                ", status=" + status +
                ", user=" + user +
                '}';
    }
}
