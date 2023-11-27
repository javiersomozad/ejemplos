package es.anaya.spring.basic.s01.xmlandconfig;

import java.util.Random;

public class ArrayShuffler {
  private Random random = new Random();
  
  public Object[] shuffle (Object[] array) {    
    for (int i=0;i<array.length;i++) {
      int j = random.nextInt(array.length-1);
      int k = random.nextInt(array.length-1);
      Object tmp = array[j];
      array[j] = array[k];
      array[k] = tmp;
    }
  
    return array;
  }
}
