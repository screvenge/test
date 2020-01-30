package com.study.service.aspect;

import com.alibaba.fastjson.JSON;
import com.study.common.AccountUtil;
import com.study.common.web.HttpCommonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 发送邮件抽象类
 */
public abstract class EmailUtil {
    public static void sendEmail(String moduleId, String msg, String account) {
        // url和signkey应该写到配置中, 待完成
        String url = "";
        String signKey = "";
        String jsonBody = JSON.toJSONString(new EmailContent("模块: " + moduleId + ",发件人: " + AccountUtil.getInstance().getAccount() + ",收件人 : " + account, "内容: " + msg));

        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json;charset=UTF-8");
        header.put("sign", HmacSHA256.encrypt(jsonBody, signKey)); // 签名是把请求参数拼接起来通过HmacSHA256进行加密
        // 这个是瞎编的, 公司的特有标识
        header.put("nodeId", "zhangshuailong");

        String response = null;
        try {
            response = HttpCommonUtil.getInstance().executePostWithJsonAndSSL(url, jsonBody, header);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("邮件发送失败");
        }

        // 响应成功返回200
        if (null == response || !response.equals("200")) {
            System.out.println("邮件发送失败");
        } else {
            System.out.println("邮件发送成功");
            // 记录到数据库
        }
    }
}

class HmacSHA256 {
    public static String encrypt(String param, String signKey) {
        return param + signKey;
    }
}

/**
 * 邮件正文
 */
class EmailContent {
    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    public EmailContent(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
