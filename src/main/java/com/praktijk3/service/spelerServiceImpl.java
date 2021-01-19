package com.praktijk3.service;

import com.praktijk3.model.speler;
import com.praktijk3.payload.spelerResponse;
import com.praktijk3.repository.spelerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("spelerService")
public class spelerServiceImpl implements spelerService {

	
	@Autowired
	private spelerRepository spelers;
	
	public List<speler> findAll() {
		List<speler> list = new ArrayList<>();
		spelers.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(int id) {
		spelers.deleteById(id );
	}

	@Override
	public speler findOne(String username) {
		return spelers.findByname(username);
	}

	@Override
	public speler findById(int id) {
		Optional<speler> optionalUser = spelers.findById( id);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}

    @Override
    public spelerResponse update(spelerResponse spelerReponse) {
        speler speler = findById(spelerReponse.getId());
        if(speler != null) {
            BeanUtils.copyProperties(spelerReponse, speler, "password", "username");
            spelers.save(speler);
        }
        return spelerReponse;
    }
	
	
    
	@Override
    public speler save(spelerResponse speler) {
		
	    speler newSpeler = new speler();
	    newSpeler.setName(speler.getName());
	    newSpeler.setAchternaam(speler.getAchternaam());
	    newSpeler.setPositie(speler.getPositie());
	    newSpeler.setNummer(speler.getNummer());
	
        return spelers.save(newSpeler);
        
    }

	
}
