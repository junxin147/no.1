package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

import control.GameDir;
import control.MyKeyAdapter;
import control.MyKeyAdapter1;
import model.Bomb;
import model.ImageDate;
import model.Map;
import model.Scence;

/**
 * 
 * @ClassName: GamePanel
 * @Description: TODO(游戏面板)
 * @author
 *
 */
public class GamePanel extends JPanel {

	private Map map = new Map();
	private MyKeyAdapter keylis;
	private MyKeyAdapter1 keylis1;

	private GameDir gd;

	public GamePanel(GameDir gd) {
		keylis1 = new MyKeyAdapter1(gd);
		keylis = new MyKeyAdapter(gd);
		this.gd = gd;
		this.setPreferredSize(new Dimension(600, 600));
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		this.addKeyListener(keylis);
		this.addKeyListener(keylis1);
		// 设置面板可聚焦
		this.setFocusable(true);
		// 请求焦点
		this.requestFocus();
	

	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		// gd.getTimer().getPcMoveTime().start();
		// gd.getTimer().getPcFireTime().start();
		// 画我方坦克
		gd.getTank().drawRole(g);
		// 画敌方坦克
	
		for (int i = 0; i < Scence.allEnemytank.size(); i++) {
			Scence.allEnemytank.get(i).drawRole(g);

		}
		
		// 画地图
		gd.getScence().drawMap(g);
		// 画我方坦克
	    gd.getTank().drawRole(g);
	    // 画敌方坦克
	    for (int i = 0; i < Scence.allEnemytank.size(); i++) {
					Scence.allEnemytank.get(i).drawRole(g);
				}
	    if(Scence.allEnemytank.size()<10) {
	    	gd.getTimer().getPcProduceTime().start();
		}
	    if (Scence.allEnemytank.size() == 10) {
			gd.getTimer().getPcProduceTime().stop();
		}
		// 画子弹
		for (int j = 0; j < Scence.allbullet.size(); j++) {
			Scence.allbullet.get(j).drawRole(g);
		}
		// 画道具生成
		gd.getTimer().getItemProduceTime().start();
		for (int i = 0; i < Scence.allitem.size(); i++) {
			Scence.allitem.get(i).drawRole(g);
		}
		for (int i = 0; i < Scence.allitem.size(); i++) {
			gd.getTimer().getItemremoveTime().start();
		}
		if (Scence.allitem.size() == 0) {
			gd.getTimer().getItemremoveTime().stop();
		}
	for (int i = 0; i < Scence.allbomb.size(); i++) {
		Scence.allbomb.get(i).paintComponent(g);
	}
	if (Map.mapcopy[13][6]==3||Map.mapcopy[13][7]==3||Map.mapcopy[13][8]==3||Map.mapcopy[14][6]==3||Map.mapcopy[14][8]==3) {
		gd.getTimer().getSteelremoveTime().stop();//定时关闭碉堡变红砖计时器
		}
		pass();
		endLevel();
		this.repaint();
	}

