package com.game.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements KeyListener {
	// 创建时食物对象
	Food food = new Food();
	// 创建蛇对象
	Snake snake = new Snake(food);
	// 创建蛇线程的对象
	SnakeThread snakeThread = new SnakeThread();

	public MyPanel() {
		// 设置容器坐标及大小
		this.setBounds(0, 0, 700, 440);
		// 设置容器背景色
		this.setBackground(Color.PINK);
		//
		this.addKeyListener(this);
		// 启动蛇的线程
		snakeThread.start();
	}

	// 绘制容器
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// 设置绘制的颜色
		g.setColor(Color.GRAY);
		// 绘制横线
		for (int i = 0; i < Config.ROWS; i++) {
			// 使用当前颜色在点 (x1, y1) 和 (x2, y2) 之间画一条线
			g.drawLine(0, Config.SPAN * i, Config.COLS * Config.SPAN, Config.SPAN * i);
		}
		// 绘制竖线
		for (int i = 0; i < Config.COLS; i++) {
			g.drawLine(Config.SPAN * i, 0, Config.SPAN * i, Config.ROWS * Config.SPAN);
		}
		// 蛇移动
		snake.move();
		// 绘制实物-->调用食物对象的draw方法
		food.draw(g);
		// 绘制蛇
		snake.draw(g);
		// 创建贪吃蛇的线程类

	}

	class SnakeThread extends Thread {
		boolean flag=true;
		// 重写run方法
		@Override
		public void run() {
			super.run();

			// 让蛇跑起来，当蛇没有死亡，就持续移动
			// 使用while循环
			while (Config.isLive&&flag) {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (Config.isLive&&!Config.isPause) {
					repaint();// 重绘
				}
			}
			//弹出对话框，显示游戏结束
			if(flag==false){
			JOptionPane.showMessageDialog(MyPanel.this, "游戏结束！");
		}

	}
		public void stopThread(){
			flag=false;
	}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		snake.dirControl(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	}


