package com.game.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

//食物类
public class Food {
	private int row;//所在的行  
	private int col;//所在的列  
	//自定义无参构造无参方法，在方法中调用repair()
	public Food(){
		repair();
		
	}
	//绘制食物自身
	public void draw(Graphics g){
		//设置颜色
		g.setColor(Color.WHITE);
		//填充方格
		g.fillRect(col*Config.SPAN, row*Config.SPAN, Config.SPAN,Config.SPAN );
	}
	
//重新定义位置--》修改row、 col（随即值）
	public void repair(){
		row=new Random().nextInt(Config.ROWS);//0-Config.Rows（不包含）的随机数
		col=new Random().nextInt(Config.COLS);
	}
	//获得食物所在矩形空间
	public Rectangle getFoodRect(){
		return new Rectangle(col*Config.SPAN, row*Config.SPAN, Config.SPAN, Config.SPAN);
	} 
}
