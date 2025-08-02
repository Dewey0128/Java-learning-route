package com.george.sessionscope;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/session")
@SessionAttributes({"x", "y"})  //标注了当key是 x 或者 y 时，数据将被存储到会话session中。如果没有 SessionAttributes注解，默认存储到request域中。
public class SessionController {

    /**
     * 第一种方式：使用原生的Servlet API实现。
     *      （在处理器方法的参数上添加一个 HttpSession 参数，SpringMVC会自动将session对象传递给这个参数。）
     *
     * @param session session
     * @return ok
     */
    @RequestMapping("/servlet")
    public String testServlet(HttpSession session){
        session.setAttribute("testSessionScope", "在SpringMVC中使用原生Servlet API实现session域数据共享");
        return "ok";
    }

    /**
     * 第二种方式：使用@SessionAttributes注解标注Controller
     */
    @RequestMapping("/anno")
    public String testSessionAttr(ModelMap modelMap) {
        // 向session域中存储数据
        modelMap.addAttribute("x", "我是埃克斯");
        modelMap.addAttribute("y", "我是歪");

        return "ok";
    }
}
