package forester.project;

import java.security.Principal;

class StompPrincipal implements Principal {

    private String name;

    public StompPrincipal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}