package com.federico.d.bernst.security

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm

class JWTAuthClass(secret: String, val issuer: String, val realm: String) {

    private val algorithm = Algorithm.HMAC256(secret)
    val verifier = JWT.require(algorithm).withIssuer(issuer).build()

    //    fun sign(userName: String) = JWT.create().withClaim(claimName, userName).sign(algorithm)
    fun sign(userName: String) = JWT.create()
            .withSubject("Authentication")
            .withIssuer(issuer)
            .withClaim(claimName, userName)
//            .withExpiresAt(getExpiration())
            .sign(algorithm)

    companion object {
        val claimName = "user"
        val instance = JWTAuthClass("my-super-secret-for-jwt", "remoteWR.com", "Remote Waiting Room Realm")
    }
}