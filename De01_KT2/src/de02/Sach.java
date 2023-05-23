
package de02;

import java.io.Serializable;


public class Sach implements Serializable{
    private String tenSach;
    private String maSach;
    private String tacGia;
    private String NXB;
    private int namXB;

    public Sach() {
    }

    public Sach(String tenSach, String maSach, String tacGia, String NXB, int namXB) {
        this.tenSach = tenSach;
        this.maSach = maSach;
        this.tacGia = tacGia;
        this.NXB = NXB;
        this.namXB = namXB;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public int getNamXB() {
        return namXB;
    }

    public void setNamXB(int namXB) {
        this.namXB = namXB;
    }
    
    @Override
    public String toString(){
        return "Ten sach: " + tenSach + ", Ma Sach: " + maSach + ", Tac gia: " + tacGia + ", Nha xuat ban: " + NXB + ", Nam xuat ban: " + namXB;
    }
}
