package game.sprites;

import game.gamestates.inclientgamestate.entities.Entity;
import game.gamestates.inclientgamestate.entities.lights.Light;
import game.gamestates.inclientgamestate.entities.lights.LightList;
import game.renderer.data.RenderList;
import game.renderer.textures.Textures;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 7/4/2016.
 * <p>
 * A list of Sprites to be used by the Renderer.
 */

public class EntityList extends RenderList<Entity> {

    /**
     * The LightList that affects the Sprites
     */
    private LightList lightList = new LightList();

    /**
     * Default EntityList constructor.
     */
    public EntityList() {
        super(Textures.spriteTextures.size());
    }

    /**
     * See game.sprites.RenderList documentation
     */
    @Override
    protected void onAdd(Entity sprite) {
        if (sprite.isLight)
            lightList.addLight((Light) sprite);
    }

    /**
     * See game.sprites.RenderList documentation
     */
    @Override
    protected void onRemove(Entity sprite) {
        if (sprite.isLight)
            lightList.removeLight((Light) sprite);
        sprite.onDestruction();
    }

    /**
     * See game.sprites.RenderList documentation
     */
    @Override
    protected void onUpdate() {
        for (ArrayList<Sprite> ss : renderables)
            ss.forEach(Sprite::update);
    }

    public LightList getLightList() {
        return lightList;
    }

}