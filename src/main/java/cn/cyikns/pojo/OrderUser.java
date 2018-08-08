package cn.cyikns.pojo;

/**
 * @author cyikns
 * @create 2018-08-08 17:25
 */
public class OrderUser extends Order {

    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
