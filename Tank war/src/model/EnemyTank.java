package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Random;

import control.GameDir;

public class EnemyTank {
	private GameDir gd;
	private int x ;// ������Ϸ���ĺ�����
	private int y ;// ������Ϸ����������
	private int camp=1;//1Ϊ�з�̹��
	private int type;//0Ϊ��1Ϊ��2Ϊ��3Ϊ��4Ϊ��
	private int score;//��Ϊ100�֣���Ϊ200�֣���Ϊ200�֣���Ϊ300�֣���Ϊ400��
	private int hitcount;//����������
	private int blood;//�з�̹��Ѫ��
	public Random ra = new Random();
	private int power=1;//������
	private int diretion;// 0�������ϣ�1�������ң�2�������£�3��������
	private int speed = 3;//�ƶ��ٶ�
	private int bulletspeed =10;//�ӵ��ƶ��ٶ�
	private int step = ra.nextInt(12) + 5;//���·��
	private Image image= ImageDate.pc1_up;
	public EnemyTank(GameDir gd) {
		this.gd = gd;
		// TODO Auto-generated constructor stub
	}

	public EnemyTank(int x, int y, int diretion,int type,GameDir gd, int blood, int speed, int power ) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.diretion = diretion;
		this.type=type;
		this.gd = gd;
		this.blood=blood;
		this.speed=speed;
		this.power=power;
	}
/**
 * 
 * * @Title: productTank 
 * @Description: TODO(��ӵ�̹�����鼯�ϣ�������λ�õط��Ͳ�ͬ���͵�����) 
 * @param     �趨�ļ� 
 * @return void    �������� 
 * @throws
 */
	public void productTank() {
		setX(ra.nextInt(15) * 40);
		setY(ra.nextInt(11) * 40);
    	diretion = ra.nextInt(4);
    		for (int row = 0; row < 15; row++) {
    			for (int col = 0; col < 15; col++) {
    				if (Map.mapcopy[row][col] == 4 || Map.mapcopy[row][col] == 2) {// 4�ǲݵ�.2�ǿյ�
    					// ������col��Ӧx�ᣬ��row��Ӧy��
    					Rectangle re = new Rectangle(col * 40, row * 40, 40, 40);//�ϰ������
    					if (re.contains(x, y)) {// ���������ɵ������ڲݵػ�յ��ڣ�����ӵ��з�̹�˼�����  
    						for (int type =0; type <Map.tankcopy.length ; type++) {//С��̹�˸������鳤�Ƚ���ѭ��
    							if (Map.tankcopy[type]>0) {
    								switch (type) {
									case 0:
										blood=1;
										power=1;
										break;
									case 1:
										blood=1;
										power=1;
										break;
									case 2:
										blood=2;
										power=2;
										break;
									case 3:
										blood=2;
										power=2;
										break;
									case 4:
										blood=3;
										power=3;
										break;
									}
    								//�����з�̹�˼��Ͼ������Ƿ�����ཻ���о�ֱ�����������������뼯��
    								if (Scence.allEnemytank.size()>0) {
    									for (int i = 0; i < Scence.allEnemytank.size(); i++) {
											EnemyTank et=Scence.allEnemytank.get(i);
											if (this!=et) {
												if (et.getRectangle().intersects(this.x,this.y,40,40)) {
													return;
												}
											}
										}
									}
    								////�����ҷ�̹�˾������Ƿ�����ཻ���о�ֱ�����������������뼯��
    								if (gd.getTank().getRectangle().intersects(this.x,this.y,40,40))  {
    									return;
    								}  						
    							EnemyTank enemy = new EnemyTank(x, y, diretion,type, gd, blood,speed,power);
        				        Map.tankcopy[type] = Map.tankcopy[type] - 1;
        				        Scence.allEnemytank.add(enemy);								
    	           			break;
    					}
						}   																			
							}  						
							}   					   							
							}    					  					
    				}
    			}
    		/**
    		 * 
    		 * * @Title: drawRole 
    		 * @Description: TODO(��ͼ�ط�̹�˵ķ���) 
    		 * @param @param g    �趨�ļ� 
    		 * @return void    �������� 
    		 * @throws
    		 */
	public void drawRole(Graphics g) {
		switch (diretion) {
		case 0://��
			switch (type) {
			case 0://��ɫ̹��
				g.drawImage(ImageDate.white_up, getX(), getY(), 40, 40, null);
				break;
			case 1://��ɫ̹��
				g.drawImage(ImageDate.yellow_up, getX(), getY(), 40, 40, null);
				break;
			case 2://��ɫ̹��
				g.drawImage(ImageDate.green_up, getX(), getY(), 40, 40, null);
				break;
			case 3://��ɫ̹��
				g.drawImage(ImageDate.pc1_up, getX(), getY(), 40, 40, null);
				break;
			case 4://��ɫ̹��
				g.drawImage(ImageDate.red_up, getX(), getY(), 40, 40, null);
				break;
			}
			break;
		case 1://��
			switch (type) {
			case 0:
				g.drawImage(ImageDate.white_right, getX(), getY(), 40, 40, null);
				break;
			case 1:
				g.drawImage(ImageDate.yellow_right, getX(), getY(), 40, 40, null);
				break;
			case 2:
				g.drawImage(ImageDate.green_right, getX(), getY(), 40, 40, null);
				break;
			case 3:
				g.drawImage(ImageDate.pc1_right, getX(), getY(), 40, 40, null);
				break;
			case 4:
				g.drawImage(ImageDate.red_right, getX(), getY(), 40, 40, null);
				break;

			}
			break;
		case 2://��
			switch (type) {
			case 0:
				g.drawImage(ImageDate.white_down, getX(), getY(), 40, 40, null);
				break;
			case 1:
				g.drawImage(ImageDate.yellow_down, getX(), getY(), 40, 40, null);
				break;
			case 2:
				g.drawImage(ImageDate.green_down, getX(), getY(), 40, 40, null);
				break;
			case 3:
				g.drawImage(ImageDate.pc1_down, getX(), getY(), 40, 40, null);
				break;
			case 4:
				g.drawImage(ImageDate.red_down, getX(), getY(), 40, 40, null);

				break;
			}
			break;
		case 3://��
			switch (type) {
			case 0:
				g.drawImage(ImageDate.white_left, getX(), getY(), 40, 40, null);
				break;
			case 1:
				g.drawImage(ImageDate.yellow_left, getX(), getY(), 40, 40, null);
				break;
			case 2:
				g.drawImage(ImageDate.green_left, getX(), getY(), 40, 40, null);
				break;
			case 3:
				g.drawImage(ImageDate.pc1_left, getX(), getY(), 40, 40, null);
				break;
			case 4:
				g.drawImage(ImageDate.red_left, getX(), getY(), 40, 40, null);
				break;
			}
			break;
		}
		Life life=new Life(getX(), getY(),this.blood);
		life.draw(g);
	}
