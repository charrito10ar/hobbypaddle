package com.marbit.hobbypaddle.domain.model.booking

class InternalBooking(start: Long,
                      end: Long,
                      description: String,
                      totalPrice: Double,
                      var internalMessage: String) : Booking(start, end, description, totalPrice)