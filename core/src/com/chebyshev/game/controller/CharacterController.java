package com.chebyshev.game.controller;

import com.chebyshev.game.model.Character;
import com.chebyshev.game.view.PlayerView;
import com.chebyshev.game.view.View;

public class CharacterController {
    Character character;
    PlayerView view;

    public CharacterController() {
        character = new Character();
        view = new PlayerView();
    }
    public View refresh(){
        view.setLocation(character.getX(),character.getY());
        return view;
    }
}
