package validators;

import io.qameta.allure.Step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasKey;

public class RateValidator {
    @Step("Проверить соответствие ответа json схеме")
    public void validateSchema(int statusCode) {
        given()
                .log().all()
                .then()
                .body(matchesJsonSchemaInClasspath(
                        "schemas/rate_schema.json"))
                .statusCode(statusCode);
    }

    @Step("Проверка обязательных полей amount, grow, scale")
    public void validateKeys(String response) {
        given()
                .body(response)
                .then()
                .body("$", hasKey("amount"))
                .body("$", hasKey("grow"))
                .body("$", hasKey("scale"));
    }

    @Step("Проверка обязательных полей amount, grow, scale")
    public void validateHeaders(String response) {
        given()
                .log().all()
                .body(response)
                .then()
                .header("Content-Type", containsString("application/json"));
    }
}