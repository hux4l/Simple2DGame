package sk.tobas.game.tiles;

import sk.tobas.game.graphics.Sprite;
import sk.tobas.game.tiles.blocks.Block;
import sk.tobas.game.tiles.blocks.HoleBlock;
import sk.tobas.game.tiles.blocks.ObjBlock;
import sk.tobas.game.util.Vector2f;

import java.awt.*;
import java.util.HashMap;

public class TileMapObj extends TileMap {

    public static HashMap<String, Block> tmo_blocks;

    public TileMapObj(String data, Sprite sprite, int width, int height, int tileWidth, int tileHeight, int tileColumns) {
        Block tempBlock;
        tmo_blocks = new HashMap<String, Block>();

        String[] block = data.split(",");
        for(int i = 0; i < (width * height); i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+",""));
            if(temp != 0) {
                if (temp == 172) {
                    tempBlock = new HoleBlock(sprite.getSprite((temp - 1) % tileColumns, (temp - 1) / tileColumns),new Vector2f((i % width) * tileWidth, (int)(i / height) * tileHeight), tileWidth, tileHeight);
                } else {
                    tempBlock = new ObjBlock(sprite.getSprite((temp - 1) % tileColumns, (temp - 1) / tileColumns),new Vector2f((i % width) * tileWidth, (int)(i / height) * tileHeight), tileWidth, tileHeight);
                }
                tmo_blocks.put(String.valueOf((int)(i % width)) + "," + String.valueOf((int)(i / height)), tempBlock);
            }
        }
    }

    @Override
    public void render(Graphics2D g) {
        for(Block block : tmo_blocks.values()) {
            block.render(g);
        }
    }
}

