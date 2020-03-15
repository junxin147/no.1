package model;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Bomb {

	private int bombNum = 8; // ��ը����
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
 * @Description: TODO(��λ���ը�ķ���) 
 * @param     �趨�ļ� 
 * @return void    �������� 
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
	 * @Description: TODO(����ըͼ) 
	 * @param @param g    �趨�ļ� 
	 * @return void    �������� 
	 * @throws
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(this.getImage(), this.getX(), this.getY(), 40, 40, null);
	}
	//----------------------set��get������-----------------------------

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
