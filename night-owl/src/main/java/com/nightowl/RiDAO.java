package com.nightowl;

import com.nightowl.ingredients.Ingredient;

import java.util.List;
import java.util.Optional;

public interface RiDAO {
    
    List<Ri> selectRi();
//    int insertRi(Ri ri);
//    int deleteRi(int id);
    Optional<Ri> selectRiById(int id);
//    void updateRi(Ri ri, Integer id);
}

