package io.wannabit.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import io.wannabit.demo.dto.DemoDto.SlackDto;

@Service
public class DemoService {

  private static final String token =
      "xoxp-263815483012-263903951685-357922063767-925db2dbb4838c8a09328760b3af24ee";

  public Map<String, Boolean> send(SlackDto slackDto) throws UnirestException {

    HttpResponse<String> response = Unirest.post("https://slack.com/api/chat.postMessage")
        .header("Content-Type", "application/json").header("Authorization", "Bearer " + token)
        .header("Cache-Control", "no-cache")
        .header("Postman-Token", "e065d31c-d33b-4e7e-81d6-a3e03937c87b")
        .body("{\n  " + "\"channel\" : \"" + slackDto.getChannel() + "\"," + "\n  \"username\" : \""
            + slackDto.getUsername() + "\"," + "\n  \"text\" : \"" + slackDto.getText() + "\","
            + "\n  \"as_user\" : false" + "\n}")
        .asString();

    System.out.println(response.getBody());

    Map<String, Boolean> map = new HashMap<String, Boolean>();
    map.put("isSent", true);
    return map;
  }

}