/**
 * 
 * * @Title: getRectangle 
 * @Description: TODO(��þ��ο�) 
 * @param @return    �趨�ļ� 
 * @return Rectangle    �������� 
 * @throws
 */
	public Rectangle getRectangle() {
		   return new Rectangle(this.x, this.y, 40, 40);       
	}
/**
 * 
 * * @Title: hit 
 * @Description: TODO(�ط�̹�˸���ͼ�ϰ���֮�����ײ���) 
 * @param @return    �趨�ļ� 
 * @return boolean    �������� 
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
							Rectangle tankRe=new Rectangle(this.x+1, this.y-speed+1, 39, 39);//��Ͳ���ϵ�̹�˾���
							if (tankRe.intersects(re)) {
								return true;
							}
							break;
						case 1:// ������
							Rectangle tankRe1=new Rectangle(this.x+speed+1, this.y+1, 39,39);//��Ͳ���ҵ�̹�˾���
							if (tankRe1.intersects(re)) {								
								return true;
							}		
							break;
						case 2:// ������
							Rectangle tankRe2=new Rectangle(this.x+1, this.y+speed+1, 39, 39);//��Ͳ���µ�̹�˾���
							if (tankRe2.intersects(re)) {
								return true;
							}
							break;
						case 3:// ������
							Rectangle tankRe3=new Rectangle(this.x-speed+1, this.y+1, 39, 39);//��Ͳ�����̹�˾���
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
/**
 * 
 * * @Title: hitMyTank 
 * @Description: TODO(�ط�̹�˸��ҷ��ϰ���ĵ���ײ���) 
 * @param @return    �趨�ļ� 
 * @return boolean    �������� 
 * @throws
 */
	
	public boolean hitMyTank() {
		switch (this.diretion) {
		case 0:
			Rectangle tankRe=new Rectangle(this.x+1, this.y-speed+1, 39, 39);//��Ͳ���ϵ�̹�˾��α�����
            if (tankRe.intersects(gd.getTank().getRectangle())) {
				return true;

			}
			break;
		case 1:
			Rectangle tankRe1=new Rectangle(this.x+speed+1, this.y+1, 39, 39);//��Ͳ���ҵ�̹�˾��α�����
            if (tankRe1.intersects(gd.getTank().getRectangle())) {
			return true;
			}
			break;
		case 2:
			Rectangle tankRe2=new Rectangle(this.x+1, this.y+speed+1, 39,39);//��Ͳ���µ�̹�˾��α�����
              if (tankRe2.intersects(gd.getTank().getRectangle())) {
					return true;

			}
			break;
		case 3:
			Rectangle tankRe3=new Rectangle(this.x-speed+1, this.y+1, 39, 39);//��Ͳ�����̹�˾��α�����
               if (tankRe3.intersects(gd.getTank().getRectangle())) {
					return true;
			}
			break;

		}
		
		return false;
		
		
	}
	/**
	 * 
	 * * @Title: tankHit 
	 * @Description: TODO(�з�̹��֮�����ײ���) 
	 * @param @return    �趨�ļ� 
	 * @return boolean    �������� 
	 * @throws
	 */
	public boolean tankHit() {
		for (int i = 0; i < Scence.allEnemytank.size(); i++) {
			EnemyTank t = Scence.allEnemytank.get(i);// ��ȡ̹�˶���
			if (this != t) {// ����������̹�˶�����ͬһ���Ļ�
					switch (this.diretion) {
					case 0:// ������
						Rectangle tankRe=new Rectangle(this.x+1, this.y-speed+1, 39, 39);//��Ͳ���ϵ�̹�˾��α�����
						Rectangle tankRe1=new Rectangle(t.getX(), t.getY(), 40, 40);//̹�˾���̹�˶���
						if (tankRe.intersects(tankRe1)) {
							return true;
						}
						break;
					case 1:// ������
						Rectangle tankRe2=new Rectangle(this.x+speed+1, this.y+1, 39, 39);//��Ͳ���ҵ�̹�˾��α�����
						Rectangle tankRe3=new Rectangle(t.getX(), t.getY(), 40, 40);//̹�˾���̹�˶���
						if (tankRe2.intersects(tankRe3)) {								
							return true;
						}		
						break;
					case 2:// ������
						Rectangle tankRe4=new Rectangle(this.x+1, this.y+speed+1, 39,39);//��Ͳ���µ�̹�˾��α�����
						Rectangle tankRe5=new Rectangle(t.getX(), t.getY(), 40, 40);//̹�˾���̹�˶���						
						if (tankRe4.intersects(tankRe5)) {
							return true;
						}
						break;
					case 3:// ������
						Rectangle tankRe6=new Rectangle(this.x-speed+1, this.y+1, 39, 39);//��Ͳ�����̹�˾��α�����
						Rectangle tankRe7=new Rectangle(t.getX(), t.getY(), 40, 40);//̹�˾���̹�˶���						
						if (tankRe6.intersects(tankRe7)) {						
							return true;
						}				
						break;
					}
				}
			}
		return false;
		}
	
	/**
	 * 
	 * * @Title: move 
	 * @Description: TODO(�з�̹�˵��ƶ�����) 
	 * @param     �趨�ļ� 
	 * @return void    �������� 
	 * @throws
	 */

	public void move() {
		switch (diretion) {
		case 0:// ����
			if(hit()||tankHit()||y<0||hitMyTank()){
				diretion = ra.nextInt(3) + 1;	//�����0
			}else{
				image = ImageDate.pc1_up;	
				setY(getY() - getSpeed());
			}
			
			break;
		case 1:// ����
			if(hit()||tankHit()||x> 600-40||hitMyTank()){
				int []num={0,2,3};
				int index=ra.nextInt(3);
				diretion = num[index] ;//�����1	
			}else{
				setX(getX() + getSpeed());
			}
			break;
		case 2:// ����
			if(hit()||tankHit()||y> 600-40||hitMyTank()){
				int []num={0,1,3};
				int index=ra.nextInt(3);
				diretion = num[index] ;//�����2	
			}else{
				setY(getY() + getSpeed());
			}
			break;
		case 3:// ����
			if(hit()||tankHit()||x< 0||hitMyTank()){
				int []num={0,1,2};
				int index=ra.nextInt(3);
				diretion = num[index] ;//�����3
				}else{
				setX(getX() - getSpeed());
			}
			break;
		}	
		if (step == 0) {
			step = ra.nextInt(20) + 10; // �������·��
			diretion = ra.nextInt(4); // �����������
		}
		step--;
	}
