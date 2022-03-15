package com.rp.sec01;

import com.github.javafaker.Faker;
import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

    public static void main(String[] args) {

        //define usage: When a long-standing execution is completed,
        // it sends the onComplete signal for us to do the next steps

        //create from runnable
        Runnable myRunnable = () -> {
            System.out.println("runnable is called");
            Util.sleepSeconds(5);
        };

        Mono.fromRunnable(myRunnable).subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        Util.sleepSeconds(1);

    }


}
