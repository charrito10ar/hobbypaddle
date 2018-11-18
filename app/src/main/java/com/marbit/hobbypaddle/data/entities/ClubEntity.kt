package com.marbit.hobbypaddle.data.entities

data class ClubEntity(var id: String = "",
                 var name: String = "",
                 var address: String = "",
                 var calendarId: String = ""){
    constructor() : this("", "", "","")
}