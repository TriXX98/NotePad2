package testGraphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;

import javax.swing.JFrame;

public class demoGraphics extends Canvas {
	
public void paint(Graphics g) {
	// Thiet ke do hoa
	// TODO Auto-generated constructor stub
	// Tạo chữ 
	g.drawString("Hello Word", 100, 100); 
	// màu nền
	setBackground(Color.BLACK);
	//sử dụng để điền màu mặc định và độ rộng và chiều cao đã cho vào hình chữ nhật.
	 g.fillRect(130, 30,100, 80); 
	 // vẽ hình Ovan với độ rộng và chiều cao đã cho.
     g.drawOval(30,130,50, 60);  
     
     setForeground(Color.RED);  
     
     //để điền màu mặc định và độ rộng và chiều cao đã cho vào hình Oval.
     g.fillOval(130,130,50, 60);  
     // vẽ đường tròn circular hoặc elip.
     g.drawArc(30, 200, 40,50,90,60);  
     //để điền một hình tròn hoặc elip.
     g.fillArc(30, 130, 40,50,180,40); 
}
public static void main(String[] args) {
	// TODO Auto-generated method stub
	demoGraphics m = new demoGraphics();
	JFrame f=new JFrame();  
    f.add(m);  
    f.setSize(400,400);  
    //f.setLayout(null);  
    f.setVisible(true);  
}
}

