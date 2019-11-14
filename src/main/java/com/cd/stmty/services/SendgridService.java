package com.cd.stmty.services;

import com.cd.stmty.common.CommonBase;
import com.cd.stmty.model.User;
import com.cd.stmty.model.UserDetail;
import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SendgridService extends CommonBase {

    @Autowired
    private SendGrid sendGrid;

    @Value("${mail.sender.email}")
    private String senderEmail;

    public Response sendMail(String subject, String body, List<User> recipients) throws Exception {
        Email sender = getSender();
        Personalization personalization = getPersonalization(recipients);
        if (!personalization.getTos().isEmpty()) {
            Content content = new Content("text/html", body);
            return sendMail(subject, content, personalization, sender);
        }
        return null;
    }

    private Email getSender() {
        UserDetail loginUser = getLoginUser();
        String senderName = loginUser.getLastName() + " " + loginUser.getFirstName();
        Email sender = new Email(senderEmail, senderName);
        return sender;
    }

    private Personalization getPersonalization(List<User> recipients) {
        Personalization personalization = new Personalization();
        Set<String> emails = new HashSet<>();
        recipients.forEach(user -> {
            String recipientEmail = user.getEmail();
            if (!emails.contains(recipientEmail)) {
                String recipientName = user.getDisplayName();
                logger.info("{}: {}", recipientEmail, recipientName);
                if (recipientEmail != null && !recipientEmail.isEmpty()) {
                    personalization.addTo(new Email(recipientEmail, recipientName));
                    emails.add(recipientEmail);
                }
            }
        });
        return personalization;
    }

    private Response sendMail(String subject, Content content, Personalization personalization, Email sender)
            throws Exception {
        Mail mail = new Mail();
        mail.setFrom(sender);
        mail.addContent(content);
        mail.addPersonalization(personalization);
        mail.setSubject(subject);

        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        return sendGrid.api(request);
    }
}
