package com.example.shut_be.domains;

import javax.persistence.*;

@Entity
@Table(name = "preference")
public class Preference {
    private int id;
    private int userId;
    private int maxSound;
    private int maxVibration;
    private boolean soundControl;
    private boolean colorAlert;
    private boolean soundAlert;
    private int music;

    public Preference() {
    }
    public Preference(int userId) {
        this.userId = userId;
    }


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
    public int getMaxSound() {
        return maxSound;
    }

    public void setMaxSound(int maxSound) {
        this.maxSound = maxSound;
    }

    @Basic
    public int getMaxVibration() {
        return maxVibration;
    }

    public void setMaxVibration(int maxVibration) {
        this.maxVibration = maxVibration;
    }

    @Basic
    public boolean getSoundControl() {
        return soundControl;
    }

    public void setSoundControl(boolean soundControl) {
        this.soundControl = soundControl;
    }


    @Basic
    public boolean getColorAlert() {
        return colorAlert;
    }

    public void setColorAlert(boolean colorAlert) {
        this.colorAlert = colorAlert;
    }

    @Basic
    public boolean getSoundAlert() {
        return soundAlert;
    }

    public void setSoundAlert(boolean soundAlert) {
        this.soundAlert = soundAlert;
    }

    @Basic
    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
    }
}