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
 * @Description: TODO(画笔G画地图方法) 
 * @param @param g    设定文件 
 * @return void    返回类型 
 * @throws
 */
public void drawMap(Graphics g) {
	//map.setMap(level);
	for (int row = 0; row < Map.mapcopy .length; row++) {
		for (int col = 0; col < Map.mapcopy[row].length; col++) {
			if (Map.mapcopy[row][col] == 3) {
				// 绘制墙壁，数组列col对应x轴，行row对应y轴	
				g.drawImage(ImageDate.WALLS, col * 40, row * 40, 40, 40, null);		
			}
			if (Map.mapcopy[row][col] == 4) {
				// 绘制草地，数组列col对应x轴，行row对应y轴
				g.drawImage(ImageDate.GRASS, col * 40, row * 40, 40, 40, null);
			}
			if (Map.mapcopy[row][col] == 1) {
				// 绘制银墙，数组列col对应x轴，行row对应y轴				
				g.drawImage(ImageDate.STEELS, col * 40, row * 40, 40, 40, null);				
			}
			if (Map.mapcopy[row][col] == 0) {
				// 绘制大鸟标志，数组列col对应x轴，行row对应y轴6			
				g.drawImage(ImageDate.SYMBOL, col * 40, row * 40, 40, 40, null);
			}
			if (Map.mapcopy[row][col] == 5) {
				// 绘制河流，数组列col对应x轴，行row对应y轴
				g.drawImage(ImageDate.WATER, col * 40, row * 40, 40, 40, null);
			}
		}
		}
	}
//----------------------set和get方法区-----------------------------

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
