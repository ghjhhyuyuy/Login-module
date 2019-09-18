package com.wing8.servlet;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wing8.dao.UserDao;
import com.wing8.util.MD5;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")//请求路径,  如果配置了@WebServlet注解就不配置web.xml，两者二选一
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**设置请求编码*/
        request.setCharacterEncoding("UTF-8");
        /**设置响应类型*/
        response.setContentType("text/html");
        /**设置响应编码*/
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        // 获取服务器生成的验证码
        String ServiceCode = session.getAttribute("validateCode").toString();
        // 获取用户输入的的验证码
        String ClientCode = request.getParameter("codetext");
        if (ClientCode.equalsIgnoreCase(ServiceCode)) {
            //获取输入的用户名和密码
            String name = request.getParameter("username");
            String pass = null;
            try {
                pass = MD5.getMd5(request.getParameter("password"));
            } catch (Exception e) {
                // TODO: handle exceptio
                e.printStackTrace();
            }
            //初始化dao层
            UserDao userDao = new UserDao();
            /**调用dao层的获取用户的方法*/
            try {
                System.out.println(name+"|||"+pass);
                String user = userDao.findUserByName(name,pass);
                if(user.equals("查询失败！")){
                    response.sendRedirect("fail.jsp");
                }else {
                    System.out.println(user);

                    //获取session,将获取到的数据保存到session中
                    session.setAttribute("user", user);
                    //重定向，跳转到成功页面
                    response.sendRedirect("success.jsp");
                }


            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else {
            String erro = "你输入的验证码错误！请重新输入!";
            erro = URLEncoder.encode(erro, "utf-8");
            response.sendRedirect("login.jsp?erro=" + erro);
        }

    }
}