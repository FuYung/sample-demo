package cn.dreamfy.email;

import cn.dreamfy.email.entity.ComplexEmail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.IOException;

/**
 * 复杂邮件发送（带附件）
 */
public class SendComplexEmailMessage {

    /**
     * 发送复杂邮件
     * @param from 发件人邮箱
     * @param fromName 发件人名字
     * @param receivers 收件人邮箱
     * @param receiverNames 收件人姓名
     * @param attchPaths 附件地址
     * @param attchNames 附件名称（现在在邮件上）
     * @param content 文本内容（支持HTML）
     * @throws javax.mail.MessagingException
     * @throws IOException
     */
    private static void sendComplexEmail(String from, String fromName, String[] receivers,
                                 String[] receiverNames, String[] attchPaths,
                                 String[] attchNames, String content) throws MessagingException,
            IOException {
        StringBuilder addresslist = new StringBuilder();
        for (int i = 0; i < receivers.length; i++) {
            addresslist.append(MimeUtility.encodeText(receiverNames[i]))
                    .append("<").append(receivers[i]).append(">,");//收件人列表
        }
        addresslist.deleteCharAt(addresslist.length() - 1);

        Session session = EmailConnectionUtil.getSession();
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(
                MimeUtility.encodeText(fromName) + "<" + from + ">"));// 发件人

        MimeMultipart msgMultipart = new MimeMultipart("mixed");//混合关系(子类型)
        msg.setContent(msgMultipart);
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addresslist.toString()));// 收件人

        // 附件
        for (int j = 0; j < attchPaths.length; j++) {
            MimeBodyPart attch = new MimeBodyPart();// 附件
            msgMultipart.addBodyPart(attch);
            DataSource ds = new FileDataSource(attchPaths[j]);
            DataHandler dh = new DataHandler(ds);
            attch.setDataHandler(dh);
            attch.setFileName(MimeUtility.encodeText(attchNames[j]));
        }

        MimeMultipart bodyMultipart = new MimeMultipart("releated");// 关联关系
        MimeBodyPart contentPart = new MimeBodyPart();// 正文
        msgMultipart.addBodyPart(contentPart);
        contentPart.setContent(bodyMultipart);

        MimeBodyPart conPart = new MimeBodyPart();// 正文
        conPart.setContent(content, "text/html;charset=UTF-8");

        bodyMultipart.addBodyPart(conPart);
        msg.saveChanges();
        Transport.send(msg);

        // 保存为eml文件
//        OutputStream ops = new FileOutputStream("E:\\我的文档\\卡通\\demo3.eml");
//        msg.writeTo(ops);
//        ops.close();
    }

    /**
     * 发送
     * @param email 复杂邮件对象
     */
    public static void sendEmail(ComplexEmail email) {
        try {
            sendComplexEmail(email.getFrom(), email.getFromName(), email.getReceivers(), email.getReceviverNames(),
                    email.getAttchPaths(), email.getAttchNames(), email.getContent());
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }

}
