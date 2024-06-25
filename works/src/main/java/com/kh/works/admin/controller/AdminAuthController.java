package com.kh.works.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AdminAuthController {

    @GetMapping("admin/auth_manage")
    public String showAuthPage(){
        return "admin/auth_manage";
    }
}
