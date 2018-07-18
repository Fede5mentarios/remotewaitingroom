package com.federico.d.bernst.security


data class UserSession(val token: String){
    companion object {
        val sessionName = "userSession"
    }
}
