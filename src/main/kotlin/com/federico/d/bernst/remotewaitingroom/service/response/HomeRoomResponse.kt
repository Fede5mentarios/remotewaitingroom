package com.federico.d.bernst.remotewaitingroom.service.response

import com.federico.d.bernst.remotewaitingroom.exception.RequestError

data class HomeRoomResponse(val roomID: Long, val url: String, val absoluteURL: String, val error: RequestError?)