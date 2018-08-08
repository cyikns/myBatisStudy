package cn.cyikns.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author cyikns
 * @create 2018-08-08 14:11
 */
public class QueryVo implements Serializable {

    //包含其他的POJO
    private User user;

    private List ids;

    public List getIds() {
        return ids;
    }

    public void setIds(List ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
