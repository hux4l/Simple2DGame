package sk.tobas.game.states;

import sk.tobas.game.GamePanel;
import sk.tobas.game.entity.Player;
import sk.tobas.game.graphics.Font;
import sk.tobas.game.graphics.Sprite;
import sk.tobas.game.tiles.TileManager;
import sk.tobas.game.util.KeyHandler;
import sk.tobas.game.util.MouseHandler;
import sk.tobas.game.util.Vector2f;

import java.awt.Graphics2D;


public class PlayState extends GameState {

    private Font font;
    private Player player;
    private TileManager tm;

    public static Vector2f map;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        map = new Vector2f(32, 32);

        tm = new TileManager("tile/tilemap.xml");
        font = new Font("font/fontFinal.png", 10, 10);
        player = new Player(new Sprite("entity/linkFormatted.png"), new Vector2f(32 + (GamePanel.width / 2) - 32,32 + (GamePanel.height / 2) - 32), 64);
    }

    @Override
    public void update() {
        Vector2f.setWorldVar(map.x, map.y);
        player.update();
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
        player.input(mouse, key);
    }

    @Override
    public void render(Graphics2D g) {
        tm.render(g);
        Sprite.drawArray(g, font, GamePanel.oldFrameCount + " FPS", new Vector2f(GamePanel.width - 192, 10), 32, 32, 32, 0);
        player.render(g);
    }
}
