package com.example.dmattd.shopdeviceonline.model;

public class Traloinhanxet {

    public int idtraloinx;
    public int idnguoitraloinx;
    public String tennguoitraloinx;
    public String noidungtraloinx;
    public String timetraloinx;

    public Traloinhanxet(int idtraloinx,int idnguoitraloinx, String tennguoitraloinx, String noidungtraloinx, String timetraloinx) {
        this.tennguoitraloinx = tennguoitraloinx;
        this.noidungtraloinx = noidungtraloinx;
        this.idnguoitraloinx = idnguoitraloinx;
        this.idtraloinx = idtraloinx;
        this.timetraloinx = timetraloinx;
    }

    public Traloinhanxet(int idnguoitraloinx, String tennguoitraloinx, String noidungtraloinx, String timetraloinx) {
        this.idnguoitraloinx = idnguoitraloinx;
        this.tennguoitraloinx = tennguoitraloinx;
        this.noidungtraloinx = noidungtraloinx;
        this.timetraloinx = timetraloinx;
    }

    public Traloinhanxet(String tennguoitraloinx, String noidungtraloinx, String timetraloinx) {
        this.tennguoitraloinx = tennguoitraloinx;
        this.noidungtraloinx = noidungtraloinx;
        this.timetraloinx = timetraloinx;
    }

    public int getIdtraloinx() {
        return idtraloinx;
    }

    public void setIdtraloinx(int idtraloinx) {
        this.idtraloinx = idtraloinx;
    }

    public int getIdnguoitraloinx() {
        return idnguoitraloinx;
    }

    public void setIdnguoitraloinx(int idnguoitraloinx) {
        this.idnguoitraloinx = idnguoitraloinx;
    }

    public String getTennguoitraloinx() {
        return tennguoitraloinx;
    }

    public void setTennguoitraloinx(String tennguoitraloinx) {
        this.tennguoitraloinx = tennguoitraloinx;
    }

    public String getNoidungtraloinx() {
        return noidungtraloinx;
    }

    public void setNoidungtraloinx(String noidungtraloinx) {
        this.noidungtraloinx = noidungtraloinx;
    }

    public String getTimetraloinx() {
        return timetraloinx;
    }

    public void setTimetraloinx(String timetraloinx) {
        this.timetraloinx = timetraloinx;
    }
}
