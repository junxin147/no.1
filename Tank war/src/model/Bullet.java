package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import control.GameDir;

public class Bullet {
	private int x;
	private int y;
	private int diretion;// 0代表向上，1代表向右，2代表向下，3代表向左
	private int speed = 10;//子弹速度
	private int power = 1;// 攻击力
	private int camp;// 0为我方坦克，1为地方坦克.
	private GameDir gd;

	public Bullet() {
		// TODO Auto-generated constructor stub
	}

	public Bullet(int x, int y, int diretion, int camp, GameDir gd, int power, int speed) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.diretion = diretion;
		this.camp = camp;
		this.speed=speed;
		this.gd = gd;
        this.power=power;
	}

	/**
	 * 
	 * * @Title: move @Description: TODO(子弹的移动方法) @param 设定文件 @return void
	 * 返回类型 @throws
	 */
	public void move() {
		switch (diretion) {
		case 0:// 向上
			setY(getY() - getSpeed());
			break;
		case 1:// 向右
			setX(getX() + getSpeed());
			break;
		case 2:// 向下
			setY(getY() + getSpeed());
			break;
		case 3:// 向左
			setX(getX() - getSpeed());
			break;
		}
		if (x < 0 || y < 0 || x > 600 || y > 600) {
			Scence.allbullet.remove(this);
		}
		hitDraw();
		bulletHit();
		bulletHitTank();
	}

	/**
	 * 
	 * * @Title: bulletHitTank @Description: TODO(子弹碰撞坦克的各种情况) @param
	 * 设定文件 @return void 返回类型 @throws
	 */
	public void bulletHitTank() {
		for (int j = 0; j < Scence.allEnemytank.size(); j++) {
			EnemyTank et = Scence.allEnemytank.get(j);
			if (this.getCamp() == 0) {// 我方发射的子弹
				if (this.getRectangle().intersects(et.getRectangle())) {
					Scence.allbullet.remove(this);
					Bomb bomb = new Bomb(et.getX(), et.getY());
					Scence.allbomb.add(bomb);
					if (et.getType() == 0) {// 对象是白色坦克
						if (et.getBlood() > 0) {// 血量大于0情况，血量变化
							et.setBlood(et.getBlood() - power);
							System.out.println(et.getBlood() + ":9999");
						}
						if (et.getBlood() <= 0) {// 血量<=0情况
							Scence.allEnemytank.remove(j);
							// 游戏信息面板变化
							gd.getTank().setHitcount(gd.getTank().getHitcount() + 1);// 该关击毁数量
							gd.getEnemyTank().setHitcount(gd.getEnemyTank().getHitcount() + 1);
							gd.getUi().getGameframe().getGameinfo().getWhitetankinfo1()
									.setText("X" + (Map.tankcopy1[0] = Map.tankcopy1[0] - 1));
							gd.getEnemyTank().setScore(gd.getEnemyTank().getScore() + 100);
							gd.getTank().setScore(gd.getTank().getScore() + 100);// 该关白色分数
							gd.getTank().setHitwhite(gd.getTank().getHitwhite() + 1);// 白色被击毁数量
							gd.getUi().getFinishDialog().getFinish().getWhitetankinfo1().setText(
									"X" + gd.getTank().getHitwhite() + "     X100=" + gd.getTank().getHitwhite() * 100);
						}
					}
					if (et.getType() == 1) {// 对象是黄色色坦克
						if (et.getBlood() > 0) {// 血量大于0情况，血量变化
							et.setBlood(et.getBlood() - power);
							System.out.println(et.getBlood() + ":9991");
						}
						if (et.getBlood() <= 0) {// 血量<=0情况
							Scence.allEnemytank.remove(j);
							gd.getTank().setHitcount(gd.getTank().getHitcount() + 1);
							gd.getEnemyTank().setHitcount(gd.getEnemyTank().getHitcount() + 1);// 总共被击毁数量+1
							gd.getUi().getGameframe().getGameinfo().getYellowtankinfo1()
									.setText("X" + (Map.tankcopy1[1] = Map.tankcopy1[1] - 1));
							gd.getEnemyTank().setScore(gd.getEnemyTank().getScore() + 200);// 总共分数+200
							gd.getTank().setScore(gd.getTank().getScore() + 200);// 该关黄色分数
							gd.getTank().setHityellow(gd.getTank().getHityellow() + 1);// 黄色被击毁数量
							gd.getUi().getFinishDialog().getFinish().getYellowtankinfo1().setText("X"
									+ gd.getTank().getHityellow() + "     X200=" + gd.getTank().getHityellow() * 200);
						}

					}
					if (et.getType() == 2) {// 对象是绿色坦克
						if (et.getBlood() > 0) {// 血量大于0情况，血量变化
							et.setBlood(et.getBlood() - power);
							System.out.println(et.getBlood() + ":9992");
						}
						if (et.getBlood() <= 0) {// 血量<=0情况
							Scence.allEnemytank.remove(j);
							gd.getTank().setHitcount(gd.getTank().getHitcount() + 1);
							gd.getEnemyTank().setHitcount(gd.getEnemyTank().getHitcount() + 1);
							gd.getUi().getGameframe().getGameinfo().getGreentankinfo1()
									.setText("X" + (Map.tankcopy1[2] = Map.tankcopy1[2] - 1));
							gd.getEnemyTank().setScore(gd.getEnemyTank().getScore() + 200);
							gd.getTank().setScore(gd.getTank().getScore() + 200);// 该关绿色分数
							gd.getTank().setHitgreen(gd.getTank().getHitgreen() + 1);// 绿色被击毁数量
							gd.getUi().getFinishDialog().getFinish().getGreentankinfo1().setText(
									"X" + gd.getTank().getHitgreen() + "     X200=" + gd.getTank().getHitgreen() * 200);
						}

					}
					if (et.getType() == 3) {// 对象是蓝色坦克
						if (et.getBlood() > 0) {// 血量大于0情况，血量变化
							et.setBlood(et.getBlood() - power);
							System.out.println(et.getBlood() + ":9993");
						}
						if (et.getBlood() <= 0) {// 血量<=0情况
							Scence.allEnemytank.remove(j);
							gd.getTank().setHitcount(gd.getTank().getHitcount() + 1);
							gd.getEnemyTank().setHitcount(gd.getEnemyTank().getHitcount() + 1);
							gd.getUi().getGameframe().getGameinfo().getBluetankinfo1()
									.setText("X" + (Map.tankcopy1[3] = Map.tankcopy1[3] - 1));
							gd.getEnemyTank().setScore(gd.getEnemyTank().getScore() + 300);
							gd.getTank().setScore(gd.getTank().getScore() + 300);// 该关蓝色分数
							gd.getTank().setHitblue(gd.getTank().getHitblue() + 1);// 蓝色被击毁数量
							gd.getUi().getFinishDialog().getFinish().getBluetankinfo1().setText(
									"X" + gd.getTank().getHitblue() + "     X300=" + gd.getTank().getHitblue() * 300);
						}

					}
					if (et.getType() == 4) {// 对象是红色坦克
						if (et.getBlood() > 0) {// 血量大于0情况，血量变化
							et.setBlood(et.getBlood() - power);
							System.out.println(et.getBlood() + ":9994");
						}
						if (et.getBlood() <= 0) {// 血量<=0情况
							Scence.allEnemytank.remove(j);
							gd.getTank().setHitcount(gd.getTank().getHitcount() + 1);
							gd.getEnemyTank().setHitcount(gd.getEnemyTank().getHitcount() + 1);
							gd.getUi().getGameframe().getGameinfo().getRedtankinfo1()
									.setText("X" + (Map.tankcopy1[4] = Map.tankcopy1[4] - 1));
							gd.getEnemyTank().setScore(gd.getEnemyTank().getScore() + 500);
							gd.getTank().setScore(gd.getTank().getScore() + 500);// 该关红色色分数
							gd.getTank().setHitred(gd.getTank().getHitred() + 1);// 红色被击毁数量
							gd.getUi().getFinishDialog().getFinish().getRedtankinfo1().setText(
									"X" + gd.getTank().getHitred() + "     X500=" + gd.getTank().getHitred() * 500);
						}

					}
					// 游戏信息面板变化
					gd.getUi().getGameframe().getGameinfo().getDestroyinfo()
							.setText("该关击毁坦克：" + gd.getTank().getHitcount());
					gd.getUi().getGameframe().getGameinfo().getAlldestroyinfo()
							.setText("总共击毁坦克：" + gd.getEnemyTank().getHitcount());
					gd.getUi().getGameframe().getGameinfo().getScoreinfo().setText("该关得分：" + gd.getTank().getScore());
					gd.getUi().getGameframe().getGameinfo().getAllscoreinfo()
							.setText("总共得分：" + (gd.getEnemyTank().getScore()));
					// 结算面板信息变化
					gd.getUi().getFinishDialog().getFinish().getAllscoreinfo()
							.setText("总共得分：" + (gd.getEnemyTank().getScore()));
					gd.getUi().getFinishDialog().getFinish().getAlldestroyinfo()
							.setText("总共击毁坦克：" + gd.getEnemyTank().getHitcount());
				}
			}
		}
		if (this.getCamp() == 1) {// 敌方发射的子弹
			if (this.getRectangle().intersects(gd.getTank().getRectangle())) {
				Scence.allbullet.remove(this);// 移除敌方子弹
				Bomb bomb = new Bomb(gd.getTank().getX(), gd.getTank().getY());
				Scence.allbomb.add(bomb);
				if (gd.getTank().getHp() <= 3 && gd.getTank().getHp() > 0) {
					if (gd.getTank().getBlood() > 1) {
						gd.getTank().setBlood(gd.getTank().getBlood() - gd.getEnemyTank().getPower());// 血量-1
						if(gd.getTank().getBlood() <1) {
							gd.getTank().setHp(gd.getTank().getHp() - 1);
							// 初始化坦克
							gd.getTank().setPower(1);
							gd.getTank().setBlood(3);
							gd.getTank().setX(200);
							gd.getTank().setY(560);
							gd.getTank().setDiretion(0);
							gd.getTank().setImage(ImageDate.player1_up);
							if (gd.getTank().getHp() <= 0) {
								gd.defeat.play(1);//失败音效
								gd.getTimer().allStop();								
								gd.getUi().getFinishDialog().setVisible(true);
								gd.getUi().getFinishDialog().setAlwaysOnTop(true);
								gd.getUi().getGameframe().getGamepanel().reset1();
								gd.getUi().getGameframe().dispose();
								gd.getUi().getInputframe().setVisible(true);
							}
						}
						System.out.println(gd.getTank().getBlood() + ":6454");
					} else if (gd.getTank().getBlood() <= 1) {
						gd.getTank().setHp(gd.getTank().getHp() - 1);
						// 初始化坦克
						gd.relive.play(1);
						gd.getTank().setPower(1);
						gd.getTank().setBlood(3);
						gd.getTank().setX(200);
						gd.getTank().setY(560);
						gd.getTank().setDiretion(0);
						gd.getTank().setImage(ImageDate.player1_up);
						if (gd.getTank().getHp() <= 0) {
							gd.defeat.play(1);//失败音效		
							gd.getTimer().allStop();							
							gd.getUi().getFinishDialog().setVisible(true);
							gd.getUi().getFinishDialog().setAlwaysOnTop(true);
							gd.getUi().getGameframe().getGamepanel().reset1();
							gd.getUi().getGameframe().dispose();
							gd.getUi().getInputframe().setVisible(true);
						}
					}
				}
			}
		}
	}

	/**
	 * 
	 * * @Title: bulletHit @Description: TODO(敌我坦克发射的子弹碰撞检测) @param 设定文件 @return
	 * void 返回类型 @throws
	 */
	public void bulletHit() {
		for (int i = 0; i < Scence.allbullet.size(); i++) {
			Bullet bu = Scence.allbullet.get(i);// 获取子弹对象
			if (this != bu) {// 如果本对象跟获取子弹对象不是同一个的话
				if (this.camp == 0 && bu.camp == 1) {// 分别是我方和敌方发射的子弹
					if (this.getRectangle().intersects(bu.getRectangle())) {
						 Bomb bomb=new Bomb(this.x-15, this.y-15);
					        Scence.allbomb.add(bomb);
						Scence.allbullet.remove(this);
						Scence.allbullet.remove(bu);
					}
				}
			}
		}
	}

	/**
	 * 
	 * * @Title: getRectangle @Description: TODO(子弹的矩形框) @param @return
	 * 设定文件 @return Rectangle 返回类型 @throws
	 */
	public Rectangle getRectangle() {
		return new Rectangle(this.x, this.y, 10, 10);
	}

	/**
	 * 
	 * * @Title: hitwall @Description: TODO(子弹碰撞红砖检测) @param @param
	 * row @param @param col 设定文件 @return void 返回类型 @throws
	 */
	public void hitwall(int row, int col) {
		if (getRectangle().intersects(col * 40, row * 40, 40, 40)) {
			Scence.allbullet.remove(this);
			Map.mapcopy[row][col] = 2;
			 Bomb bomb=new Bomb(col*40, row*40);
		        Scence.allbomb.add(bomb);
		        gd.hitiron.play(1);//打到墙音效
		}
	}

	/**
	 * 
	 * * @Title: hitSteels @Description: TODO(子弹碰撞银墙检测) @param @param
	 * row @param @param col 设定文件 @return void 返回类型 @throws
	 */
	public void hitSteels(int row, int col) {
		if (getRectangle().intersects(col * 40, row * 40, 40, 40)) {
			Scence.allbullet.remove(this);
			 Bomb bomb=new Bomb(this.x-15,this.y-15);
		        Scence.allbomb.add(bomb);
		        gd.hitiron.play(1);//打到墙音效
		}
	}

	/**
	 * 
	 * * @Title: hitSymbol @Description: TODO(子弹碰撞大鸟检测) @param @param
	 * row @param @param col 设定文件 @return void 返回类型 @throws
	 */
	public void hitSymbol(int row, int col) {
		if (getRectangle().intersects(col * 40, row * 40, 40, 40)) {
			Scence.allbullet.remove(this);
			Bomb bomb=new Bomb(col*40, row*40);
		    Scence.allbomb.add(bomb);
			gd.defeat.play(1);//失败音效
		    gd.getTimer().allStop();
			gd.getUi().getFinishDialog().setVisible(true);
			gd.getUi().getFinishDialog().setAlwaysOnTop(true);
			gd.getUi().getGameframe().getGamepanel().reset1();
			gd.getUi().getGameframe().setVisible(false);
			gd.getUi().getInputframe().setVisible(true);

		}
	}

	/**
	 * 
	 * * @Title: hitDraw @Description: TODO(子弹跟地图障碍物的碰撞处理) @param 设定文件 @return
	 * void 返回类型 @throws
	 */
	public void hitDraw() {
		for (int row = 0; row < 15; row++) {
			for (int col = 0; col < 15; col++) {
				if (Map.mapcopy[row][col] == 3) {
					// 墙壁，数组列col对应x轴，行row对应y轴
					hitwall(row, col);
					  
				}
				if (Map.mapcopy[row][col] == 1) {
					// 银墙，数组列col对应x轴，行row对应y轴
					hitSteels(row, col);
					 
				}
				if (Map.mapcopy[row][col] == 0) {
					// 大鸟标志，数组列col对应x轴，行row对应y轴
					hitSymbol(row, col);			
				   	 
				}

			}
		}
	}

	public void drawRole(Graphics g) {
		g.drawImage(ImageDate.bullet, x, y, 10, 10, null);
     
	}
	//----------------------set和get方法区-----------------------------

	public int getCamp() {
		return camp;
	}

	public void setCamp(int camp) {
		this.camp = camp;
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

	public int getDiretion() {
		return diretion;
	}

	public void setDiretion(int diretion) {
		this.diretion = diretion;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
