package com.marbit.hobbypaddle.domain.model

import com.marbit.hobbypaddle.domain.model.booking.Booking

class Court(var bookingList: List<Booking>,
            var description: String,
            var normalPrice: Double,
            var availabilityAnticipateDays: Int) {
}