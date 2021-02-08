package sk.tobas.game.entity;

import sk.tobas.game.graphics.Sprite;
import sk.tobas.game.util.KeyHandler;
import sk.tobas.game.util.MouseHandler;
import sk.tobas.game.util.Vector2f;

import java.awt.*;

public class Player extends Entity {


    public Player(Sprite sprite, Vector2f origin, int size) {
        super(sprite, origin, size);
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
            if(dy < maxSpeed) {
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
        pos.x += dx;
        pos.y += dy;
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(ani.getImage(), (int) (pos.x), (int) (pos.y), size, size, null);
    }

    public void input(MouseHandler mouse, KeyHandler key) {

        up = key.up.down;
        down = key.down.down;
        left = key.left.down;
        right = key.right.down;
        attack = key.attack.down;
    }
}
