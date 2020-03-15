package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import control.GameDir;

public class BaseTank {
	private GameDir gd;
	private int hitcount;//���д���
	private int hitwhite;//���а�̹������
	private int hityellow;//���л�̹������
	private int hitgreen;//������̹������
	private int hitblue;//������̹������
	private int hitred;//���к�̹������
	private int score;//��Ϊ100�֣���Ϊ200�֣���Ϊ200�֣���Ϊ300�֣���Ϊ400��
	private int x =200;// ������Ϸ���ĺ�����
	private int y =560;// ������Ϸ����������
	private int camp=0;//0Ϊ�ҷ�̹��
	private int hp=3;//����ֵ
	private int blood=3;//Ѫ��
	private int diretion;// 0�������ϣ�1�������ң�2�������£�3��������
	private int power=1;//������
	private int bulletspeed=10;//������ӵ��ٶ�
	private int speed = 5;	
	private boolean moveState = false;// false��ʾδ�ƶ���true��ʾ�ƶ�״̬��
	private boolean state = false;// false��ʾδ����״̬��true��ʾ����״̬��
	private Image image = ImageDate.player1_up;
	public BaseTank(GameDir gd) {
		// TODO Auto-generated constructor stub
	this.gd =gd;
	}
	public BaseTank(GameDir gd, int hp, int blood) {
		// TODO Auto-generated constructor stub
	this.gd =gd;
	this.hp=hp;
	this.blood=blood;
	}
	/**
	 * 
	 * * @Title: move 
	 * @Description: TODO(�ҷ�̹�˵��ƶ�����) 
	 * @param     �趨�ļ� 
	 * @return void    �������� 
	 * @throws
	 */
	public void move() {
		gd.mymove.play(1);
		switch (diretion) {
		case 0:// ����
			if (this.getY() < 0||hit()) {
				setX(x);
				setY(y);
				diretion = 0;
				image = ImageDate.player1_up;

			}else {
				diretion = 0;
				image = ImageDate.player1_up;
				setY(getY() - getSpeed());
			}
			
			break;
		case 1:// ����
			if (this.getX() > (600 - 40)||hit()) {
				setX(x);
				setY(y);
				diretion = 1;
				image = ImageDate.player1_right;

			}else {
				diretion = 1;
				image = ImageDate.player1_right;
				setX(getX() + getSpeed());
			}
			break;
		case 2:// ����
			if (this.getY() >(600 - 40)||hit()) {
				setX(x);
				setY(y);
				diretion = 2;
				image = ImageDate.player1_down;
			}else {				
				diretion = 2;
				image = ImageDate.player1_down;
				setY(getY() + getSpeed());
			}
			break;
		case 3:// ����
			if (this.getX() <0||hit()) {			
				setX(x);
				setY(y);
				diretion = 3;
				image = ImageDate.player1_left;

			}else {	diretion = 3;
				image = ImageDate.player1_left;
				setX(getX() - getSpeed());
			}
			break;
		}
		hitEnemyTank();
		hitItem();
	
		}
	
/**
 * 
 * * @Title: fire 
 * @Description: TODO(�ҷ�̹�˵Ŀ��𷽷�) 
 * @param     �趨�ļ� 
 * @return void    �������� 
 * @throws
 */
	public void fire() {
		gd.bullet.play(1);
		if (diretion == 0) {
			Bullet bullet = new Bullet(this.getX() + 15, this.getY()+1, diretion,camp,this.gd, power,bulletspeed);
			Scence.allbullet.add(bullet);
		} else if (diretion == 1) {
			Bullet bullet = new Bullet(this.getX() +39, this.getY() + 15, diretion,camp,this.gd, power,bulletspeed);
			Scence.allbullet.add(bullet);
		} else if (diretion == 2) {
			Bullet bullet = new Bullet(this.getX() + 15, this.getY() + 39, diretion,camp,this.gd, power,bulletspeed);
			Scence.allbullet.add(bullet);
		} else if (diretion == 3) {
			Bullet bullet = new Bullet(this.getX()+1, this.getY() + 15, diretion,camp,this.gd, power,bulletspeed);
			Scence.allbullet.add(bullet);
		}

	}
/**
 * 
 * * @Title: getRectangle 
 * @Description: TODO(�ҷ�̹�˵ľ��ο�) 
 * @param @return    �趨�ļ� 
 * @return Rectangle    �������� 
 * @throws
 */
	public Rectangle getRectangle() {
		return new Rectangle(getX(), getY(), 40, 40);
	}

