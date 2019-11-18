package com.game.snake;

import java.awt.Color;
import java.awt.Graphics;

public class Node {
	int row;
	int col;
	String dir;
	Node next;
	Node pre;

	public Node(int row, int col, String dir) {
		super();
		this.row = row;
		this.col = col;
		this.dir = dir;

	}

	// 绘制节点自身的方法
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if (this.pre == null) {
			// 是蛇头
			g.setColor(Color.YELLOW);
		} else {
			g.setColor(Color.BLUE);
		}
		// 填充方格
		g.fillOval(col * Config.SPAN, row * Config.SPAN, Config.SPAN, Config.SPAN);
	}

}
