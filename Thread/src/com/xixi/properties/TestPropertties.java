package com.xixi.properties;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * @author 孟凡喜
 * @version 1.0.0
 * @ClassName TestPropertties.java
 * @createTime 2022年07月16日 14:30
 */
public class TestPropertties {
    public static void main(String[] args) throws IOException {
        Properties properties  = new Properties();
        //添加数据（K-V）
        properties.setProperty("userName","张三");
        properties.setProperty("password","123456");

        //输出Properties对象中的信息
        System.out.println(properties.toString());

        //遍历
        Set<String> proNames = properties.stringPropertyNames();
        for(String key:proNames){
            //根据指定的key获取对应的value
            System.out.println(key+"="+properties.getProperty(key));
        }

        //与流相关的API
        //---------------list----------------------
        String outPath = "/Volumes/Macintosh-HD-Data/File/Java/workspace/Thread/src/com/xixi/model/properties/test.properties";
        PrintWriter pw = new PrintWriter(outPath);

        properties.list(pw);  //将Properties对象中的所有k-y输出至指定的文件中
        pw.flush();
        pw.close();


        //---------------store------------------------
        outPath = "/Volumes/Macintosh-HD-Data/File/Java/workspace/Thread/src/com/xixi/model/properties/testStore.properties";
        try {
            FileWriter fw = new FileWriter(outPath);

            properties.store(fw,"Comment");  //第二个是参数为注释的内容，不能为中文（使用Unicode编码方法写入）
            fw.close();
         //   properties.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //load方法：加载指定的Properties文件中的内容
        Properties properties2 = new Properties();
        FileReader fr = new FileReader("/Volumes/Macintosh-HD-Data/File/Java/workspace/Thread/src/com/xixi/model/properties/test.properties");
        properties2.load(fr);
        fr.close();
        System.out.println(properties2.toString());

    }
}
