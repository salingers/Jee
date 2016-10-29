package com.umt.file;

import java.io.File;

public class TestFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("C:\\test");
		
		if(file.exists()){
			System.out.println("此" + file.getAbsolutePath() + "存在");
		}else{
			System.out.println("此File不存在");
			return;
		}
		
		if(file.isFile()){
			System.out.println("是文件");
		}else{
			System.out.println("是目录");
			File[] files = file.listFiles();
			
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i].getAbsolutePath());
			}
		}
	}

}
