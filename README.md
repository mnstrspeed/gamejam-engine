gamejam-engine
==============

Basic framework to use in game jams

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
}
```
