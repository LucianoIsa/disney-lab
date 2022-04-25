package com.alkemy.disney.disney.service;


import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Service;

import javax.swing.text.AbstractDocument;
import java.io.IOException;
import java.lang.reflect.Method;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServicio {

    private final SendGrid sendGrid;
    @Value("${mi.email}")
    private String miEmail;

    public boolean enviarMail(String nombreUsuario, String emailUsuario) {

        Email de = new Email(miEmail);
        String asunto = "¡¡Bienvenido " + nombreUsuario;
        Email para = new Email(emailUsuario);
        AbstractDocument.Content contenido = new AbstractDocument.Content("text/plain", "Gracias por registrarte en Disney");
        Mail mail = new Mail(de, asunto, para, contenido);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            Response response = sendGrid.api(request);
            log.info("estado", response.getStatusCode());
            log.info(response.getBody());
            log.info("cabeceras", response.getHeaders());
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
