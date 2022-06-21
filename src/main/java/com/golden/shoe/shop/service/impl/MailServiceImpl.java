package com.golden.shoe.shop.service.impl;

import com.golden.shoe.shop.domain.dao.Template;
import com.golden.shoe.shop.service.MailService;
import com.golden.shoe.shop.service.TemplateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;


import java.util.Locale;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    private final TemplateService templateService;

    private final ITemplateEngine iTemplateEngine;


    @Override
    @Async
    public void send(String email, String templateName, Map<String, Object> variables) {

        Template template = templateService.findByName(templateName);
        Context context = new Context(Locale.getDefault(), variables);
        String htmlBody = iTemplateEngine.process(template.getBody(), context);



        try {
            javaMailSender.send(message -> {
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message);
                mimeMessageHelper.setTo(email);
                mimeMessageHelper.setFrom("patrykblakala108java@gmail.com");
//                mimeMessageHelper.setSubject(template.getSubject());
                mimeMessageHelper.setSubject("Welcome to Golden Shoe.");
                mimeMessageHelper.setText(htmlBody, true);

            });

        } catch (Exception e) {

            log.error(e.getMessage(), e);
        }

    }
}


