package game;

import game.gamestates.GameState;
import game.gamestates.bootgamestate.BootGameState;
import game.gamestates.inclientgamestate.InClientGameState;
import game.gamestates.mainmenugamestate.MainMenuGameState;

/**
 * Created by Aedan Smith on 5/23/2016.
 *
 * The class controlling the updating and rendering of the Game
 */

public class Game {

    /**
     * Currently unused GameState for future loading screen.
     */
    public static BootGameState bootGameState;

    /**
     * Currently unused GameState for future menus.
     */
    public static MainMenuGameState menuGameState;

    /**
     * The Client-side ingame GameState.
     */
    public static InClientGameState inClientGameState;

    /**
     * The list of GameStates
     */
    private static GameState[] gameStates = new GameState[]{
            bootGameState, menuGameState, inClientGameState
    };

    /**
     * The GameState currently being rendered by the Game. Will be set to 0 (bootGameState) in the future.
     */
    private static int activeGameState = 2;

    /**
     * Initializes the game.
     */
    public static void initialize(){
        bootGameState = new BootGameState();
        menuGameState = new MainMenuGameState();
        inClientGameState = new InClientGameState();
    }

    /**
     * Updates the active GameState
     */
    public static void update(){
        getActiveGameState().update();
    }

    /**
     * Renders the active GameState
     */
    public static void render(){
        getActiveGameState().render();
    }

    /**
     * @return GameState: Returns the active GameState.
     */
    public static GameState getActiveGameState(){
        return Game.gameStates[Game.activeGameState];
    }

    /**
     * @param gameState: The GameState to set as active.
     */
    public static void setGameState(int gameState){
        activeGameState = gameState;
    }

}