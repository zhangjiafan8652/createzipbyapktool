package com.jiafancreatezipfile;

import java.io.File;

import javax.swing.JLabel;

public class Mainthread2 {

	
	public static void createZip(JLabel labe){
		labe.setText("正在生成zip");
		String sdkpath=Myconstant.sdkpath;
		String delpath=Myconstant.apktoolpath+"\\"+sdkpath+"\\original";
		String delpath2=Myconstant.apktoolpath+"\\"+sdkpath+"\\apktool.yml";
		String delpath3=Myconstant.apktoolpath+"\\"+sdkpath+"\\AndroidManifest.xml";
		String zippath=Myconstant.apktoolpath+"\\"+sdkpath;
		String zippathtaget=Myconstant.apktoolpath+"\\"+sdkpath+".zip";
		//F:\0azhangjiafan\apktoolfan\Sdk360\original
		// Fileutils.delFolder("F:\\0azhangjiafan\\apktoolfan\\Sdk360\\original");
		File file = new File(delpath);
		Fileutils.deleteDir2(file);
		Fileutils.delFile(delpath2);
		String read = Filetextutils.read(delpath3);
		System.out.println(read);
		int indexOf = read.indexOf("<activity");
		int indexOf2 = read.indexOf("activity>");
		System.out.println(indexOf+"++"+indexOf2);
		String substring = read.substring(indexOf, indexOf2+9);
		System.out.println(substring);
		String replace = read.replace(substring, "");
		System.out.println(replace);
		Filetextutils.write(delpath3, false, replace);
		//Fileutils.zip(zippath, Myconstant.fileroot);
		System.out.println(zippathtaget+"   "+zippath);
		labe.setText("开始压缩");
		Fileutils.zip(zippathtaget, zippath);
		labe.setText("成功生成zip");
	}
	
	
}
