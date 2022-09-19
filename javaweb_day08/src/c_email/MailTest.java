package c_email;

import org.junit.Test;

import javax.mail.MessagingException;

public class MailTest {

    @Test
    public void test() {
        try {
            MailUtils.sendMail("jiangxstar@163.com","蜡笔小新和派大星！");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
