import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SDG3Poster extends Application {

    @Override
    public void start(Stage stage) {

        // -------------------------------
        // Title
        // -------------------------------

        Label title = new Label("SDG 3");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        title.setTextFill(Color.WHITE);

        Label subtitle = new Label("GOOD HEALTH AND WELL-BEING");
        subtitle.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        subtitle.setTextFill(Color.WHITE);


        // -------------------------------
        // Description
        // -------------------------------

        Label description = new Label(
                "Ensure healthy lives and promote well-being "
                + "for all at all ages."
        );

        description.setWrapText(true);
        description.setFont(Font.font("Arial", 16));
        description.setTextFill(Color.DARKSLATEGRAY);


        // -------------------------------
        // Name input
        // -------------------------------

        Label nameLabel = new Label("Enter Your Name:");

        TextField nameField = new TextField();
        nameField.setPromptText("Your name");


        // -------------------------------
        // Healthy habits
        // -------------------------------

        Label habitLabel = new Label("Choose your healthy habits:");
        habitLabel.setFont(
                Font.font("Arial", FontWeight.BOLD, 17)
        );

        CheckBox exercise = new CheckBox(
                "Exercise regularly"
        );

        CheckBox water = new CheckBox(
                "Drink enough water"
        );

        CheckBox sleep = new CheckBox(
                "Get 7-8 hours of sleep"
        );

        CheckBox food = new CheckBox(
                "Eat healthy food"
        );

        CheckBox mentalHealth = new CheckBox(
                "Take care of mental health"
        );


        // -------------------------------
        // Progress bar
        // -------------------------------

        Label scoreLabel = new Label(
                "Well-Being Score"
        );

        scoreLabel.setFont(
                Font.font("Arial", FontWeight.BOLD, 17)
        );

        ProgressBar progressBar = new ProgressBar(0);

        progressBar.setPrefWidth(350);


        // -------------------------------
        // Result label
        // -------------------------------

        Label resultLabel = new Label(
                "Select your habits and calculate your score."
        );

        resultLabel.setWrapText(true);
        resultLabel.setFont(Font.font("Arial", 15));


        // -------------------------------
        // Calculate Button
        // -------------------------------

        Button calculateButton = new Button(
                "CALCULATE MY HEALTH SCORE"
        );

        calculateButton.setFont(
                Font.font("Arial", FontWeight.BOLD, 14)
        );

        calculateButton.setStyle(
                "-fx-background-color: #2E7D32;" +
                "-fx-text-fill: white;" +
                "-fx-padding: 10 20 10 20;"
        );


        // -------------------------------
        // Button Action
        // -------------------------------

        calculateButton.setOnAction(event -> {

            int score = 0;

            if (exercise.isSelected()) {
                score += 20;
            }

            if (water.isSelected()) {
                score += 20;
            }

            if (sleep.isSelected()) {
                score += 20;
            }

            if (food.isSelected()) {
                score += 20;
            }

            if (mentalHealth.isSelected()) {
                score += 20;
            }

            double progress = score / 100.0;

            progressBar.setProgress(progress);

            String name = nameField.getText();

            if (name.isEmpty()) {
                name = "Friend";
            }

            if (score == 100) {

                resultLabel.setText(
                        "Excellent, " + name +
                        "! You are following all the healthy habits."
                );

            } else if (score >= 60) {

                resultLabel.setText(
                        "Good job, " + name +
                        "! Keep improving your healthy habits."
                );

            } else {

                resultLabel.setText(
                        "Keep going, " + name +
                        "! Try to follow more healthy habits."
                );
            }
        });


        // -------------------------------
        // Health Tips
        // -------------------------------

        Label tipsTitle = new Label(
                "HEALTH TIPS"
        );

        tipsTitle.setFont(
                Font.font("Arial", FontWeight.BOLD, 18)
        );

        TextArea tips = new TextArea();

        tips.setText(
                "• Exercise for at least 30 minutes a day.\n" +
                "• Drink enough water.\n" +
                "• Eat fruits and vegetables.\n" +
                "• Get sufficient sleep.\n" +
                "• Take care of your mental health."
        );

        tips.setEditable(false);
        tips.setPrefRowCount(5);
        tips.setWrapText(true);


        // -------------------------------
        // Layout for habits
        // -------------------------------

        VBox habitsBox = new VBox(
                8,
                habitLabel,
                exercise,
                water,
                sleep,
                food,
                mentalHealth
        );

        habitsBox.setPadding(
                new Insets(10)
        );


        // -------------------------------
        // Main Content
        // -------------------------------

        VBox content = new VBox(
                12,
                nameLabel,
                nameField,
                habitsBox,
                scoreLabel,
                progressBar,
                calculateButton,
                resultLabel,
                tipsTitle,
                tips
        );

        content.setPadding(
                new Insets(20)
        );

        content.setAlignment(Pos.CENTER_LEFT);


        // -------------------------------
        // Header
        // -------------------------------

        VBox header = new VBox(
                5,
                title,
                subtitle
        );

        header.setAlignment(Pos.CENTER);
        header.setPadding(
                new Insets(20)
        );

        header.setStyle(
                "-fx-background-color: #2E7D32;"
        );


        // -------------------------------
        // Footer
        // -------------------------------

        Label footer = new Label(
                "Take care of your health. "
                + "Your well-being matters!"
        );

        footer.setFont(
                Font.font("Arial", FontWeight.BOLD, 14)
        );

        footer.setTextFill(Color.WHITE);

        footer.setAlignment(Pos.CENTER);

        footer.setPadding(
                new Insets(12)
        );

        footer.setMaxWidth(Double.MAX_VALUE);

        footer.setStyle(
                "-fx-background-color: #1B5E20;"
        );


        // -------------------------------
        // Main Layout
        // -------------------------------

        BorderPane root = new BorderPane();

        root.setTop(header);
        root.setCenter(content);
        root.setBottom(footer);

        root.setStyle(
                "-fx-background-color: #F1F8E9;"
        );


        // -------------------------------
        // Scene
        // -------------------------------

        Scene scene = new Scene(
                root,
                600,
                750
        );

        stage.setTitle(
                "SDG 3 - Good Health and Well-Being"
        );

        stage.setScene(scene);

        stage.show();
    }


    public static void main(String[] args) {

        launch(args);

    }
}