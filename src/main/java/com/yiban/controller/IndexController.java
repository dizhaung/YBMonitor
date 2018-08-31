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
        HttpPost httpost2 = new HttpPost("https://www.yiban.cn/login?go=http://www.yiban.cn/"); // ���ݽӿ�url
        try {
            HttpResponse response2 = httpclient.execute(httpost2);
            String str = EntityUtils.toString(response2.getEntity()); // �����������Ҫ�������ˡ�
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
        simulateLogin("13556507839", "zws19970423"); // ģ���½github���û���������

        return "index";
    }
    public static String LOGIN_URL = "https://www.yiban.cn/login";
    public static String USER_AGENT = "User-Agent";
    public static String USER_AGENT_VALUE = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0";

    /**
     * @param userName �û���
     * @param pwd ����
     * @throws Exception
     */
    public static void simulateLogin(String userName, String pwd) throws Exception {

        /*
         * ��һ������
         * grab login form page first
         * ��ȡ��½�ύ�ı���Ϣ�����޸����ύdata���ݣ�login��password��
         */
        // get the response, which we will post to the action URL(rs.cookies())
        Connection con = Jsoup.connect(LOGIN_URL);  // ��ȡconnection
        con.header(USER_AGENT, USER_AGENT_VALUE);   // ����ģ�������
        Connection.Response rs = con.execute();                // ��ȡ��Ӧ
        Document d1 = Jsoup.parse(rs.body());       // ת��ΪDom��
        List<Element> eleList = d1.select("login-pr");  // ��ȡ�ύform��������ͨ���鿴ҳ��Դ������֪

        // ��ȡcooking�ͱ�����
        // lets make data map containing all the parameters and its values found in the form
        Map<String, String> datas = new HashMap<>();
        for (Element e : eleList.get(0).getAllElements()) {
            // �����û���
            if (e.attr("id").equals("account-txt")) {
                e.attr("value", userName);
            }
            // �����û�����
            if (e.attr("id").equals("password-txt")) {
                e.attr("value", pwd);
            }
            // �ų���ֵ������
            if (e.attr("name").length() > 0) {
                datas.put(e.attr("name"), e.attr("value"));
            }
        }

        /*
         * �ڶ���������post��ʽ�ύ�������Լ�cookie��Ϣ
         */
        Connection con2 = Jsoup.connect("https://github.com/session");
        con2.header(USER_AGENT, USER_AGENT_VALUE);
        // ����cookie��post�����map����
        Connection.Response login = con2.ignoreContentType(true).followRedirects(true).method(Connection.Method.POST)
                .data(datas).cookies(rs.cookies()).execute();
        // ��ӡ����½�ɹ������Ϣ
        // parse the document from response
        System.out.println(login.body());

        // ��½�ɹ����cookie��Ϣ�����Ա��浽���أ��Ժ��½ʱ��ֻ��һ�ε�½����
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
