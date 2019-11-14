package com.cd.stmty.exception;

import com.cd.stmty.common.BaseStatusError;
import org.springframework.http.HttpStatus;

public class StmtyException extends RuntimeException {

    private static final long serialVersionUID = 5926563242473060260L;
    private int code;
    protected String messageCode;

    public StmtyException(Exception e) {
        super(e);
    }

    public StmtyException(String messageCode, String messageContent) {
        super(messageContent);
        this.messageCode = messageCode;
    }

    public StmtyException(HttpStatus code, String msgCode) {
        this.setCode(code);
        this.setMessageCode(msgCode);
    }

    public StmtyException(String messageContent) {
        super(messageContent);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setCode(HttpStatus code) {
        this.code = code.value();
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }
}
