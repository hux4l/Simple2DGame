package sk.tobas.game.entity;

import sk.tobas.game.graphics.Sprite;
import sk.tobas.game.states.PlayState;
import sk.tobas.game.util.KeyHandler;
import sk.tobas.game.util.MouseHandler;
import sk.tobas.game.util.Vector2f;

import java.awt.*;

public class Player extends Entity {


    public Player(Sprite sprite, Vector2f origin, int size) {
        super(sprite, origin, size);
        acceleration = 2f;
        maxSpeed = 3f;
    }

    public void move() {
        if(up) {
            dy -= acceleration;
            if(dy < -maxSpeed) {
                dy = -maxSpeed;
            }
        } else {
            if(dy < 0) {
                dy += deacceleration;
                if(dy > 0) {
                    dy = 0;
                }
            }
        }
        if(down) {
            dy += acceleration;
            if(dy > maxSpeed) {
                dy = maxSpeed;
            }
        } else {
            if(dy > 0) {
                dy -= deacceleration;
                if(dy < 0) {
                    dy = 0;
                }
            }
        }
        if(left) {
            dx -= acceleration;
            if(dx < -maxSpeed) {
                dx = -maxSpeed;
            }
        } else {
            if(dx < 0) {
                dx += deacceleration;
                if(dx > 0) {
                    dx = 0;
                }
            }
        }
        if(right) {
            dx += acceleration;
            if(dx > maxSpeed) {
                dx = maxSpeed;
            }
        } else {
            if(dx > 0) {
                dx -= deacceleration;
                if(dx < 0) {
                    dx = 0;
                }
            }
        }
    }

    @Override
    public void update() {
        super.update();
        move();
        PlayState.map.x += dx;
        PlayState.map.y += dy;
        pos.x += dx;
        pos.y += dy;
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(ani.getImage(), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
    }

    public void input(MouseHandler mouse, KeyHandler key) {
        if(key.up.down) {
            up = true;
        } else {
            up = false;
        }
        if(key.down.down) {
            down = true;
        } else {
            down = false;
        }
        if(key.left.down) {
            left = true;
        } else {
            left = false;
        }
        if(key.right.down) {
            right = true;
        } else {
            right = false;
        }
        if(key.attack.down) {
            attack = true;
        } else {
            attack = false;
        }
    }
}
