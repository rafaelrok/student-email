package com.rafaelvieira.studentemail.mail;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.util.Map;

@Slf4j
@AllArgsConstructor
//Utilizada como herança colocando como abstratic e colocando o metodo como protected
public abstract class MailComponent {

    private JavaMailSender javaMailSender;

    //Motodo para enviar um endereço eletrônico simples
    protected void sendSimpleEmail(MailMessage mail) {
        log.info("Sending email.");

        //tratamento de exceção com try/catch para informa apenas se teve erro no email
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(mail.getFrom());
            message.setTo(mail.getTo());
            message.setSubject(mail.getSubject());
            message.setText(mail.getMessage());

            this.javaMailSender.send(message);

            log.info("Simple email sent successfully.");
        } catch (Exception e) {
            log.error("Error when tried to send the email.");
        }
    }

    //Metodo utilizado para enviar um email com templete onde pode ser enviado um arquivo de imagem em anexo...
    //Nesse modelo é utilizado o MimeMessage e MimeMessageHelper para enviar o email avançado com templete e nele ja é declarado o (mimeMessage)
    protected void sendAdvancedEmail(MailMessage mail) {
        log.info("Sending email.");

        try {
            MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
            //MimeMessageHelper nele é utilizado um valor booleano para informar se o email é multipart ou não para enviar anexos
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setFrom(mail.getFrom(), "Rafael Vieira - Spring Boot");
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getMessage(), true);

            //O map.getKeys() retorna um array de chaves do mapa com nome de arquivos e o map.getValues() retorna um array de valores do mapa com nome de arquivos
            for (Map.Entry<String, ClassPathResource> map : mail.getAttachments().entrySet()) {
                helper.addAttachment(map.getKey(), map.getValue());
            }
            //O helper.addInline() é utilizado para anexar um arquivo de imagem em anexo
            for (Map.Entry<String, ClassPathResource> map : mail.getBodyFiles().entrySet()) {
                helper.addInline(map.getKey(), map.getValue());
            }

            this.javaMailSender.send(mimeMessage);
            log.info("Advanced email sent successfully.");
        } catch (Exception e) {
            log.error("Error when tried to send the email.");
        }
    }

}