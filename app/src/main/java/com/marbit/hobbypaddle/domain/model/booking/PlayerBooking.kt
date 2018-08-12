package com.marbit.hobbypaddle.domain.model.booking

import com.marbit.hobbypaddle.domain.model.Player

class PlayerBooking(start: Long,
                    end: Long,
                    description: String,
                    totalPrice: Double,
                    var asignedPlayer: Player) : Booking(start, end, description, totalPrice)