package com.bmo.configmapbooster.service;

public class Message {

    private final String content;

    public Message() {
        this.content = null;
    }

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
