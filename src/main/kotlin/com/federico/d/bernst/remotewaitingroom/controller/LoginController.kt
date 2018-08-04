package com.federico.d.bernst.remotewaitingroom.controller

import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Transactional
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

@Controller
class LoginController {

    @Transactional
    @PostMapping("/login")
    fun login(model: Model, @RequestParam username: String, @RequestParam password: String): String {
        model.addAttribute("name", "Burika")
        model.addAttribute("empresas", listOf("emp1", "emp2", "emp3"))
        return "home"
    }

    @Transactional
    @PostMapping("/api/login")
    fun login(@RequestParam username: String, @RequestParam password: String): ModelAndView {
        val myv: ModelAndView
        if (password.equals("pass")) {
            myv = ModelAndView("home")
            myv.addObject("name", username)
            myv.addObject("empresas", listOf("emp1", "emp2", "emp3"))
        } else {
            myv = ModelAndView("login")
            myv.addObject("errorMessage", "Password Incorrecto")
        }
        return myv
    }
}