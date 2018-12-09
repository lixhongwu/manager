基于JFinal3.0 + metrolab UI


V4主要变动：
	
	升级JFinal3.0，V4代码完全从V3迁移过来，只是为了升级JFinal3.0进行了一些修改
	

JDK要求：

	JDK6、JDK7、JDK8都可以，编译级别默认是1.6，可以更高


Eclipse安装配置说明：

	1.用eclipse导入项目，修改受限API调用编译报错，见/build-lib/eclipse受限API调用设置.png
	2.运行com.platform.config.Run.java类
	
IDEA安装配置说明：
	
	1.用IDEA打开项目
	2.运行com.platform.config.Run.java类，编辑main运行配置，修改JRE路径为本地JDK根路径，千万不要选择本地JRE路径
	
	
	账号：admins
	密码：123456

build-lib说明：

	1.此目录都是一些编译依赖包，并不需要发布到运行环境中，
	2.如果你用到了这些jar，请把这些jar移动到WEB-INF\lib目录中，并删除此目录中的jar
	
	jetty-8.1.8：内嵌启动jetty8.1.8依赖的jar
	
	jetty-9.2-jdk7+：内嵌启动jetty9.2依赖的jar
	
	jfinal3：编译jfinal源码用到的jar，这些jar在项目中没用到，不用发布
	
	junit：junit单元测试依赖的jar
	
	postgresql：在JDK6或JDK7中的驱动类
	
	spring：如果启用了spring插件，可以加入这些jar

 