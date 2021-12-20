package com.rafaelvieira.studentemail.mail;

import com.rafaelvieira.studentemail.entity.Student;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDate;

@Component
public class StudentMailComponent extends MailComponent {

    private TemplateEngine templateEngine;

    public StudentMailComponent(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        super(javaMailSender);
        this.templateEngine = templateEngine;
    }

    public void sendSimpleWelcomeEmail(Student student) {
        MailMessage mail = MailMessage.builder()
                .to(student.getEmail())
                .from("rafavista1@hotmail.com")
                .message(String.format("Olá, %s! Espero que você tenha curtido nossas ofertas.", student.getName()))
                .subject("Spring boot - Spring Mail Sender")
                .build();

        //Esse metoddo está sendo chamado pela classe MailComponent pela herança
        this.sendSimpleEmail(mail);
    }


    public void sendWelcomeEmail(Student student) {
        // contexto do template para ser informado as variaveis no template
        Context context = new Context();
        context.setVariable("name", student.getName());
        context.setVariable("email", student.getEmail());
        context.setVariable("birthday", student.getBirthday());
        context.setVariable("date", LocalDate.now());

        String templateMessage = this.templateEngine.process("welcome-template", context);

        MailMessage mail = MailMessage.builder()
                .to(student.getEmail())
                .from("rafavista1@hotmail.com")
                .message(templateMessage)
                .subject("Comece com Spring - Spring Mail Sender")
                .bodyFile("headerLogo", new ClassPathResource("static/images/spring_send.png"))
                .attachment("teste.txt", new ClassPathResource("static/docs/teste.txt"))
                .build();

        //Esse metoddo está sendo chamado pela classe MailComponent pela herança
        this.sendAdvancedEmail(mail);
    }

}
