package cn.dreamfy;

import cn.dreamfy.email.SendSimpleEmailMessage;
import cn.dreamfy.email.entity.SimpleEmail;

/**
 * test send email
 */
public class App {
	public static void main(String[] args) {

		SimpleEmail simpleEmail = new SimpleEmail();
		simpleEmail.setTitle("title");
		simpleEmail.setContent("content");
		simpleEmail.setFrom("");
		simpleEmail.setFromName("");
		simpleEmail.setReceivers(new String[]{});
		simpleEmail.setReceviverNames(new String[]{});

		SendSimpleEmailMessage.sendSimpleEmail(simpleEmail);

	}
}
