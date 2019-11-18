package com.game.snake;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Snake {

	Node head;// 蛇头
	Node body;// 蛇身
	Node tail;// 蛇尾
	Food food;// 食物
	// 构造方法，初始化蛇身（是指蛇头、蛇身蛇尾的信息）

	public Snake(Food food) {
		this.food = food;
		// 初始化蛇头，指定了蛇头的行、列、前进的方向
		head = new Node(7, 13, Config.R);
		body = new Node(7, 12, Config.R);
		tail = new Node(7, 11, Config.R);
		// 设置节点间的关系
		head.next = body;// Head的下一个节点为body节点
		body.next = tail;
		tail.pre = body;
		body.pre = head;
	}

	public void draw(Graphics g) {
		// 遍历得到蛇的每一个节点（Node），然后绘制每一个节点
		for (Node n = head; n != null; n = n.next) {
			// 绘制借点n
			// 调用节点的绘图方法
			n.draw(g);
		}
	}

	// 蛇移动的方法
	public void move() {
		// 1.添加蛇头2.去蛇尾3.吃食物4.死亡检测
		addHEAD();// 添加蛇头
		removeTail();// 去蛇尾
		eatFood();// 吃食物
		deadCheck();//死亡检查
	}
//死亡检测
	private void deadCheck() {
	//情况1.越界
		if(head.row<0||head.col<0||head.row>Config.ROWS-1||head.col>Config.COLS-1){
			Config.isLive=false;
		}
		//情况2.蛇头与其他借点重合--》遍历得到蛇头以外的任何一个节点，然后将此借点的行、列与蛇头的行、列比较，如果都一直说明重合，此时死亡，
		for(Node n=head.next;n!=null;n=n.next){
			if(head.col==n.col&&head.row==n.row){
				Config.isLive=false;
				
			}
			
		}
	}
	// 吃食物
	private void eatFood() {
		// System.out.println(getHeadRest().intersects(food.getFoodRect()));
		if (getHeadRest().intersects(food.getFoodRect())) {
			// 重合，吃到了
			// 加蛇头
			addHEAD();
			// 重新布局食物
			food.repair();
		}
	}

	// 去蛇尾
	private void removeTail() {
		tail.pre.next = null;// 设置尾节点的上一个节点的下一个节点为null
		tail = tail.pre;// 把蛇尾的前一个节点赋值为蛇尾
	}

	// 添加蛇头
	private void addHEAD() {
		Node node = null;// 临时节点
		switch (head.dir) {// 根据蛇头前进的方向
		case Config.R:// 如果方向向右，那应该在右边添加蛇头，行不变、列+1、方向不变
			node = new Node(head.row, head.col + 1, head.dir);
			break;
		case Config.L:
			node = new Node(head.row, head.col - 1, head.dir);
			break;
		case Config.U:
			node = new Node(head.row - 1, head.col, head.dir);
			break;
		case Config.D:
			node = new Node(head.row + 1, head.col, head.dir);
			break;

		default:
			break;
		}
		node.next = head;
		head.pre = node;
		head = node;
		

	}

	public void dirControl(KeyEvent e) {
		// TODO Auto-generated method stub
		// 根据按键，控制蛇头运行的方向
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:// 上-->如果蛇头的方向不为下，那么就将蛇头的方向改为上
			if (!head.dir.equals(Config.D)) {
				// 设置蛇头方向为上
				head.dir = Config.U;
			}
			break;
		case KeyEvent.VK_DOWN:
			if (!head.dir.equals(Config.U)) {
				head.dir = Config.D;
			}
			break;
		case KeyEvent.VK_LEFT:
			if (!head.dir.equals(Config.R)) {
				head.dir = Config.L;
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (!head.dir.equals(Config.L)) {
				head.dir = Config.R;
			}
			break;

		default:
			break;
		}
	}

	// 获得蛇头坐标的矩形空间
	public Rectangle getHeadRest() {
		return new Rectangle(head.col * Config.SPAN, head.row * Config.SPAN, Config.SPAN, Config.SPAN);
	}
}
