package com.marbit.hobbypaddle.domain.usecases;

import com.marbit.hobbypaddle.domain.repositories.ClubRepository;

public class GetClubsUseCase {

    private ClubRepository clubRepository;

    public GetClubsUseCase(ClubRepository clubRepository){
        this.clubRepository = clubRepository;
    }
}
