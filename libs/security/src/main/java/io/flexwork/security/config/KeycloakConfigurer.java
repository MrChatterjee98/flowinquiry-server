package io.flexwork.security.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfigurer {

    @Value("${application.keycloak.server-url}")
    private String serverUrl;

    @Value("${application.keycloak.realm}")
    private String realm;

    @Value("${application.keycloak.client-id}")
    private String clientId;

    @Value("${application.keycloak.username}")
    private String username;

    @Value("${application.keycloak.password}")
    private String password;

    @Bean
    public Keycloak keycloak() {
        return KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .clientId(clientId)
                .grantType(OAuth2Constants.PASSWORD)
                .username(username)
                .password(password)
                .build();
    }
}
