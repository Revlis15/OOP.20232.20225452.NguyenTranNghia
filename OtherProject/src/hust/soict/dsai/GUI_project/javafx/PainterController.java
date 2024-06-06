package hust.soict.dsai.GUI_project.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    
    @FXML
    private RadioButton penButton;

    @FXML
    private RadioButton eraserButton;
    
    private boolean isPenSelected = true;
    
    @FXML
    void initialize() {
        penButton.setOnAction(event -> isPenSelected = true);
        eraserButton.setOnAction(event -> isPenSelected = false);
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (isPenSelected) {
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        } else {
            // Eraser mode: remove circles within a certain radius
            double eraserRadius = 10;
            drawingAreaPane.getChildren().removeIf(node -> {
                if (node instanceof Circle) {
                    Circle circle = (Circle) node;
                    double distance = Math.sqrt(Math.pow(circle.getCenterX() - event.getX(), 2) +
                                                Math.pow(circle.getCenterY() - event.getY(), 2));
                    return distance <= eraserRadius;
                }
                return false;
            });
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
}
