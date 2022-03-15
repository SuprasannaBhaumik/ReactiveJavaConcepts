package com.rp.sec01;

import java.util.stream.Stream;

public class Lec01Stream {

    public static void main(String[] args) {

        //create a stream
        Stream<String> stringStream = Stream.of("Suprasanna", "Bhaumik");

        //output it
        System.out.println(stringStream);

        //consume it
        stringStream.forEach(System.out::println);

    }


}
