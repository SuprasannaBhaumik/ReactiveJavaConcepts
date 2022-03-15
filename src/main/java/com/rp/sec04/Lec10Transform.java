package com.rp.sec04;

import com.rp.courseutil.Util;
import com.rp.sec04.helper.Person;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lec10Transform {

    public static void main(String[] args) {

            getPerson()
                    .transform(applyFilterMap())
                    .subscribe(Util.subscriber());


            Flux.range(1, 10)
                    .transform(evenTransformation())
                    .subscribe(Util.subscriber());

    }

    public static Flux<Person> getPerson(){
        return Flux.range(1, 10)
                    .map(i -> new Person());
    }

    public static Function<Flux<Person>, Flux<Person>> applyFilterMap(){
        return flux -> flux
                            .filter(p -> p.getAge() > 10)
                            .doOnNext(p -> p.setName(p.getName().toUpperCase()))
                            .doOnDiscard(Person.class, p -> System.out.println("Not allowing : " + p));
    }


    public static Function<Flux<Integer>, Flux<Integer>> evenTransformation(){
        return flux -> flux
                .filter( i -> i%2 ==0)
                .doOnDiscard(Integer.class, o -> System.out.println("Rejected:"+o));
    }


}
