package com.federico.d.bernst.remotewaitingroom.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import javax.validation.constraints.NotNull

@Configuration
@ConfigurationProperties(prefix = "base")
@EnableConfigurationProperties
class YmlConfig {

    @NotNull
    private var url: String? = null

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String) {
        this.url = url
    }
}