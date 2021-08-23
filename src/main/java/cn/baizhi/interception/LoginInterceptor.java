package cn.baizhi.interception;

import cn.baizhi.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    /**
     * 请求到达Controller之前执行该方法
     *
     * @param request
     * @param Response
     * @param o
     * @return false：不放行 true：放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse Response,
            Object o) throws Exception {

        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");

        if(user!=null){
            return true;
        }else{
            log.info("path: {}",request.getContextPath()+"/login.jsp");
            Response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;
        }
    }

    /**
     * controller中方法执行完毕后未响应之前执行该方法
     *
     * @param httpServletRequest 当前请求对象
     * @param httpServletResponse 当前相应对象
     * @param o 目标方法对象
     * @param modelAndView 模型视图对象
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("我只是想知道进不进的来");
    }

    /**
     * 响应完全结束后执行该方法  出现异常时执行该方法
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
