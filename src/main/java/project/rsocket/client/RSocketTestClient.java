package project.rsocket.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.MediaType;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RSocketTestClient implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        RSocketRequester requester = RSocketRequester.builder()
                .dataMimeType(MediaType.APPLICATION_JSON)
                .tcp("localhost", 7000);

        requester.route("log.activity")
                .data("User clicked on 'Join Now' button")
                .send()
                .subscribe();

        log.info("Log sent via Fire-and-Forget");
    }
}
