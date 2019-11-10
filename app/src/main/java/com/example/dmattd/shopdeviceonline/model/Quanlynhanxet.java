package com.example.dmattd.shopdeviceonline.model;

public class Quanlynhanxet {
    public int idqlnx;
    public String noidungqlnx;
    public String time;
    public String imgsp;
    public String tensp;
//
//    public Quanlynhanxet(int idqlnx, String noidungqlnx, String time) {
//        this.idqlnx = idqlnx;
//        this.noidungqlnx = noidungqlnx;
//        this.time = time;
//    }
//


    public Quanlynhanxet(int idqlnx, String noidungqlnx, String time, String imgsp, String motasp) {
        this.idqlnx = idqlnx;
        this.noidungqlnx = noidungqlnx;
        this.time = time;
        this.imgsp = imgsp;
        this.tensp = motasp;
    }

    public Quanlynhanxet(String noidungqlnx, String imgsp, String motasp, String time) {
        this.noidungqlnx = noidungqlnx;
        this.time = time;
        this.imgsp = imgsp;
        this.tensp = motasp;
    }

    public int getIdqlnx() {
        return idqlnx;
    }

    public void setIdqlnx(int idqlnx) {
        this.idqlnx = idqlnx;
    }

    public String getNoidungqlnx() {
        return noidungqlnx;
    }

    public void setNoidungqlnx(String noidungqlnx) {
        this.noidungqlnx = noidungqlnx;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImgsp() {
        return imgsp;
    }

    public void setImgsp(String imgsp) {
        this.imgsp = imgsp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String motasp) {
        this.tensp = motasp;
    }
}
