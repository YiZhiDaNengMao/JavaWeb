一、JavaWeb(J2EE或JavaEE)
1.JavaWeb规范

    sun公司规定了13种Javaweb开发需要遵循的规范,其中Servlet 和 JSP是核心规范.

2.JavaWeb开发过程

    web前端 => 业务处理层(Servelet) => JDBC => 数据库

3.静态资源 和 动态资源

    1）静态资源：
        网站中提供给用户展示的资源是一成不变的，
        所有人在不同时期看到的内容都是一样的

    2）动态资源：
        网站中提供给用户的资源有程序产生，不同时间和
        用户产生不同界面

4.局域网和广域网

    1）局域网：在一定范围内可以访问的网络，出了范围不能使用
    
    2）广域网（万维网）：互联网

5.系统架构
    
    1）基础结构
        C/S架构
        B/S架构

    2）部署方式
        一体式开发
        分布式开发
        微服务开发

6.服务器

    特殊的计算机，也即安装了服务器软件的电脑
        例如: 
            安装了mysql,就称之为mysql服务器
            安装了tomcat,就称之为tomcat服务器

7.web服务器

    1)概念: 本质上就是一个软件,用于接收和处理用户的请求,做出响应

    2）常见的web服务器
        ① weblogic：Oracle公司，支持所有JavaEE规范，收费
        ② JBoss：JBoss，支持所有JavaEES规范，收费
        ③ WebSphere：IBM公司的大型收费web服务器，支持所有JavaEES规范，收费

        ④ Tomcat：Apache公司，轻量级服务器，仅支持Servlet / JSP规范

    —————————————————————————————————————————————————————————————————————————

二、Tomcat服务器
1.Tomcat的⽬录结构

    bin：脚本⽬录
    启动脚本：startup.bat
    停⽌脚本：shutdown.bat
    
    conf：配置⽂件⽬录 (config /configuration)
    核⼼配置⽂件：server.xml
    ⽤户权限配置⽂件：tomcat-users.xml
    所有web项⽬默认配置⽂件：web.xml
    
    lib：依赖库，tomcat和web项⽬中需要使⽤的jar包
    
    logs：⽇志⽂件
    localhost_access_log.*.txt tomcat 记录⽤户访问信息，星*表示时间。
    例如：localhost_access_log.2016-02-28.txt
    
    temp：临时⽂件⽬录，⽂件夹内内容可以任意删除。
    
    webapps：默认情况下发布WEB项⽬所存放的⽬录。
    
    work：tomcat处理JSP的⼯作⽬录。

2.tomcat的配置

    1）出现启动后闪屏
        原因：没有正确配置环境变量
        解决方式：添加JAVA_HOME环境变量

    2)启动报错
  	报错: Address ...

    3)配置Tomcat环境变量
    变量名:JAVA_HOME: JDK的bin目录

  	变量名:CATALINA_HOME
  	变量值:D:\xxx\apache-tomcat-8.5.76
  	配置path路径: %CATALINA_HOME%\bin

    4)将项目部署到Tomcat服务器的方式:

    ①.直接将项目放到webapps目录下即可
        /form:项目的访问路径-->虚拟目录
    
          简化部署:将项目打成一个war包,再将war包放置到webapps目录下。
            war包会自动解压缩
      
    ②.配置conf/server.xml文件
      在<Host>标签体中配置
        <Context docBase="D:\hello" path="/hehe" />
          * docBase:项目存放的路径
          * path：虚拟目录
    
    ③.在conf\Catalina\localhost创建任意名称的xml文件。
      在xml文件中编写: <Context docBase="D:\hello" />
        * 虚拟目录：xml文件的名称


3.Java的Web工程 -> 写java代码的地方

    目录结构:
        javaweb_day01  -> web工程名
        |- src: 存放java代码
        |- web: web资源(静态资源)
            |-静态资源(html,jsp)
            |-WEB-INF:(用户不可直接访问)
                |- lib: 存放第三方jar包
                |- web.xml (当前web项目的核心配置文件)
        
        |- 普通文件夹(资源) -> 部署在web应用下是不识别的资源


4.Tomcat的web应用
    
    目录结构
        javaweb_day01_war_exploded -> web应用名

    |- WEB-INF
        |- classes: java代码编译后的字节码文件
        |- web.xml
        |- lib: 类库
    |- 静态资源
        html、js、css...

    —————————————————————————————————————————————————————————————————————————

三、Servlet
1.全称：server applet => 服务器小程序

2.使用Servlet的步骤
    
    1）添加javaEE规范
    2）定义一个类,实现Servlet接口
    3）重写接口中的抽象方法
    4）配置Servlet（位置：web.xml）

    <!--访问ServletDemo类-->
    <servlet>
        <!--给Servlet定义名称: 随意 -->
        <servlet-name>hello</servlet-name>
        <!--识别Servlet的路径: 全限定类名 -->
        <servlet-class>web.servlet.ServletDemo</servlet-class>
    </servlet>

    <!--映射地址: ServletDemo类对应的资源访问方式 -->
    <servlet-mapping>
        <!--必须和上面的servlet-name一致 -->
        <servlet-name>hello</servlet-name>
        <!--访问的路径: 随意-->
        <url-pattern>/hi</url-pattern>
    </servlet-mapping>

    5）启动服务器,访问Servlet
    localhost:8080/javaweb_day01/bai

3.Servlet的执行原理：

    1）当服务器接收到浏览器的请求后，会解析URL路径，获取
        访问Servlet的资源路径

    2）查找web.xml，查看是否有对应的<url-pattern>

    3）<url-pattern> => <servlet-name> => <servlet-class>

    4）tomcat会将字节码文件加载到内存中,将其创建对象

    5)调用对象中的service方法