	/**
	 * 
	 * * @Title: hitEnemyTank @Description: TODO(�ҷ�̹�˸��з�̹����ײ���) @param
	 * �趨�ļ� @return void �������� @throws
	 */
	public void hitEnemyTank() {
		for (int i = 0; i < Scence.allEnemytank.size(); i++) {
			EnemyTank et = Scence.allEnemytank.get(i);
			if (this.getRectangle().intersects(et.getRectangle())) {
				Bomb bomb = new Bomb(this.x, this.y);
				Scence.allbomb.add(bomb);
				if (gd.getTank().getHp() <= 3 && gd.getTank().getHp() > 0) {
					gd.getTank().setHp(gd.getTank().getHp() - 1);// ����ֵ��1
					// ��ʼ��̹��
					gd.relive.play(1);
					gd.getTank().setPower(1);
					gd.getTank().setBlood(3);
					gd.getTank().setX(200);
					gd.getTank().setY(560);
					gd.getTank().setDiretion(0);
					gd.getTank().setImage(ImageDate.player1_up);
					System.out.println(gd.getTank().getHp() + ":685544");
					if (gd.getTank().getHp() == 0) {
						gd.defeat.play(1);
						gd.getTimer().allStop();
						gd.getUi().getFinishDialog().setVisible(true);
						gd.getUi().getFinishDialog().setAlwaysOnTop(true);
						gd.getUi().getGameframe().dispose();
						gd.getUi().getGameframe().getGamepanel().reset1();
						gd.getUi().getInputframe().setVisible(true);
					}
				}
			}
		}
	}
	/**
	 * 
	 * * @Title: hitItem 
	 * @Description: TODO(�ҷ�̹�˳Ե����ߵ���ײ���) 
	 * @param     �趨�ļ� 
	 * @return void    �������� 
	 * @throws
	 */
	public void hitItem() {
		for (int i = 0; i < Scence.allitem.size(); i++) {
			Items item=Scence.allitem.get(i);
			if (this.getRectangle().intersects(item.getRectangle())) {
				switch (item.getType()) {
				case 0://Ѫ������
					if (gd.getTank().getBlood()<3) {//�ҷ�̹��Ѫ��С��3
						gd.getTank().setBlood(gd.getTank().getBlood()+1);
						System.out.println("Ѫ�����߻�ò�Ѫ���ﵽ��"+gd.getTank().getBlood());
						Scence.allitem.remove(i);
					}else if (gd.getTank().getBlood()==3) {//�ҷ�̹��Ѫ��==3ʱ��
						Scence.allitem.remove(i);
						if (gd.getTank().getHp()<3) {
							gd.getTank().setHp(gd.getTank().getHp()+1);
							System.out.println("HPֵ��"+gd.getTank());
						}
					}
					
					break;
                case 1://�ﱤ��ǿ����
					Map.mapcopy[13][6]=1;
					Map.mapcopy[13][7]=1;
					Map.mapcopy[13][8]=1;
					Map.mapcopy[14][6]=1;
					Map.mapcopy[14][8]=1;
					Scence.allitem.remove(i);
					gd.getTimer().getSteelremoveTime().start();
					break;
                case 2://�ӵ���ǿ����
					Scence.allitem.remove(i);
                	
                		if (getPower()<3) {
                			setPower(getPower()+1);
                            System.out.println("�ӵ���ǿ�ˣ�����"+getPower());
    					}else if (getPower()==3) {
                             System.out.println("�ӵ����������Ϊ��");
    					}
					}
               
	                 break;
				}
			}
		}
	
