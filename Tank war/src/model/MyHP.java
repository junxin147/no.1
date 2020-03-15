package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class MyHP {
	private int x;
	private int y;
	private int width=41;
	private int height=10;
	private int HP;
	public MyHP() {
		// TODO Auto-generated constructor stub
	}
	public MyHP(int x, int y, int HP) {
		super();
		this.x = x;
		this.y = y;
		this.HP=HP;
	}
	
	public void draw(Graphics g){	
		Graphics2D g2=(Graphics2D) g;
		//画外圈
		Rectangle2D r2=new Rectangle2D.Double(x, y-height, width, height);
		g2.setColor(Color.YELLOW);
		g2.draw(r2);
		//根据血量比例画HP
		Rectangle2D r=new Rectangle2D.Double(x+1, y-height+1, ((double)HP/(0.075)), height-1);
		g2.setColor(Color.GREEN);
		g2.fill(r);
	}
	//----------------------set和get方法区-----------------------------

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
