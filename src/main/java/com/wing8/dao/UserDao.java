package com.wing8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wing8.entity.po.User;
import com.wing8.jdbc.ConnectionFactory;
public class UserDao {

    public String findUserByName(String name, String pass) throws Exception {
        /**获取连接，因为连接工厂设置的静态方法，可以指定使用类名调用方法*/
        Connection conn = ConnectionFactory.getConnection();
        /**拼接sql语句*/
        String sql = "select * from user where username= ? and password = ? "+"and state!=0";
        /**预编译sql语句，这样是为了防止sql语句攻击*/
        PreparedStatement statement = conn.prepareStatement(sql);
        /**set参数,1表示第一个参数，2表示第二个参数*/
        statement.setString(1, name);
        statement.setString(2, pass);
        //执行sql语句，返回结果集
        ResultSet rs = statement.executeQuery();
        /**判断结果集是否有数据*/
        if(rs.last()){
            /**返回用户真实姓名*/
            return rs.getString("realname");
        }else{
            return "查询失败！";
        }   
    }
    public int save(User user) throws Exception {
        /**获取连接，因为连接工厂设置的静态方法，可以指定使用类名调用方法*/
        Connection conn = ConnectionFactory.getConnection();
        /**拼接sql语句*/
        String sql = "insert INTO user(username, password,realname,email,code) VALUES (?, ?,?,?,?)";
        /**预编译sql语句，这样是为了防止sql语句攻击*/
        PreparedStatement statement = conn.prepareStatement(sql);
        /**set参数,1表示第一个参数，2表示第二个参数*/
        statement.setString(1,user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setString(3,user.getRealName());
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getCode());
        //执行sql语句，返回结果集
        int rs = statement.executeUpdate();
        return rs;

    }
    public boolean activeUser(String code) throws Exception {
        /**获取连接，因为连接工厂设置的静态方法，可以指定使用类名调用方法*/
        Connection conn = ConnectionFactory.getConnection();
        /**拼接sql语句*/
        String sql = "UPDATE user set state = 1  where code = ? ";
        /**预编译sql语句，这样是为了防止sql语句攻击*/
        PreparedStatement statement = conn.prepareStatement(sql);
        /**set参数,1表示第一个参数，2表示第二个参数*/
        statement.setString(1,code);
        //执行sql语句，返回结果集
        int rs = statement.executeUpdate();
        if(rs>0){
            return true;
        }else {
            return false;
        }

    }
}