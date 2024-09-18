package com.Assignment2Spring.utils.helper;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String content;

    @Builder.Default
    private MessageType type = MessageType.success;
}
