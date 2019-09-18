<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
<script type="text/javascript">
//点击更新验证码
    function change(){
    document.getElementById("code").src="ValidateServlet?a="+new Date();
    }
    </script>
<body>
<span style="color: red">
   <%String erro=request.getParameter("erro");
  if(erro!=null){
  erro=new String(erro.getBytes("utf-8"),"utf-8");
  erro=URLDecoder.decode(erro, "utf-8");
  }else{
  erro="";
  }
   %>
  <%=erro %>
  </span>
    <form action="login" method="post">
       <table>
           <tr>
              <td>用户名：</td>
              <td><input type="text" name='username' style="width: 140px"></td>
              <td></td>
           </tr>
           <tr>
              <td>密码：</td>
              <td><input type="password" name='password'  style="width: 140px"></td>
              <td></td>
           </tr>
           <tr>
              <td>验证码：</td>
              <td><input type="text" name='codetext' style="width: 70px"> <img alt="" src="ValidateServlet" width="60px"
                  height="25px" id='code' onclick="change()"></td>
              <td><span onclick="change()">看不清，换一张</span></td>
           </tr>
           <tr>
              <td></td>
              <td><input type="submit" value="提交"> <input type="reset" value="重置"></td>
              <td></td>
           </tr>
       </table>
    </form>
</body>
</html>
