package forester.project;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

public class CustomHandshake extends DefaultHandshakeHandler {

    @Override
    protected Principal determineUser(ServerHttpRequest request, org.springframework.web.socket.WebSocketHandler wsHandler, Map<String, Object> attributes) {
        return new StompPrincipal(UUID.randomUUID().toString());
    }
}
