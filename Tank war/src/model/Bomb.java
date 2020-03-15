package model;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Bomb {

	private int bombNum = 8; // 爆炸次数
	private int x;
	private int y;
	private Image image;

	public Bomb(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
/**
 * 
 * * @Title: drawRole 
 * @Description: TODO(如何画爆炸的方法) 
 * @param     设定文件 
 * @return void    返回类型 
 * @throws
 */
	public void drawRole() {
		// TODO Auto-generated method stub
		switch (bombNum--) {
		case 8:
			this.setImage(ImageDate.explode1);
			break;
		case 7:
			this.setImage(ImageDate.explode2);
			break;
		case 6:
			this.setImage(ImageDate.explode3);
			break;
		case 5:
			this.setImage(ImageDate.explode4);
			break;
		case 4:
			this.setImage(ImageDate.explode5);
			break;
		case 3:
			this.setImage(ImageDate.explode6);
			break;
		case 2:
			this.setImage(ImageDate.explode7);
			break;
		case 1:
			this.setImage(ImageDate.explode8);
			break;
		default:
			this.setImage(null);
			break;
		}
	}

	/**
	 * 
	 * * @Title: paintComponent 
	 * @Description: TODO(画爆炸图) 
	 * @param @param g    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(this.getImage(), this.getX(), this.getY(), 40, 40, null);
	}
	//----------------------set和get方法区-----------------------------

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getBombNum() {
		return bombNum;
	}

	public void setBombNum(int bombNum) {
		this.bombNum = bombNum;
	}

}
