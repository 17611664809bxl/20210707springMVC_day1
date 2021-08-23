package cn.baizhi.entity;

import java.util.List;

public class Vo {

    private List<Emp> empList;

    @Override
    public String toString() {
        return "Vo{" +
                "empList=" + empList +
                '}';
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public Vo(List<Emp> empList) {
        this.empList = empList;
    }

    public Vo() {
    }
}
