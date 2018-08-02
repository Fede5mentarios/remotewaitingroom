package com.federico.d.bernst.controller.service

import com.federico.d.bernst.controller.response.AuthResponse

interface LoginService {
    fun login(username: String, password: String): AuthResponse
}