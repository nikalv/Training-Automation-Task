package org.softserve.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.softserve.models.User;

import java.io.IOException;
import java.util.List;

public class JsonParser {

    public static String userToJson(User user) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(user);
    }

    public static User userFromJsonToObj(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, User.class);
    }

    public static List<User> usersListFromJsonToObj(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json,  new TypeReference<List<User>>(){});
    }
}
