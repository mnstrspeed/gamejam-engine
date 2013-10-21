gamejam-engine
==============

Basic framework to use in game jams

### Features
- Deals with window shit (Java Swing)
- Receives input from player
- Controls game loop/frame rate
- Provides basic types for 2D graphics (`Rectangle`, `Size`, `Point`, etc.)
- ?

### Usage
```java
public class Game extends nl.tomsanders.game.engine.GameBase {
  @Override
  public void loadContent() {
    super.loadContent();
  }
  
  @Override
  public void update(GameTime time) {
    super.update(time);
  }
  
  @Override
  public void render(Graphics g) { 
    super.render(g);
  }
  
  @Override
  public void renderOverlay(Graphics g) {
    super.renderOverlay(g);
  }

  // Entry point
  public static void main(String[] args) {
    new Game().start();
  }
}
```
