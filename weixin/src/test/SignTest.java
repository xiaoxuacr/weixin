package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.SignUtil;

public class SignTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String signature = req.getParameter("signature");  
        String timestamp = req.getParameter("timestamp");  
        String nonce = req.getParameter("nonce");  
        String echostr = req.getParameter("echostr"); 
        if(SignUtil.checkSignature(signature, timestamp, nonce)){
        	PrintWriter out = resp.getWriter();
            out.print(echostr);
            out.close();
        }else {
			System.out.println("«Î«Û¥ÌŒÛ");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
}
