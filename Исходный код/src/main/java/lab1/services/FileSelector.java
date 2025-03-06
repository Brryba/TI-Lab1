package lab1.services;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public abstract class FileSelector {
    public static File selectFile(boolean isReading, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(isReading ? "Сохранить файл" : "Прочитать файл");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Текстовые файлы (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        return isReading ? fileChooser.showOpenDialog(stage) : fileChooser.showSaveDialog(stage);
    }
}
