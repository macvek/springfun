package pl.almatron.embedded;

import org.springframework.stereotype.Component;

/**
 * httpserver
 *
 * @author macvek
 */
@Component
public class KillServer {

    public void kill() {
        new Thread(() -> {
            try {
                HelloWorld.server.stop();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();

    }
}
