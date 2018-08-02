package com.federico.d.bernst.remotewaitingroom.security

data class JwtAuthenticationResponse(val accessToken: String) {
    val tokenType = "Bearer"
}
