
package com.csse.pms.dal.model;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Malwatta H.G.
 *	
 * This class is handle by the email format
 * - @see #sendEmail()
 *
 */

@Component
public class EmailSender {
	
	@Autowired
	JavaMailSender mailSender;
	
	private String toAddress;
	private final String fromAddress = "rhnaconference@gmail.com";
	private final String senderName = "PMS Team";
	private final String subject = "Thank your for registration!";
	private String content = "<h4>Dear [[name]], </h4><br>"
			+ "You're account has been successfully registered! <br>"
			+ "Your account is now ready to use."
			+ "<h3><a href=\"[[URL]]\" target=\"_self\">click here to login!</a></h3><br>"
			+ "Thank you,<br>"
			+ "PMS Team.<br>";
	
	private MimeMessage message;
	private MimeMessageHelper helper;
	private String username;
	private String email;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void sendEmail() throws UnsupportedEncodingException, MessagingException {
		
		 message = mailSender.createMimeMessage();
		 helper = new MimeMessageHelper(message);
		 
		 toAddress = getEmail();
		 
		 helper.setFrom(fromAddress, senderName);
		 helper.setTo(toAddress);
		 helper.setSubject(subject);
			
		 content = content.replace("[[name]]", getUsername());
		 String verifyURL = "https://net-garage.vercel.app/login";
		 content = content.replace("[[URL]]", verifyURL);
		 helper.setText(content, true);
			
		 mailSender.send(message);
			
		 System.out.println("Email has been sent!");
			
		
	}
	

}
