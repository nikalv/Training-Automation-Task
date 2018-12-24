package org.softserve;

import io.restassured.response.Response;
import org.softserve.models.User;
import org.softserve.services.HttpService;
import org.softserve.utils.JsonParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class verifyCountOfUsersTest {

    @Test(groups = { "usertest"})
    public void getUserByIdTest() throws IOException {
        Response response = HttpService.getUsers();
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);

        String usersListJSONInString = response.getBody().asString();
        List<User> usersList = JsonParser.usersListFromJsonToObj(usersListJSONInString);

        Assert.assertTrue(usersList.size() > 5);
    }
}