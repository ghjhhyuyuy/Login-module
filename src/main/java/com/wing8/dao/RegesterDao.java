package com.wing8.dao;

import com.wing8.entity.po.User;
import com.wing8.util.CodeUtil;
import com.wing8.util.MailUtil;

/**
 * Created by wzw on 2019/8/6
 *
 * @Author wzw
 */
public class RegesterDao {
    public boolean doRegister(String userName, String password, String realName,String email) throws Exception {
        // 这里可以验证各字段是否为空

        //利用正则表达式（可改进）验证邮箱是否符合邮箱的格式
        if(!email.matches("^\\w+@(\\w+\\.)+\\w+$")){
            return false;
        }
        //生成激活码
        String code= CodeUtil.generateUniqueCode();
        User user=new User(userName,password,realName,email,code);
        //将用户保存到数据库
        UserDao userDao=new UserDao();
        //保存成功则通过线程的方式给用户发送一封邮件
        if(userDao.save(user)>0){
            new Thread(new MailUtil(email, code)).start();
            return true;
        }
        return false;
    }
}
