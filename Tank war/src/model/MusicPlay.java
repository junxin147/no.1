package model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlay {
	String file;  //wav音乐文件
	int  loop;   // n循环标记，0=循环播放，1=单次播放, n=播放n次
	
	Clip clip;
	File wavFile;
	AudioInputStream ais;
	
	
	public MusicPlay(String filepath){
		file = filepath;
		
		try {
			clip = AudioSystem.getClip();
			wavFile = new File(file);
			ais = AudioSystem.getAudioInputStream(wavFile);
			clip.open(ais);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//n循环标记，0=循环播放，1=单次播放, n=播放n次
	public MusicPlay play( int n) {
		loop = n;
		if(n==0)
		    clip.loop(Clip.LOOP_CONTINUOUSLY);  //永远循环播放
		else if(n>=1)
		{
			clip.setMicrosecondPosition(0);  //每次重复播放前设置剪辑播放位置为0.
			clip.loop(n-1);   //播放n次 
		}
		/* 说明：loop函数很特别，参数0表示播放一次，参数1表示播放完毕后再重复播放1次
		 * */
		
		return this;
	}
	
	//这个stop具备暂停效果，再次调用play方法会继续播放下去
	public void stop(){
		clip.stop();
	}
	
	public boolean playingStatus(){
		return clip.isRunning();
	}
}
