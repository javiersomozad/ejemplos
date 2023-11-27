package es.anaya.spring.reactive.s06.functionaljava;

import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class NumberStreams {
  public void print (List<Integer> numbers) {
    numbers
    .stream()
    .forEach(System.out::println);
  }

  public void parallelPrint(List<Integer> numbers) {
    numbers
      .parallelStream()
      .forEach(System.out::println);
  }

  public List<Float> increment (List<Integer> numbers) {
        return numbers.stream()
            .map(Object::toString)
            .map(Float::parseFloat)
            .collect(Collectors.toList());
  }
  
  public List<Integer> positives (List<Integer> numbers) {
    return numbers
        .stream()
        .filter(n -> n > 0)
        .collect(Collectors.toList());
  }
  
  public int countZeroes (List<Integer> numbers) {
    return numbers
        .stream()
        .filter(n -> n == 0)
        .collect(Collectors.toList())
        .size();
  }
  
  public List<Integer> firstNegatives (List<Integer> numbers) {
    return numbers
        .stream()
        .limit(numbers.size()/2)
        .skip(1)
        .filter(n -> n < 0)
        .collect(Collectors.toList());
  }

  public String numbersAsString (List<Integer> numbers) {
    return numbers
        .stream()
        .map(Object::toString)
        .collect(Collectors.joining(", "));
  }

  
  public int sum (List<Integer> numbers) {
    return  numbers
        .stream()
                .mapToInt(x -> x)
                .sum();
  }

  public int max (List<Integer> numbers) {
    return  numbers
        .stream()
        .mapToInt(x -> x)
        .max()   // min() also available
        .getAsInt();
  }
  
  public int collectSum (List<Integer> numbers) {
    return  numbers
        .stream()
        .collect(Collectors.summingInt(n -> n));
  }
  
  public IntSummaryStatistics listStats (List<Integer> numbers) {
    return  numbers
        .stream()
        .mapToInt(x -> x)
        .summaryStatistics();
  }
  
  public List<Integer> flatten (List<Integer>...numbers) {
    
    return  Arrays.asList(numbers)
        .stream()
        .flatMap(Collection::stream) 
        .collect(Collectors.toList());
  }
  
    public  Map<Integer, Set<Integer>>grouped (List<Integer> numbers)  {
       return numbers
         .stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.toSet()));
    }
}
