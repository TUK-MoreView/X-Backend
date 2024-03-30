package com.moreview.domain.work;

import lombok.Getter;

@Getter
public class WorkText {

    public enum TextType {
        ENTER, TEXT
    }

    private TextType type;
    private String workId;
    private String sender;
    private String text;
}
