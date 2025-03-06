package lab1.services;

import javafx.scene.control.Alert;

public abstract class ErrorViewer {
    public static void showError(String errorName) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(errorName);
        alert.setContentText("Пожалуйста, введите корректные данные");
        alert.show();
    }
}
