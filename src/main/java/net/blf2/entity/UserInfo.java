package net.blf2.entity;

/**
 * Created by blf2 on 17-6-21.
 */
public class UserInfo {
    private String userId;
    private String userPswd;
    private String userName;
    private String userRole;
    private String belongTo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPswd() {
        return userPswd;
    }

    public void setUserPswd(String userPswd) {
        this.userPswd = userPswd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userPswd='" + userPswd + '\'' +
                ", userName='" + userName + '\'' +
                ", userRole='" + userRole + '\'' +
                ", belongTo='" + belongTo + '\'' +
                '}';
    }
}
