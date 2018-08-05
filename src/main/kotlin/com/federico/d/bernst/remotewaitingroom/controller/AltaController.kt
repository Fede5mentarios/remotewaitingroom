package com.federico.d.bernst.remotewaitingroom.controller

import com.federico.d.bernst.remotewaitingroom.service.HomeService
import com.federico.d.bernst.remotewaitingroom.service.response.HomeResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Transactional
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class AltaController(@Autowired val homeService: HomeService) {

    @Transactional
    @GetMapping("/")
    fun indexToHome(model: Model) = "home"

    @Transactional
    @GetMapping("/home")
    fun home() =  responseToModel(homeService.getHomeData())

    private fun responseToModel(homeData: HomeResponse): ModelAndView {
        val viewModel = ModelAndView("home")
        viewModel.addObject("name", homeData.username)
        homeData.error?.let { viewModel.addObject("error",it) }
        return viewModel
    }

    @Transactional
    @GetMapping("/redirect/login")
    fun redirectTologin(): String {
        return "login"
    }
}