package model;
import java.time.YearMonth;

public class CreditCard {
    private int id;
    private int ccNum;
    private String firstName;
    private String lastName;
    private YearMonth expDate;
    private int cvv;
    private int userId;

    public CreditCard(int id, int ccNum, String firstName, String lastName, YearMonth expDate, int cvv) {
        this.id = id;
        this.ccNum = ccNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.expDate = expDate;
        this.cvv = cvv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCcNum() {
        return ccNum;
    }

    public void setCcNum(int ccNum) {
        this.ccNum = ccNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public YearMonth getExpDate() {
        return expDate;
    }

    public void setExpDate(YearMonth expDate) {
        this.expDate = expDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", ccNum=" + ccNum +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", expDate=" + expDate +
                ", cvv=" + cvv +
                ", userId=" + userId +
                '}';
    }
}
