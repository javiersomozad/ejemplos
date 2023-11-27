package es.anaya.spring.basic.s02.aop.custompointcuts;

import java.util.Random;

public class PasswordGenerator {
  private int length;
  private String characters;
  private Random random;

  public PasswordGenerator() {
    init();
  }

  @MonitorThis
  public void init() {
    random = new Random();
    length = random.nextInt(8) + 8;
    characters = "abcdefghijklmnopqrstuvw23456789";
  }

  public String generate() {
    String result = "";
    for (int i = 0; i < length; i++)
      result += characters.charAt(random.nextInt(characters.length()));

    return result;
  }
}
