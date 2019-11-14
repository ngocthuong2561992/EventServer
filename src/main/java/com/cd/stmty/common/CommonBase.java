package com.cd.stmty.common;


import com.cd.stmty.model.UserDetail;
import com.cd.stmty.services.UserService;
import com.cd.stmty.util.Const;
import com.google.gson.Gson;
import org.apache.http.annotation.Contract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.acls.AclPermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.acls.model.Permission;
import org.springframework.stereotype.Service;

import java.util.Locale;

public class CommonBase {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageSource messageSource;

    private AclPermissionEvaluator evaluator;

    @Autowired
    private UserService userService;

    @Value("${spring.mvc.locale}")
    private String locale;

    @Autowired
    protected Gson gson;

    protected String getMessage(String code) {
        return messageSource.getMessage(code, null, new Locale(locale));
    }

    protected UserDetail getLoginUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ((UserDetail) auth.getPrincipal());
    }

    protected boolean isCSMember() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return isCSMember(auth) || isAdmin(auth);
    }

    protected boolean isCCMember() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return isCCMember(auth) || isAdmin(auth);
    }

    protected boolean isAdmin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return isAdmin(auth);
    }

    private boolean isAdmin(Authentication auth) {
        boolean result = auth.getAuthorities().contains(new SimpleGrantedAuthority(Const.AuthorizationRoles.ROLE_ADMIN));
        logger.info("{}, {}, {}", auth.getName(), Const.AuthorizationRoles.ROLE_ADMIN, result);
        return result;
    }

    protected boolean isSalesMember() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return isSalesMember(auth) || isAdmin(auth);
    }

    protected boolean isMainStaff(long contractId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return isMainStaff(contractId, auth) || isAdmin(auth);
    }

    protected boolean isSubStaff(long contractId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return isSubStaff(contractId, auth) || isAdmin(auth);
    }

    protected boolean isViewStaff(long contractId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return isViewStaff(contractId, auth) || isAdmin(auth);
    }

    private boolean isCSMember(Authentication auth) {
        boolean result = auth.getAuthorities().contains(new SimpleGrantedAuthority(Const.AuthorizationRoles.ROLE_CS));
        logger.info("{}, {}, {}", auth.getName(), Const.AuthorizationRoles.ROLE_CS, result);
        return result;
    }

    private boolean isCCMember(Authentication auth) {
        boolean result = auth.getAuthorities().contains(new SimpleGrantedAuthority(Const.AuthorizationRoles.ROLE_CC));
        logger.info("{}, {}, {}", auth.getName(), Const.AuthorizationRoles.ROLE_CC, result);
        return result;
    }

    private boolean isSalesMember(Authentication auth) {
        boolean result = auth.getAuthorities().contains(new SimpleGrantedAuthority(Const.AuthorizationRoles.ROLE_SALES));
        logger.info("{}, {}, {}", auth.getName(), Const.AuthorizationRoles.ROLE_SALES, result);
        return result;
    }

    private boolean isMainStaff(long contractId, Authentication auth) {
        return hasPermission(auth, contractId, Contract.class.getName(), CustomPermission.MAIN);
    }

    private boolean isSubStaff(long contractId, Authentication auth) {
        return hasPermission(auth, contractId, Contract.class.getName(), CustomPermission.SUB);
    }

    private boolean isViewStaff(long contractId, Authentication auth) {
        return hasPermission(auth, contractId, Contract.class.getName(), CustomPermission.VIEW);
    }

    protected boolean isViewerOrUpper(long contractId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return isCCMember(auth) || isCSMember(auth) || isMainStaff(contractId, auth) || isSubStaff(contractId, auth)
                || isViewStaff(contractId, auth) || isAdmin(auth);
    }

    private boolean hasPermission(Authentication auth, long id, String classz, Permission permission) {
        boolean result = evaluator.hasPermission(auth, id, classz, permission);
        logger.info("{}, {}, {}, {}, {}", auth.getName(), id, classz, permission, result);
        return result;
    }
}
