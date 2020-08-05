package com.java.sales.Utils;



public class SendMail {

	public void sendEmailTest(String to,String subject,String content) {
		
		try {            
	        Email email = new SimpleEmail();

	        // Cấu hình thông tin Email Server
	        email.setHostName("smtp.googlemail.com");
	        email.setSmtpPort(465);
	        email.setAuthenticator(new DefaultAuthenticator(Constants.MY_EMAIL,
	                Constants.MY_PASSWORD));
	         
	        // Với gmail cái này là bắt buộc.
	        email.setSSLOnConnect(true);
	         
	        // Người gửi
	        email.setFrom(Constants.MY_EMAIL);
	         
	        // Tiêu đề
	        email.setSubject(subject);
	         
	        // Nội dung email
	        email.setMsg(content);
	         
	        // Người nhận
	        email.addTo(to);            
	        email.send();
	        System.out.println("Sent!!");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
