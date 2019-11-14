package com.cd.stmty.common;


import org.springframework.security.acls.model.Permission;

import org.springframework.security.acls.domain.BasePermission;

public class CustomPermission extends BasePermission{

    public static final Permission VIEW = new CustomPermission(1 << 5, 'V'); // 32
    public static final Permission SUB = new CustomPermission(1 << 6, 'S'); // 64
    public static final Permission MAIN = new CustomPermission(1 << 7, 'M'); // 128

    private static final long serialVersionUID = -2146195359775386156L;

    private CustomPermission(int mask) {
        super(mask);
    }

    protected CustomPermission(int mask, char code) {
        super(mask, code);
    }
}
