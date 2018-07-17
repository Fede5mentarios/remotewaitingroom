package com.federico.d.bernst.security

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm

class JWTAuthClass(secret: String) {
    private val algorithm = Algorithm.HMAC256(secret)
    val verifier = JWT.require(algorithm).build()

    fun sign(userName: String): String = JWT.create().withClaim(claimName, userName).sign(algorithm)

    companion object {
        val claimName = "user"
    }
}