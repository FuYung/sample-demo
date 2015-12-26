package cn.dreamfy.email;


import cn.dreamfy.email.entity.SimpleEmail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 简单邮件发送
 */
public class SendSimpleEmailMessage {

    /**
     * 简单邮件发送（文本）
     *
     * @param subject 主题
     * @param content 正文（可以加入html样式）
     * @param from    发件人
     * @param address 收件人，可以是多个
     * @throws javax.mail.MessagingException
     */
    private static void sendEmail(String subject, String content, String from, String fromName,
                            String[] address) throws
            MessagingException, UnsupportedEncodingException {

        Session session = EmailConnectionUtil.getSession();
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(MimeUtility.encodeText(fromName) + "<" + from + ">"));// 邮件显示的发送人（并非真正的发送人）
        msg.setSubject(subject);// 邮件主题
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Arrays.toString(address).substring(1,
                Arrays.toString(address).length() - 1)));

        msg.setContent(content, "text/html;charset=UTF-8");// 邮件正文
        msg.saveChanges();

        Transport.send(msg);
    }

    /**
     * 发送简单邮件
     *
     * @param email 简单邮件对象
     */
    public static void sendSimpleEmail(SimpleEmail email) {
        if (email != null) {
            try {
                sendEmail(email.getTitle(), email.getContent(), email.getFrom(), email.getFromName(),
                        email.getReceivers());
            } catch (MessagingException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {

        SimpleEmail simpleEmail = new SimpleEmail();
        simpleEmail.setTitle("标题");
        simpleEmail.setContent("内容");
        simpleEmail.setFrom("service@qq.com");
        simpleEmail.setFromName("service");
        simpleEmail.setReceivers(new String[]{"12345@qq.com", "1234566@qq.com"});
        simpleEmail.setReceviverNames(new String[]{"12345", "1234566"});
        sendSimpleEmail(simpleEmail);
    }

}
