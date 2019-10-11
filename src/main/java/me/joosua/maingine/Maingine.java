package me.joosua.maingine;

import me.joosua.maingine.glfw.GlfwManager;
import me.joosua.maingine.glfw.window.Window;
import me.joosua.maingine.settings.WindowSettings;
import me.joosua.maingine.utils.LoggerManager;
import me.joosua.maingine.utils.SystemInfo;

/**
 * <p>Main class of Maingine. This class bootstraps the other parts of the engine.
 * Some of the intialization is done here.</p>
 *
 * @since 0.0.2
 */
public class Maingine {

  public static final String VERSION = "0.0.2";

  public static boolean DEBUG = false;

  /**
   * <p>Main constructor of Maingine. The first part of
   * initialization is done here.</p>
   *
   * @since 0.0.2
   */
  public Maingine(WindowSettings windowSettings) {

    LoggerManager.prepareLogger();

    SystemInfo.printInfo();

    if (!GlfwManager.init()) {
      throw new IllegalStateException("GLFW couldn't be initialized ");
    }

    Window window = new Window(windowSettings);

    if (!window.isOpen()) {
      throw new IllegalStateException("Window couldn't be created");
    }

    // LOOP TO PREVENT WINDOW FROM CLOSING
    while (!window.isCloseRequested()) {
      window.update();
    }

    window.destroy();

    GlfwManager.terminate();

  }

}
