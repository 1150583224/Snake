package com.game.snake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.game.snake.MyPanel.SnakeThread;

//按钮
public class Button extends JPanel implements ActionListener{
	MyPanel myPanel;
	JButton pause;
	JButton continu;
	JButton restart;
	public Button(MyPanel myPanel) {
		this.myPanel = myPanel;
		this.setBounds(0, 440, 706, 60);
		 pause = new JButton("暂停游戏");
		 continu = new JButton("继续游戏");
		 restart = new JButton("重新开始");
		this.add(pause);
		this.add(continu);
		this.add(restart);
		pause.addActionListener(this);
		continu.addActionListener(this);
		restart.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//暂停？继续？重新开始
		if(e.getSource()==pause){
			//暂停
			Config.isPause=true;
		}
		if(e.getSource()==continu){
				//继续
			Config.isPause=false;
			//获取焦点
			myPanel.setFocusable(true);
			myPanel.requestFocus();
			}
		if(e.getSource()==restart){
			myPanel.snakeThread.stopThread();
			//重新开始		
			//创建新的食物，新的蛇
			Food food=new Food();
			Snake snake=new Snake(food);
			myPanel.food=food;
			myPanel.snake=snake;
			//控制条件还原
			Config.isLive=true;
			Config.isPause=false;
			//创建的线程对象
			SnakeThread   snakeThread=myPanel.new SnakeThread();
			snakeThread.start();
			myPanel.snakeThread=snakeThread;
			//获取焦点
			myPanel.setFocusable(true);
			myPanel.requestFocus();
			}
		}
		
	}


