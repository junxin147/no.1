package control;

import model.BaseTank;
import model.Bullet;
import model.Data;
import model.EnemyTank;
import model.Items;
import model.MusicPlay;
import model.Scence;
import model.User;
import view.Ui;

public class GameDir {
	public MusicPlay  gamebutton = new MusicPlay("music/gamebutton.wav"); //游戏按钮音效
	public MusicPlay  bk = new MusicPlay("music/bk.wav");//背景音乐
	public MusicPlay  defeat = new MusicPlay("music/defeat.wav");//失败音效
	public MusicPlay ok = new MusicPlay("music/ok.wav");//确定按钮声音
	public MusicPlay bullet = new MusicPlay("music/zidan.wav");//发射子弹
	public MusicPlay bk2 = new MusicPlay("music/bk2.wav");//
	public MusicPlay victory2 = new MusicPlay("music/victory2.wav");//胜利音效
	public MusicPlay victory = new MusicPlay("music/victory.wav");
	public MusicPlay mymove = new MusicPlay("music/mymove.wav");
	public MusicPlay hitiron = new MusicPlay("music/hitiron.wav");//子弹碰撞到铁块音效
	public MusicPlay relive = new MusicPlay("music/relive.wav");
	private EnemyTank enemyTank=new EnemyTank(this);
	private BaseTank tank=new BaseTank(this);//坦克类实例化优先于在UI绘制前！放后面有时候会出错也会正常。	
	private Scence scence=new Scence();
	private Items item=new Items(this);
	private MyTimer timer=new MyTimer(this);
	private Ui ui=new Ui(this);
	private User user;
	
	public GameDir() {
		bk.play(0);	//背景音效
		ui.showlogin();
		// 画敌方坦克
		if (Scence.allEnemytank.size() < 10) {
			timer.getPcProduceTime().start();

		}
		timer.getPcMoveTime().start();
		timer.getPcFireTime().start();
		timer.getMoveTime().start();// 子弹移动定时器
		timer.getItemProduceTime().start();
		timer.getBombtime().start();
	}   
	
	//----------------------set和get方法区-----------------------------
	
	public BaseTank getTank() {
		return tank;
	}

	public void setTank(BaseTank tank) {
		this.tank = tank;
	}





	public MyTimer getTimer() {
		return timer;
	}
	public void setTimer(MyTimer timer) {
		this.timer = timer;
	}
	public Ui getUi() {
		return ui;
	}

	public void setUi(Ui ui) {
		this.ui = ui;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Scence getScence() {
		return scence;
	}
	public void setScence(Scence scence) {
		this.scence = scence;
	}
	public EnemyTank getEnemyTank() {
		return enemyTank;
	}
	public void setEnemyTank(EnemyTank enemyTank) {
		this.enemyTank = enemyTank;
	}
	public Items getItem() {
		return item;
	}
	public void setItem(Items item) {
		this.item = item;
	}
	
	
	
	
	
}
