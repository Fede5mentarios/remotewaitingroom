package com.federico.d.bernst.remotewaitingroom.service

import com.federico.d.bernst.remotewaitingroom.service.response.HomeResponse
import com.federico.d.bernst.remotewaitingroom.service.response.HomeRoomResponse
import org.springframework.stereotype.Service

@Service
class HomeService {
    fun getHomeData(): HomeResponse = TODO("Falta implementar, estoy armando la estructura por ahora")
    fun createGuestRoom(roomID: Long?): HomeRoomResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}