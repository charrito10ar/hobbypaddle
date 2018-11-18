package com.marbit.hobbypaddle.domain.repositories

import org.w3c.dom.Entity

interface ClubRepository{

    fun getClubs(): List<Entity>
}