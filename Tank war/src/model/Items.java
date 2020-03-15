package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import control.GameDir;

public class Items {
	private GameDir gd;
	private int x ;// ������Ϸ���ĺ�����
	private int y ;// ������Ϸ����������
    private int type;//���ͣ�Ѫ�����ӵ���ǿ���ﱤ��ǿ��
    private int value;//����ֵ
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
     * @Description: TODO(��ӵ��������鼯�ϣ�������λ�õط�) 
     * @param     �趨�ļ� 
     * @return void    �������� 
     * @throws
     */
    public void product(){
    	setX(ra.nextInt(15) * 40);
		setY(ra.nextInt(12) * 40);
		setType(ra.nextInt(3));
		for (int row = 0; row < 15; row++) {
			for (int col = 0; col < 15; col++) {
				if (Map.mapcopy[row][col] == 4 || Map.mapcopy[row][col] == 2|| Map.mapcopy[row][col] == 3) {// 4�ǲݵ�.2�ǿյ�
					// ������col��Ӧx�ᣬ��row��Ӧy��
					Rectangle re = new Rectangle(col * 40, row * 40, 40, 40);//�ϰ������
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
	case 0://Ѫ������
		g.drawImage(ImageDate.bloodup, getX(), getY(), 40, 40, null);
		break;
	case 1://��ǽ����
		g.drawImage(ImageDate.steelup, getX(), getY(), 40, 40, null);
		break;
	case 2://�ӵ���ǿ����
		g.drawImage(ImageDate.bulletup, getX(), getY(), 40, 40, null);
		break;
	}
}

    public Rectangle getRectangle() {
		return new Rectangle(this.x, this.y,39, 39);
	}
	//----------------------set��get������-----------------------------

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