	/**
	 * 
	 * * @Title: pass @Description: TODO(进入下一关地图，并初始化相关信息) @param 设定文件 @return
	 * void 返回类型 @throws
	 */
	public void pass() {
		if (gd.getTank().getHitcount() == 20 && gd.getScence().getLevel() < 8) {
			gd.getScence().setLevel(gd.getScence().getLevel() + 1);// 关卡+1
			gd.getScence().getMap().backupMap(gd.getScence().getLevel());// 使用备份地图
			gd.getScence().getMap().backupTank(gd.getScence().getLevel());// 使用备份坦克数组
			gd.getTimer().allStop();																
            gd.victory.play(1);//过关胜利条件
			// 初始化信息面板的坦克信息
			gd.getUi().getGameframe().getGameinfo().getWhitetankinfo1().setText("X" + Map.tankcopy1[0]);
			gd.getUi().getGameframe().getGameinfo().getYellowtankinfo1().setText("X" + Map.tankcopy1[1]);
			gd.getUi().getGameframe().getGameinfo().getGreentankinfo1().setText("X" + Map.tankcopy1[2]);
			gd.getUi().getGameframe().getGameinfo().getBluetankinfo1().setText("X" + Map.tankcopy1[3]);
			gd.getUi().getGameframe().getGameinfo().getRedtankinfo1().setText("X" + Map.tankcopy1[4]);
			gd.getTank().setHitcount(0);// 该关击毁数量初始化0
			gd.getUi().getGameframe().getGameinfo().getDestroyinfo().setText("该关击毁坦克：" + gd.getTank().getHitcount());
			gd.getTank().setScore(0);
			gd.getUi().getGameframe().getGameinfo().getScoreinfo().setText("该关得分：" + gd.getTank().getScore());
			
			// 初始化坦克
			gd.getTank().setPower(1);
			gd.getTank().setX(200);
			gd.getTank().setY(560);
			gd.getTank().setDiretion(0);
			gd.getTank().setImage(ImageDate.player1_up);
			// 初始化集合
			Scence.allbullet.clear();
			Scence.allEnemytank.clear();
			Scence.allitem.clear();
			gd.getUi().getFinishDialog().setVisible(true);
			gd.getUi().getFinishDialog().setAlwaysOnTop(true);
			gd.getUi().getSettingJDialog().setVisible(false);
			gd.getUi().getInputframe().setVisible(false);
			gd.getUi().getGameframe().setVisible(true);
			gd.getTimer().allStop();																

		}
	}

