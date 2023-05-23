
package de01_kt2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;




public class QLSV {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("CHUONG TRINH QUAN LY SINH VIEN");
            System.out.println("1. Nhập");
            System.out.println("2. Hiển thị");
            System.out.println("3. Tìm kiếm");
            System.out.println("4. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int luaChon = sc.nextInt();
            switch (luaChon) {
                case 1:
                    int n;
                    System.out.print("Nhập số lượng sinh viên: ");
                    n = sc.nextInt();
                    List<SinhVien> listInput = nhapDS(n);
                    ghiDSVaoFile(listInput, "QLSV.dat");
                    break;
                case 2:
                    List<SinhVien> listOutput = docDSTuFile("QLSV.dat");
                    hienThiDS(listOutput);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (true);
    }

    private static List<SinhVien> nhapDS(int n) {
        Scanner sc = new Scanner(System.in);
        List<SinhVien> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập sinh viên thứ " + (i + 1) + " :");
            SinhVien sinhVien = new SinhVien();
            System.out.print("Nhập họ tên: ");
            sinhVien.setHoTen(sc.nextLine());
            System.out.print("Nhập mã sv: ");
            sinhVien.setMaSV(sc.nextLine());
            System.out.print("Nhập giới tính: ");
            sinhVien.setGioiTinh(sc.nextLine());
            System.out.print("Nhập năm sinh: ");
            sinhVien.setNamSinh(sc.nextInt());
            sc.nextLine();
            list.add(sinhVien);
        }
        return list;
    }

    private static void hienThiDS(List<SinhVien> list) {
        list.forEach(sinhVien -> {
            System.out.println(sinhVien.toString());
        });
    }

    public static void ghiDSVaoFile(List<SinhVien> list, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(list);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<SinhVien> docDSTuFile(String filename) {
        List<SinhVien> list = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            list = (List<SinhVien>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.unmodifiableList(new ArrayList<>(list));
    }
    
}


