package com.moreview.global.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moreview.domain.work.Service.WorkService;
import com.moreview.domain.work.WorkSlide;
import com.moreview.domain.work.WorkText;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketHandler extends TextWebSocketHandler {

    private final WorkService workService;
    private final ObjectMapper objectMapper;
    private String workId;
    private WorkSlide workSlide;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        String payload = message.getPayload();

        // 메시지를 WorkText 객체로 변환
        WorkText workText = objectMapper.readValue(payload, WorkText.class);

        // UUID 가져오기
        workId = workText.getWorkId();

        // WorkSlide 찾기
        workSlide = workService.findWorkSlide(workId);

        // 로직 실행
        workService.handleMessage(workSlide, workText,session);
    }
}
