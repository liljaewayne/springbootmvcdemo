package com.ljw.controller;

import com.ljw.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 接受参数示例
 */
@Controller
@Slf4j
@RequestMapping("/req")
public class ReqDemo {
    // 接收表单参数
    @RequestMapping("/formDemo")
    public String formDemo(
            @RequestParam(name = "id", required = false, defaultValue = "999") String id,
            @RequestParam(name = "name", required = false, defaultValue = "默认名字") String name
    ) {
        log.info("接收 id={}", id);
        log.info("接收 name={}", name);
        return "success";
    }

    // json对象参数
    @RequestMapping("/jsonEntity")

    public String jsonEntity(@RequestBody Student student) {
        log.info("接收 student={}", student);
        return "success";
    }

    // json对象参数
    @RequestMapping("/jsonEntityAsMap")

    public String jsonEntityAsMap(
            @RequestBody Map<String, String> studentProperties) {
        log.info("接收 Map={}", studentProperties);
        studentProperties.forEach((k, v) -> log.info("{}={}", k, v));

        return "success";
    }

    // json对象参数
    @RequestMapping("/jsonArrayObjsAsListObj")

    public String jsonArrayObjsAsListObj(@RequestBody List<Student> students) {
        log.info("接收 students={}", students);

        return "success";
    }

    // json对象参数
    @RequestMapping("/jsonArrayObjsAsListMap")
    public String jsonArrayObjsAsListMap(@RequestBody List<Map<String, String>> studentsAsMap) {
        log.info("接收 studentsAsMap={}", studentsAsMap);

        return "success";
    }

}
