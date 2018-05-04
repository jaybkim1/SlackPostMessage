package io.wannabit.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.exceptions.UnirestException;

import io.wannabit.demo.dto.DemoDto.SlackDto;
import io.wannabit.demo.service.DemoService;

@RestController
public class DemoController {

  @Autowired DemoService demoService;

  @RequestMapping(value = "/test", method = RequestMethod.POST)
  public Map<String, Boolean> test(@RequestBody SlackDto slackDto) throws UnirestException {
    return demoService.send(slackDto);
  }

}
