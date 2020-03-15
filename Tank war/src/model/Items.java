package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import control.GameDir;

public class Items {
	private GameDir gd;
	private int x ;// 所在游戏面板的横坐标
	private int y ;// 所在游戏面板的纵坐标
    private int type;//类型（血包，子弹增强，碉堡增强）
    private int value;//道具值
	public Random ra = new Random();
	public Items(GameDir gd) {
		this.gd=gd;
		// TODO Auto-generated constructor stub
	}
    public Items(int x, int y, int type) {
		// TODO Auto-generated constructor stub
    	this.x=x;
    	this.y=y;
    	this.type=type;
	}
    /**
     * 
     * * @Title: product 
     * @Description: TODO(添加到道具数组集合，并限制位置地方) 
     * @param     设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void product(){
    	setX(ra.nextInt(15) * 40);
		setY(ra.nextInt(12) * 40);
		setType(ra.nextInt(3));
		for (int row = 0; row < 15; row++) {
			for (int col = 0; col < 15; col++) {
				if (Map.mapcopy[row][col] == 4 || Map.mapcopy[row][col] == 2|| Map.mapcopy[row][col] == 3) {// 4是草地.2是空地
					// 数组列col对应x轴，行row对应y轴
					Rectangle re = new Rectangle(col * 40, row * 40, 40, 40);//障碍物矩形
					if (re.contains(x, y)) {
						Items item=new Items(x, y, type);					
					    Scence.allitem.add(item);
    }
			}
		}
    }
    }

	public void remove() {
		for (int i = 0; i < Scence.allitem.size(); i++) {
			Scence.allitem.remove(i);

		}
	}
    
    public void drawRole(Graphics g){
	switch (type) {
	case 0://血包道具
		g.drawImage(ImageDate.bloodup, getX(), getY(), 40, 40, null);
		break;
	case 1://银墙道具
		g.drawImage(ImageDate.steelup, getX(), getY(), 40, 40, null);
		break;
	case 2://子弹增强道具
		g.drawImage(ImageDate.bulletup, getX(), getY(), 40, 40, null);
		break;
	}
}

    public Rectangle getRectangle() {
		return new Rectangle(this.x, this.y,39, 39);
	}
	//----------------------set和get方法区-----------------------------

public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
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
