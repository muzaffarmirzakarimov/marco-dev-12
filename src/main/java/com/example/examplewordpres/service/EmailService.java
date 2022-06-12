package com.example.examplewordpres.service;

import com.example.examplewordpres.dto.EmailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class EmailService {
//
//
//    private final JavaMailSender javaMailSender;
//
//
//
//
//        @Async
//        public void sendMessage(EmailDTO emailDTO) {
//        SimpleMailMessage message = new SimpleMailMessage();
//            message.setFrom("farruxbekaxmadaliyev850@gmail.com");
//            message.setTo(emailDTO.getEmail());
//            message.setSubject(emailDTO.getSubject());
//            message.setText(emailDTO.getText());
//            javaMailSender.send(message);
//        }
//
//
//
//
////
////   public void sendMessageAttechment(){
////
////       this.javaMailSender.send(new MimeMessagePreparator() {
////           @Override
////            public void prepare(MimeMessage mimeMessage) throws Exception {
////                MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
////               mimeMessageHelper.setFrom("farruxbekaxmadaliyev850@gmail.com");
////               mimeMessageHelper.setTo("axmadaliyevfarruxbek967@gmail.com");
////               mimeMessageHelper.setSubject("Salom");
////               mimeMessageHelper.setText("Salom");
////                FileSystemResource file = new FileSystemResource(new File("com/example/examplewordpres/word/12.docx"));
////                mimeMessageHelper.addAttachment("Invoice", file);
////
////
//////                mimeMessageHelper.addAttachment(file.getOriginalFilename(),file);
////            }
////        });
////    }
//
//
//
//
//
//
//
////    public void sendMessageWithAttachment(MultipartFile file) throws MessagingException {
////
////
////        MimeMessage message = javaMailSender.createMimeMessage();
////
////        MimeMessageHelper helper= new MimeMessageHelper(message, true);
////            helper.setFrom("farruxbekaxmadaliyev850@gmail.com");
////            helper.setTo("tohiribodullaye@gmail.com");
////            helper.setSubject("Salom");
////            helper.setText("Salom");
////            helper.addAttachment(file.getOriginalFilename(), file);
////            javaMailSender.send(message);
////
////    }
//}
