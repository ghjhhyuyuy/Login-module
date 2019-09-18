package com.wing8.servlet;

import com.wing8.dao.RegesterDao;
import com.wing8.util.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/regester")//请求路径,  如果配置了@WebServlet注解就不配置web.xml，两者二选一
public class RegesterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegesterServlet() {
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
//        HttpSession session = request.getSession();
//        // 获取服务器生成的验证码
//        String ServiceCode = session.getAttribute("validateCode").toString();
//        // 获取用户输入的的验证码
//        String ClientCode = request.getParameter("codetext");
 //       if (ClientCode.equalsIgnoreCase(ServiceCode)) {
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
            RegesterDao regesterDao = new RegesterDao();
            String email = request.getParameter("email");
            String realName = request.getParameter("realName");
            if(email!=null){
                /**调用dao层的获取用户的方法*/
                try {
                    System.out.println(name+"|||"+pass);
                    Boolean user = regesterDao.doRegister(name,pass,realName,email);
                    System.out.println(user);
                    //重定向，跳转到成功页面
                    response.sendRedirect("haha.jsp");

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
}