package com.example.shut_be.domains;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pics")
public class Pic {
    private int id;
    private int userId;
    private Date time;
    private int value;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    @Basic
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
