package com.rp.sec01;

import com.rp.courseutil.Util;
import com.rp.sec01.assignment.FileService;

public class Lec09AssignmentDemo {

    public static void main(String[] args) {

        FileService.write("This is file3","file03.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.read("file03.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.delete("file03.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }

}
