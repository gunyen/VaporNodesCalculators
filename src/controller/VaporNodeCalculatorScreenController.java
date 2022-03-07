package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CalculateROI;
import model.ROI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static model.Coin.coinPrice;

public class VaporNodeCalculatorScreenController implements Initializable {

    @FXML
    private Label avalancheLabel;
    @FXML
    private Label vaporNodeLabel;
    @FXML
    private TextField labelCurrentVPND;
    @FXML
    private TextField labelDaysSinceClaimed;
    public Label exceptionLabel;

    @FXML
    private TableView<CalculateROI> calculateTableView;
    @FXML
    private TableColumn<CalculateROI, Integer> dayColumn;
    @FXML
    private TableColumn<CalculateROI, Double> vpndColumn;
    @FXML
    private TableColumn<CalculateROI, String> diamondHandsColumn;
    @FXML
    private TableColumn<CalculateROI, String> compoundBonusColumn;
    @FXML
    private TableColumn<CalculateROI, Double> rewardColumn;
    @FXML
    private TableColumn<CalculateROI, Double> feeColumn;
    @FXML
    private TableColumn<CalculateROI, Double> totalColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            String avax = String.valueOf(coinPrice("https://api.coingecko.com/api/v3/simple/price?ids=avalanche-2&vs_currencies=usd"));
            avalancheLabel.setText("$" + avax);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String vaporNode = String.valueOf(coinPrice("https://api.coingecko.com/api/v3/simple/price?ids=vapornodes&vs_currencies=usd"));
            vaporNodeLabel.setText("$" + vaporNode);
        } catch (IOException e) {
            e.printStackTrace();
        }

        calculateTableView.setItems(ROI.getAllROI());

        dayColumn.setCellValueFactory(new PropertyValueFactory<>("day"));
        vpndColumn.setCellValueFactory(new PropertyValueFactory<>("vpnd"));
        diamondHandsColumn.setCellValueFactory(new PropertyValueFactory<>("diamondHands"));
        compoundBonusColumn.setCellValueFactory(new PropertyValueFactory<>("compoundBonus"));
        rewardColumn.setCellValueFactory(new PropertyValueFactory<>("reward"));
        feeColumn.setCellValueFactory(new PropertyValueFactory<>("fee"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));


    }

    public void onClickCalculate(ActionEvent actionEvent) throws IOException {
        if (!exceptionLabel.getText().isEmpty()) {
            exceptionLabel.setText("");
        }
        ROI.getAllROI().clear();
        double days = 0d;
        double currentVPND = 0d;

        try {
            days = Double.parseDouble(labelDaysSinceClaimed.getText());
        } catch (NumberFormatException e) {
            String exception = exceptionLabel.getText();
            if (exceptionLabel.getText().isEmpty()) {
                exceptionLabel.setText("Enter days since rewards was claimed");
            } else {
                exceptionLabel.setText(exception + "\nEnter days since rewards was claimed");
            }
        }

        try {
            currentVPND = Double.parseDouble(labelCurrentVPND.getText());
        } catch (NumberFormatException e) {
            String exception = exceptionLabel.getText();
            if (exceptionLabel.getText().isEmpty()) {
                exceptionLabel.setText("Enter current amount of VPND");
            } else {
                exceptionLabel.setText(exception + "\nEnter current amount of VPND");
            }
        }

        String avax = String.valueOf(coinPrice("https://api.coingecko.com/api/v3/simple/price?ids=avalanche-2&vs_currencies=usd"));
        avalancheLabel.setText("$" + avax);

        String vpnd = String.valueOf(coinPrice("https://api.coingecko.com/api/v3/simple/price?ids=vapornodes&vs_currencies=usd"));
        vaporNodeLabel.setText("$" + vpnd);
        double vpndUSD = Double.parseDouble(vpnd);
        double currentVPNDUSD = currentVPND * vpndUSD;
        int daysList = 0;
        String diamondHands = "";
        String compoundBonus = "";
        double reward = 0d;
        double fee = 0d;
        double total = 0d;
        while (daysList < 365) {
            reward = currentVPNDUSD * .01d;
            if (days <= 2) {
                diamondHands = "x0";
                if ((currentVPNDUSD / vpndUSD) >= 20000) {
                    compoundBonus = "0%";
                } else if ((currentVPNDUSD / vpndUSD) >= 10000) {
                    compoundBonus = "10%";
                    reward *= 1.1d;
                } else if ((currentVPNDUSD / vpndUSD) >= 5000) {
                    compoundBonus = "15%";
                    reward *= 1.15d;
                } else if ((currentVPNDUSD / vpndUSD) >= 1000) {
                    compoundBonus = "25%";
                    reward *= 1.25d;
                }
            } else if (days <= 6) {
                diamondHands = "x1.05";
                reward *= 1.05d;
                if ((currentVPNDUSD / vpndUSD) >= 20000) {
                    compoundBonus = "0%";
                } else if ((currentVPNDUSD / vpndUSD) >= 10000) {
                    compoundBonus = "10%";
                    reward *= 1.1d;
                } else if ((currentVPNDUSD / vpndUSD) >= 5000) {
                    compoundBonus = "15%";
                    reward *= 1.15d;
                } else if ((currentVPNDUSD / vpndUSD) >= 1000) {
                    compoundBonus = "25%";
                    reward *= 1.25d;
                }
            } else if (days <= 14) {
                diamondHands = "x1.2";
                reward *= 1.2d;
                if ((currentVPNDUSD / vpndUSD) >= 20000) {
                    compoundBonus = "0%";
                } else if ((currentVPNDUSD / vpndUSD) >= 10000) {
                    compoundBonus = "10%";
                    reward *= 1.1d;
                } else if ((currentVPNDUSD / vpndUSD) >= 5000) {
                    compoundBonus = "15%";
                    reward *= 1.15d;
                } else if ((currentVPNDUSD / vpndUSD) >= 1000) {
                    compoundBonus = "25%";
                    reward *= 1.25d;
                }
            } else if (days > 14) {
                diamondHands = "x1.4";
                reward *= 1.4d;
                if ((currentVPNDUSD / vpndUSD) >= 20000) {
                    compoundBonus = "0%";
                } else if ((currentVPNDUSD / vpndUSD) >= 10000) {
                    compoundBonus = "10%";
                    reward *= 1.1d;
                } else if ((currentVPNDUSD / vpndUSD) >= 5000) {
                    compoundBonus = "15%";
                    reward *= 1.15d;
                } else if ((currentVPNDUSD / vpndUSD) >= 1000) {
                    compoundBonus = "25%";
                    reward *= 1.25d;
                }
            }
            fee = reward * .01d;
            total = (currentVPNDUSD + reward) - fee;
            days++;
            daysList++;
            if (exceptionLabel.getText().isEmpty()) {
                CalculateROI calculateROI = new CalculateROI(daysList, currentVPNDUSD, diamondHands, compoundBonus, reward, fee, total);
                ROI.addCalculation(calculateROI);
            }
            currentVPNDUSD = total;
        }
    }
}
