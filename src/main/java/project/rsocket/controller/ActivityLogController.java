package project.rsocket.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import project.rsocket.dto.LogMessageDTO;
import reactor.core.publisher.Mono;

@Controller
@Slf4j
public class ActivityLogController {

    @MessageMapping("log.activity")
    public Mono<Void> logUserActivity(LogMessageDTO dto) {

        // 실제 구현 시 DB 저장 등 처리
        log.info("Received User activity logged: {}", dto);
        return Mono.empty(); // fire-and-forget 은 응답 없음
    }
}
