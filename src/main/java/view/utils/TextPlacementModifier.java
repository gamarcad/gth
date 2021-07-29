package view.utils;

import javafx.scene.text.Text;

public class TextPlacementModifier {
    public static void centerText( Text text ) {
        text.setX(text.getX() - text.getLayoutBounds().getWidth() / 2);
        text.setY(text.getY() + text.getLayoutBounds().getHeight() / 4);
    }
}
