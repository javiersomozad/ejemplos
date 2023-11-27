## Streams en Java
[Proyecto s06.functionaljava]

El lenguaje de programación Java está evolucionando en las últimas versiones, incorporando técnicas e incluso paradigmas de otros lenguajes como la programación funcional. Una de las más evidentes es el tratamiento que permite hacer de las colecciones con métodos bien conocidos en otros entornos como map, filter, etc, sin necesidad de hacer bucles. En lugar de escribir el típico bucle for para recorrer una lista, ahora se puede convertir la colección en un stream e ir aplicando filtros y funciones en una única sentencia. Esta forma de trabajar es similar a la que se utiliza en la programación Reactiva, donde los datos llegan en forma de flujos, así que a continuación se presentan las distintas técnicas existentes en Java para el tratamiento de colecciones, las cuales nos servirán, además de una actualización del conocimiento del lenguaje, como una manera práctica de introducir el concepto de flujos o streams.

### Bucles sobre colecciones

Supongamos que queremos hacer un programa que cuente los números pares de un array.Esta sería la forma clásica de hacerlo:

```java 
public int countOddsClassic(List<Integer> numbers) {
    int counter = 0;

    for (int i = 0; i < numbers.size(); i++) {
      if (numbers.get(i) % 2 == 0) {
        counter++;
      }
    }

    return counter;
  }
```

Desde hace años, existe un foreach implícito en Java utilizando la sententencia for, con la cual se puede ahorrar el tratamiento de índices:

```java
public int countOdds(List<Integer> numbers) {
    int counter = 0;
    for (Integer n : numbers) {
      if (n % 2 == 0) {
        counter++;
      }
    }
    return counter;
  }
```

Otra forma peculiar es aplicar el forEach directamente sobre la colección, cosa que otros lenguajes (Ruby, JavaScript) es algo de lo más natural. En el caso de Java, nos obliga a crear una instancia de Consumer con el método accept para tratar cada elemento:

```java
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
```

Hay una manera de hacerlo con una única línea. Se trata de usar los streams. Desde la versión 8 de Java, las colecciones pueden convertirse en streams invocando simplemente el método stream(). A partir de ahí, se pueden aplicar filtros, agrupaciones y toda clase de modificaciones. En este caso, se consigue contar el número de números pares en una línea:


```java  
  public int countOddsStream(List<Integer> numbers) {
    return numbers.stream()
    			  .filter(n -> n % 2 == 0)
    			  .collect(Collectors.toList())
    			  .size();
  }
```

### Streams sobre colecciones


Este sería el ejemplo más simple. Convertimos la colección a Stream y a cada elemento se le aplica el println para mostrarlo por pantalla:

```java
  public void print (List<Integer> numbers) {
    numbers
    .stream()
    .forEach(System.out::println);
  }
```

Una variante del anterior es usar parallelStream, el cual procesa varios elementos de la colección a la vez. Según lo que querramos obtener no siempre será lo aconsejable:

```java
  public void parallelPrint(List<Integer> numbers) {
    numbers
      .parallelStream()
      .forEach(System.out::println);
  }
```

Map nos permite aplicar una función a cada elemento, en este caso tomamos cada entero , lo convertimos a String, luego a Float, y finalmente retornamos una lista de Float:

```java
  public List<Float> increment (List<Integer> numbers) {
        return numbers.stream()
            .map(Object::toString)
            .map(Float::parseFloat)
            .collect(Collectors.toList());
  }
```

Medianta filter, podemos aplicar un filtro a cada elemento para que se selecionen únicamente aquellos que cumplan con esa condición, y mediante el collect convertimos todos esos elementos en una lista:

```java
  public List<Integer> positives (List<Integer> numbers) {
    return numbers
        .stream()
        .filter(n -> n > 0)
        .collect(Collectors.toList());
  }
```

Además de aplicar filtros, también se puede aplicar al final el método size para obtener simplemente el total de valores que cumples la condición de filtrado:

```java
  public int countZeroes (List<Integer> numbers) {
    return numbers
        .stream()
        .filter(n -> n == 0)
        .collect(Collectors.toList())
        .size();
  }
```

Si queremos sacar determinados valores pero solamente cierto número de ellos, se pueden aplicar distintos funciones:
*	limit(n): en lugar de tratar todos los elementos se limita a n
*	skip(n): permite saltar n elementos del Stream.

```java
  public List<Integer> firstNegatives (List<Integer> numbers) {
    return numbers
        .stream()
        .limit(numbers.size()/2)
        .skip(1)
        .filter(n -> n < 0)
        .collect(Collectors.toList());
  }
```

Una forma de convertir la lista a una cadena, aplicando el formato que queramos, es mediante la conversión a String y aplicando una unión (collect) de todos los elementos con una cadena de unión concreta:

```java
  public String numbersAsString (List<Integer> numbers) {
    return numbers
        .stream()
        .map(Object::toString)
        .collect(Collectors.joining(", "));
  }
```

Otra función obvia es la de suma:

```java
  public int sum (List<Integer> numbers) {
    return  numbers
        .stream()
        .mapToInt(x -> x)
        .sum();
  }
```

Mediante collect podemos unir todos los elementos en uno aplicando distintas funciones. En este caso, se suman todos los valores de la colección:

```java
  public int collectSum (List<Integer> numbers) {
    return  numbers
        .stream()
        .collect(Collectors.summingInt(n -> n));
  }
```

Tambíén al stream se le pueden sacar valores concretos como el máximo y el mínimo:

```java
  public int max (List<Integer> numbers) {
    return  numbers
        .stream()
        .mapToInt(x -> x)
        .max()   // min() also available
        .getAsInt();
  }
```

En el tratamiento de Streams también existe un método por defecto que nos ofrece una instancia de IntSummaryStatistics, que, como su nombre indica, contiene información sobre la colección, como número de elementos, tipos, etc.:

```java
  public IntSummaryStatistics listStats (List<Integer> numbers) {
    return  numbers
        .stream()
        .mapToInt(x -> x)
        .summaryStatistics();
  }
 ```

En el caso de tener, no un conjunto de números sino un conjunto de listas de números, se puede aplicar el aplanado de la misma (flatten), es decir, múltiples listas que se convierten en una:

```java
  public List<Integer> flatten (List<Integer>...numbers) {
    
    return  Arrays.asList(numbers)
        .stream()
        .flatMap(Collection::stream) 
        .collect(Collectors.toList());
  }
```

También se pueden crear agrupaciones y formar otras estructuras de datos. En el siguiente ejemplo, la lista de números se agrupan en una estructura Map:

```java
  public  Map<Integer, Set<Integer>>grouped (List<Integer> numbers)  {
   return numbers
       .stream()  
	 .collect(Collectors.groupingBy(Function.identity(), Collectors.toSet()));
   }
 ```
