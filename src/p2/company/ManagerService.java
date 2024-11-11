package p2.company;

import java.util.ArrayList;
import java.util.List;

public class ManagerService {
    private List<Worker> workers;

    public ManagerService() {
        workers = new ArrayList<Worker>();
        this.workers = workers;
    }

    public void addWorker(Worker worker){
        workers.add(worker);
    }

    public void showAllSalaryInfo(){
        for (Worker worker : workers) {
            worker.showSalaryInfo(worker.name);
        }
    }

    public void showSalaryInfo(String name){
        for (Worker worker : workers) {
            if (worker.name.equals(name)) {
                worker.showSalaryInfo(name); // 이름이 일치하는 Worker의 급여 정보 출력
                return;
            }
        }
        System.out.println("해당 이름의 사원이 없습니다.");
    }

    public void showTotalSalary(){
        int totalSalary = 0;
        for (Worker worker: workers){
            totalSalary += worker.getPay();
        }
        System.out.println("모든 사원들의 급여 총액은: " + totalSalary);
    }
}
