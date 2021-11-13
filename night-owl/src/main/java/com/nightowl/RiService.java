package com.nightowl;

import com.nightowl.exceptions.Exceptions;
import com.nightowl.ingredients.Ingredient;
import com.nightowl.ingredients.IngredientDAO;
import com.nightowl.recipes.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RiService {

    private final RiDAO riDAO;

    public RiService(RiDAO riDAO) {
        this.riDAO = riDAO;
    }

    public List<RiTwo> getRiTwo() {
        return riDAO.selectRiTwo();
    }

    public Ri getRi(int id) {
        return riDAO.selectRiById(id)
                .orElseThrow(() -> new Exceptions(String.format("Recipe with id %s not found", id)));
    }

    public void deleteRi(Integer id) {
        Optional<Ri> ris = riDAO.selectRiById(id);
        ris.ifPresentOrElse(ri -> {
            int result = riDAO.deleteRi(id);
            if (result != 1) {
                throw new IllegalStateException("oops could not delete recipe");
            }
        }, () -> {
            throw new Exceptions(String.format("Recipe with id %s not found", id));
        });
    }

    public void addNewRi(Ri ri) {
        int result = riDAO.insertRi(ri);
        if (result != 1) {
            throw new IllegalStateException("oops something went wrong");
        }
    }

    public void updateRi( Ri ri, Integer id) {
        riDAO.updateRi(ri, id);
//        if (result != 1) {
//            throw new IllegalStateException("oops something went wrong");
//        }

    }
}
