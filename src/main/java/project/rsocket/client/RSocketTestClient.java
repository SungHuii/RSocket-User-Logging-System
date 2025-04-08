package project.rsocket.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.stereotype.Component;
import project.rsocket.config.RSocketConfig;
import project.rsocket.dto.LogMessageDTO;

import java.time.Instant;

@Component
@RequiredArgsConstructor
@Slf4j
public class RSocketTestClient implements CommandLineRunner {

    private final RSocketStrategies rSocketStrategies;

    @Override
    public void run(String... args) throws Exception {

        RSocketRequester requester = RSocketRequester.builder()
                .rsocketStrategies(rSocketStrategies)
                .dataMimeType(MediaType.APPLICATION_JSON)
                .tcp("localhost", 7000);

        /*LogMessageDTO logMessage = new LogMessageDTO(
                "testUser1",
                "User clicked on 'Join Now' button",
                Instant.now().toString()
        );*/

        requester.route("log.activity")
                .data(new LogMessageDTO(
                        "testUser1",
                        "User clicked on 'Join Now' button",
                        Instant.now().toString()
                ))
                .send()
                .subscribe();

        log.info("DTO sent via Fire-and-Forget");
    }
}
