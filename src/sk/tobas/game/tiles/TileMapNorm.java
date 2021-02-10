package sk.tobas.game.tiles;

import sk.tobas.game.graphics.Sprite;
import sk.tobas.game.tiles.blocks.Block;
import sk.tobas.game.tiles.blocks.NormBlock;
import sk.tobas.game.util.Vector2f;

import java.awt.*;
import java.util.ArrayList;

public class TileMapNorm extends TileMap{

    private ArrayList<Block> blocks;

    public TileMapNorm(String data, Sprite sprite, int width, int height, int tileWidth, int tileHeight, int tileColumns) {
        blocks = new ArrayList<Block>();

        String[] block = data.split(",");
        for(int i = 0; i < (width * height); i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+",""));
            if(temp != 0) {
                blocks.add(new NormBlock(sprite.getSprite((temp - 1) % tileColumns, (temp - 1) / tileColumns),new Vector2f((i % width) * tileWidth, (int)(i / height) * tileHeight), tileWidth, tileHeight));
            }
        }
    }

    @Override
    public void render(Graphics2D g) {
        for(int i = 0; i < blocks.size(); i++) {
            blocks.get(i).render(g);
        }
    }
}
