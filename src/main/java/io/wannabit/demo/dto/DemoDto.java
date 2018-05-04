package io.wannabit.demo.dto;

import lombok.Data;

public class DemoDto {

  @Data
  public static class SlackDto {
    private String channel;
    private String username;
    private String text;
  }
}
