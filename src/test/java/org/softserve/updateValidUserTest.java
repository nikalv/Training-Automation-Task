package org.softserve;

import io.restassured.response.Response;
import org.softserve.models.Address;
import org.softserve.models.Company;
import org.softserve.models.User;
import org.softserve.services.HttpService;
import org.softserve.utils.JsonParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class updateValidUserTest {

    @Test(groups = { "usertest"})
    public void UpdateValidUserTest() throws IOException {
        User user = new User("John", "Doe", "john.doe@gmail.com",
                new Address("Main", "Apt. 111", "LA", "88000"), "133-33-33", "www.jd-ws.com",
                new Company("Robel-Corkery", "Multi-tiered zero tolerance productivity", "transition cutting-edge web services"));
        String userJSONInString = JsonParser.userToJson(user);
        Response response = HttpService.updateUser(userJSONInString, 5);
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);

        String updatedUserJSONInString = response.getBody().asString();
        User updatedUser = JsonParser.userFromJsonToObj(updatedUserJSONInString);

        Assert.assertEquals(user, updatedUser);
    }
}