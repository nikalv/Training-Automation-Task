package org.softserve.testing;

import io.restassured.response.Response;
import org.softserve.models.User;
import org.softserve.services.HttpService;
import org.softserve.utils.JsonParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class getUserByIdTest {

    @Test(groups = { "usertest"})
    public void getUserByIdTest() throws IOException {
        Response response = HttpService.getUserById(1);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        String userJSONInString = response.getBody().asString();
        User user = JsonParser.userFromJsonToObj(userJSONInString);

        Assert.assertEquals(user.getName(), "Leanne Graham");
        Assert.assertEquals(user.getUsername(), "Bret");
        Assert.assertEquals(user.getAddress().getCity(), "Gwenborough");

    }

}
