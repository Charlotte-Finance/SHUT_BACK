package com.example.shut_be.domains;

import javax.persistence.*;

@Entity
@Table(name = "music")
public class Music {
    private int id;
    private String link;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
