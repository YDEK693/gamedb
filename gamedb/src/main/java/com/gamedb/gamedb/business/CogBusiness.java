package com.gamedb.gamedb.business;

import com.gamedb.gamedb.dto.GogResponse;
import com.gamedb.gamedb.repository.GogRepository;
import com.gamedb.gamedb.repository.SteamRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

@Component
public class CogBusiness {

    @Inject()
    private GogRepository gogRepository;

    public GogResponse getGames(){
        return gogRepository.getGames();
    }
}
