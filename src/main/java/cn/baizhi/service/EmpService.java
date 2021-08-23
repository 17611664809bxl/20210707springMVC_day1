package cn.baizhi.service;

import cn.baizhi.entity.Emp;

import java.util.List;

public interface EmpService {

    List<Emp> selectAll(Emp emp);

    void deleteEmp(String id);

    void insertEmp(Emp emp);

    void updateEmp(Emp emp);

}
