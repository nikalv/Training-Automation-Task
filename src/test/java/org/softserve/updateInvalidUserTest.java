package org.softserve;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.softserve.models.Address;
import org.softserve.models.Company;
import org.softserve.models.User;
import org.softserve.services.HttpService;
import org.softserve.utils.JsonParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class updateInvalidUserTest {

    @Test(groups = { "usertest"})
    public void UpdateInvalidUserTest() throws JsonProcessingException {
        User user = new User("John", "Doe", "john.doe@gmail.com",
                new Address("Main", "Apt. 111", "LA", "88000"), "133-33-33", "www.jd-ws.com",
                new Company("Robel-Corkery", "Multi-tiered zero tolerance productivity", "transition cutting-edge web services"));
        String userJSONInString = JsonParser.userToJson(user);
        int statusCode = HttpService.updateUser(userJSONInString, 15).getStatusCode();

        Assert.assertEquals(statusCode, 404);
    }
}