/**
 * 
 * * @Title: fire 
 * @Description: TODO(�з�̹�˵Ŀ���) 
 * @param     �趨�ļ� 
 * @return void    �������� 
 * @throws
 */
	public void fire() {
		int rnum = ra.nextInt(100);// �������������Χ��0-99
		if (rnum <20) {// ��������С��20ʵ�п���
			if (diretion == 0) {
				Bullet bullet = new Bullet(this.getX() + 15, this.getY(), diretion,camp,this.gd,power,bulletspeed);
			Scence.allbullet.add(bullet);
			} else if (diretion == 1) {
				Bullet bullet = new Bullet(this.getX() + 40, this.getY() + 15, diretion,camp,this.gd,power,bulletspeed);
				Scence.allbullet.add(bullet);
			} else if (diretion == 2) {
				Bullet bullet = new Bullet(this.getX() + 15, this.getY() + 40, diretion,camp,this.gd,power,bulletspeed);
				Scence.allbullet.add(bullet);
			} else if (diretion == 3) {
				Bullet bullet = new Bullet(this.getX(), this.getY() + 15, diretion,camp,this.gd,power,bulletspeed);
				Scence.allbullet.add(bullet);
			}

		}

	}
	//----------------------set��get������-----------------------------

	public int getCamp() {
		return camp;
	}

	public void setCamp(int camp) {
		this.camp = camp;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getBlood() {
		return blood;
	}

	public void setBlood(int blood) {
		this.blood = blood;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDiretion() {
		return diretion;
	}

	public void setDiretion(int diretion) {
		this.diretion = diretion;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getHitcount() {
		return hitcount;
	}

	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
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
