package com.game.snake;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

// JFrame图形化界面设计——容器
public class MyFrame extends JFrame {
	MyPanel myPanel = new MyPanel();
	Button button = new Button(myPanel);
	
	public MyFrame() {
		// 设置窗体标题
		this.setTitle("贪吃勇");
		//设置窗体图标
		 Toolkit tool=this.getToolkit(); //得到一个Toolkit对象 
	     Image myimage=tool.getImage("snake.jpg"); //由tool获取图像 
	    this.setIconImage(myimage);
		// 设置窗体初始位置及大小
		this.setBounds(300, 50, 706, 500);
		// 设置当关闭窗口的时候,保证JVM退出
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置布局管理器为null 清空布局
		this.setLayout(null);
		// 设置此窗体是否可由用户调整大小
		this.setResizable(false);
		// 添加控件
		this.add(myPanel);
		// 设置键盘监听焦点
		myPanel.setFocusable(true);
		myPanel.requestFocus();
		// 添加按钮
		this.add(button);
		// 显示
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
