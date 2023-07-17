package FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class A implements MyFunctionalInterface{
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
class Employee{
    String name;
    int salary;

    public Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
    }
}
public class FI  {
    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee("Sawan", 5));
        emp.add(new Employee("Anirban", 43));
        emp.add(new Employee("Rudrarup", 32));
        emp.add(new Employee("Soumo", 10));

        Consumer<String> c = s -> System.out.println(s);
        Predicate<Integer> p = (salary) -> salary > 30;

        //provide me the position of the emp name based on salary
        Function<Employee, String> f = e -> {
            int salary = e.salary;
            String pos = "";
            if(salary == 5) pos = "Analyst";
            else if (salary > 9 && salary < 30) pos = "Senior Analyst";
            else if (salary > 30 && salary < 40) pos = "Consultant";
            else pos = "Senior Consultant";
            return pos;
        };

        /*for( Employee e : emp){
            System.out.println("Name :" + e.name);
            System.out.println("Salary :" + e.salary);
            System.out.println("Position :" + f.apply(e));
            System.out.println();
        }*/

        /*for( Employee e : emp){
            if(p.test(e.salary)){
                c.accept(e.name);
            }
            System.out.println();
        }*/

        Supplier<String> s = () ->{
          String otp = "";
          for(int i=0;i<4;i++){
              otp = otp + (int)(Math.random() * 10);
          }
          return otp;
        };

        System.out.println(s.get());
        System.out.println((int)(Math.random() * 10));

        String a = "32";
        String b = "2";
        int mod = (int)1e9+7;
        //long res = (long)((Integer.valueOf(first) * Integer.valueOf(second)) % mod);
        long res = ((long)((Integer.valueOf(a) * Integer.valueOf(b)) % mod));
        System.out.println("res : " + res);

    }
}

//predicate -> test
//function -> apply
//consumer -> accept
//supplier -> get