package es.anaya.spring.reactive.s06.functionaljava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class NumberLoops {
  public int countOddsClassic(List<Integer> numbers) {
    int counter = 0;

    for (int i = 0; i < numbers.size(); i++) {
      if (numbers.get(i) % 2 == 0) {
        counter++;
      }
    }

    return counter;
  }

  public int countOdds(List<Integer> numbers) {
    int counter = 0;
    for (Integer n : numbers) {
      if (n % 2 == 0) {
        counter++;
      }
    }
    return counter;
  }

  public int countOddsConsumer(List<Integer> numbers) {
    int counter = 0;

    numbers.forEach(new Consumer<Integer>() {
      @Override
      public void accept(Integer n) {
        if (n % 2 == 0)
          System.out.println(n);
      }
    });

    return counter;
  }

  public int countOddsStream(List<Integer> numbers) {
    return numbers.stream()
    			  .filter(n -> n % 2 == 0)
    			  .collect(Collectors.toList())
    			  .size();
  }
}
