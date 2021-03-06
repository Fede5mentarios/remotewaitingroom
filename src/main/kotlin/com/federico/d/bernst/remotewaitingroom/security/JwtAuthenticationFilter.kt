package com.federico.d.bernst.remotewaitingroom.security

import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.util.StringUtils
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.http.HttpServletRequest


class JwtAuthenticationFilter : OncePerRequestFilter() {

    @Autowired
    lateinit var tokenProvider: JwtTokenProvider

    @Autowired
    lateinit var customUserDetailsService: CustomUserDetailsService

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        try {
            val jwt = getJwtFromRequest(request)
            if (!jwt.isNullOrBlank()) {
                if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt!!)) {
                    val userId = tokenProvider.getUserIdFromJWT(jwt)
                    userId?.let {
                        val userDetails = customUserDetailsService.loadUserById(it)
                        val authentication = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
                        authentication.details = WebAuthenticationDetailsSource().buildDetails(request)

                        SecurityContextHolder.getContext().authentication = authentication
                    }
                }
            }
        } catch (ex: Exception) {
            logger.error("Could not set user authentication in security context", ex)
        }

        filterChain.doFilter(request, response)
    }

    private fun getJwtFromRequest(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader("Authorization")
        return if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            bearerToken.substring(7, bearerToken.length)
        } else null
    }

    companion object {
        private val logger = LoggerFactory.getLogger(JwtAuthenticationFilter::class.java)
    }
}
