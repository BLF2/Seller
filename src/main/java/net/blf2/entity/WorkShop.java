package net.blf2.entity;

import java.util.List;

/**
 * Created by blf2 on 17-6-24.
 */
public class WorkShop {
    private String workShopNum;//车间编号
    private String workShopName;//车间名称
    private String workShopAdmin;//车间主任
    private String workShopDesc;//车间描述
    private List<UserInfo> members;//成员


    public String getWorkShopNum() {
        return workShopNum;
    }

    public void setWorkShopNum(String workShopNum) {
        this.workShopNum = workShopNum;
    }

    public String getWorkShopName() {
        return workShopName;
    }

    public void setWorkShopName(String workShopName) {
        this.workShopName = workShopName;
    }

    public String getWorkShopAdmin() {
        return workShopAdmin;
    }

    public void setWorkShopAdmin(String workShopAdmin) {
        this.workShopAdmin = workShopAdmin;
    }

    public String getWorkShopDesc() {
        return workShopDesc;
    }

    public void setWorkShopDesc(String workShopDesc) {
        this.workShopDesc = workShopDesc;
    }

    public List<UserInfo> getMembers() {
        return members;
    }

    public void setMembers(List<UserInfo> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "WorkShop{" +
                "workShopNum='" + workShopNum + '\'' +
                ", workShopName='" + workShopName + '\'' +
                ", workShopAdmin='" + workShopAdmin + '\'' +
                ", workShopDesc='" + workShopDesc + '\'' +
                ", members=" + members +
                '}';
    }
}
