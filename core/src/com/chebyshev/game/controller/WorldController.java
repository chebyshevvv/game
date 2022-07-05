package com.chebyshev.game.controller;

import com.chebyshev.game.model.World;
import com.chebyshev.game.view.View;
import com.chebyshev.game.view.WorldView;

public class WorldController {
    World world;
    WorldView worldView;

    public WorldController() {
        world = new World(2048,2048);
        worldView = new WorldView();
    }

    public View refresh(){
        return worldView;
    }
}
