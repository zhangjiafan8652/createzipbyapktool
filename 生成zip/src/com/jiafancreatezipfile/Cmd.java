package com.jiafancreatezipfile;

public class Cmd {
	public static void execCommand(String arstringCommand) {
		try {
			Process exec = Runtime.getRuntime().exec(arstringCommand);
			new Thread(new StreamDrainer(exec.getInputStream())).start();
			new Thread(new StreamDrainer(exec.getErrorStream())).start();
			// exec.getOutputStream().close();

			exec.waitFor();
			exec.destroy();
			System.out.println("我执行完了");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void apktooljieya(String apkname) {

		String sdkpath = Myconstant.sdkworkspace + apkname + "\\bin\\";
		String cmd2 = "cmd /c start " + Myconstant.apktoolpath + " d" + " -f "
				+ sdkpath + apkname + ".apk" + " -o " + Myconstant.apktoolpath
				+ "\\" + apkname;
		System.out.println(cmd2);
		execCommand(cmd2);
	}

	/**
	 * 解压对应路径下的apk包
	 * @param path  apk路径
	 */
	public static void apktooljieya1(String path,String apkname) {
		
		String sdkpath = path ;
		String cmd2 = "cmd /c start " + Myconstant.apktoolpath + " d" + " -f "
				+ sdkpath + apkname + ".apk" + " -o " + Myconstant.apktoolpath
				+ "\\" + apkname;
		System.out.println(cmd2);
		execCommand(cmd2);
	}

	public static void startApkroot() {
		String cmd2 = "cmd /c start " + Myconstant.apktoolpath + "\\";
		execCommand(cmd2);
	}
}
