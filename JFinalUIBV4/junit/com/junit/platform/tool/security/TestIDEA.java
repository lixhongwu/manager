package com.junit.platform.tool.security;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import com.platform.tools.security.ToolIDEA;

public class TestIDEA { // extends TestBase  {

	@Test
    public void test() throws Exception{
		String inputStr = "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作"
				+ "录入密码，检测录入的密码和数据库密码是否是123456，如果是，强制弹出密码修改框改密码，修改完后重新录入新密码继续登录操作";
		byte[] inputData = inputStr.getBytes();
		System.err.println("原文:\t" + inputStr);

		// 初始化密钥
		byte[] key = ToolIDEA.initKey();
		System.err.println("密钥:\t" + Base64.encodeBase64String(key));

		// 加密
		inputData = ToolIDEA.encrypt(inputData, key);
		System.err.println("加密后:\t" + Base64.encodeBase64String(inputData));

		// 解密
		byte[] outputData = ToolIDEA.decrypt(inputData, key);

		String outputStr = new String(outputData);
		System.err.println("解密后:\t" + outputStr);
	}

}
