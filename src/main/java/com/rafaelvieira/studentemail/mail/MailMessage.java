package com.rafaelvieira.studentemail.mail;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;

@Getter
@Setter
@Builder //padrão de projeto builder pelo lombok
public class MailMessage {

    //Referencias de email template
    private String to;
    private String from;
    private String subject;
    private String message;

    //Referencia de arquivos em anexo
    @Singular
    private Map<String, ClassPathResource> attachments;

    //referencia a imagem do corpo do email
    @Singular
    private Map<String, ClassPathResource> bodyFiles;

}

