package sk.tobas.game.states;

import sk.tobas.game.entity.Player;
import sk.tobas.game.graphics.Font;
import sk.tobas.game.graphics.Sprite;
import sk.tobas.game.util.KeyHandler;
import sk.tobas.game.util.MouseHandler;
import sk.tobas.game.util.Vector2f;

import java.awt.Graphics2D;


public class PlayState extends GameState {

    private Font font;
    private Player player;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        font = new Font("font/ZeldaFont.png", 16, 16);
        player = new Player(new Sprite("entity/linkFormatted.png"), new Vector2f(300,300), 128);
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
        player.input(mouse, key);
    }

    @Override
    public void render(Graphics2D g) {
        Sprite.drawArray(g, font, "HELLO TOM small works to", new Vector2f(100, 100), 32, 32, 16, 0);
        player.render(g);
    }
}
