package com.ra.controller;

import com.ra.dto.EmployeeRequest;
import com.ra.service.IEmployeeService;
import com.ra.service.impl.EmployeeServiceImpl;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 10
)
public class EmployeeServlet extends HttpServlet {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static final IEmployeeService employeeService = new EmployeeServiceImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if(action!=null){
            switch(action){
                case "LIST":
                        request.setAttribute("list",employeeService.findAll());
                        request.getRequestDispatcher("/employee/list.jsp").forward(request,response);
                    break;
                case "ADD":
                    request.getRequestDispatcher("/employee/add.jsp").forward(request,response);
                    break;
            }
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if(action!=null){
            switch(action){
                case "ADD":
                   String name = request.getParameter("name");
                   String address = request.getParameter("address");
                   Part file = request.getPart("file");
                   String sex = request.getParameter("sex");
                   String birthday = request.getParameter("dob");
                   try{
                       EmployeeRequest employeeRequest = new EmployeeRequest(null,name,address,sdf.parse(birthday),Boolean.valueOf(sex),file);
                       employeeService.save(employeeRequest);
                   }catch (ParseException e){
                       throw new RuntimeException(e);
                   }
                   response.sendRedirect("/EmployeeServlet?action=LIST");
                    break;

            }
        }
    }

    public void destroy() {
    }
}