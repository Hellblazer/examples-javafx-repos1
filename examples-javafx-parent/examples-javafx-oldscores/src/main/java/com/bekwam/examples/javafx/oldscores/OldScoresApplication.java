/*
 * Copyright 2015 Bekwam, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bekwam.examples.javafx.oldscores;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * An application that compares standardized test scores from before 1995 with today's scores
 *
 * @author carl_000
 */
public class OldScoresApplication extends Application {

    private Logger logger = LoggerFactory.getLogger(OldScoresApplication.class);

    @Override
    public void start(Stage primaryStage) throws Exception {

        if( logger.isDebugEnabled() ) {
            logger.debug("[START]");
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
        Parent p = loader.load();
        MainViewController mv = loader.getController();

        Scene scene = new Scene( p );

        scene.setOnKeyPressed(evt -> {

            if( evt.getCode().equals(KeyCode.F1) ) {
                try {
                    if( logger.isDebugEnabled() ) {
                        logger.debug("[OPEN HELP]");
                    }
                    mv.openHelpDialog();
                } catch (IOException exc) {
                    String msg = "error showing help dialog";
                    logger.error(msg);
                    Alert alert = new Alert(Alert.AlertType.ERROR, msg);
                    alert.showAndWait();
                }
            }
        });

        primaryStage.setTitle("Old Scores");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
