package cn.baizhi.service;

import cn.baizhi.dao.EmpDao;
import cn.baizhi.entity.Emp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("empService")
@Transactional
public class EmpServiceImpl implements EmpService{

    @Resource
    private EmpDao empDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Emp> selectAll(Emp emp) {
        List<Emp> list = empDao.selectAll(emp);
        return list;
    }

    @Override
    public void deleteEmp(String id) {
        empDao.delete(id);
    }

    @Override
    public void insertEmp(Emp emp) {
        empDao.insert(emp);
    }

    @Override
    public void updateEmp(Emp emp) {
        empDao.update(emp);
    }



}
