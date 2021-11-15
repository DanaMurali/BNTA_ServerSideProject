package com.nightowl;

import com.nightowl.ingredients.Ingredient;
import com.nightowl.user.User;

import java.util.List;
import java.util.Optional;

public interface RiDAO {

    List<RiTwo> selectRiTwo( User user);
    int insertRi(Ri ri);
    int deleteRi(int id);
    Optional<Ri> selectRiById(int id);
    void updateRi(Ri ri, Integer id);
}

