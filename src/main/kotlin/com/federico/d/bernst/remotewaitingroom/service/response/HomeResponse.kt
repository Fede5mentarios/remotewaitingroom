package com.federico.d.bernst.remotewaitingroom.service.response

import com.federico.d.bernst.remotewaitingroom.exception.RequestError

data class HomeResponse(val username: String, val error: RequestError?)