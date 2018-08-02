package com.federico.d.bernst.remotewaitingroom.security

import com.federico.d.bernst.remotewaitingroom.persistence.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomUserDetailsService : UserDetailsService {

    @Autowired
    lateinit var userRepository: UsuarioRepository

    @Transactional
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String) = LoguedUser.create(userRepository.findByUnique(username).orElseThrow { UsernameNotFoundException("User not found with username or email : $username") })

    // This method is used by JWTAuthenticationFilter
    @Transactional
    fun loadUserById(id: Long) = LoguedUser.create(userRepository.findById(id).orElseThrow { UsernameNotFoundException("User not found with id : $id") })
}
