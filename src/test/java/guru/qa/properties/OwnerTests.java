package guru.qa.properties;

import guru.qa.config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class OwnerTests {
    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

    @Test
    @Tag("properties")
    void readCredentialsTest(){
        String login = credentials.login();
        String password = credentials.password();
    }
}
