package com.george.requestscope;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/request")
public class RequestController {

    /**
     * 第一种方式：在SpringMVC中使用原生的Servlet API可以完成request域数据共享
     * @param request request
     * @return "ok"
     */
    @RequestMapping("/servlet")
    public String testServlet(HttpServletRequest request){
        // 向 request域 写入数据
        request.setAttribute("testRequestScope","在SpringMVC中使用原生Servlet API实现request域数据共享");

        return "ok";
    }

    /**
     * 第二种方式：在SpringMVC的处理器方法的参数上添加一个接口类型：Model
     * @param model model
     * @return "ok"
     */
    @RequestMapping("/model")
    public String testModel(Model model){
        model.addAttribute("testRequestScope", "在SpringMVC中使用 Model 实现request域数据共享");

        return "ok";
    }

    /**
     * 第三种方式：在SpringMVC的处理器方法的参数上添加一个类型：ModelMap
     * @param modelMap modelMap
     * @return "ok"
     */
    @RequestMapping("/modelmap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope", "在SpringMVC中使用 ModelMap 实现request域数据共享");

        return "ok";
    }

    /**
     * 第三种方式：在SpringMVC的处理器方法的参数上添加一个类型：ModelMap
     * @param map map
     * @return "ok"
     */
    @RequestMapping("/map")
    public String testModelMap(Map<String, Object> map){
        map.put("testRequestScope", "在SpringMVC中使用 Map 实现request域数据共享");

        return "ok";
    }


    /*
    研究一下：Model接口、Map接口、ModelMap类，三者之间的关系？
        表面上使用的是不同的接口和不同的类。实际上底层都使用了同一个对象：
            org.springframework.validation.support.BindingAwareModelMap

        BindingAwareModelMap 继承了 ExtendedModelMap 类
                                   ExtendedModelMap 继承了 ModelMap 类
                                                          ModelMap类继承了LinkedHashMap继承了HashMap实现了Map接口
                                   ExtendedModelMap 实现了 Model 接口
    */



    /**
     * 第五种方式：使用Spring MVC框架提供的ModelAndView类完成request域数据共享。
     *
     * @return "ok"
     */
    @RequestMapping("/modelAndView")
    public ModelAndView testModelAndView(){
        // 创建 模型视图 对象
        ModelAndView mav = new ModelAndView();
        // 给 模型视图对象 绑定数据
        mav.addObject("testRequestScope", "在SpringMVC当中使用 ModelAndView类 完成request域数据共享");
        // 给 模型视图对象 绑定视图（绑定逻辑视图名称）
        mav.setViewName("ok");
        // 返回 模型视图对象
        return mav;
    }
}
