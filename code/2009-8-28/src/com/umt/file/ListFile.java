package com.umt.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ListFile {

	private int count = 0;
	
	
	
	
	public int getCount() {
		return count;
	}

	/**
	 * ʵ�ֶ�Ŀ¼�ı��������Ŀ¼�µ������ļ���
	 * @param url��Ŀ��·��
	 */
	public void listDir(String url){
		File file = new File(url);
		
		//�жϴ�file�Ƿ����
		if(!file.exists()){
			System.out.println("��·��������");
			return;
		}
		
		
		//file����
		if(file.isDirectory()){
			//����Ŀ¼�µ������ļ���Ŀ¼
			File[] files = file.listFiles();
			
			for (int i = 0; i < files.length; i++) {
				//�ݹ����
				this.listDir(files[i].getAbsolutePath());
			}
		}else{
			//System.out.println(file.getAbsolutePath());
			
			if(file.getAbsolutePath().endsWith(".java")){
				System.out.println(file.getAbsolutePath());
				Reader r = null;
				BufferedReader br = null;
				try {
					r = new FileReader(file);
					br = new BufferedReader(r);
					
					while(br.readLine() != null){
						this.count ++;
					}
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String args[]){
		ListFile lf = new ListFile();
		lf.listDir("D:\\workspace4");
		
		System.out.println("��ϲ�㣡ĿǰΪֹ�����Ѿ�д��  " + lf.getCount() + "  �д��룡");
		System.out.println("����Ŭ����δ�������㡣");
	}

}
