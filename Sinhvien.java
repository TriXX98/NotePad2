/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhsach;

import java.util.Scanner;

/**
 *
 * @author 8470p
 */
public class Sinhvien {
    private String Hoten;
    private int MSV;
    private int DTB;
    public void Nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.printf("Nhap ho va ten: ");
        Hoten=sc.nextLine();
        System.out.print("Nhap MSV:");
        MSV=Integer.parseInt(sc.nextLine());
        System.out.printf("Nhap diem trung binh");
        DTB=Integer.parseInt(sc.nextLine());
    }   
    public void In(){
        System.out.print("Sinh vien vua nhap la:" +Hoten+ "   " +MSV+"  "+DTB);
    }
        
}
