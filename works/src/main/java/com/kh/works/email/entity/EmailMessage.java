package com.kh.works.email.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

public class EmailMessage {

    private String to;
    private String subject;
    private String message;
}