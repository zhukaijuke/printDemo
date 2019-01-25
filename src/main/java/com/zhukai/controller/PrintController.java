package com.zhukai.controller;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhukai
 * @date 2019/1/21
 */
@Controller
@RequestMapping("/print")
public class PrintController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest request, HttpServletResponse response) {
        ServletContext context = request.getSession().getServletContext();
        String filepath = context.getRealPath("../ireport/test.jasper");
        return "success";
    }

    @RequestMapping("/test2")
    public void test2(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("inter..test2");
        ServletContext context = request.getSession().getServletContext();
        String filepath = context.getRealPath("ireport/test.jasper");

        try {
            //这里因为需要实现批量打印，所以使用list ，将所有需要 JasperPrint 装在list中

            Map<String, Object> map = new HashMap<>();
            map.put("test", "AE100");

            JasperPrint jasperPrint = JasperFillManager.fillReport(filepath, map, new JREmptyDataSource());
            //list.add(jasperPrint);
            response.setContentType("application/octet-stream");
            ServletOutputStream ouputStream = response.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(ouputStream);
            oos.writeObject(jasperPrint);//将所有JasperPrint对象写入对象输出流中
            oos.flush();
            oos.close();

        } catch (JRException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
