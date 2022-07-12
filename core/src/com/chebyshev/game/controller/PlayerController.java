package com.chebyshev.game.controller;

import com.chebyshev.game.model.Player;
import com.chebyshev.game.physics.Direction;
import com.chebyshev.game.view.PlayerView;
import com.chebyshev.game.view.View;

public class PlayerController {
    Player player;
    PlayerView playerView;

    public PlayerController() {
        player = Player.getInstance();
        playerView = new PlayerView();
    }

    public void up(){
        player.setDirection(Direction.UP);
        player.boost();
        playerView.animate();
    }
    public void down(){
        player.setDirection(Direction.DOWN);
        player.boost();
        playerView.animate();
    }
    public void left(){
        player.setDirection(Direction.LEFT);
        player.boost();
        playerView.animate();
    }
    public void right(){
        player.setDirection(Direction.RIGHT);
        player.boost();
        playerView.animate();
    }
    public void waite(){
        player.setDirection(null);
        player.boost();
    }
    public View refresh(){
        playerView.setLocation(player.getX(), player.getY());
        return playerView;
    }
    public float getX(){
        return player.getX();
    }
    public float getY(){
        return player.getY();
    }
}
