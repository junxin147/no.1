package control;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.Timer;

import model.EnemyTank;
import model.Map;
import model.Scence;

public class MyTimer {
	private GameDir gd;
	public MyTimer(GameDir gd) {
		this.gd=gd;
		// TODO Auto-generated constructor stub
	}
	private ActionListener boom = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {	
              for (int i = 0; i <Scence.allbomb.size(); i++) {
            	  Scence.allbomb.get(i).drawRole();
            	  if (	  Scence.allbomb.get(i).getBombNum()==0) {
            		  Scence.allbomb.remove(i);
				}
			}    
			
			}
	};
	private Timer bombtime = new Timer(100,boom);
	
	private ActionListener steelremove = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {	
			Map.mapcopy[13][6]=3;
			Map.mapcopy[13][7]=3;
			Map.mapcopy[13][8]=3;
			Map.mapcopy[14][6]=3;
			Map.mapcopy[14][8]=3;
			}
	};
	private Timer steelremoveTime = new Timer(10000, steelremove);
	private ActionListener itemremove = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {	
			gd.getItem().remove();
	    	System.out.println("开始倒计时");

			}
	};
	private Timer itemremoveTime = new Timer(10000, itemremove);
	private ActionListener itemProduce = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {	
			gd.getItem().product();

			}
	};
	private Timer itemProduceTime = new Timer(15000, itemProduce);
	private ActionListener pcProduce = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {	
			gd.getEnemyTank().productTank();
			}
	};
	private Timer pcProduceTime = new Timer(3000, pcProduce);
	private ActionListener pcFire = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		
				for (int i = 0; i < Scence.allEnemytank.size(); i++) {
					Scence.allEnemytank.get(i).fire();
				}
			}
			
	
	};
	private Timer pcFireTime = new Timer(500, pcFire);
	private ActionListener pcMove = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		
				for (int i = 0; i < Scence.allEnemytank.size(); i++) {
					Scence.allEnemytank.get(i).move();
				
				}
			}
	};
	private Timer pcMoveTime = new Timer(100, pcMove);
private ActionListener 	movestate=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
            		 gd.getTank().move();
		}
	};
	
	private Timer movingTime=new Timer(80, movestate);
	private ActionListener 	state=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
             gd.getTank().fire();			 
		}
	};
	
	private Timer fireTime=new Timer(400, state);
	private ActionListener move = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < Scence.allbullet.size(); i++) {
				Scence.allbullet.get(i).move();
			}
		}
	};
	private Timer moveTime = new Timer(50, move);

	public void partStart() {
		moveTime.start();
		pcMoveTime.start();
		pcFireTime.start();
		pcProduceTime.start();
		itemProduceTime.start();
		itemremoveTime.start();
		steelremoveTime.start();
	}
	public void allStart() {
		moveTime.start();
		fireTime.start();
		movingTime.start();
		pcMoveTime.start();
		pcFireTime.start();
		pcProduceTime.start();
		itemProduceTime.start();
		itemremoveTime.start();
		steelremoveTime.start();
	}
	public void allStop(){
		moveTime.stop();
		fireTime.stop();
		movingTime.stop();
		pcMoveTime.stop();
		pcFireTime.stop();
		pcProduceTime.stop();
		itemProduceTime.stop();
		itemremoveTime.stop();
		steelremoveTime.stop();
	}
	
	public Timer getMoveTime() {
		return moveTime;
	}
	public void setMoveTime(Timer moveTime) {
		this.moveTime = moveTime;
	}
	public Timer getFireTime() {
		return fireTime;
	}
	public void setFireTime(Timer fireTime) {
		this.fireTime = fireTime;
	}
	public Timer getMovingTime() {
		return movingTime;
	}
	public void setMovingTime(Timer movingTime) {
		this.movingTime = movingTime;
	}
	public Timer getPcMoveTime() {
		return pcMoveTime;
	}
	public void setPcMoveTime(Timer pcMoveTime) {
		this.pcMoveTime = pcMoveTime;
	}
	public Timer getPcFireTime() {
		return pcFireTime;
	}
	public void setPcFireTime(Timer pcFireTime) {
		this.pcFireTime = pcFireTime;
	}
	public Timer getPcProduceTime() {
		return pcProduceTime;
	}
	public void setPcProduceTime(Timer pcProduceTime) {
		this.pcProduceTime = pcProduceTime;
	}
	public Timer getItemProduceTime() {
		return itemProduceTime;
	}
	public void setItemProduceTime(Timer itemProduceTime) {
		this.itemProduceTime = itemProduceTime;
	}
	public Timer getItemremoveTime() {
		return itemremoveTime;
	}
	public void setItemremoveTime(Timer itemremoveTime) {
		this.itemremoveTime = itemremoveTime;
	}

	public Timer getSteelremoveTime() {
		return steelremoveTime;
	}

	public void setSteelremoveTime(Timer steelremoveTime) {
		this.steelremoveTime = steelremoveTime;
	}
	public Timer getBombtime() {
		return bombtime;
	}
	public void setBombtime(Timer bombtime) {
		this.bombtime = bombtime;
	}
	
	
}
