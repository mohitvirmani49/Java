package com.mohitvirmani;

import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

class mobile implements Comparable<mobile> {
    String name, model, camera;
    int ram, gpu;
    float cost;

    mobile(String name, String model, String camera, int ram, int gpu, float cost) {
        this.name = name;
        this.model = model;
        this.camera = camera;
        this.ram = ram;
        this.gpu = gpu;
        this.cost = cost;
    }


    public int compareTo(mobile m1) {
        if (this.cost > m1.cost) {
            return 1;
        } else if (this.cost < m1.cost) {
            return -1;
        } else {
            return 0;
        }
    }
}

class cmp implements Comparator<mobile> {
    public int compare(mobile l1, mobile l2) {
        if (l1.cost < l2.cost) {
            return 1;
        }
        if (l2.cost < l1.cost) {
            return -1;
        } else {
            return 0;
        }
    }

    public class Main {

        public static void main(String[] args) {

            ArrayList<mobile> al = new ArrayList<mobile>();
            al.add(new mobile("Samsung", "M52", "32", "24", 8, 4, 8433.34f));
            al.add(new mobile("Oppo", "Cam", "12", "108", 12, 8, 10100.23f));
            al.add(new mobile("Vivo", "V1", "50", "64", 8, 0, 158764.23f));
            al.add(new mobile("Moto", "G51", "16", "48", 16, 18000.12f));


            //minimum
            Optional<mobile> st = al.stream().min((i, j) -> i.compareTo(j));
            System.out.println(st.get().name + st.get().model);

            //maximum
            Optional<mobile> stma = al.stream().max((i, j) -> i.compareTo(j));
            System.out.println(stma.get().name + stma.get().model);

            //filter based on ram more than 4gb
            long i = al.stream().filter(lap -> lap.ram > 4).count();
            System.out.println(i);

            //filter based on camera
            long j = al.stream().filter(lap -> lap.gpu < 8).count();
            System.out.println(j);

            // collector
            List<mobile> ob = al.stream().filter(lap -> lap.cost < 100000f).collect(Collectors.toList());
            for (mobile l : ob) {
                System.out.println(l.name + l.model);
            }


            al.stream().filter(lap -> lap.cost > 100000f).map(lap -> lap.cost = (float) (lap.cost - (lap.cost * 0.25))).forEach(x -> System.out.println(x));

            // sort

            List<mobile> ob6 = al.stream().limit(3).sorted((lp1, lp2) -> lp1.compareTo(lp2)).collect(Collectors.toList());
            for (mobile l : ob6) {
                System.out.println(l.name + l.model + l.cost);
            }
        }
        // write your code here
    }
}
