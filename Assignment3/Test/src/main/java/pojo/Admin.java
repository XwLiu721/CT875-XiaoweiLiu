package pojo;

public class Admin {
    private Integer adminID;
    private String adminUserName;
    private String adminPassword;
    private String adminName;

    public Admin() {
    }

    public Admin(Integer adminID, String adminUserName, String adminPassword, String adminName) {
        this.adminID = adminID;
        this.adminUserName = adminUserName;
        this.adminPassword = adminPassword;
        this.adminName = adminName;
    }

    public Integer getAdminID() {
        return adminID;
    }

    public void setAdminID(Integer adminID) {
        this.adminID = adminID;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
