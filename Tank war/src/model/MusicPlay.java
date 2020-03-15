package model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlay {
	String file;  //wav�����ļ�
	int  loop;   // nѭ����ǣ�0=ѭ�����ţ�1=���β���, n=����n��
	
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

	//nѭ����ǣ�0=ѭ�����ţ�1=���β���, n=����n��
	public MusicPlay play( int n) {
		loop = n;
		if(n==0)
		    clip.loop(Clip.LOOP_CONTINUOUSLY);  //��Զѭ������
		else if(n>=1)
		{
			clip.setMicrosecondPosition(0);  //ÿ���ظ�����ǰ���ü�������λ��Ϊ0.
			clip.loop(n-1);   //����n�� 
		}
		/* ˵����loop�������ر𣬲���0��ʾ����һ�Σ�����1��ʾ������Ϻ����ظ�����1��
		 * */
		
		return this;
	}
	
	//���stop�߱���ͣЧ�����ٴε���play���������������ȥ
	public void stop(){
		clip.stop();
	}
	
	public boolean playingStatus(){
		return clip.isRunning();
	}
}
