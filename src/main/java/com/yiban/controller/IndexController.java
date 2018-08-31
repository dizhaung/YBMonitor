package com.yiban.controller;

import com.yiban.service.Md5Utils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Kuexun on 2018/8/11.
 */
@Controller
public class IndexController {

    @Autowired
    private Md5Utils md5Utils;

    private Logger logger = LoggerFactory.getLogger(IndexController.class);


    @RequestMapping(value = "/index")
    public String index(Model model) throws Exception {

        /*HttpClient httpclient = HttpClients.createDefault();
        HttpPost httpost2 = new HttpPost("https://www.yiban.cn/login?go=http://www.yiban.cn/"); // 数据接口url
        try {
            HttpResponse response2 = httpclient.execute(httpost2);
            String str = EntityUtils.toString(response2.getEntity()); // 这里就是我们要的数据了。
            String tmp = "style=\"display:none;\"";
            System.out.println(tmp);
            str = str.replaceAll(tmp,"");
            tmp = "/captcha/";
            str = str.replaceAll(tmp,"https://www.yiban.cn/captcha/");
            System.out.println(str);
            tmp = "/public/";
            str = str.replaceAll(tmp,"https://www.yiban.cn/public/");
            System.out.println(str);
            tmp = "/upload/";
            str = str.replaceAll(tmp,"https://www.yiban.cn/upload/");
            System.out.println(str);
            tmp = "/ajax/";
            str = str.replaceAll(tmp,"https://www.yiban.cn/ajax/");
            System.out.println(str);
            str = str.replaceFirst("<script>","<script src=\"https://www.yiban.cn/public/js/config/message.js?v=201805311655\"></script><script>");
            str = str.replaceFirst("<script>","<script src=\"https://www.yiban.cn/public/js/config/url.js?v=201805311655\"></script><script>");
            str = str.replaceFirst("<script>","<script src=\"https://www.yiban.cn/public/js/jquery/jquery/1.11.1/jquery.js?v=201805311655\"></script><script>");
            str = str.replaceFirst("<script>","<script src=\"https://www.yiban.cn/public/js/arale/base/1.2.0/aspect.js?v=201805311655\"></script><script>");
            str = str.replaceFirst("<script>","<script src=\"https://www.yiban.cn/public/js/arale/base/1.2.0/attribute.js?v=201805311655\"></script><script>");
            str = str.replaceFirst("<script>","<script src=\"https://www.yiban.cn/public/js/arale/base/1.2.0/base.js?v=201805311655\"></script><script>");
            str = str.replaceFirst("<script>","<script src=\"https://www.yiban.cn/public/js/arale/class/1.2.0/class.js?v=201805311655\"></script><script>");
            str = str.replaceFirst("<script>","<script src=\"https://https://www.yiban.cn/public/js/yiban.js?v=201805311655\"></script><script>");
            str = str.replaceFirst("<script>","<script src=\"https://www.yiban.cn/public/js/vendor/ie.js?v=201805311655\"></script><script>");
            str = str.replaceFirst("<script>","<script src=\"https://www.yiban.cn/public/js/vendor/kick-ie.js?v=201805311655\"></script><script>");
            str = str.replaceFirst("<script>","<script src=\"https://www.yiban.cn/public/js/vendor/rsa/jsencrypt.min.js?v=201805311655\"></script><script>");
            str = str.replaceFirst("<script>","<script src=\"https://www.yiban.cn/public/js/vendor/guide/2015/guide.js?v=201805311655\"></script><script>");
            System.out.println(str);
            model.addAttribute("html",str);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        simulateLogin("13556507839", "zws19970423"); // 模拟登陆github的用户名和密码

        return "index";
    }
    public static String LOGIN_URL = "https://www.yiban.cn/login";
    public static String USER_AGENT = "User-Agent";
    public static String USER_AGENT_VALUE = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0";

    /**
     * @param userName 用户名
     * @param pwd 密码
     * @throws Exception
     */
    public static void simulateLogin(String userName, String pwd) throws Exception {

        /*
         * 第一次请求
         * grab login form page first
         * 获取登陆提交的表单信息，及修改其提交data数据（login，password）
         */
        // get the response, which we will post to the action URL(rs.cookies())
        Connection con = Jsoup.connect(LOGIN_URL);  // 获取connection
        con.header(USER_AGENT, USER_AGENT_VALUE);   // 配置模拟浏览器
        Connection.Response rs = con.execute();                // 获取响应
        Document d1 = Jsoup.parse(rs.body());       // 转换为Dom树
        List<Element> eleList = d1.select("login-pr");  // 获取提交form表单，可以通过查看页面源码代码得知

        // 获取cooking和表单属性
        // lets make data map containing all the parameters and its values found in the form
        Map<String, String> datas = new HashMap<>();
        for (Element e : eleList.get(0).getAllElements()) {
            // 设置用户名
            if (e.attr("id").equals("account-txt")) {
                e.attr("value", userName);
            }
            // 设置用户密码
            if (e.attr("id").equals("password-txt")) {
                e.attr("value", pwd);
            }
            // 排除空值表单属性
            if (e.attr("name").length() > 0) {
                datas.put(e.attr("name"), e.attr("value"));
            }
        }

        /*
         * 第二次请求，以post方式提交表单数据以及cookie信息
         */
        Connection con2 = Jsoup.connect("https://github.com/session");
        con2.header(USER_AGENT, USER_AGENT_VALUE);
        // 设置cookie和post上面的map数据
        Connection.Response login = con2.ignoreContentType(true).followRedirects(true).method(Connection.Method.POST)
                .data(datas).cookies(rs.cookies()).execute();
        // 打印，登陆成功后的信息
        // parse the document from response
        System.out.println(login.body());

        // 登陆成功后的cookie信息，可以保存到本地，以后登陆时，只需一次登陆即可
        Map<String, String> map = login.cookies();
        for (String s : map.keySet()) {
            System.out.println(s + " : " + map.get(s));
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login() throws IOException, ServletException {
        return null;
    }
}
