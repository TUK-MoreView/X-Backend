package com.moreview.domain.work.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moreview.domain.work.WorkSlide;
import com.moreview.domain.work.WorkText;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkService {

    private final ObjectMapper objectMapper;
    private Map<String, WorkSlide> workSlides; // repository 대신 사용

    // 서버가 실행되면 실행
    @PostConstruct
    public void init() {
        workSlides = new LinkedHashMap<>();
    }

    // 채팅방 생성
    public WorkSlide createWorkSlide(String name) {
        String randomId = UUID.randomUUID().toString();

        WorkSlide workSlide = WorkSlide.builder()
                .workId(randomId)
                .name(name)
                .build();

        // WorkSlides(목록)에 채팅방 추가
        workSlides.put(workSlide.getWorkId(), workSlide);
        return workSlide;
    }

    // workId로 채팅방 찾기
    public WorkSlide findWorkSlide(String workId) {
        return workSlides.get(workId);
    }

    // WorkSlide에 있는 모든 session에 메시지 전송
    public void sendToAllMessage(WorkSlide workSlide, String text) {
        workSlide.getSessions().forEach(session -> {
            sendText(session, text);
        });
    }

    // session에 메시지 전송
    public <T> void sendText(WebSocketSession session, T text) {
        try {
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(text)));
        } catch (IOException e) {
            throw new IllegalArgumentException("메시지 전송 실패");
        }
    }

    // TextType에 따라 로직 실행
    public void handleMessage(WorkSlide WorkSlide, WorkText text, WebSocketSession session) {

        // 텍스트 타입이 ENTER면
        if (text.getType().equals(WorkText.TextType.ENTER)) {

            // 채팅방에 session추가
            WorkSlide.getSessions().add(session);

            // 메시지 보낸 사람 이름 가져오기
            String sender = text.getSender();
            sendToAllMessage(WorkSlide, sender + "님이 입장하셨습니다.");
        }
        else {

            // 메시지 보낸 사람 이름 가져오기
            String sender = text.getSender();
            sendToAllMessage(WorkSlide, sender + " : " + text.getText());
        }
    }


}
