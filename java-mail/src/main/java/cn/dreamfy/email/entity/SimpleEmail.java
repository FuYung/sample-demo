package cn.dreamfy.email.entity;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 简单邮件对象
 */
public class SimpleEmail implements Serializable {

    /**
     * 发件人邮件地址
     */
    private String from;
    /**
     * 发件人姓名
     */
    private String fromName;
    /**
     * 邮件主题
     */
    private String title;
    /**
     * 邮件正文（可以包含html）
     */
    private String content;
    /**
     * 收件人邮件地址（支持群发）
     */
    private String[] receivers;
    /**
     * 收件人姓名
     */
    private String[] receviverNames;


    public SimpleEmail() {

    }

    public SimpleEmail(String from, String fromName, String title, String content, String[] receivers,
                       String[] receviverNames) {
        this.from = from;
        this.fromName = fromName;
        this.title = title;
        this.content = content;
        this.receivers = receivers;
        this.receviverNames = receviverNames;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String[] getReceviverNames() {
        return receviverNames;
    }

    public void setReceviverNames(String[] receviverNames) {
        this.receviverNames = receviverNames;
    }

    @Override
    public String toString() {
        return "SimpleEmail{" +
                "from='" + from + '\'' +
                ", fromName='" + fromName + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", receivers=" + Arrays.toString(receivers) +
                ", receviverNames=" + Arrays.toString(receviverNames) +
                '}';
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getReceivers() {
        return receivers;
    }

    public void setReceivers(String[] receivers) {
        this.receivers = receivers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
