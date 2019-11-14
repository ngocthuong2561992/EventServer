package com.cd.stmty.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfirmInfo implements Serializable {

    private static final long serialVersionUID = -4618741566078280845L;

    private Long contractId;
    private Integer deliveryWay;
    private Date deliveryDate;
    private String deliveryTime;
    private String deliveryPlace;
    private String deliveryNote;
    private Date transferKeyDate;
    private String transferKeyPlace;
    private Integer sentConfirmMail;
    private Integer updatedBy;

}