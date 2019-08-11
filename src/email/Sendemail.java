package email;

import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;
import com.sun.mail.util.MailSSLSocketFactory;
import org.other.Redis;

/**
 *JavaMail发送邮件:前提是QQ邮箱里帐号设置要开启POP3/SMTP协议
 */
public class Sendemail {

    public String sendemail(String email,String name) throws Exception {
        String s=varify();

        Properties prop = new Properties();
// 开启debug调试，以便在控制台查看
        prop.setProperty("mail.debug", "true");
// 设置邮件服务器主机名
        prop.setProperty("mail.host", "smtp.qq.com");
// 发送服务器需要身份验证
        prop.setProperty("mail.smtp.auth", "true");
// 发送邮件协议名称
        prop.setProperty("mail.transport.protocol", "smtp");

// 开启SSL加密，否则会失败
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);

// 创建session
        Session session = Session.getInstance(prop);
// 通过session得到transport对象
        Transport ts = session.getTransport();
// 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
        ts.connect("smtp.qq.com","1695949429", "lfbieispicdndaie");//后面的字符是授权码，用qq密码反正我是失败了（用自己的，别用我的，这个号是我瞎编的，为了。。。。）
// 创建邮件
        Message message = createSimpleMail(session,email,name,s);
// 发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
        new Redis().set(email,s);
        return s;
    }

    /**
     * @Method: createSimpleMail
     * @Description: 创建一封只包含文本的邮件
     */
    public static MimeMessage createSimpleMail(Session session,String email,String name,String varify)
            throws Exception {
// 创建邮件对象
        MimeMessage message = new MimeMessage(session);
// 指明邮件的发件人
        message.setFrom(new InternetAddress("1695949429@qq.com"));
// 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email+"@qq.com"));
// 邮件的标题
        message.setSubject("验证码");
// 邮件的文本内容
        message.setContent("欢迎使用天津职业技术师范大学宿舍后台管理系统，您本次的验证码为 "+varify+" 。欢迎下次使用", "text/html;charset=UTF-8");
// 返回创建好的邮件对象
        return message;
    }

       public String varify(){
        Random random=new Random();
        int a=random.nextInt(9999)+1000;
        return a+"";
    }

}