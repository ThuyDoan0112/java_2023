/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de02;

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
public class QLThuVien {
    private static List<Sach> dsSach = new ArrayList<Sach>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {            
              System.out.println("CHUONG TRINH QUAN LY THU VIEN");
            System.out.println("1. Nhập");
            System.out.println("2. Hiển thị");
            System.out.println("3. Tìm kiếm");
            System.out.println("4. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int luaChon = sc.nextInt();
            switch(luaChon){ 
                    case 1: 
                        System.out.println("Nhap so luong sach: ");
                        int n = sc.nextInt();
                        nhapSach(n);
                        luuTep(dsSach);
                        break;
                    case 2: 
                        docTuTep(dsSach);
                        hienThiDS(dsSach);
                        break;
                    case 3: 
                        timKiem(dsSach);
                        break;
                    case 4: 
                        sapXep(dsSach);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                        
                        
            }
        } while (true);
        
    }
    public static List<Sach>  nhapSach(int n){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<n;i++){
            System.out.println("Nhap cuon sach thu " + (i+1)+ ": ");
            Sach sach = new Sach();
            System.out.println("Nhap ten sach: ");
            sach.setTenSach(sc.nextLine());
            System.out.println("Nhap ma sach: ");
            sach.setMaSach(sc.nextLine());
            System.out.println("Nhap tac gia: ");
            sach.setTacGia(sc.nextLine());
            System.out.println("Nhap nha xuat ban: ");
            sach.setNXB(sc.nextLine());
            System.out.println("Nhap nam xuat ban: ");
            sach.setNamXB(sc.nextInt());
            sc.nextLine();
            dsSach.add(sach);
        }
        return dsSach;
    }
    public static void hienThiDS(List<Sach> list){
        if(list.isEmpty()){
            System.out.println("Danh sach sach trong");
            return;
        }
        System.out.println("Danh sach sach: ");
        list.forEach((sach) -> {
            System.out.println(sach.toString());
        });
    }
    public static void timKiem(List<Sach> list){
        if(list.isEmpty()){
            System.out.println("Danh sach sach trong");
            return;
        }
        Scanner sc = new Scanner(System.in);
            System.out.println("Nhap ma sach can tim: ");
            String maSach = sc.nextLine();
        for(Sach sach:list){
            if(sach.getMaSach().equalsIgnoreCase(maSach)){
                System.out.println(sach.toString());
              
            }
        }
           
    }
    public static void sapXep(List<Sach> list){
        if(list.isEmpty()){
            System.out.println("Danh sach sach trong");
            return;
        }
        Collections.sort(list, new Comparator<Sach>(){
            @Override
            public int compare(Sach s1, Sach s2){
                return s1.getNamXB() - s2.getNamXB();
            }
        });
    }
    public static void luuTep(List<Sach> list){
        try {
            FileOutputStream fos = new  FileOutputStream("book.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
            System.out.println("Luu tep thanh cong");
        } catch (Exception e) {
            System.out.println("Lỗi khi lưu xuống tệp: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void docTuTep(List<Sach> list) {
        try {
            FileInputStream fis = new FileInputStream("book.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<Sach>) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Doc tep thanh cong");
        } catch (Exception e) {
            System.out.println("Lỗi khi đọc từ tệp: " + e.getMessage());
        }
    }
}
