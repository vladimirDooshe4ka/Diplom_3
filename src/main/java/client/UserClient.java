package client;
import Data.UserData;
import constants.ConstantAPI;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserClient {

    public RequestSpecification getDefaultRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConstantAPI.BASE_URL)
                .setContentType(ContentType.JSON)
                .build();
    }

    public ValidatableResponse createUser(UserData userData){
        return given()
                .spec(getDefaultRequestSpec())
                .body(userData)
                .log()
                .all()
                .post(ConstantAPI.USER_CREATE)
                .then();
    }

    public ValidatableResponse loginUser(UserData userData){
        return given()
                .spec(getDefaultRequestSpec())
                .body(userData)
                .post(ConstantAPI.USER_LOGIN)
                .then();
    }

    public ValidatableResponse deleteUser(String token){
        return given()
                .header("Authorization", "Bearer" + token)
                .spec(getDefaultRequestSpec())
                .delete(ConstantAPI.USER_PATCH)
                .then();
    }



}
