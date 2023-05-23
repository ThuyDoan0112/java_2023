/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author doanthithuy
 */
public class QLSV {
    private static List<SinhVien> dsSV = new ArrayList<SinhVien>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {            
            System.out.println("CHUONG TRINH QUAN LY SINH VIEN");
            System.out.println("1. Nhap");
            System.out.println("2. hien thi");
            System.out.println("3. Tim kiem");
            System.out.println("4. Xoa");
            System.out.println("5. Thoat");
            System.out.println("Nhap lua chon: ");
            int luachon = sc.nextInt();
            switch(luachon){
                case 1:
                    System.out.println("nhap so luong sinh vien: ");
                    int n = sc.nextInt();
                    nhapDS(n);
                    luuVaoTep(dsSV, "QLSV.dat");
                    break;
                case 2: 
                    List<SinhVien> listOutput = docTuTep("QLSV.dat");
                    hienThiDs(listOutput);
                    break;
                case 3: 
                    timKiem(dsSV);
                    break;
                case 4:
                    sapXep(dsSV);
                    luuVaoTep(dsSV, "QLSV.dat");
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Lua chon khong hop le");
                    
            }
        } while (true);
        
    }
    public static List<SinhVien> nhapDS(int n){
        Scanner sc = new Scanner(System.in);
        
        for(int i=0;i<n;i++){
            System.out.println("Nhap sinh vien thu " + (i+1) + ": ");
            SinhVien sv = new SinhVien();
            System.out.println("Nhap ho ten: ");
            sv.setHoTen(sc.nextLine());
            System.out.println("Nhap ma sinh vien: ");
            sv.setMaSV(sc.nextLine());
            System.out.println("Nhap gioi tinh: ");
            sv.setGioiTinh(sc.nextLine());
            System.out.println("Nhap nam sinh: ");
            sv.setNamSinh(sc.nextInt());
            sc.nextLine();
            dsSV.add(sv);
        }
        return dsSV;
    }
    public static void hienThiDs(List<SinhVien> list){
        if(list.isEmpty()){
            System.out.println("Danh sach rong");
            return;
        }
        System.out.println("Danh sach sinh vien: ");
        for(SinhVien sv:list){
            System.out.println(sv.toString());
        }
    }
    public static void luuVaoTep(List<SinhVien> list, String filename){
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
            System.out.println("Luu tep thanh cong");
        } catch (Exception e) {
            System.out.println("Co loi khi luu tep: " + e.getMessage());
        }
    }
    public static  List<SinhVien> docTuTep( String filename){
        List<SinhVien> list = null;
        try {
            
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<SinhVien>) ois.readObject();
            ois.close();
            fis.close();
            
        } catch (Exception e) {
             System.out.println("Co loi doc luu tep: " + e.getMessage());
        }
        return Collections.unmodifiableList(new ArrayList<>(list));
    }
    public static void timKiem(List<SinhVien> list){
        if(list.isEmpty()){
            System.out.println("Danh sach rong");
            return;
        }
         Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma sinh vien can tim: ");
        String maSV = sc.nextLine();
        for(SinhVien sv:list){
            if(sv.getMaSV().equalsIgnoreCase(maSV)){
                System.out.println(sv.toString());
                return;
            }
        }
        System.out.println("Khong co sinh vien nao");
    }
    public static void sapXep(List<SinhVien> list){
        Collections.sort(list, new Comparator<SinhVien>(){
            public int compare(SinhVien sv1, SinhVien sv2){
                if(sv1.getNamSinh()<sv2.getNamSinh())
                    return -1;
                else if(sv1.getNamSinh()>sv2.getNamSinh())
                    return 1;
                else 
                    return 0;
            }
        });
    }
}
