package org.jfs.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DriverController {

    @GetMapping("/drivers")
    public String drivers() {
        return "drivers";
    }
} 