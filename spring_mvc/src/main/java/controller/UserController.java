package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.User;
import domain.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    // http://localhost:8080/user/quick
    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    public String save() {
        System.out.println("UserController Save Running...");
        return "success";
    }

    @RequestMapping(value = "/quick2")
    public ModelAndView save2() {
        /*
        *   Model: 模型 作用封装数据
        *   View:  视图 作用展示数据
        * */
        System.out.println("UserController Save2 Running...");
        ModelAndView modelAndView = new ModelAndView();
        // 设置视图名称
        modelAndView.setViewName("success");
        // 设置模型数据
        modelAndView.addObject("user", "222");
        return modelAndView;
    }

@RequestMapping(value = "/quick3")
public ModelAndView save3(ModelAndView modelAndView) {
    System.out.println("UserController Save3 Running...");
    // 设置视图名称
    modelAndView.setViewName("success");
    // 设置模型数据
    modelAndView.addObject("user", "333");
    return modelAndView;
}

@RequestMapping(value = "/quick4")
public String save4(Model model) {
    System.out.println("UserController Save4 Running...");
    // 设置模型数据
    model.addAttribute("user", "444");
    return "success";
}

    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request) {
        System.out.println("UserController Save5 Running...");
        request.setAttribute("user", "555");
        return "success";
    }

    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        System.out.println("UserController Save6 Running...");
        response.getWriter().write("666");
    }

    @RequestMapping(value = "/quick7")
    @ResponseBody   // 告知SpringMVC 不进行视图跳转 直接进行数据响应
    public String save7() throws IOException {
        System.out.println("UserController Save7 Running...");
        return "777";
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody   // 告知SpringMVC 不进行视图跳转 直接进行数据响应
    public String save8() throws IOException {
        System.out.println("UserController Save8 Running...");
        return "{\"username\" : \"zhangsan\", \"age\" : 18}";
    }

    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9() throws IOException {
        System.out.println("UserController Save9 Running...");
        User user = new User();
        user.setUsername("zhangsan");
        user.setAge(18);
        // 使用json的转换工具将对象转换成json格式字符串再返回
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping(value = "/quick10")
    @ResponseBody
    //期望SpringMVC自动将User转换成json格式的字符串
    public User save10() {
        System.out.println("UserController Save10 Running...");
        User user = new User();
        user.setUsername("zhangsan");
        user.setAge(18);
        return user;
    }

    @RequestMapping(value = "/quick11")
    @ResponseBody
    public void save11(String username, int age) {
        System.out.println("UserController Save11 Running...");
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(User user) {
        System.out.println("UserController Save12 Running...");
        System.out.println(user);
    }

    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(String[] strs) {
        System.out.println("UserController Save13 Running...");
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping(value = "/quick14")
    @ResponseBody
    public void save14(Users users) {
        System.out.println("UserController Save14 Running...");
        System.out.println(users);
    }

    @RequestMapping(value = "/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> users) {
        System.out.println("UserController Save15 Running...");
        System.out.println(users);
    }

    @RequestMapping(value = "/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name", required = false, defaultValue = "张三") String username) {
        System.out.println("UserController Save16 Running...");
        System.out.println(username);
    }

    @RequestMapping(value = "/quick17/{username}")
    @ResponseBody
    public void save17(@PathVariable(value = "username") String username) {
        System.out.println("UserController Save17 Running...");
        System.out.println(username);
    }

    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date) {
        System.out.println("UserController Save18 Running...");
        System.out.println(date);
    }

    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println("UserController Save19 Running...");
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent", required = false) String user_agent) {
        System.out.println("UserController Save20 Running...");
        System.out.println(user_agent);
    }

    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(@CookieValue("JSESSIONID") String jsessionid) {
        System.out.println("UserController Save21 Running...");
        System.out.println(jsessionid);
    }

@RequestMapping(value = "/quick22")
@ResponseBody
public void save22(String username, String password, MultipartFile uploadFile) throws IOException {
    System.out.println("UserController Save22 Running...");
    System.out.println(username);
    System.out.println(password);
    System.out.println(uploadFile);
    String filename = uploadFile.getOriginalFilename();
    uploadFile.transferTo(new File("D:\\" + filename));
}

    @RequestMapping(value = "/quick23")
    @ResponseBody
    public void save23(String username, MultipartFile uploadFile1, MultipartFile uploadFile2) {
        System.out.println("UserController Save23 Running...");
        System.out.println(username);
        System.out.println(uploadFile1.getOriginalFilename());
        System.out.println(uploadFile2.getOriginalFilename());
    }

    @RequestMapping(value = "/quick24")
    @ResponseBody
    public void save24(@RequestParam("username") String name, MultipartFile[] uploadFiles) {
        System.out.println("UserController Save24 Running...");
        System.out.println(name);
        System.out.println(uploadFiles.length);
        for (MultipartFile uploadFile : uploadFiles) {
            System.out.println(uploadFile.getOriginalFilename());
        }
    }
}