import io.restassured.response.Response;
import org.softserve.models.Address;
import org.softserve.models.Company;
import org.softserve.models.User;
import org.softserve.services.HttpService;
import org.softserve.utils.JsonParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class createNewUserTest {

    @Test()
    public void createNewUserTest() throws IOException {
        User user = new User("", "", "",
                new Address("", "", "", ""), "", "",
                new Company("", "", ""));
        String userJSONInString = JsonParser.userToJson(user);
        Response response = HttpService.sendUser(userJSONInString);
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 201);

        String createdUserJSONInString = response.getBody().asString();
        User createdUser = JsonParser.userFromJsonToObj(createdUserJSONInString);

        Assert.assertEquals(user, createdUser);
    }
}
