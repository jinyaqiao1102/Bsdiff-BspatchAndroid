package com.hht.patch;

public class HPatchHelper {
	static HPatchHelper instance;

	public static HPatchHelper getInstance() {
		if (instance == null)
			instance = new HPatchHelper();
		return instance;
	}

	static {
		System.loadLibrary("AppPatch");
	}

	/**
	 * native方法 比较路径为oldPath的apk与newPath的apk之间差异，并生成patch包，存储于patchPath
	 * 
	 * 返回：0，说明操作成功
	 *  
	 * @param oldApkPath 示例:/sdcard/old.apk
	 * @param newApkPath 示例:/sdcard/new.apk
	 * @param patchPath  示例:/sdcard/xx.patch
	 * @return
	 */
	public native int generatePatch(String oldApkPath, String newApkPath, String patchPath);
	
	/**
	 * native方法 使用路径为oldApkPath的apk与路径为patchPath的补丁包，合成新的apk，并存储于newApkPath
	 * 
	 * 返回：0，说明操作成功
	 * 
	 * @param oldApkPath 示例:/sdcard/old.apk
	 * @param newApkPath 示例:/sdcard/new.apk
	 * @param patchPath  示例:/sdcard/xx.patch
	 * @return
	 */
	public native int applyPatch(String oldApkPath, String newApkPath, String patchPath);
}
