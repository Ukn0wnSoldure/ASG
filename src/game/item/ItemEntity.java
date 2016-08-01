package game.item;

import game.Game;
import game.gamestates.inclientgamestate.entities.Entity;

/**
 * Created by Aedan Smith on 7/30/2016.
 */

public class ItemEntity extends Entity {

    // TODO Add movement towards nearby players

    private Item item;

    public ItemEntity(Item item, int x, int y) {
        super(item.getTextureID(), x, y, 64, 64);
        this.item = item;
    }

    @Override
    public void update() {
        if (Game.inClientGameState.players[0].getPixelPosition().distance(this.getPixelPosition()) < 50) {
            Game.inClientGameState.playerInventory.add(item, 1);
            destroy();
        }
    }

    @Override
    public void onRender() {

    }

}