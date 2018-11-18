package com.marbit.hobbypaddle.domain.presenters

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.marbit.hobbypaddle.data.entities.ClubEntity
import com.marbit.hobbypaddle.domain.usecases.GetClubsUseCase
import com.marbit.hobbypaddle.presentation.presenters.ClubsPresenter
import com.marbit.hobbypaddle.presentation.ui.fragments.interfaces.ClubsView

class ClubsPresenterImpl(val view: ClubsView, private val getClubsUseCase: GetClubsUseCase) : ClubsPresenter {

    private var database = FirebaseDatabase.getInstance()
    private var dataBaseReference = database.getReference("clubes")

    override fun getClubs() {
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    val club = postSnapshot.getValue(ClubEntity::class.java)
                    Log.d("Club", club?.name)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("", "loadPost:onCancelled", databaseError.toException())
            }
        }
        dataBaseReference.addListenerForSingleValueEvent(postListener)
    }
}