package model;

import java.awt.Graphics;
import java.util.ArrayList;

import control.GameDir;

public class Scence {
	 public static ArrayList<Bullet> allbullet=new ArrayList<>();
	 public static ArrayList<EnemyTank> allEnemytank=new ArrayList<>();
	 public static ArrayList<Items> allitem=new ArrayList<>();
	 public static ArrayList<Bomb> allbomb=new ArrayList<>();

	 private Map map = new Map();
 
     private int level=1;
    
public Scence() {
	// TODO Auto-generated constructor stub
}
/**
 * 
 * * @Title: drawMap 
 * @Description: TODO(����G����ͼ����) 
 * @param @param g    �趨�ļ� 
 * @return void    �������� 
 * @throws
 */
public void drawMap(Graphics g) {
	//map.setMap(level);
	for (int row = 0; row < Map.mapcopy .length; row++) {
		for (int col = 0; col < Map.mapcopy[row].length; col++) {
			if (Map.mapcopy[row][col] == 3) {
				// ����ǽ�ڣ�������col��Ӧx�ᣬ��row��Ӧy��	
				g.drawImage(ImageDate.WALLS, col * 40, row * 40, 40, 40, null);		
			}
			if (Map.mapcopy[row][col] == 4) {
				// ���Ʋݵأ�������col��Ӧx�ᣬ��row��Ӧy��
				g.drawImage(ImageDate.GRASS, col * 40, row * 40, 40, 40, null);
			}
			if (Map.mapcopy[row][col] == 1) {
				// ������ǽ��������col��Ӧx�ᣬ��row��Ӧy��				
				g.drawImage(ImageDate.STEELS, col * 40, row * 40, 40, 40, null);				
			}
			if (Map.mapcopy[row][col] == 0) {
				// ���ƴ����־��������col��Ӧx�ᣬ��row��Ӧy��6			
				g.drawImage(ImageDate.SYMBOL, col * 40, row * 40, 40, 40, null);
			}
			if (Map.mapcopy[row][col] == 5) {
				// ���ƺ�����������col��Ӧx�ᣬ��row��Ӧy��
				g.drawImage(ImageDate.WATER, col * 40, row * 40, 40, 40, null);
			}
		}
		}
	}
//----------------------set��get������-----------------------------

public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
public Map getMap() {
	return map;
}
public void setMap(Map map) {
	this.map = map;
}

}
