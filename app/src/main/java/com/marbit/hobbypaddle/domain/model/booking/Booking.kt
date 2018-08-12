package com.marbit.hobbypaddle.domain.model.booking

abstract class Booking(var start: Long,
              var end: Long,
              var description: String,
              var totalPrice: Double)