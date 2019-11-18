package com.game.snake;

//常量配置
public class Config {
	public static final int ROWS = 22;//行
	public static final int COLS = 35;//列
	public static final int SPAN = 20;
	//定义方向的静态常量
	public static final String U="u";//方向-上
	public static final String D="d";//方向-下
	public static final String L="l";//方向-左
	public static final String R="r";//方向-右
	//死亡检测的标识
	public static boolean isLive=true;
	//游戏暂停的标识
	public static boolean isPause=false;
}
 