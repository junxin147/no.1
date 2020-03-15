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
	private int x ;// 所在游戏面板的横坐标
	private int y ;// 所在游戏面板的纵坐标
	private int camp=1;//1为敌方坦克
	private int type;//0为白1为黄2为绿3为蓝4为红
	private int score;//白为100分，黄为200分，绿为200分，蓝为300分，红为400分
	private int hitcount;//被击毁数量
	private int blood;//敌方坦克血量
	public Random ra = new Random();
	private int power=1;//攻击力
	private int diretion;// 0代表向上，1代表向右，2代表向下，3代表向左
	private int speed = 3;//移动速度
	private int bulletspeed =10;//子弹移动速度
	private int step = ra.nextInt(12) + 5;//随机路径
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
 * @Description: TODO(添加到坦克数组集合，并限制位置地方和不同类型的数量) 
 * @param     设定文件 
 * @return void    返回类型 
 * @throws
 */
	public void productTank() {
		setX(ra.nextInt(15) * 40);
		setY(ra.nextInt(11) * 40);
    	diretion = ra.nextInt(4);
    		for (int row = 0; row < 15; row++) {
    			for (int col = 0; col < 15; col++) {
    				if (Map.mapcopy[row][col] == 4 || Map.mapcopy[row][col] == 2) {// 4是草地.2是空地
    					// 数组列col对应x轴，行row对应y轴
    					Rectangle re = new Rectangle(col * 40, row * 40, 40, 40);//障碍物矩形
    					if (re.contains(x, y)) {// 如果随机生成的坐标在草地或空地内，则添加到敌方坦克集合内  
    						for (int type =0; type <Map.tankcopy.length ; type++) {//小于坦克复制数组长度进行循环
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
    								//检测跟敌方坦克集合经过是是否出现相交，有就直接跳出方法，不加入集合
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
    								////检测跟我方坦克经过是是否出现相交，有就直接跳出方法，不加入集合
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
    		 * @Description: TODO(画图地方坦克的方法) 
    		 * @param @param g    设定文件 
    		 * @return void    返回类型 
    		 * @throws
    		 */
	public void drawRole(Graphics g) {
		switch (diretion) {
		case 0://上
			switch (type) {
			case 0://白色坦克
				g.drawImage(ImageDate.white_up, getX(), getY(), 40, 40, null);
				break;
			case 1://黄色坦克
				g.drawImage(ImageDate.yellow_up, getX(), getY(), 40, 40, null);
				break;
			case 2://绿色坦克
				g.drawImage(ImageDate.green_up, getX(), getY(), 40, 40, null);
				break;
			case 3://蓝色坦克
				g.drawImage(ImageDate.pc1_up, getX(), getY(), 40, 40, null);
				break;
			case 4://红色坦克
				g.drawImage(ImageDate.red_up, getX(), getY(), 40, 40, null);
				break;
			}
			break;
		case 1://右
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
		case 2://下
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
		case 3://左
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
 * @Description: TODO(获得矩形框) 
 * @param @return    设定文件 
 * @return Rectangle    返回类型 
 * @throws
 */
	public Rectangle getRectangle() {
		   return new Rectangle(this.x, this.y, 40, 40);       
	}
/**
 * 
 * * @Title: hit 
 * @Description: TODO(地方坦克跟地图障碍物之间的碰撞检测) 
 * @param @return    设定文件 
 * @return boolean    返回类型 
 * @throws
 */
	public boolean hit() {
		for (int row = 0; row < 15; row++) {
			for (int col = 0; col < 15; col++) {
				if (Map.mapcopy[row][col] == 3 || Map.mapcopy[row][col] == 0 || Map.mapcopy[row][col] == 1
						|| Map.mapcopy[row][col] == 5) {
					// 数组列col对应x轴，行row对应y轴
					Rectangle re = new Rectangle(col * 40, row * 40, 40, 40);//障碍物矩形
						switch (diretion) {
						case 0:// 方向上
							Rectangle tankRe=new Rectangle(this.x+1, this.y-speed+1, 39, 39);//炮筒朝上的坦克矩形
							if (tankRe.intersects(re)) {
								return true;
							}
							break;
						case 1:// 方向右
							Rectangle tankRe1=new Rectangle(this.x+speed+1, this.y+1, 39,39);//炮筒朝右的坦克矩形
							if (tankRe1.intersects(re)) {								
								return true;
							}		
							break;
						case 2:// 方向下
							Rectangle tankRe2=new Rectangle(this.x+1, this.y+speed+1, 39, 39);//炮筒朝下的坦克矩形
							if (tankRe2.intersects(re)) {
								return true;
							}
							break;
						case 3:// 方向左
							Rectangle tankRe3=new Rectangle(this.x-speed+1, this.y+1, 39, 39);//炮筒朝左的坦克矩形
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
 * @Description: TODO(地方坦克跟我方障碍物的的碰撞检测) 
 * @param @return    设定文件 
 * @return boolean    返回类型 
 * @throws
 */
	
	public boolean hitMyTank() {
		switch (this.diretion) {
		case 0:
			Rectangle tankRe=new Rectangle(this.x+1, this.y-speed+1, 39, 39);//炮筒朝上的坦克矩形本对象
            if (tankRe.intersects(gd.getTank().getRectangle())) {
				return true;

			}
			break;
		case 1:
			Rectangle tankRe1=new Rectangle(this.x+speed+1, this.y+1, 39, 39);//炮筒朝右的坦克矩形本对象
            if (tankRe1.intersects(gd.getTank().getRectangle())) {
			return true;
			}
			break;
		case 2:
			Rectangle tankRe2=new Rectangle(this.x+1, this.y+speed+1, 39,39);//炮筒朝下的坦克矩形本对象
              if (tankRe2.intersects(gd.getTank().getRectangle())) {
					return true;

			}
			break;
		case 3:
			Rectangle tankRe3=new Rectangle(this.x-speed+1, this.y+1, 39, 39);//炮筒朝左的坦克矩形本对象
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
	 * @Description: TODO(敌方坦克之间的碰撞检测) 
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public boolean tankHit() {
		for (int i = 0; i < Scence.allEnemytank.size(); i++) {
			EnemyTank t = Scence.allEnemytank.get(i);// 获取坦克对象
			if (this != t) {// 如果本对象跟坦克对象不是同一个的话
					switch (this.diretion) {
					case 0:// 方向上
						Rectangle tankRe=new Rectangle(this.x+1, this.y-speed+1, 39, 39);//炮筒朝上的坦克矩形本对象
						Rectangle tankRe1=new Rectangle(t.getX(), t.getY(), 40, 40);//坦克矩形坦克对象
						if (tankRe.intersects(tankRe1)) {
							return true;
						}
						break;
					case 1:// 方向右
						Rectangle tankRe2=new Rectangle(this.x+speed+1, this.y+1, 39, 39);//炮筒朝右的坦克矩形本对象
						Rectangle tankRe3=new Rectangle(t.getX(), t.getY(), 40, 40);//坦克矩形坦克对象
						if (tankRe2.intersects(tankRe3)) {								
							return true;
						}		
						break;
					case 2:// 方向下
						Rectangle tankRe4=new Rectangle(this.x+1, this.y+speed+1, 39,39);//炮筒朝下的坦克矩形本对象
						Rectangle tankRe5=new Rectangle(t.getX(), t.getY(), 40, 40);//坦克矩形坦克对象						
						if (tankRe4.intersects(tankRe5)) {
							return true;
						}
						break;
					case 3:// 方向左
						Rectangle tankRe6=new Rectangle(this.x-speed+1, this.y+1, 39, 39);//炮筒朝左的坦克矩形本对象
						Rectangle tankRe7=new Rectangle(t.getX(), t.getY(), 40, 40);//坦克矩形坦克对象						
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
	 * @Description: TODO(敌方坦克的移动方法) 
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */

	public void move() {
		switch (diretion) {
		case 0:// 向上
			if(hit()||tankHit()||y<0||hitMyTank()){
				diretion = ra.nextInt(3) + 1;	//不获得0
			}else{
				image = ImageDate.pc1_up;	
				setY(getY() - getSpeed());
			}
			
			break;
		case 1:// 向右
			if(hit()||tankHit()||x> 600-40||hitMyTank()){
				int []num={0,2,3};
				int index=ra.nextInt(3);
				diretion = num[index] ;//不获得1	
			}else{
				setX(getX() + getSpeed());
			}
			break;
		case 2:// 向下
			if(hit()||tankHit()||y> 600-40||hitMyTank()){
				int []num={0,1,3};
				int index=ra.nextInt(3);
				diretion = num[index] ;//不获得2	
			}else{
				setY(getY() + getSpeed());
			}
			break;
		case 3:// 向左
			if(hit()||tankHit()||x< 0||hitMyTank()){
				int []num={0,1,2};
				int index=ra.nextInt(3);
				diretion = num[index] ;//不获得3
				}else{
				setX(getX() - getSpeed());
			}
			break;
		}	
		if (step == 0) {
			step = ra.nextInt(20) + 10; // 产生随机路径
			diretion = ra.nextInt(4); // 产生随机方向
		}
		step--;
	}
/**
 * 
 * * @Title: fire 
 * @Description: TODO(敌方坦克的开火) 
 * @param     设定文件 
 * @return void    返回类型 
 * @throws
 */
	public void fire() {
		int rnum = ra.nextInt(100);// 创建随机数，范围在0-99
		if (rnum <20) {// 如果随机数小于20实行开火
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
	//----------------------set和get方法区-----------------------------

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
