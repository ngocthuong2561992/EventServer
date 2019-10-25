package com.cd.stmty.services;

import com.cd.stmty.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User findByDisplayName(String displayName);
}
