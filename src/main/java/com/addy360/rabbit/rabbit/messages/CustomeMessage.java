package com.addy360.rabbit.rabbit.messages;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomeMessage {
    private String messageId;
    private String message;
    private String messageDate;
}
