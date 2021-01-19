package com.praktijk3.service;

import java.util.List;

import com.praktijk3.model.speler;
import com.praktijk3.payload.spelerResponse;

public interface spelerService {
	
	speler save(spelerResponse speler);
    List<speler> findAll();
    void delete(int id);

    speler findOne(String name);

    speler findById(int id);

    spelerResponse update(spelerResponse spelerResponse);
    
}
