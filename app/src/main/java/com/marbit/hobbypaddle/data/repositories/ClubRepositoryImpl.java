package com.marbit.hobbypaddle.data.repositories;

import com.marbit.hobbypaddle.data.CloudDataStore;
import com.marbit.hobbypaddle.domain.repositories.ClubRepository;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Entity;

import java.util.List;

public class ClubRepositoryImpl implements ClubRepository {
    private CloudDataStore cloudDataStore;

    public ClubRepositoryImpl(CloudDataStore cloudDataStore) {
        this.cloudDataStore = cloudDataStore;
    }

    @NotNull
    @Override
    public List<Entity> getClubs() {
        return cloudDataStore.getClubs();
    }
}
