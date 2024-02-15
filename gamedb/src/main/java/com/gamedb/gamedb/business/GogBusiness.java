package com.gamedb.gamedb.business;

import com.gamedb.gamedb.dto.GogResponse;
import com.gamedb.gamedb.repository.GogRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

@Component
public class GogBusiness {

    @Inject()
    private GogRepository gogRepository;

    public Object getGames(){
        return gogRepository.getGames();
    }
}
