package org.jfs.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AssignmentController {

    @GetMapping("/assignments")
    public String assignments() {
        return "assignments";
    }
} 