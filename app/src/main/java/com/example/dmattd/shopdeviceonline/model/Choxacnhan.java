package com.example.dmattd.shopdeviceonline.model;

public class Choxacnhan {


    public int iddonhang;
    public String trangthai;
    public String ngaydathang;
    public String tennguoinhan;
    public String sodienthoai;
    public String diachi;

    public String tenspcxn;
    public long giaspcxn;
    public String hinhanhspcxn;
    public int soluongspcxn;

    public Choxacnhan(int iddonhang, String ngaydathang) {
        this.iddonhang = iddonhang;
        this.ngaydathang = ngaydathang;
    }

    public Choxacnhan(int iddonhang, String trangthai, String ngaydathang) {
        this.iddonhang = iddonhang;
        this.trangthai = trangthai;
        this.ngaydathang = ngaydathang;
    }



    public Choxacnhan(String tenspcxn, long giaspcxn, String hinhanhspcxn, int soluongspcxn) {
        this.tenspcxn = tenspcxn;
        this.giaspcxn = giaspcxn;
        this.hinhanhspcxn = hinhanhspcxn;
        this.soluongspcxn = soluongspcxn;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public int getIddonhang() {
        return iddonhang;
    }

    public void setIddonhang(int iddonhang) {
        this.iddonhang = iddonhang;
    }

    public String getNgaydathang() {
        return ngaydathang;
    }

    public void setNgaydathang(String ngaydathang) {
        this.ngaydathang = ngaydathang;
    }

    public String getTenspcxn() {
        return tenspcxn;
    }
    public void setTenspcxn(String tenspcxn) {
        this.tenspcxn = tenspcxn;
    }

    public long getGiaspcxn() {
        return giaspcxn;
    }

    public void setGiaspcxn(long giaspcxn) {
        this.giaspcxn = giaspcxn;
    }

    public String getHinhanhspcxn() {
        return hinhanhspcxn;
    }

    public void setHinhanhspcxn(String hinhanhspcxn) {
        this.hinhanhspcxn = hinhanhspcxn;
    }

    public int getSoluongspcxn() {
        return soluongspcxn;
    }

    public void setSoluongspcxn(int soluongspcxn) {
        this.soluongspcxn = soluongspcxn;
    }
}
