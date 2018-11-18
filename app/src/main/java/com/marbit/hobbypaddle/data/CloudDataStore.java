package com.marbit.hobbypaddle.data;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Entity;

import java.util.List;

import javax.inject.Inject;

public class CloudDataStore {



    @Inject
    public CloudDataStore(){

    }

    public List<Entity> getClubs() {

        return null;
    }
}
