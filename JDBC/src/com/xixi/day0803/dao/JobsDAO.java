package com.xixi.day0803.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @ClassName: JobsDAO
 * @Author: macbook-xi
 * @Date: 2022/8/3
 * @Description: 数据库操作
 */
public class JobsDAO {
    public static void main(String[] args) {
        try {
            //1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获得连接
            String url ="jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=utf8&useSSL=false";
            Connection connection = DriverManager.getConnection(url,"root","mengfanxi123");
            //测试是否连接
            System.out.println(connection);
            //3、获取sql操作对象
            Statement statement = connection.createStatement();
            //4、业务操作
            String sql = "insert into t_jobs values('BBB','22222','3000','30000')";
            final int count = statement.executeUpdate(sql);
            //5、处理结果
            if(count > 0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
            //6、释放资源，先打开，后关闭
            //注意，关闭自愿
            statement.close();
             connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
