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
	private int diretion;// 0�������ϣ�1�������ң�2�������£�3��������
	private int speed = 10;//�ӵ��ٶ�
	private int power = 1;// ������
	private int camp;// 0Ϊ�ҷ�̹�ˣ�1Ϊ�ط�̹��.
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
	 * * @Title: move @Description: TODO(�ӵ����ƶ�����) @param �趨�ļ� @return void
	 * �������� @throws
	 */
	public void move() {
		switch (diretion) {
		case 0:// ����
			setY(getY() - getSpeed());
			break;
		case 1:// ����
			setX(getX() + getSpeed());
			break;
		case 2:// ����
			setY(getY() + getSpeed());
			break;
		case 3:// ����
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
	 * * @Title: bulletHitTank @Description: TODO(�ӵ���ײ̹�˵ĸ������) @param
	 * �趨�ļ� @return void �������� @throws
	 */
	public void bulletHitTank() {
		for (int j = 0; j < Scence.allEnemytank.size(); j++) {
			EnemyTank et = Scence.allEnemytank.get(j);
			if (this.getCamp() == 0) {// �ҷ�������ӵ�
				if (this.getRectangle().intersects(et.getRectangle())) {
					Scence.allbullet.remove(this);
					Bomb bomb = new Bomb(et.getX(), et.getY());
					Scence.allbomb.add(bomb);
					if (et.getType() == 0) {// �����ǰ�ɫ̹��
						if (et.getBlood() > 0) {// Ѫ������0�����Ѫ���仯
							et.setBlood(et.getBlood() - power);
							System.out.println(et.getBlood() + ":9999");
						}
						if (et.getBlood() <= 0) {// Ѫ��<=0���
							Scence.allEnemytank.remove(j);
							// ��Ϸ��Ϣ���仯
							gd.getTank().setHitcount(gd.getTank().getHitcount() + 1);// �ùػ�������
							gd.getEnemyTank().setHitcount(gd.getEnemyTank().getHitcount() + 1);
							gd.getUi().getGameframe().getGameinfo().getWhitetankinfo1()
									.setText("X" + (Map.tankcopy1[0] = Map.tankcopy1[0] - 1));
							gd.getEnemyTank().setScore(gd.getEnemyTank().getScore() + 100);
							gd.getTank().setScore(gd.getTank().getScore() + 100);// �ùذ�ɫ����
							gd.getTank().setHitwhite(gd.getTank().getHitwhite() + 1);// ��ɫ����������
							gd.getUi().getFinishDialog().getFinish().getWhitetankinfo1().setText(
									"X" + gd.getTank().getHitwhite() + "     X100=" + gd.getTank().getHitwhite() * 100);
						}
					}
					if (et.getType() == 1) {// �����ǻ�ɫɫ̹��
						if (et.getBlood() > 0) {// Ѫ������0�����Ѫ���仯
							et.setBlood(et.getBlood() - power);
							System.out.println(et.getBlood() + ":9991");
						}
						if (et.getBlood() <= 0) {// Ѫ��<=0���
							Scence.allEnemytank.remove(j);
							gd.getTank().setHitcount(gd.getTank().getHitcount() + 1);
							gd.getEnemyTank().setHitcount(gd.getEnemyTank().getHitcount() + 1);// �ܹ�����������+1
							gd.getUi().getGameframe().getGameinfo().getYellowtankinfo1()
									.setText("X" + (Map.tankcopy1[1] = Map.tankcopy1[1] - 1));
							gd.getEnemyTank().setScore(gd.getEnemyTank().getScore() + 200);// �ܹ�����+200
							gd.getTank().setScore(gd.getTank().getScore() + 200);// �ùػ�ɫ����
							gd.getTank().setHityellow(gd.getTank().getHityellow() + 1);// ��ɫ����������
							gd.getUi().getFinishDialog().getFinish().getYellowtankinfo1().setText("X"
									+ gd.getTank().getHityellow() + "     X200=" + gd.getTank().getHityellow() * 200);
						}

					}
					if (et.getType() == 2) {// ��������ɫ̹��
						if (et.getBlood() > 0) {// Ѫ������0�����Ѫ���仯
							et.setBlood(et.getBlood() - power);
							System.out.println(et.getBlood() + ":9992");
						}
						if (et.getBlood() <= 0) {// Ѫ��<=0���
							Scence.allEnemytank.remove(j);
							gd.getTank().setHitcount(gd.getTank().getHitcount() + 1);
							gd.getEnemyTank().setHitcount(gd.getEnemyTank().getHitcount() + 1);
							gd.getUi().getGameframe().getGameinfo().getGreentankinfo1()
									.setText("X" + (Map.tankcopy1[2] = Map.tankcopy1[2] - 1));
							gd.getEnemyTank().setScore(gd.getEnemyTank().getScore() + 200);
							gd.getTank().setScore(gd.getTank().getScore() + 200);// �ù���ɫ����
							gd.getTank().setHitgreen(gd.getTank().getHitgreen() + 1);// ��ɫ����������
							gd.getUi().getFinishDialog().getFinish().getGreentankinfo1().setText(
									"X" + gd.getTank().getHitgreen() + "     X200=" + gd.getTank().getHitgreen() * 200);
						}

					}
					if (et.getType() == 3) {// ��������ɫ̹��
						if (et.getBlood() > 0) {// Ѫ������0�����Ѫ���仯
							et.setBlood(et.getBlood() - power);
							System.out.println(et.getBlood() + ":9993");
						}
						if (et.getBlood() <= 0) {// Ѫ��<=0���
							Scence.allEnemytank.remove(j);
							gd.getTank().setHitcount(gd.getTank().getHitcount() + 1);
							gd.getEnemyTank().setHitcount(gd.getEnemyTank().getHitcount() + 1);
							gd.getUi().getGameframe().getGameinfo().getBluetankinfo1()
									.setText("X" + (Map.tankcopy1[3] = Map.tankcopy1[3] - 1));
							gd.getEnemyTank().setScore(gd.getEnemyTank().getScore() + 300);
							gd.getTank().setScore(gd.getTank().getScore() + 300);// �ù���ɫ����
							gd.getTank().setHitblue(gd.getTank().getHitblue() + 1);// ��ɫ����������
							gd.getUi().getFinishDialog().getFinish().getBluetankinfo1().setText(
									"X" + gd.getTank().getHitblue() + "     X300=" + gd.getTank().getHitblue() * 300);
						}

					}
					if (et.getType() == 4) {// �����Ǻ�ɫ̹��
						if (et.getBlood() > 0) {// Ѫ������0�����Ѫ���仯
							et.setBlood(et.getBlood() - power);
							System.out.println(et.getBlood() + ":9994");
						}
						if (et.getBlood() <= 0) {// Ѫ��<=0���
							Scence.allEnemytank.remove(j);
							gd.getTank().setHitcount(gd.getTank().getHitcount() + 1);
							gd.getEnemyTank().setHitcount(gd.getEnemyTank().getHitcount() + 1);
							gd.getUi().getGameframe().getGameinfo().getRedtankinfo1()
									.setText("X" + (Map.tankcopy1[4] = Map.tankcopy1[4] - 1));
							gd.getEnemyTank().setScore(gd.getEnemyTank().getScore() + 500);
							gd.getTank().setScore(gd.getTank().getScore() + 500);// �ùغ�ɫɫ����
							gd.getTank().setHitred(gd.getTank().getHitred() + 1);// ��ɫ����������
							gd.getUi().getFinishDialog().getFinish().getRedtankinfo1().setText(
									"X" + gd.getTank().getHitred() + "     X500=" + gd.getTank().getHitred() * 500);
						}

					}
					// ��Ϸ��Ϣ���仯
					gd.getUi().getGameframe().getGameinfo().getDestroyinfo()
							.setText("�ùػ���̹�ˣ�" + gd.getTank().getHitcount());
					gd.getUi().getGameframe().getGameinfo().getAlldestroyinfo()
							.setText("�ܹ�����̹�ˣ�" + gd.getEnemyTank().getHitcount());
					gd.getUi().getGameframe().getGameinfo().getScoreinfo().setText("�ùص÷֣�" + gd.getTank().getScore());
					gd.getUi().getGameframe().getGameinfo().getAllscoreinfo()
							.setText("�ܹ��÷֣�" + (gd.getEnemyTank().getScore()));
					// ���������Ϣ�仯
					gd.getUi().getFinishDialog().getFinish().getAllscoreinfo()
							.setText("�ܹ��÷֣�" + (gd.getEnemyTank().getScore()));
					gd.getUi().getFinishDialog().getFinish().getAlldestroyinfo()
							.setText("�ܹ�����̹�ˣ�" + gd.getEnemyTank().getHitcount());
				}
			}
		}
		if (this.getCamp() == 1) {// �з�������ӵ�
			if (this.getRectangle().intersects(gd.getTank().getRectangle())) {
				Scence.allbullet.remove(this);// �Ƴ��з��ӵ�
				Bomb bomb = new Bomb(gd.getTank().getX(), gd.getTank().getY());
				Scence.allbomb.add(bomb);
				if (gd.getTank().getHp() <= 3 && gd.getTank().getHp() > 0) {
					if (gd.getTank().getBlood() > 1) {
						gd.getTank().setBlood(gd.getTank().getBlood() - gd.getEnemyTank().getPower());// Ѫ��-1
						if(gd.getTank().getBlood() <1) {
							gd.getTank().setHp(gd.getTank().getHp() - 1);
							// ��ʼ��̹��
							gd.getTank().setPower(1);
							gd.getTank().setBlood(3);
							gd.getTank().setX(200);
							gd.getTank().setY(560);
							gd.getTank().setDiretion(0);
							gd.getTank().setImage(ImageDate.player1_up);
							if (gd.getTank().getHp() <= 0) {
								gd.defeat.play(1);//ʧ����Ч
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
						// ��ʼ��̹��
						gd.relive.play(1);
						gd.getTank().setPower(1);
						gd.getTank().setBlood(3);
						gd.getTank().setX(200);
						gd.getTank().setY(560);
						gd.getTank().setDiretion(0);
						gd.getTank().setImage(ImageDate.player1_up);
						if (gd.getTank().getHp() <= 0) {
							gd.defeat.play(1);//ʧ����Ч		
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
	 * * @Title: bulletHit @Description: TODO(����̹�˷�����ӵ���ײ���) @param �趨�ļ� @return
	 * void �������� @throws
	 */
	public void bulletHit() {
		for (int i = 0; i < Scence.allbullet.size(); i++) {
			Bullet bu = Scence.allbullet.get(i);// ��ȡ�ӵ�����
			if (this != bu) {// ������������ȡ�ӵ�������ͬһ���Ļ�
				if (this.camp == 0 && bu.camp == 1) {// �ֱ����ҷ��͵з�������ӵ�
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
	 * * @Title: getRectangle @Description: TODO(�ӵ��ľ��ο�) @param @return
	 * �趨�ļ� @return Rectangle �������� @throws
	 */
	public Rectangle getRectangle() {
		return new Rectangle(this.x, this.y, 10, 10);
	}

	/**
	 * 
	 * * @Title: hitwall @Description: TODO(�ӵ���ײ��ש���) @param @param
	 * row @param @param col �趨�ļ� @return void �������� @throws
	 */
	public void hitwall(int row, int col) {
		if (getRectangle().intersects(col * 40, row * 40, 40, 40)) {
			Scence.allbullet.remove(this);
			Map.mapcopy[row][col] = 2;
			 Bomb bomb=new Bomb(col*40, row*40);
		        Scence.allbomb.add(bomb);
		        gd.hitiron.play(1);//��ǽ��Ч
		}
	}

	/**
	 * 
	 * * @Title: hitSteels @Description: TODO(�ӵ���ײ��ǽ���) @param @param
	 * row @param @param col �趨�ļ� @return void �������� @throws
	 */
	public void hitSteels(int row, int col) {
		if (getRectangle().intersects(col * 40, row * 40, 40, 40)) {
			Scence.allbullet.remove(this);
			 Bomb bomb=new Bomb(this.x-15,this.y-15);
		        Scence.allbomb.add(bomb);
		        gd.hitiron.play(1);//��ǽ��Ч
		}
	}

	/**
	 * 
	 * * @Title: hitSymbol @Description: TODO(�ӵ���ײ������) @param @param
	 * row @param @param col �趨�ļ� @return void �������� @throws
	 */
	public void hitSymbol(int row, int col) {
		if (getRectangle().intersects(col * 40, row * 40, 40, 40)) {
			Scence.allbullet.remove(this);
			Bomb bomb=new Bomb(col*40, row*40);
		    Scence.allbomb.add(bomb);
			gd.defeat.play(1);//ʧ����Ч
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
	 * * @Title: hitDraw @Description: TODO(�ӵ�����ͼ�ϰ������ײ����) @param �趨�ļ� @return
	 * void �������� @throws
	 */
	public void hitDraw() {
		for (int row = 0; row < 15; row++) {
			for (int col = 0; col < 15; col++) {
				if (Map.mapcopy[row][col] == 3) {
					// ǽ�ڣ�������col��Ӧx�ᣬ��row��Ӧy��
					hitwall(row, col);
					  
				}
				if (Map.mapcopy[row][col] == 1) {
					// ��ǽ��������col��Ӧx�ᣬ��row��Ӧy��
					hitSteels(row, col);
					 
				}
				if (Map.mapcopy[row][col] == 0) {
					// �����־��������col��Ӧx�ᣬ��row��Ӧy��
					hitSymbol(row, col);			
				   	 
				}

			}
		}
	}

	public void drawRole(Graphics g) {
		g.drawImage(ImageDate.bullet, x, y, 10, 10, null);
     
	}
	//----------------------set��get������-----------------------------

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
