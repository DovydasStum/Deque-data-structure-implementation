package tests;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.BenchmarkParams;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import utils.Deque_ArrayList;
import utils.Deque_LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(time = 1, timeUnit = TimeUnit.SECONDS)
public class Benchmark {

    @State(Scope.Benchmark)
    public static class DequeBenchmark {

        int[] numbers;
        Deque_LinkedList<Integer> linkedList_numbers;
        Deque_ArrayList<Integer> arrayList_numbers;

        @Setup(Level.Iteration)
        public void generateElements(BenchmarkParams params) {
            numbers = Benchmark.generateElements(Integer.parseInt(params.getParam("elementCount")));
        }

        @Setup(Level.Invocation)
        public void fillLinkedListDeque(BenchmarkParams params) {
            linkedList_numbers = new Deque_LinkedList<>();
            addElementsToLL(numbers, linkedList_numbers);
        }

        @Setup(Level.Invocation)
        public void fillArrayDeque(BenchmarkParams params) {
            arrayList_numbers = new Deque_ArrayList<>(500000);
            addElementsToAR(numbers, arrayList_numbers);
        }


    }

    @Param({"10000", "20000", "40000", "80000"})
    public int elementCount;

    int[] numbers;

    @Setup(Level.Iteration)
    public void generateElements() {
        numbers = generateElements(elementCount);
    }

    public static int[] generateElements(int count) {
        Random picker = new Random();
        int[] numbers = new int[count];
        int minValue = 0;
        int maxValue = 1000;
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = picker.nextInt((maxValue - minValue) + 1) + minValue;
        }
        return numbers;
    }


   /*@org.openjdk.jmh.annotations.Benchmark
    public void addFirstLinkedList(DequeBenchmark deque) {
        for(Integer number: deque.numbers){
            deque.linkedList_numbers.addFirst(number);
        }
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void addFirstArray(DequeBenchmark deque) {
        for(Integer number: deque.numbers){
            deque.arrayList_numbers.addFirst(number);
        }
    }*/




  /*  @org.openjdk.jmh.annotations.Benchmark
    public void addLastLinkedList(DequeBenchmark deque) {
        for(Integer number: deque.numbers){
            deque.linkedList_numbers.addLast(number);
        }
    }

   @org.openjdk.jmh.annotations.Benchmark
    public void addLastArray(DequeBenchmark deque) {
        for(Integer number: deque.numbers){
            deque.arrayList_numbers.addLast(number);
        }
    }*/



    @org.openjdk.jmh.annotations.Benchmark
    public void removeFirstLinkedList(DequeBenchmark deque) {
        deque.linkedList_numbers.removeFirst();
    }
    @org.openjdk.jmh.annotations.Benchmark
    public void removeFirstArray(DequeBenchmark deque) {
        deque.arrayList_numbers.removeFirst();
    }




   /* @org.openjdk.jmh.annotations.Benchmark
    public void removeLastLinkedList(DequeBenchmark deque) {
        deque.linkedList_numbers.removeLast();
    }
    @org.openjdk.jmh.annotations.Benchmark
    public void removeLastArray(DequeBenchmark deque) {
        deque.arrayList_numbers.removeLast();
    }*/




    /*@org.openjdk.jmh.annotations.Benchmark
    public void getFirstLinkedList(DequeBenchmark deque) {
        deque.linkedList_numbers.getFirst();
    }
    @org.openjdk.jmh.annotations.Benchmark
    public void getFirstArray(DequeBenchmark deque) {
        deque.arrayList_numbers.getFirst();
    }*/


    /*
    @org.openjdk.jmh.annotations.Benchmark
    public void getLastLinkedList(DequeBenchmark deque) {
        deque.linkedList_numbers.getLast();
    }
    @org.openjdk.jmh.annotations.Benchmark
    public void getLastArray(DequeBenchmark deque) {
        deque.arrayList_numbers.getLast();
    }
*/
    public static void addElementsToLL(int[] numbersArray, Deque_LinkedList<Integer> numbers) {
        for (Integer number : numbersArray) {
            numbers.addFirst(number);
        }
    }

    public static void addElementsToAR(int[] numbersArray, Deque_ArrayList<Integer> numbers) {
        for (Integer number : numbersArray) {
            numbers.addFirst(number);
        }
    }



    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Benchmark.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}

