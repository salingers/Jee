package com.umt.file;

import java.io.File;

public class TestFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("C:\\test");
		
		if(file.exists()){
			System.out.println("��" + file.getAbsolutePath() + "����");
		}else{
			System.out.println("��File������");
			return;
		}
		
		if(file.isFile()){
			System.out.println("���ļ�");
		}else{
			System.out.println("��Ŀ¼");
			File[] files = file.listFiles();
			
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i].getAbsolutePath());
			}
		}
	}

}
