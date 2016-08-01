import game.renderer.DisplayManager;
import game.renderer.Loader;
import game.Game;
import game.renderer.Renderer;

/**
 * Created by Aedan Smith on 5/23/2016.
 */

public class Main {

    /**
     * @param args: xRes, yRes
     */
    public static void main(String[] args){
        try {
            DisplayManager.createDisplay(Integer.parseInt(args[0]), Integer.parseInt(args[1]), false, "Consumables");
            Game.initialize();
            long time = System.nanoTime();
            while (!DisplayManager.isCloseRequested()) {
                DisplayManager.updateDisplay();
                Game.currentGameState().update();
                Game.currentGameState().render();
                System.out.println(1000000/((System.nanoTime() - time)/1000));
                time = System.nanoTime();
            }
            Loader.cleanUp();
            Renderer.lights.cleanUp();
            DisplayManager.closeDisplay();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}