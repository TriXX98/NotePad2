/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhsach;

import java.util.Scanner;


public class DSSV {
    private int n,i;
    private Sinhvien a[];
    public void NhapDS(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhap so sinh vien:");
        n=Integer.parseInt(sc.nextLine());
        a=new Sinhvien[n];
        for (i=1;i<=n;i++)
        {
            a[i]=new Sinhvien();
            System.out.println("Sinh vien thư "+i+ " la");
            a[i].Nhap();
        }
    }
    public void InDS(){
        System.out.print("Danh sach sinh vien sau khi nhap la:");
        System.out.print(" Hoten      MSV       DTB");
        for(i=1;i<=n;i++)
        {
            a[i].In();
        }
    }
}
