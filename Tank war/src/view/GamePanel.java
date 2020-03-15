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
 * @Description: TODO(��Ϸ���)
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
		// �������ɾ۽�
		this.setFocusable(true);
		// ���󽹵�
		this.requestFocus();
	

	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		// gd.getTimer().getPcMoveTime().start();
		// gd.getTimer().getPcFireTime().start();
		// ���ҷ�̹��
		gd.getTank().drawRole(g);
		// ���з�̹��
	
		for (int i = 0; i < Scence.allEnemytank.size(); i++) {
			Scence.allEnemytank.get(i).drawRole(g);

		}
		
		// ����ͼ
		gd.getScence().drawMap(g);
		// ���ҷ�̹��
	    gd.getTank().drawRole(g);
	    // ���з�̹��
	    for (int i = 0; i < Scence.allEnemytank.size(); i++) {
					Scence.allEnemytank.get(i).drawRole(g);
				}
	    if(Scence.allEnemytank.size()<10) {
	    	gd.getTimer().getPcProduceTime().start();
		}
	    if (Scence.allEnemytank.size() == 10) {
			gd.getTimer().getPcProduceTime().stop();
		}
		// ���ӵ�
		for (int j = 0; j < Scence.allbullet.size(); j++) {
			Scence.allbullet.get(j).drawRole(g);
		}
		// ����������
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
		gd.getTimer().getSteelremoveTime().stop();//��ʱ�رյﱤ���ש��ʱ��
		}
		pass();
		endLevel();
		this.repaint();
	}

	/**
	 * 
	 * * @Title: pass @Description: TODO(������һ�ص�ͼ������ʼ�������Ϣ) @param �趨�ļ� @return
	 * void �������� @throws
	 */
	public void pass() {
		if (gd.getTank().getHitcount() == 20 && gd.getScence().getLevel() < 8) {
			gd.getScence().setLevel(gd.getScence().getLevel() + 1);// �ؿ�+1
			gd.getScence().getMap().backupMap(gd.getScence().getLevel());// ʹ�ñ��ݵ�ͼ
			gd.getScence().getMap().backupTank(gd.getScence().getLevel());// ʹ�ñ���̹������
			gd.getTimer().allStop();																
            gd.victory.play(1);//����ʤ������
			// ��ʼ����Ϣ����̹����Ϣ
			gd.getUi().getGameframe().getGameinfo().getWhitetankinfo1().setText("X" + Map.tankcopy1[0]);
			gd.getUi().getGameframe().getGameinfo().getYellowtankinfo1().setText("X" + Map.tankcopy1[1]);
			gd.getUi().getGameframe().getGameinfo().getGreentankinfo1().setText("X" + Map.tankcopy1[2]);
			gd.getUi().getGameframe().getGameinfo().getBluetankinfo1().setText("X" + Map.tankcopy1[3]);
			gd.getUi().getGameframe().getGameinfo().getRedtankinfo1().setText("X" + Map.tankcopy1[4]);
			gd.getTank().setHitcount(0);// �ùػ���������ʼ��0
			gd.getUi().getGameframe().getGameinfo().getDestroyinfo().setText("�ùػ���̹�ˣ�" + gd.getTank().getHitcount());
			gd.getTank().setScore(0);
			gd.getUi().getGameframe().getGameinfo().getScoreinfo().setText("�ùص÷֣�" + gd.getTank().getScore());
			
			// ��ʼ��̹��
			gd.getTank().setPower(1);
			gd.getTank().setX(200);
			gd.getTank().setY(560);
			gd.getTank().setDiretion(0);
			gd.getTank().setImage(ImageDate.player1_up);
			// ��ʼ������
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
	 * * @Title: reset @Description: TODO(���õ�ͼ) @param �趨�ļ� @return void
	 * �������� @throws
	 */
	public void reset() {
		gd.getTimer().getFireTime().stop();
		gd.getTimer().getMovingTime().stop();
        
		gd.getScence().setLevel(gd.getScence().getLevel());
		gd.getScence().getMap().backupMap(gd.getScence().getLevel());// ʹ�ñ��ݵ�ͼ
		gd.getScence().getMap().backupTank(gd.getScence().getLevel());// ʹ�ñ���̹�� ����
		// ��ʼ����Ϣ����̹����Ϣ
		gd.getUi().getGameframe().getGameinfo().getWhitetankinfo1().setText("X" + Map.tankcopy1[0]);
		gd.getUi().getGameframe().getGameinfo().getYellowtankinfo1().setText("X" + Map.tankcopy1[1]);
		gd.getUi().getGameframe().getGameinfo().getGreentankinfo1().setText("X" + Map.tankcopy1[2]);
		gd.getUi().getGameframe().getGameinfo().getBluetankinfo1().setText("X" + Map.tankcopy1[3]);
		gd.getUi().getGameframe().getGameinfo().getRedtankinfo1().setText("X" + Map.tankcopy1[4]);
		gd.getTank().setHitcount(0);// �ùػ���������ʼ��0
		gd.getUi().getGameframe().getGameinfo().getDestroyinfo().setText("�ùػ���̹�ˣ�" + gd.getTank().getHitcount());
		gd.getTank().setScore(0);
		gd.getUi().getGameframe().getGameinfo().getScoreinfo().setText("�ùص÷֣�" + gd.getTank().getScore());
		gd.getEnemyTank().setScore(0);
		 gd.getUi().getFinishDialog().getFinish().getAllscoreinfo().setText("�ܹ��÷֣�"+(gd.getEnemyTank().getScore()));
		gd.getEnemyTank().setHitcount(0);
		 gd.getUi().getFinishDialog().getFinish().getAlldestroyinfo().setText("�ܹ�����̹�ˣ�"+gd.getEnemyTank().getHitcount());
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
		 // ��ʼ��̹��
		gd.getTank().setPower(1);
		gd.getTank().setX(200);
		gd.getTank().setY(560);
		gd.getTank().setDiretion(0);
		gd.getTank().setImage(ImageDate.player1_up);
		gd.getTank().setBlood(3);
		gd.getTank().setHp(3);
		// ��ʼ������
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
 * @Description: TODO(//�������������ܹ����ٹ�����Ϣ.�����õ�ͼ) 
 * @param     �趨�ļ� 
 * @return void    �������� 
 * @throws
 */
	public void reset1() {//������ܹ����ٹ�����Ϣ
		gd.getTimer().getFireTime().stop();
		gd.getTimer().getMovingTime().stop();
		gd.getScence().setLevel(gd.getScence().getLevel());
		gd.getScence().getMap().backupMap(gd.getScence().getLevel());// ʹ�ñ��ݵ�ͼ
		gd.getScence().getMap().backupTank(gd.getScence().getLevel());// ʹ�ñ���̹�� ����
		// ��ʼ����Ϣ����̹����Ϣ
		gd.getUi().getGameframe().getGameinfo().getWhitetankinfo1().setText("X" + Map.tankcopy1[0]);
		gd.getUi().getGameframe().getGameinfo().getYellowtankinfo1().setText("X" + Map.tankcopy1[1]);
		gd.getUi().getGameframe().getGameinfo().getGreentankinfo1().setText("X" + Map.tankcopy1[2]);
		gd.getUi().getGameframe().getGameinfo().getBluetankinfo1().setText("X" + Map.tankcopy1[3]);
		gd.getUi().getGameframe().getGameinfo().getRedtankinfo1().setText("X" + Map.tankcopy1[4]);
		gd.getTank().setHitcount(0);// �ùػ���������ʼ��0
		gd.getUi().getGameframe().getGameinfo().getDestroyinfo().setText("�ùػ���̹�ˣ�" + gd.getTank().getHitcount());
		gd.getTank().setScore(0);
		gd.getUi().getGameframe().getGameinfo().getScoreinfo().setText("�ùص÷֣�" + gd.getTank().getScore());
		// ��ʼ��̹��
		gd.getTank().setPower(1);
		gd.getTank().setX(200);
		gd.getTank().setY(560);
		gd.getTank().setDiretion(0);
		gd.getTank().setImage(ImageDate.player1_up);
		gd.getTank().setBlood(3);
		gd.getTank().setHp(3);
		// ��ʼ������
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
	// ----------------------set��get������-----------------------------

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
