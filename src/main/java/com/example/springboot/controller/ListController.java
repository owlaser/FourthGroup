package com.example.springboot.controller;

import com.example.springboot.domain.Osc;
import com.example.springboot.service.DownloadPackage;
import com.example.springboot.service.OscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ListController {
    @Autowired
    private OscService oscService;

    @Autowired
    private DownloadPackage down;

    @RequestMapping("/List")
    public ModelAndView index(){
        List<Osc> OscList = oscService.getAll();
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("OscList", OscList);
        return modelAndView;
    }

    @RequestMapping("/down")
    public ModelAndView index1(@RequestParam String groupId,@RequestParam String artifactId,@RequestParam String version) throws IOException {
        Osc f = down.downloadPackage(groupId,artifactId,version);
        ModelAndView modelAndView = new ModelAndView("/index");
        if(f.getName() == "null"){
            String error = "下载失败，目标源不存在该组件";
            List<Osc> OscList = oscService.getAll();
            modelAndView.addObject("OscList", OscList);
            modelAndView.addObject("error", error);
            return modelAndView;
        }
        else {
            oscService.add(f);
            List<Osc> OscList = oscService.getAll();
            modelAndView.addObject("OscList", OscList);
            return modelAndView;
        }
    }

    @RequestMapping("/search")
    public ModelAndView index2(@RequestParam String name) throws IOException {
        List<Osc> OscList = oscService.getFromName(name);
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("OscList", OscList);
        return modelAndView;
    }
}
