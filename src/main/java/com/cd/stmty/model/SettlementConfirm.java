package com.cd.stmty.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SettlementConfirm implements Serializable {

    private static final long serialVersionUID = -4618741566078280845L;

    private Integer confirmMode;
    private String mailSubject;
    private String mailBody;
    private ConfirmInfo confirmInfo;
    private String contractType;
}
