package cn.dreamfy.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * email工具类用户创建session连接
 */
public class EmailConnectionUtil {

    /**
     * 获得session
     *
     * @return Session
     */
    public static Session getSession() {
        InputStream in;
        try {
            in = new BufferedInputStream(new FileInputStream(EmailConnectionUtil.class
                    .getProtectionDomain().getCodeSource()
                    .getLocation().getPath().concat("mail.properties")));

            final Properties p = new Properties();

            p.load(in);

            Properties props = new Properties();
            props.setProperty("mail.smtp.auth", p.get("mail.smtp.auth").toString());// 是否进行认证
            props.setProperty("mail.transport.protocol", "smtp");// 传输协议
            props.setProperty("mail.smtp.host", p.get("mail.smtp.host").toString());// 设置主机
            Session session = Session.getInstance(props,
                    new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(p.get("userName").toString(), p.get
                                    ("password").toString());
                        }
                    });
            session.setDebug((Boolean) p.get("debug"));// debug模式
            return session;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
