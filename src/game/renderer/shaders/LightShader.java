package game.renderer.shaders;

import game.gamestates.inclientgamestate.entities.Entity;
import game.renderer.DisplayManager;
import game.renderer.lights.Light;
import org.lwjgl.util.vector.Matrix4f;

public class LightShader extends Shader {

    private static final String SHADER_PATH = "assets/shaders/light/";
    private static final String VERTEX_FILE = SHADER_PATH + "light.vsh";
    private static final String FRAGMENT_FILE = SHADER_PATH + "light.fsh";

    private int transformationMatrixLocation;
    private int brightnessLocation;
    private int xBlackBarsLocation;

    public LightShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    @Override
    protected void getAllUniformLocations() {
        transformationMatrixLocation = super.getUniformLocation("transformationMatrix");
        brightnessLocation = super.getUniformLocation("brightness");
        xBlackBarsLocation = super.getUniformLocation("xBlackBars");
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
        super.bindAttribute(1, "textureCoords");
    }

    public void loadLightDistance(Light l, Entity e) {
        float brightness = (float) (1 / (l.getPosition().pixelDistance(e.getPosition())/400 + .2f)) * l.getStrength() / 10 - .1f;
        loadLightDistance(brightness);
    }

    public void loadLightDistance(float lightDistance) {
        super.loadFloat(brightnessLocation, lightDistance);
    }

    public void loadTransformationMatrix(Matrix4f matrix4f) {
        super.loadMatrix(transformationMatrixLocation, matrix4f);
    }

}
