package com.zyy.servlet;

import com.zyy.bean.XMLMessage;
import com.zyy.bean.XMLTextMessage;
import com.zyy.util.CheckUtil;
import com.zyy.util.XMLConverUtil;
import com.zyy.bean.EventMessage;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@javax.servlet.annotation.WebServlet(name = "WXServlet",value="/WXValue")
public class WXServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("==============post=================");
//        ServletInputStream inputStream = request.getInputStream();
//        ServletOutputStream outputStream = response.getOutputStream();
//
//        if(inputStream!=null){
//            //转换XML
//            EventMessage eventMessage = XMLConverUtil.convertToObject(EventMessage.class,inputStream);
//            String key = eventMessage.getFromUserName() + "__"
//                    + eventMessage.getToUserName() + "__"
//                    + eventMessage.getMsgId() + "__"
//                    + eventMessage.getCreateTime();
////            if(expireKey.exists(key)){
////                //重复通知不作处理
////                return;
////            }else{
////                expireKey.add(key);
////            }
//
//            //创建回复
//            XMLMessage xmlTextMessage = new XMLTextMessage(
//                    eventMessage.getFromUserName(),
//                    eventMessage.getToUserName(),
//                    "哈哈哈你好");
//            //回复
//            xmlTextMessage.outputStreamWrite(outputStream);
//            return;
//        }
//        outputStreamWrite(outputStream,"");


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("hello java！");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        System.out.println("--------------------------");
        System.out.println("signature:"+signature);
        System.out.println("timestamp:"+timestamp);
        System.out.println("nonce:"+nonce);
        System.out.println("echostr:"+echostr);
        System.out.println("--------------------------");
        boolean result = CheckUtil.checkSignature(signature, timestamp, nonce);
        System.out.println("result="+result);
        PrintWriter out = response.getWriter();
        out.println(echostr);
        System.out.println("验证完成!");
    }


    /**
     * 数据流输出
     * @param outputStream
     * @param text
     * @return
     */
    private boolean outputStreamWrite(OutputStream outputStream, String text){
        try {
            outputStream.write(text.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
