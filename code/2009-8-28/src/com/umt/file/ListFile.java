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
	 * 实现对目录的遍历，输出目录下的所有文件名
	 * @param url：目标路径
	 */
	public void listDir(String url){
		File file = new File(url);
		
		//判断此file是否存在
		if(!file.exists()){
			System.out.println("此路径不存在");
			return;
		}
		
		
		//file存在
		if(file.isDirectory()){
			//遍历目录下的所有文件及目录
			File[] files = file.listFiles();
			
			for (int i = 0; i < files.length; i++) {
				//递归调用
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
		
		System.out.println("恭喜你！目前为止，你已经写了  " + lf.getCount() + "  行代码！");
		System.out.println("继续努力！未来属于你。");
	}

}
