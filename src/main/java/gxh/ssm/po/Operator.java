package gxh.ssm.po;

public class Operator {
    private Integer opNumber;

    private String password;

    public Integer getOpNumber() {
        return opNumber;
    }

    public void setOpNumber(Integer opNumber) {
        this.opNumber = opNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}