	/**
	 * 
	 * * @Title: reset @Description: TODO(重置地图) @param 设定文件 @return void
	 * 返回类型 @throws
	 */
	public void reset() {
		gd.getTimer().getFireTime().stop();
		gd.getTimer().getMovingTime().stop();
        
		gd.getScence().setLevel(gd.getScence().getLevel());
		gd.getScence().getMap().backupMap(gd.getScence().getLevel());// 使用备份地图
		gd.getScence().getMap().backupTank(gd.getScence().getLevel());// 使用备份坦克 数组
		// 初始化信息面板的坦克信息
		gd.getUi().getGameframe().getGameinfo().getWhitetankinfo1().setText("X" + Map.tankcopy1[0]);
		gd.getUi().getGameframe().getGameinfo().getYellowtankinfo1().setText("X" + Map.tankcopy1[1]);
		gd.getUi().getGameframe().getGameinfo().getGreentankinfo1().setText("X" + Map.tankcopy1[2]);
		gd.getUi().getGameframe().getGameinfo().getBluetankinfo1().setText("X" + Map.tankcopy1[3]);
		gd.getUi().getGameframe().getGameinfo().getRedtankinfo1().setText("X" + Map.tankcopy1[4]);
		gd.getTank().setHitcount(0);// 该关击毁数量初始化0
		gd.getUi().getGameframe().getGameinfo().getDestroyinfo().setText("该关击毁坦克：" + gd.getTank().getHitcount());
		gd.getTank().setScore(0);
		gd.getUi().getGameframe().getGameinfo().getScoreinfo().setText("该关得分：" + gd.getTank().getScore());
		gd.getEnemyTank().setScore(0);
		 gd.getUi().getFinishDialog().getFinish().getAllscoreinfo().setText("总共得分："+(gd.getEnemyTank().getScore()));
		gd.getEnemyTank().setHitcount(0);
		 gd.getUi().getFinishDialog().getFinish().getAlldestroyinfo().setText("总共击毁坦克："+gd.getEnemyTank().getHitcount());
		 gd.getTank().setHitwhite(0);
		 gd.getUi().getFinishDialog().getFinish().getWhitetankinfo1().setText("X"+gd.getTank().getHitwhite()+"     X100="+gd.getTank().getHitwhite()*100);
		 gd.getTank().setHityellow(0);
		 gd.getUi().getFinishDialog().getFinish().getYellowtankinfo1().setText("X"+gd.getTank().getHityellow()+"     X200="+gd.getTank().getHityellow()*200);
		 gd.getTank().setHitgreen(0);
		 gd.getUi().getFinishDialog().getFinish().getGreentankinfo1().setText("X"+gd.getTank().getHitgreen()+"     X200="+gd.getTank().getHitgreen()*200);
		 gd.getTank().setHitblue(0);
		 gd.getUi().getFinishDialog().getFinish().getBluetankinfo1().setText("X"+gd.getTank().getHitblue()+"     X300="+gd.getTank().getHitblue()*300);
		 gd.getTank().setHitred(0);
		 gd.getUi().getFinishDialog().getFinish().getRedtankinfo1().setText("X"+gd.getTank().getHitred()+"     X500="+gd.getTank().getHitred()*500);
		 // 初始化坦克
		gd.getTank().setPower(1);
		gd.getTank().setX(200);
		gd.getTank().setY(560);
		gd.getTank().setDiretion(0);
		gd.getTank().setImage(ImageDate.player1_up);
		gd.getTank().setBlood(3);
		gd.getTank().setHp(3);
		// 初始化集合
		Scence.allbullet.clear();
		Scence.allEnemytank.clear();
		Scence.allitem.clear();

		gd.getUi().getSettingJDialog().setVisible(false);
		gd.getUi().getInputframe().setVisible(false);
		gd.getUi().getGameframe().setVisible(true);
	}
/**
 * 
 * * @Title: reset1 
 * @Description: TODO(//不清除结算界面总共击毁关数信息.并重置地图) 
 * @param     设定文件 
 * @return void    返回类型 
 * @throws
 */
	public void reset1() {//不清除总共击毁关数信息
		gd.getTimer().getFireTime().stop();
		gd.getTimer().getMovingTime().stop();
		gd.getScence().setLevel(gd.getScence().getLevel());
		gd.getScence().getMap().backupMap(gd.getScence().getLevel());// 使用备份地图
		gd.getScence().getMap().backupTank(gd.getScence().getLevel());// 使用备份坦克 数组
		// 初始化信息面板的坦克信息
		gd.getUi().getGameframe().getGameinfo().getWhitetankinfo1().setText("X" + Map.tankcopy1[0]);
		gd.getUi().getGameframe().getGameinfo().getYellowtankinfo1().setText("X" + Map.tankcopy1[1]);
		gd.getUi().getGameframe().getGameinfo().getGreentankinfo1().setText("X" + Map.tankcopy1[2]);
		gd.getUi().getGameframe().getGameinfo().getBluetankinfo1().setText("X" + Map.tankcopy1[3]);
		gd.getUi().getGameframe().getGameinfo().getRedtankinfo1().setText("X" + Map.tankcopy1[4]);
		gd.getTank().setHitcount(0);// 该关击毁数量初始化0
		gd.getUi().getGameframe().getGameinfo().getDestroyinfo().setText("该关击毁坦克：" + gd.getTank().getHitcount());
		gd.getTank().setScore(0);
		gd.getUi().getGameframe().getGameinfo().getScoreinfo().setText("该关得分：" + gd.getTank().getScore());
		// 初始化坦克
		gd.getTank().setPower(1);
		gd.getTank().setX(200);
		gd.getTank().setY(560);
		gd.getTank().setDiretion(0);
		gd.getTank().setImage(ImageDate.player1_up);
		gd.getTank().setBlood(3);
		gd.getTank().setHp(3);
		// 初始化集合
		Scence.allbullet.clear();
		Scence.allEnemytank.clear();
		Scence.allitem.clear();

		gd.getUi().getSettingJDialog().setVisible(false);
		gd.getUi().getInputframe().setVisible(false);
		gd.getUi().getGameframe().setVisible(true);
	}
	public void endLevel() {
		if (gd.getTank().getHitcount() == 20 && gd.getScence().getLevel() == 8) {
			gd.victory2.play(0);
			gd.getUi().getFinishDialog().setVisible(true);
			gd.getUi().getFinishDialog().setAlwaysOnTop(true);
			gd.getUi().getGameframe().dispose();
			gd.getUi().getGameframe().getGamepanel().reset1();
			gd.getUi().getInputframe().setVisible(true);
		}
	}
	// ----------------------set和get方法区-----------------------------

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public MyKeyAdapter getKeylis() {
		return keylis;
	}

	public void setKeylis(MyKeyAdapter keylis) {
		this.keylis = keylis;
	}

	public GameDir getGd() {
		return gd;
	}

	public void setGd(GameDir gd) {
		this.gd = gd;
	}

}
