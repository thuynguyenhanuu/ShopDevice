package com.example.dmattd.shopdeviceonline.model;

import java.io.Serializable;

public class Nhanxet implements Serializable {
    public String tennguoinx;
    public String noidungnx;
    public int idnguoinx;
    public int id;
    public String time;
    public int repNumber;

    public Nhanxet(int idnguoinx, String noidungnx, String tennguoinx, String time) {
        this.tennguoinx = tennguoinx;
        this.noidungnx = noidungnx;
        this.idnguoinx = idnguoinx;
        this.time = time;
    }

    public Nhanxet(int id, int idnguoinx, String noidungnx, String tennguoinx, String time) {
        this.tennguoinx = tennguoinx;
        this.noidungnx = noidungnx;
        this.idnguoinx = idnguoinx;
        this.id = id;
        this.time = time;
    }

    public Nhanxet(int id, int idnguoinx, String noidungnx, String tennguoinx, String time, int repNumber) {
        this.tennguoinx = tennguoinx;
        this.noidungnx = noidungnx;
        this.idnguoinx = idnguoinx;
        this.id = id;
        this.time = time;
        this.repNumber = repNumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdnguoinx() {
        return idnguoinx;
    }

    public void setIdnguoinx(int idnguoinx) {
        this.idnguoinx = idnguoinx;
    }



    public String getTennguoinx() {
        return tennguoinx;
    }

    public void setTennguoinx(String tennguoinx) {
        this.tennguoinx = tennguoinx;
    }

    public String getNoidungnx() {
        return noidungnx;
    }

    public void setNoidungnx(String noidungnx) {
        this.noidungnx = noidungnx;
    }

    public int getRepNumber() {
        return repNumber;
    }

    public void setRepNumber(int repNumber) {
        this.repNumber = repNumber;
    }
}
