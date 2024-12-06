package com.lds.student_currency_system.domain.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.lds.student_currency_system.application.dto.VoucherResponse;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String recipient, String subject, String bodyContent) throws MessagingException {
        String emailBody = buildEmailTemplate(subject, bodyContent);;

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(senderEmail);
        helper.setTo(recipient);
        helper.setSubject(subject);
        helper.setText(emailBody, true);

        javaMailSender.send(mimeMessage);
    }

    private String buildEmailTemplate(String subject, String bodyContent) {
        return String.format("""
            <!DOCTYPE html>
            <html lang="pt-BR">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <style>
                    body { font-family: Arial, sans-serif; line-height: 1.6; color: #333; background-color: #f9f9f9; margin: 0; padding: 0; }
                    .email-container { max-width: 600px; margin: 20px auto; background: #ffffff; border-radius: 8px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); }
                    .email-header { background-color: #FF0000; color: white; text-align: center; padding: 15px; }
                    .email-body { padding: 20px; }
                    .email-footer { text-align: center; font-size: 0.9em; color: #777; padding: 10px 20px; border-top: 1px solid #ddd; }
                    .email-footer a { color: #FF0000; text-decoration: none; }
                    .voucher { border: 2px dashed #ddd; border-radius: 10px; width: 300px; margin: 20px auto; padding: 20px; text-align: center; }
                    .company { font-weight: bold; }
                    .validity { font-size: small; color: #777; }
                    .discount { font-size: 3em; color: #e74c3c; font-weight: bold; }
                    .title { margin-top: 10px; }
                    .qr-code { width: 150px; height: 150px; margin: 20px auto; display: block;}
                    .code { font-size: larger; font-weight: bold; }
                </style>
            </head>
            <body>
                <div class="email-container">
                    <div class="email-header">
                        <h1>%s</h1>  </div> <div class="email-body"> %s </div> <div class="email-footer"> <p>Este é um e-mail automático. Por favor, não responda a esta mensagem.</p> <p>Precisa de ajuda? <a href="mailto:support@meritcoin.com">support@meritcoin.com</a></p> </div> </div> </body> </html> """, subject, bodyContent);
    }

    public void sendTransferNotification(String studentEmail, String studentName, String professorName, float amount) throws MessagingException {
        String bodyContent = String.format("""
            <p>Olá <strong>%s</strong>,</p>
            <p>Você recebeu uma transferência no valor de <strong>R$ %.2f</strong>, enviada pelo professor <strong>%s</strong>.</p>
            <p>Essa transferência foi concluída com sucesso e já está disponível no seu saldo.</p>
            <p>Caso tenha dúvidas, entre em contato com nosso suporte.</p>
            """, studentName, amount, professorName);
    
        sendEmail(studentEmail, "Notificação de Transferência Recebida", bodyContent);
    }

    public void sendPartnerVoucherAcquisitionNotification(String partnerEmail, String studentName, VoucherResponse voucherResponse) throws MessagingException {
        String bodyContent = String.format("""
            <p>Olá,</p>
            <p>O aluno <strong>%s</strong> adquiriu um voucher para <strong>%s</strong> com o código <strong>%s</strong>.</p>
            <p>Detalhes do Voucher:</p>
            <ul>
                <li>Título: %s</li>
                <li>Descrição: %s</li>
                <li>Validade: %s</li>
            </ul>
            """, 
            studentName, 
            voucherResponse.company(), 
            voucherResponse.code(),
            voucherResponse.title(),
            voucherResponse.description(),
            String.format("%02d/%02d/%04d",
                voucherResponse.validity().toLocalDate().getDayOfMonth(),
                voucherResponse.validity().toLocalDate().getMonthValue(),
                voucherResponse.validity().toLocalDate().getYear()));

        sendEmail(partnerEmail, "Novo Voucher Adquirido por Aluno", bodyContent);
    }

    
    public void sendVoucherNotification(String studentEmail, VoucherResponse voucherResponse) throws MessagingException {
    String bodyContent = String.format("""
        <style>
            body { font-family: Arial, sans-serif; }
            .voucher {
                border: 2px dashed #ddd;
                border-radius: 10px;
                width: 300px;
                margin: 20px auto;
                padding: 20px;
                text-align: center;
            }
            .company { font-weight: bold; }
            .validity { font-size: small; color: #777; }
            .discount { font-size: 3em; color: #e74c3c; font-weight: bold; }
            .title { margin-top: 10px; }
            .qr-code { width: 150px; height: 150px; margin: 20px auto; display: block; }
            .code { font-size: larger; font-weight: bold; }
        </style>
        <div class="voucher">
            <div class="company">%s</div>
            <div class="validity">Validade: %s</div>
            <div class="discount">%s</div>
            <div class="title">%s</div>
            <img class="qr-code" src=\"%s\" alt="QR Code 2">
            <div class="code">%s</div>
        </div>
        """,
        voucherResponse.company(),
        String.format("%02d/%02d/%04d",
            voucherResponse.validity().toLocalDate().getDayOfMonth(),
            voucherResponse.validity().toLocalDate().getMonthValue(),
            voucherResponse.validity().toLocalDate().getYear()),
        voucherResponse.description(),
        voucherResponse.title(),
        voucherResponse.qrCode(),
        voucherResponse.code());

    sendEmail(studentEmail, "Voucher Adquirido com Sucesso", bodyContent);
}

}
