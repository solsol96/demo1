package com.usertest.demo1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class HomeController {

    //system.out 은 시스템이 느려짐 -> logger 를 통해 효율적인 메모리 관리
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String main(Model model) {
        // model : 데이터를 담는 구조로 Map 형태로 데이터를 담는다.
        // model.addAttribute("변수명" , 값);

        model.addAttribute("msg" , "홈페이지 방문을 환영합니다.");
        return "main";
    }

//    @RequestMapping(value = "home.do" , method = RequestMethod.GET)
//    public String main(Locale locale , Model model) {
//        logger.info("Welcome home! The Client locale is {}." , locale);
//
//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG , DateFormat.LONG , locale);
//
//        String formmatedDate = dateFormat.format(date);
//
//        model.addAttribute("serverTime" , formmatedDate);
//
//        return "home";
//    }
}
