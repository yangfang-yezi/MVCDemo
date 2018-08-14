package org.westos.web;

import org.apache.commons.beanutils.BeanUtils;
import org.gjt.mm.mysql.Driver;
import org.westos.bean.User;
import org.westos.service.UserSerivce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(value="/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            Map<String, String[]> map = request.getParameterMap();
            User user = new User();
            BeanUtils.populate(user,map);
            //System.out.println(user);
            //调用业务层
            boolean b=new UserSerivce().addUser(user);
            if(b){
                response.getWriter().write("注册成功");
            }else{
                request.setAttribute("msg","用户名已经存在，请重新输入");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
