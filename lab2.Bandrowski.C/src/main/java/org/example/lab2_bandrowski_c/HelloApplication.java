package org.example.lab2_bandrowski_c;
/**
 * Title: Lab 2 Assignment CSC311
 * Description:Load calculator used to take in information from user to calculate the Payments
 * @author Cody Bandrowski
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
       // Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        //Title of Window
        stage.setTitle("Loan Calculator");
        //Directions for User
        Label directions = new Label("Input the first 3 boxes and Press calculate and it will show payments");
        //Direction Placement
        directions.setLayoutX(10);directions.setLayoutY(10);

        //Button to calculate the  payments
        Button cal = new Button("Calculate");
        cal.setLayoutX(350); cal.setLayoutY(350);
        cal.setTextFill(Color.RED);
        //Changing color for button


        //Total Payment
        //Label is the text prompt for text field
        Label tp = new Label("Total Payments");
        tp.setLayoutX(100);tp.setLayoutY(300);
        //Creating text field
        TextField num1 = new TextField();
        num1.setLayoutX(250); num1.setLayoutY(300);

        //Monthly Payment
        TextField num2 = new TextField();
        Label mp = new Label("Monthly Payments");
        mp.setLayoutX(100);mp.setLayoutY(250);
        num2.setLayoutX(250); num2.setLayoutY(250);

        //Loan Amount
        TextField num3 = new TextField();
        Label la = new Label("Loan Amount");
        la.setLayoutX(100);la.setLayoutY(200);
        la.setTextFill(Color.RED);
        num3.setLayoutX(250); num3.setLayoutY(200);

        //Number of Years
        TextField num4 = new TextField();
        Label years = new Label("Number of Years");
        years.setTextFill(Color.RED);
        years.setLayoutX(100);years.setLayoutY(150);
        num4.setLayoutX(250); num4.setLayoutY(150);

        //Annual Interest Rate
        Label irLabel = new Label("Annual Interest Rate");
        irLabel.setLayoutX(100); irLabel.setLayoutY(100);
        irLabel.setTextFill(Color.RED);
        TextField num5 = new TextField();
        num5.setLayoutX(250); num5.setLayoutY(100);

        /**
         * Title: Button function
         * Description:Using the Data inputted will calculate the monthly payment and total payment
         */
        cal.setOnAction(e->{
            //Getting the input values
            double loanAmount = Double.parseDouble(num3.getText());
            int numberofyears = Integer.parseInt(num4.getText());
            double annualInterestRate = Double.parseDouble(num5.getText());

            //annual interest to monthly
            double monthlyInterestRate = annualInterestRate/100/12;

            //number of months
            int numMonths = numberofyears*12;

            //Monthly payment
            double mPayment = (loanAmount * monthlyInterestRate) / (1- Math.pow(1 + monthlyInterestRate, -numMonths));

            //total payment
            double totalpayment = mPayment * numMonths;
            //Setting the text fields to value of calculations
            //Formatted output
            num1.setText(String.valueOf(String.format("%.2f", totalpayment)));
            num2.setText(String.valueOf(String.format("%.2f", mPayment)));
        });
        //Created a scene with group contained all elements created above
        Scene scene = new Scene(new Group(cal,num1,num2,num3,num4,num5,irLabel,tp,mp,la,years,directions), 450 ,400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}