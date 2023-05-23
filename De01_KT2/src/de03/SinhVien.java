/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de03;

import java.io.Serializable;

/**
 *
 * @author doanthithuy
 */
public class SinhVien implements Serializable{
    private String hoTen;
    private String maSV;
    private String gioiTinh;
    private int namSinh;

    public SinhVien() {
    }

    public SinhVien(String hoTen, String maSV, String gioiTinh, int namSinh) {
        this.hoTen = hoTen;
        this.maSV = maSV;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
    @Override 
    public String toString(){
        return "Ho ten: " + hoTen + ", Ma sinh vien: " + maSV + ", Gioi tinh: " + gioiTinh + ", Nam sinh: " + namSinh;
    }
    
}
