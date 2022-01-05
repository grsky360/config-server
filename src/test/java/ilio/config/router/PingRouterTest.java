package ilio.config.router;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PingRouterTest {

    @Test
    public void testPing() {
        given()
            .when().get("/api/ping")
            .then()
            .statusCode(200)
            .body("data", is("pong"));
    }

}