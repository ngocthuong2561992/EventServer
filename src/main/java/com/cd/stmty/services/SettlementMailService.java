package com.cd.stmty.services;

import com.cd.stmty.common.CommonBase;
import com.cd.stmty.model.SettlementConfirm;
import com.cd.stmty.model.User;
import com.cd.stmty.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettlementMailService extends CommonBase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SendgridService sendgridService;

    public void sendMailToStakeholders(SettlementConfirm settlementConfirm) throws Exception {
        List<User> recipients = userRepository.findAll();
        String subject = settlementConfirm.getMailSubject();
        String body = settlementConfirm.getMailBody();
        sendgridService.sendMail(subject, body, recipients);
    }
}
