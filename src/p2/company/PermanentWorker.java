package p2.company;

public class PermanentWorker extends Worker{
    private int salary;

    public PermanentWorker(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    public int getPay(){
        return salary;
    }

    public void showSalaryInfo(String name){
        System.out.printf("사원 %s의 급여는 %d원\n", name, getPay());
    }
}
