package com.mohitvirmani;
import java.util.*;

interface evenodd{
    public void even_odd(int num);
}

interface posneg{
    public void pos_neg(int num);
}

interface strupper{
    public String str_upper(String s) ;
}

class LambdaImpl{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        strupper up = (String s) -> s.toUpperCase();
        System.out.println("Input string in lowercase:");
        String x = in.next();
        System.out.println(up.str_upper(x));
    }
}
