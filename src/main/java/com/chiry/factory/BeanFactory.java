package com.chiry.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @program: jdbc_demo2
 * @description: beanFactory 根据配置文件创建初始类
 * bean 可重构类
 *
 * 工厂模式要做到编译不报错的解耦操作
 * @author: Chiry
 * @create: 2020-09-04 16:54
 **/
public class BeanFactory {
    private static Properties props;
    //对象容器实现单例对象
    private static Map<String ,Object> beans=null;
    static {

        try {
            props=new Properties();
            //获取类路径，动态加载。
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans =new HashMap<String, Object>();
            //取出配置文件中的所有的key
            Enumeration<Object> keys = props.keys();
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                Object value=Class.forName(beanPath).newInstance();
                beans.put(key,value);
            }
            //因此在改代码块执行后，所有的map中已经加载完了配置文件中对象数据

        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }

    /**
    * @Description: 根据bean在beans的map集合中获取单例对象
    * @Param: []
    * @return: java.lang.Object
    * @Author: Chiry
    * @Date: 2020/9/4
    */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }


    /**
    * @Description: 根据配置文件获取对象，每次创建都会调用创建新对象
    * @Param: [beanName] 
    * @return: java.lang.Object 
    * @Author: Chiry
    * @Date: 2020/9/4 
    */
    /*
    public static  Object  getBean(String beanName){
        Object bean =null;

        try {
            String beanPath =props.getProperty(beanName);
            bean= Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bean;
    }

    */
}
