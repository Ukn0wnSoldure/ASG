package game.renderer;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

/**
 * Created by Aedan Smith on 5/3/2016.
 * <p>
 * The Display manager for the Game.
 */

public final class DisplayManager {

    /**
     * The x and y resolution of the Display.
     */
    public static int xRes, yRes;

    /**
     * The factor to translate between OpenGL and Pixel Coordinate Systems.
     */
    public static float ppX, ppY;

    /**
     * The ratio between the current resolution and the target resolution.
     */
    public static float targetResXRatio, targetResYRatio;

    /**
     * The target resolution for the game.
     */
    @SuppressWarnings("FieldCanBeLocal")
    private static int targetResolutionX = 900,
            targetResolutionY = 900;

    /**
     * The amount to scale all Renderables by.
     */
    private static float scale;

    /**
     * The Display's maximum fps.
     */
    private static int fpscap = Display.getDesktopDisplayMode().getFrequency() * 2;

    // Do not construct DisplayManager.
    private DisplayManager() {
    }

    /**
     * Creates a display.
     *
     * @param xRes:       The x resolution of the Display.
     * @param yRes:       The y resolution of the Display.
     * @param fullscreen: True if the Display should initialize in fullscreen.
     * @param title:      The title of the display (as seen at the top)
     *                    TODO: Remove Display Title.
     * @throws LWJGLException: If LWJGL could not initialize the Display.
     */
    public static void createDisplay(int xRes, int yRes, boolean fullscreen, String title) throws Exception {
        DisplayManager.xRes = xRes;
        DisplayManager.yRes = yRes;
        ppX = 1.0f / (float) DisplayManager.xRes;
        ppY = 1.0f / (float) DisplayManager.yRes;
        targetResXRatio = (float) xRes / targetResolutionX;
        targetResYRatio = (float) yRes / targetResolutionY;
        scale = (xRes < yRes) ? targetResXRatio : targetResYRatio;

        ContextAttribs attributes = new ContextAttribs(3, 2)
                .withForwardCompatible(true)
                .withProfileCore(true);
        Display.setDisplayMode(new DisplayMode(xRes, yRes));
        Display.setResizable(false);
        Display.setFullscreen(fullscreen);
        Display.create(new PixelFormat(), attributes);
        Display.setTitle(title);
        GL11.glViewport(0, 0, xRes, yRes);
        System.out.println(GL11.glGetString(GL11.GL_VERSION));
    }

    /**
     * @return boolean: True if the user has requested to close the Display.
     */
    public static boolean isCloseRequested() {
        return Display.isCloseRequested();
    }

    /**
     * Updates the Display.
     */
    public static void updateDisplay() {
        Display.sync(fpscap);
        Display.update();
    }

    /**
     * Closes the Display.
     */
    public static void closeDisplay() {
        Display.destroy();
    }

    public static float getScale() {
        return scale;
    }

}