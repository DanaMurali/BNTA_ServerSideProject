package com.nightowl;

import com.nightowl.exceptions.Exceptions;
import com.nightowl.ingredients.Ingredient;
import com.nightowl.ingredients.IngredientDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RiService {
    
    private final RiDAO riDAO;

    public RiService(RiDAO riDAO) {
        this.riDAO = riDAO;
    }

    public List<Ri> getRi() {
        return riDAO.selectRi();
    }
    
    public Ri getRi(int id) {
        return riDAO.selectRiById(id)
                .orElseThrow(() -> new Exceptions(String.format("Recipe with id %s not found", id)));
    }

   
}
