package com.wing8.servlet;

/**
 * Created by wzw on 2019/8/6
 *
 * @Author wzw
 */
import com.wing8.dao.UserDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ActiveServlet")
public class ActiveServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code=request.getParameter("code");
        UserDao userService=new UserDao();
        try {
            if(userService.activeUser(code)){
                request.getRequestDispatcher("/welcome.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("/fail.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
