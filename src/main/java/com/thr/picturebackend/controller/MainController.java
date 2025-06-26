package com.thr.picturebackend.controller;


import com.thr.picturebackend.common.BaseResponse;
import com.thr.picturebackend.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping("/health")
    public BaseResponse<String> health () {
        return ResultUtils.success("ok");
    }
}
