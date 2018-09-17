package com.caocan.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_account")
public class Account {

    private String cardNo ;
    private String password;
    private float balance;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="cardNo")
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="balance")
    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "cardNo='" + cardNo + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
    //  @Override
    //    public String toString() {
    //        return "User [id=" + id + ", username=" + username + ", birthday="
    //                + birthday + ", sex=" + sex + ", address=" + address + "]";
    //    }
}