	/**
	 * 
	 * * @Title: hit 
	 * @Description: TODO(�ҷ�̹�˸���ͼ�ϰ������ײ) 
	 * @param     �趨�ļ� 
	 * @return void    �������� 
	 * @throws
	 */
	public boolean hit() {
		for (int row = 0; row < 15; row++) {
			for (int col = 0; col < 15; col++) {
				if (Map.mapcopy[row][col] == 3 || Map.mapcopy[row][col] == 0 || Map.mapcopy[row][col] == 1
						|| Map.mapcopy[row][col] == 5) {
					// ������col��Ӧx�ᣬ��row��Ӧy��
					Rectangle re = new Rectangle(col * 40, row * 40, 40, 40);//�ϰ������
					switch (diretion) {
						case 0:// ������
							Rectangle tankRe=new Rectangle(this.x, this.y-speed, 39, 39);//��Ͳ���ϵ�̹�˾���
							if (tankRe.intersects(re)) {
								return true;
							}
							break;
						case 1:// ������
							Rectangle tankRe1=new Rectangle(this.x+speed, this.y, 39,39);//��Ͳ���ҵ�̹�˾���
							if (tankRe1.intersects(re)) {								
								return true;
							}		
							break;
						case 2:// ������
							Rectangle tankRe2=new Rectangle(this.x, this.y+speed, 39, 39);//��Ͳ���µ�̹�˾���
							if (tankRe2.intersects(re)) {
								return true;
							}
							break;
						case 3:// ������
							Rectangle tankRe3=new Rectangle(this.x-speed, this.y, 39, 39);//��Ͳ�����̹�˾���
							if (tankRe3.intersects(re)) {
								return true;
							}				
							break;
						}
					}
				}
			}		
		return false;		
	}

	//----------------------set��get������-----------------------------


    public void drawRole(Graphics g){
		g.drawImage(gd.getTank().getImage(), gd.getTank().getX(), gd.getTank().getY(), 40, 40, null);	
		Life life=new Life(getX(), getY(),this.blood);
		life.draw(g);
		MyHP hp=new MyHP(getX(), getY()-10,this.hp);
		hp.draw(g);
    }
	
	public int getHitwhite() {
		return hitwhite;
	}
	public void setHitwhite(int hitwhite) {
		this.hitwhite = hitwhite;
	}
	public int getHityellow() {
		return hityellow;
	}
	public void setHityellow(int hityellow) {
		this.hityellow = hityellow;
	}
	public int getHitgreen() {
		return hitgreen;
	}
	public void setHitgreen(int hitgreen) {
		this.hitgreen = hitgreen;
	}
	public int getHitblue() {
		return hitblue;
	}
	public void setHitblue(int hitblue) {
		this.hitblue = hitblue;
	}
	public int getHitred() {
		return hitred;
	}
	public void setHitred(int hitred) {
		this.hitred = hitred;
	}
	public GameDir getGd() {
		return gd;
	}
	public void setGd(GameDir gd) {
		this.gd = gd;
	}
	public int getCamp() {
		return camp;
	}
	public void setCamp(int camp) {
		this.camp = camp;
	}
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
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

	
	public int getBlood() {
		return blood;
	}
	public void setBlood(int blood) {
		this.blood = blood;
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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public boolean isMoveState() {
		return moveState;
	}

	public void setMoveState(boolean moveState) {
		this.moveState = moveState;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getBulletspeed() {
		return bulletspeed;
	}
	public void setBulletspeed(int bulletspeed) {
		this.bulletspeed = bulletspeed;
	}


}
