一、Servlet
...
5.Servlet的url配置

    1）web.xml方式配置
        ① 完全匹配,只能通过 具体路径 来访问所对应的servlet
            访问URL:localhost:8080/javaweb_day02/servlet01
                虚拟目录:javaweb_day02
                资源路径(url-pattern):/servlet01
        ② 目录匹配, / 开头 + 通配符(*)使用
            栗子:
                <url-pattern>/*</url-pattern>
                localhost:8080/javaweb_day02/*

                <url-pattern>/bai/*</url-pattern>
                localhost:8080/javaweb_day02/bai/*
        ③ 后缀匹配（扩展名匹配）
            栗子:
                <url-pattern>*.do</url-pattern>
                localhost:8080/javaweb_day02/*.do
        ④ 特殊匹配，/ 所有资源，默认配置，又称之为缺省配置 - 不建议使用
            栗子:
                <url-pattern>/</url-pattern>

         ⑤ 多路径匹配同一个servlet,可以有多个<url-pattern>
    
    2)注解配置
        注解类:WebServlet
        public @interface WebServlet {
    
            //指的是Servlet的名称 对应标签:<serlvet-name>
            String name() default "";
        
            //用于映射url,是简写形式,等同于urlPatterns的使用
            String[] value() default {};
        
            //用于映射url,对应标签: <url-pattern>
            String[] urlPatterns() default {};
        
            //设置服务器开启Servlet
            int loadOnStartup() default -1;
        
            //设置servlet的初始化参数
            WebInitParam[] initParams() default {};
        
            boolean asyncSupported() default false;
        
            String smallIcon() default "";
        
            String largeIcon() default "";
        
            String description() default "";
        
            String displayName() default "";
        }

6.ServletConfig对象

    1）理解
        当servlet配置了初始化参数后，web容器在创建servlet实例对象时，
        会自动将这个初始化参数封装后ServletConfig对象中，并在调用servlet的init方法时，
        将ServletConfig对象传递给Servlet，进而，程序员通过ServletConfig对象就可以得到servet的初始化参数信息

    2）生命周期：
        随着Servlet产生而产生，销毁而销毁

7.ServletContext对象(★★★)

    1)概念
        ServletContext对象,是应用上下文对象.
        每一个web应用有且只有一个ServltContext对象.
        他可以实现让应用中所有的Servlet间的数据共享.

    结论: 所有的浏览器和Servlet共享同一个资源,也就是共享同一个application对象.

    2)ServletConetxt的生命周期
        创建:服务器启动,该对象就被创建. 一个应用有且只有一个对象(单例模式)

        服务: 只要应用一直提供服务方法(service),该对象就会一直存在.
    
        销毁: 服务器正常关闭,该对象就消失.

    3)创建方式   

    4）常用方法（作用）


    5）ServletContext作为域对象使用

8.域对象

    1）域对象概念：指的是对象有作用域，也就是对象有使用范围
    2）作用：存取数据，域对象可以实现数据的共享，不同作用域对象，共享的数据范围不一样
    3）在Servlet规范中，一共有4个域对象，ServletContext域对象是作用域最大的，
        它可以实现整个web应用间的数据共享功能
    4)常用方法
        setAttribute(String name,Object o):向域中存数据
        getAttribute(String name):取出域对象中的数据
        removeAttribute(String name):删除域对象中的数据

    ——————————————————————————————————————————————————————————————————

二、HTTP协议
1.全称：超文本传输协议

    1）HTTP: 超文本(超链接,视频..)
    2）传输协议:
        传输(Tansfer):服务器S <=> 客户端C/浏览器B
        协议(protocol):规范、约束
    3）总结：http协议指的是服务器与客户端进行超文本传输的行为规范

2.特点

    1）默认端口号: 80
    2）基于TCP/IP协议实现
    3）基于请求与响应模型: 一次请求 => 一次响应
    4）无状态协议: 
        servlet01 => 请求01 => 响应01
                    |
                    X : 每次请求之间互相独立，数据不交互
                    |
        servlet02 => 请求02 => 响应02

3.组成部分

    1）请求：request
    2）响应：response
        






    ——————————————————————————————————————————————————————————————————

面试题:
1.什么是Servlet?
2.你见过的设计模式有哪些?单例模式是什么?见过那些场景?