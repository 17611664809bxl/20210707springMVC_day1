package cn.baizhi.controller;

import cn.baizhi.entity.Emp;
import cn.baizhi.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("emp")
public class EmpController {

    @Resource
    private EmpService empService;

    @RequestMapping("showAll")
    public String showAll(HttpServletRequest request, HttpServletResponse response) {
        List<Emp> empList = empService.selectAll(new Emp(null, null, null, null));
        request.setAttribute("empList", empList);
        return "emplist";
    }

    @RequestMapping("removeById")
    public String removeById(String id) {
        empService.deleteEmp(id);
        return "redirect:/emp/showAll";
    }

    @RequestMapping("addByEmp")
    public String addByEmp(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empService.insertEmp(emp);
        return "redirect:/emp/showAll";
    }

    @RequestMapping("mixByEmpPre")
    public String mixByEmpPre(HttpServletResponse response, HttpServletRequest request,String id) {
        List<Emp> emps = empService.selectAll(new Emp(id, null, null, null));
        Emp emp = null;
        for (Emp emp1 : emps) {
            emp = emp1;
        }
        request.setAttribute("emp", emp);
        return "updateEmp";
    }

    @RequestMapping("mixByEmp")
    public String mixByEmp(Emp emp) {
        empService.updateEmp(emp);
        return "redirect:/emp/showAll";
    }

}
