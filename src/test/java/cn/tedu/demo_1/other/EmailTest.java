package cn.tedu.demo_1.other;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${mail.fromMail.addr}")
    private String from;
    //@Test
//    public void test(){
//        SimpleMailMessage message = new SimpleMailMessage();
//        //发送者
//        message.setFrom(from);
//        //接收者
//        message.setTo("593464677@qq.com");
//        //主题(标题)
//        message.setSubject("First Email!");
//        //内容
//        message.setText("Hello World !");
//        javaMailSender.send(message);
//    }

//    @Test
//    public void sendTemplateMail(){
//        //创建邮件正文
//        Context context  = new Context();
//        context.setVariable("id","006");
//        TemplateEngine templateEngine = new TemplateEngine();
//        String emailContent = templateEngine.process("emailTemplate",context);
//
//    }


}
