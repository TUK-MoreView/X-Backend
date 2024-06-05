package com.moreview.domain.work;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

@Getter
public class WorkSlide {

    private String workId;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();

    @Builder
    public WorkSlide(String workId, String name) {
        this.workId = workId;
        this.name = name;
    }
}
