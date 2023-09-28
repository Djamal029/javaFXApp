/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantkedjenou;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.converter.IntegerStringConverter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;
import static restaurantkedjenou.SellerController.showAlert;

/**
 *
 * @author djama
 */
public class SellerControllerAdmin implements Initializable {
    
    @FXML
    private ComboBox<String> comboPaiementChap, comboModePaiementAfter,comboFilterCommandesTable;

    @FXML
    private ComboBox<String> comboPlat;

    @FXML
    private ComboBox<String> comboServeur;

    @FXML
    private ComboBox<String> comboTable;

    @FXML
    private ComboBox<String> comboType;
    
    @FXML
    private ComboBox<String> comboMenu;
    
    @FXML 
    private ComboBox<String> comboFIlterCommandesTable;
        
    @FXML
    private TableView<Recu> tableRecu;
    
    @FXML
    private TableView<Commande> tableCmd;
    
    @FXML
    private TextField entryQte;
    
     @FXML
    private TextField entryTotal;
     
    @FXML
    private TextField entryMontantRemisChap;
    
    @FXML
    private TextField entryMontantAfter;
    
    @FXML
     private TextField entryFacture;
    
    @FXML
    private TextField entryTable;

    @FXML
    private Label labelFacture;

    @FXML
    private Label labelHeure;
    
    @FXML
    private Label labelNomPlat;

    @FXML
    private Label labelPrix;
    
    @FXML
    private ImageView imageView;
    
    
    @FXML
    private Label lblPrixU, lblConnecte;

   
    
    @FXML
    private Label lblQteU, lblTotal;
    
    @FXML
    private Label labelMonnaieSurLeChamp;
     
    
    
    @FXML
    private TableColumn<Recu, Integer> col1;

    @FXML
    private TableColumn<Recu, String> col2;

    @FXML
    private TableColumn<Recu, String> col3;

    @FXML
    private TableColumn<Recu, Integer> col4;

    @FXML
    private TableColumn<Recu, Double> col5;

    @FXML
    private TableColumn<Recu, Double> col6;

    @FXML
    private TableColumn<Recu, String> col7;

    @FXML
    private TableColumn<Recu, String> col8;
    
    
    @FXML
    private TableColumn<Commande, Integer> col9;

    @FXML
    private TableColumn<Commande, String> col10;

    @FXML
    private TableColumn<Commande, String> col11;

    @FXML
    private TableColumn<Commande, String> col12;

    @FXML
    private TableColumn<Commande, Integer> col13;

    @FXML
    private TableColumn<Commande, Double> col14;

    @FXML
    private TableColumn<Commande, Double> col15;
    
    @FXML
    private TableColumn<Commande, String> col16;

    @FXML
    private TableColumn<Commande, String> col17;
    
      @FXML
    private TableColumn<Commande, String> col18;

    @FXML
    private TableColumn<Commande, String> col19;

    @FXML
    private TableColumn<Commande, String> col20;

    @FXML
    private TableColumn<Commande, String> col21;
    
    @FXML
    private TableColumn<Commande, String> col22;
    
    @FXML
    private DatePicker entryDate1Rapport;

    @FXML
    private DatePicker entryDate2Rapport;

    @FXML
    private DatePicker entryDate3Rapport;

    @FXML
    private Button btnGenererPlage;

    @FXML
    private CheckBox checkBoxActiveSelection;

    @FXML
    private Button btnGenererDate;
    
    /**************************************************************************************************/
// SERVEURS 
@FXML
private TableView<Commande> tableServeur; // commande impayées

@FXML
private TableView<Commande> tableServeur1; // commandes payées

@FXML
private TableColumn<Commande, Integer> idServeur; // Colonne pour l'ID des commandes impayées

@FXML
private TableColumn<Commande, String> npServeur; // Colonne pour le nom du serveur des commandes impayées

@FXML
private TableColumn<Commande, Integer> idServeurPaye; // Colonne pour l'ID des commandes payées

@FXML
private TableColumn<Commande, String> npServeurPaye; // Colonne pour le nom du serveur des commandes payées

@FXML
private TableColumn<Commande, Integer> qteNP; // Colonne pour la quantité des commandes impayées

@FXML
private TableColumn<Commande, Double> totalNP; // Colonne pour le total des commandes impayées

@FXML
private TableColumn<Commande, Integer> qteP; // Colonne pour la quantité des commandes payées

@FXML
private TableColumn<Commande, Double> totalP; // Colonne pour le total des commandes payées

@FXML
private ComboBox<String> comboRapportServeur;

@FXML
private DatePicker datePickerServeurRapport;

@FXML
private Label textServeur;
  
/**********************************************/
   
    private final ObservableList<Recu> listeRecus = FXCollections.observableArrayList();
    
    Commande c = new Commande();
   
    private ObservableList<Commande> listeCommandes = c.getAllCommandes();

    private final ObservableList<Ventes> listeVentes = FXCollections.observableArrayList();
    
    private double total_fact_today = 0.0;

    private String facture_apres_avoir_manger = "";

    private String table_apres_avoir_manger = "";
  
    private String nomP , prenomP ;
    
    String print = "NO";
    
  private void recupererInformationsFichierTexte() {
    try {
        File file = new File("admin.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String nom = reader.readLine();
        String prenom = reader.readLine();
        reader.close();

        // Utiliser les informations récupérées comme nécessaire
        nomP = nom;
        prenomP = prenom;

        // Supprimer le fichier texte
        //file.delete();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
  
 /********************* serveur ****************************************************************/
public void initialise_table_serveur(){
    // Initialisez les colonnes des tables avec les valeurs appropriées
    idServeur.setCellValueFactory(new PropertyValueFactory<>("id"));
    npServeur.setCellValueFactory(new PropertyValueFactory<>("serveur"));
    qteNP.setCellValueFactory(new PropertyValueFactory<>("qte"));
    totalNP.setCellValueFactory(new PropertyValueFactory<>("total"));
    
    idServeurPaye.setCellValueFactory(new PropertyValueFactory<>("id"));
    npServeurPaye.setCellValueFactory(new PropertyValueFactory<>("serveur"));
    qteP.setCellValueFactory(new PropertyValueFactory<>("qte"));
    totalP.setCellValueFactory(new PropertyValueFactory<>("total"));
   Commande c = new Commande();
    // Obtenez les listes de commandes impayées et payées
    ObservableList<Commande> commandesImpayees = c.getToutesCommandesImpayees();
    ObservableList<Commande> commandesPayees = c.getToutesCommandesPayees();
    
    // Liez les listes de commandes aux tables correspondantes
    tableServeur.setItems(commandesImpayees);
    tableServeur1.setItems(commandesPayees);
    
     Utilisateur u = new Utilisateur();
     ObservableList<String> Serveurs = u.returnAllServeur();
     comboRapportServeur.setItems(Serveurs);
}

@FXML
private void actualiserCommandes(ActionEvent event) {
    // Récupérez les valeurs sélectionnées dans la ComboBox et le DatePicker
    String serveurSelectionne = comboRapportServeur.getValue();
    LocalDate dateSelectionnee = datePickerServeurRapport.getValue();

    if (serveurSelectionne != null && dateSelectionnee != null) {
        // Appelez vos méthodes pour obtenir les commandes impayées et payées en fonction des valeurs sélectionnées
         Commande c = new Commande();
        ObservableList<Commande> commandesImpayees = c.getCommandesImpayeesServeurCaissierDate(serveurSelectionne, nomP +" "+prenomP, dateSelectionnee);
        ObservableList<Commande> commandesPayees = c.getCommandesPayeesServeurCaissierDate(serveurSelectionne, nomP +" "+prenomP, dateSelectionnee);

        // Mettez à jour les tables avec les nouvelles données
        tableServeur.setItems(commandesImpayees);
        tableServeur1.setItems(commandesPayees);

        // Mettez à jour le LabelText avec les informations sur les états des commandes du serveur
        String informations = "ETAT DES COMMANDE DE  : " + serveurSelectionne +
                             " A LA DATE DU : " + dateSelectionnee.toString() + "\n";

        textServeur.setText(informations);
    } else {
        // Gérez le cas où les valeurs ne sont pas sélectionnées
        showAlert(Alert.AlertType.ERROR, "Des Champs sont vides", "Sélectionnez un serveur et une date." );
    }
}


@FXML
private void reinitialiserChampsEtTable(ActionEvent event) {
    // Réinitialisez les champs et la table avec les données initiales ici

    // Exemple : réinitialisez la ComboBox, le DatePicker et le LabelText
    comboRapportServeur.getSelectionModel().clearSelection();
    datePickerServeurRapport.setValue(null);
    textServeur.setText("ETATS DES COMMANDES DES SERVEURS");

    // Réinitialisez la table en fonction des données initiales
    initialise_table_serveur();
}


/*******************************************************************************************/
  
  
    
    public void reload(){
        Commande c = new Commande();
        listeCommandes = c.getAllCommandes();
    }

    
public void initialize_tableCmd(){
        col9.setCellValueFactory(new PropertyValueFactory<>("id"));
        col10.setCellValueFactory(new PropertyValueFactory<>("type"));
        col11.setCellValueFactory(new PropertyValueFactory<>("menu"));
        col12.setCellValueFactory(new PropertyValueFactory<>("designation"));
        col13.setCellValueFactory(new PropertyValueFactory<>("qte"));
        col14.setCellValueFactory(new PropertyValueFactory<>("prixU"));
        col15.setCellValueFactory(new PropertyValueFactory<>("total"));
        col16.setCellValueFactory(new PropertyValueFactory<>("Facture"));
        col17.setCellValueFactory(new PropertyValueFactory<>("dateHeure"));
        col18.setCellValueFactory(new PropertyValueFactory<>("table"));
        col19.setCellValueFactory(new PropertyValueFactory<>("serveur"));
        col20.setCellValueFactory(new PropertyValueFactory<>("caissier"));
        col21.setCellValueFactory(new PropertyValueFactory<>("statut"));
        col22.setCellValueFactory(new PropertyValueFactory<>("code_vente"));
        
        
        
        tableCmd.setItems(listeCommandes);
        
       comboFIlterCommandesTable.setValue("Commandes Impayées");

        comboFIlterCommandesTable.setOnAction((ActionEvent event) -> {
            String valueSelected = comboFIlterCommandesTable.getValue();

            if (valueSelected != null) {
                if (valueSelected.equals("Commandes Impayées")) {
                    filterTableByStatus("Impayé");
                } else if (valueSelected.equals("Commandes Payées")) {
                    filterTableByStatus("Payé");
                } else if (valueSelected.equals("Toutes les commandes")) {
                    reload();
                    tableCmd.setItems(listeCommandes);
                } else {
                    // Reset fields and filter by default status
                    entryFacture.setText("");
                    entryTable.setText("");
                    entryMontantAfter.setText("");
                    comboModePaiementAfter.setValue(null);
                    entryTotal.setText("");
                   reload();
                    tableCmd.refresh();
                    facture_apres_avoir_manger = "";
                    table_apres_avoir_manger = "";
                    filterTableByStatus("Impayé");
                    comboFIlterCommandesTable.setValue("Commandes Impayées");
                                      
                }
            }
        });

        
         tableCmd.setRowFactory(tv -> {
            TableRow<Commande> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    Commande commande = row.getItem();
                    
                    // Remplissez les champs Facture et table avec les valeurs de la ligne double-cliquée
                    entryFacture.setText(commande.getFacture());
                    entryTable.setText(commande.getTable());
                    double tt = commande.getTotal_(commande.getCode_vente(), commande.getFacture());
                    entryTotal.setText(Double.toString(tt));
                }
            });
                ContextMenu contextMenu = new ContextMenu();
                MenuItem annulerCommandeItem = new MenuItem("Annuler la commande");
                MenuItem modifierCommandeItem = new MenuItem("Modifier la commande");
                modifierCommandeItem.setOnAction(event -> {
                try {
                    modifierCommandesSelectionnees();
                } catch (ParseException ex) {
                    Logger.getLogger(SellerControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
                    reload();
                    tableCmd.refresh();
                    filterTableByStatus("Impayé");
                       comboFIlterCommandesTable.setValue("Commandes Impayées");
                       
                    });
                
                 annulerCommandeItem.setOnAction(event -> {
                    
                    Commande commande = row.getItem();

                    Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    confirmationAlert.setTitle("Confirmation");
                    confirmationAlert.setHeaderText("Annulation de la commande");
                    confirmationAlert.setContentText("Êtes-vous sûr de vouloir annuler cette commande ?\nToutes ses informations seront enregistrées et l'administrateur les verras lors des comptes, donc faites gaf à ne pas vous tromper !!!");

                    Optional<ButtonType> result = confirmationAlert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        try {
                            annulerCommandes();
                        } catch (ParseException ex) {
                            Logger.getLogger(SellerControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        reload();
                        tableCmd.refresh();
                       filterTableByStatus("Impayé");
                       comboFIlterCommandesTable.setValue("Commandes Impayées");
                      
                    
                    }
                    });
                    /*
                    
                    */
               

                contextMenu.getItems().addAll(modifierCommandeItem,annulerCommandeItem);
                row.contextMenuProperty().bind(
                        Bindings.when(Bindings.isNotNull(row.itemProperty()))
                                .then(contextMenu)
                                .otherwise((ContextMenu) null));
                return row;
        });
         filterTableByStatus("Impayé");
}

public void filterTableByStatus(String status) {
    ObservableList<Commande> filteredList = FXCollections.observableArrayList();
    
    for (Commande commande : listeCommandes) {
        if (commande.getStatut().equals(status)) {
            filteredList.add(commande);
        }
    }
    //filterTableByStatus("Impayé");
    tableCmd.setItems(filteredList);
}

public void filterTableByFactureAndTable(String facture, String table) {
    if (facture.isEmpty() && table.isEmpty()) {
        tableCmd.setItems(listeCommandes); // Aucun filtre, afficher toutes les commandes
        return;
    }
    
    ObservableList<Commande> filteredList = FXCollections.observableArrayList();
    
    for (Commande commande : listeCommandes) {
        String commandeFacture = commande.getFacture();
        String commandeTable = commande.getTable();
        
        if (!facture.isEmpty() && !table.isEmpty()) {
            if (commandeFacture.equals(facture) && commandeTable.equals(table)) {
                filteredList.add(commande);
            }
        } else if (!facture.isEmpty()) {
            if (commandeFacture.equals(facture)) {
                filteredList.add(commande);
            }
        } else if (!table.isEmpty()) {
            if (commandeTable.equals(table)) {
                filteredList.add(commande);
            }
        }
    }
    
    tableCmd.setItems(filteredList);
}

@FXML
public void searchAndActualCmd(ActionEvent event){
    String fact = entryFacture.getText().trim();
    String table = entryTable.getText().trim();
    filterTableByFactureAndTable(fact,table);
}



/**************************************** Table recu **************************************************************/

public void initialize_tableRecu(){
    col1.setCellValueFactory(new PropertyValueFactory<>("id"));
    col2.setCellValueFactory(new PropertyValueFactory<>("menu"));
    col3.setCellValueFactory(new PropertyValueFactory<>("designation"));
    col4.setCellValueFactory(new PropertyValueFactory<>("qte"));
    col5.setCellValueFactory(new PropertyValueFactory<>("prixU"));
    col6.setCellValueFactory(new PropertyValueFactory<>("total"));
    col7.setCellValueFactory(new PropertyValueFactory<>("facture"));
    col8.setCellValueFactory(new PropertyValueFactory<>("table"));
    
    tableRecu.setItems(listeRecus);

    tableRecu.setEditable(true); // Permet la modification des cellules

    col4.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter())); // Colonne "qte" modifiable
    
    col4.setOnEditCommit(event -> {
        Recu recu = event.getRowValue();
        int newQuantity = event.getNewValue();
        int oldValue = recu.getQte();
        double odlTotal = recu.getTotal();
        if(newQuantity > 0){
            try {
                // Verify if the new quantity is valid
                if (newQuantity <= getQuantiteDisponible(recu.getMenu(), recu.getDesignation()) ) {
                    recu.setQte(newQuantity);
                    recu.setTotal(recu.getPrixU() * newQuantity); // Update the total based on the modified quantity
                    
                    total_fact_today += recu.getPrixU() * newQuantity - odlTotal;
                    String textTotal = "Total : " + total_fact_today+" fcfa";
                    lblTotal.setText(textTotal);
                    // Update the sales list based on the modifications made to the receipts
                    for (Ventes vente : listeVentes) {
                        if (vente.getMenu().equals(recu.getMenu()) && vente.getDesignation().equals(recu.getDesignation())) {
                            vente.setQte(recu.getQte());
                            vente.setTotal(recu.getTotal());
                            break;
                        }
                    }

                    tableRecu.refresh(); // Refresh the table to display the new total value
                } else {
                    String message = "La quantité disponible est insuffisante. Quantité disponible : " + getQuantiteDisponible(recu.getMenu(), recu.getDesignation()) +
                            ", Quantité demandée : " + newQuantity;
                    showAlert(Alert.AlertType.WARNING, "Quantité indisponible", message);
                      recu.setQte(oldValue);
                    //recu.setTotal(recu.getPrixU() * oldValue);
                    tableRecu.refresh();

                }   } catch (SQLException ex) {
                Logger.getLogger(SellerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
             showAlert(Alert.AlertType.WARNING, "Quantité Nulle", "Entrez une quantité positive");
             recu.setQte(oldValue);
             tableRecu.refresh();
        }
            
    });
}

private void initialiserMenuContextuel() {
    MenuItem retirerMenuItem = new MenuItem("Retirer");
    retirerMenuItem.setOnAction(this::retirerElement);

    ContextMenu contextMenu = new ContextMenu(retirerMenuItem);
    tableRecu.setContextMenu(contextMenu);
}

@FXML
private void retirerElement(ActionEvent event) {
    if (listeRecus.isEmpty()) {
        showAlert(Alert.AlertType.INFORMATION, "Panier vide", "Le panier est vide.");
        return; // Sortir de la méthode si le panier est vide
    }

    Recu selectedRecu = tableRecu.getSelectionModel().getSelectedItem();
    if (selectedRecu != null) {
        listeRecus.remove(selectedRecu);
        double total = selectedRecu.getTotal();
        total_fact_today -= total ;
        String textTotal = "Total : " + total_fact_today+" fcfa";
        lblTotal.setText(textTotal);

        // Retirer l'élément correspondant de la liste des ventes
        Ventes venteToRemove = null;
        for (Ventes vente : listeVentes) {
            if (vente.getMenu().equals(selectedRecu.getMenu()) && vente.getDesignation().equals(selectedRecu.getDesignation())) {
                venteToRemove = vente;
                break;
            }
        }
        if (venteToRemove != null) {
            listeVentes.remove(venteToRemove);
            showAlert(Alert.AlertType.INFORMATION, "Élément retiré", "L'élément a été retiré du panier:\n\nMenu: " + venteToRemove.getMenu() + "\nDesignation: " + venteToRemove.getDesignation() + "\nQuantité: " + venteToRemove.getQte());
        }
    } else {
        int lastIndex = listeRecus.size() - 1;
        if (lastIndex >= 0) { // Check if the index is valid
            Recu lastRecu = listeRecus.remove(lastIndex);
            double total = lastRecu.getTotal();
            total_fact_today -= total ;
            String textTotal = "Total : " + total_fact_today+" fcfa";
            lblTotal.setText(textTotal);

            // Retirer l'élément correspondant de la liste des ventes
            if (!listeVentes.isEmpty()) {
                Ventes venteToRemove = listeVentes.remove(lastIndex);
                showAlert(Alert.AlertType.INFORMATION, "Élément retiré", "L'élément a été retiré du panier:\n\nMenu: " + venteToRemove.getMenu() + "\nDesignation: " + venteToRemove.getDesignation() + "\nQuantité: " + venteToRemove.getQte());
            }
        }
    }

    tableRecu.refresh();
}

public static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

// serveurs

public void remplirComboServeursCaissiers(){
        Utilisateur u = new Utilisateur();
         ObservableList<String> Serveurs = u.returnAllServeur();
         comboServeur.setItems(Serveurs);      
    }


public String gen_code_vente(String code_Fact){
    return "Vente" + "_" + code_Fact;
}

public static java.sql.Date extractSqlDateFromString(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = dateFormat.parse(dateString);
            return new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

 public static String extractTimeFromString(String dateString) {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat outputTimeFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            Date date = inputDateFormat.parse(dateString);
            return outputTimeFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

// ajouter au panier

public void ajouterEvent(ActionEvent event) throws SQLException{
     ajouter();
}


public void ajouter() throws SQLException{
    String type = comboType.getValue();
    String menu = comboMenu.getValue();
    String designation = comboPlat.getValue();
    String Caissier = nomP + " " + prenomP;
    String serveur = comboServeur.getValue();
    
    double prix = Double.parseDouble(labelPrix.getText());
    
    String noTable = comboTable.getValue();
    String facture = labelFacture.getText();
    Date today = new Date() ;
    long timestamp = System.currentTimeMillis();
    Date heureActuelle = new Date(timestamp);
    SimpleDateFormat heureFormat = new SimpleDateFormat("HH:mm:ss");
    String heureFormatee = heureFormat.format(heureActuelle);
    String date_heure = today.toString() + " " + heureFormatee;
    String code_vente = gen_code_vente(facture);
    String paiement = "NONE"; // a modifier avant l'impression
    java.sql.Date sqlDate;
        sqlDate = new java.sql.Date(today.getTime());
    
    int qte_disponible = Integer.parseInt(lblQteU.getText());
    if (type == null || menu == null || designation == null || entryQte.getText().trim().isEmpty() || noTable == null || comboServeur.getValue() == null) {
    showAlert(Alert.AlertType.ERROR, "Champs vides", "Veuillez remplir tous les champs.");
    return;
}
    else {
     if (verifierQuantiteDisponible() && !entryQte.getText().trim().isEmpty()) {
         int qte =  Integer.parseInt(entryQte.getText().trim());
         Double total = qte*prix;
        int id_rec = listeRecus.size() + 1;
        Recu recu = new Recu(id_rec, menu, designation, qte, prix,total,facture, noTable);
        listeRecus.add(recu);

        Ventes vente = new Ventes(id_rec, type, menu,designation, qte, prix, total, facture, 0.0, 0.0,paiement, Caissier, serveur, sqlDate, heureFormatee,code_vente);
        listeVentes.add(vente);
        total_fact_today += total;
        
         String textTotal = "Total : " + total_fact_today+" fcfa";
        lblTotal.setText(textTotal);
        verifierProduitsGroupes();
        tableRecu.refresh();
       
        entryQte.setText("1");
        
    } else {
        showAlert(Alert.AlertType.ERROR, "Erreur", "Les informations d'ajout sont invalides ou la quantité disponible est insuffisante.");
    }
}
   
}

// enregistrer et annuler commandes 

public void enregistrerCommandeAvecConfirmation(String Statut,double montant, String modePaiement) {
    if (listeVentes.isEmpty() || listeRecus.isEmpty()) {
        showAlert(Alert.AlertType.ERROR, "Erreur", "Impossible d'enregistrer les commandes. Assurez-vous que la liste des ventes et la liste des reçus ne sont pas vides.");
        return;
    }else{
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText("Enregistrement de commandes");
        confirmationAlert.setContentText("Êtes-vous sûr de vouloir enregistrer la commande ?");
        String factUpdate;
        double total_ttt = 0.0;


        Optional<ButtonType> result = confirmationAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            for (Ventes vente : listeVentes) {
                Commande commande = new Commande();
                commande.setId(vente.getId());
                commande.setType(vente.getType());
                commande.setMenu(vente.getMenu());
                commande.setDesignation(vente.getDesignation());
                commande.setQte(vente.getQte());
                commande.setPrixU(vente.getPrixUnitaire());
                commande.setTotal(vente.getTotal());
                commande.setFacture(vente.getFacture());
                factUpdate = vente.getFacture();
                commande.setTable(listeRecus.get(0).getTable().toString());
                commande.setDateHeure(vente.getDate_vente() + " " + vente.getHeure());
                commande.setServeur(vente.getServeur());
                commande.setCaissier(vente.getCaissier());
                commande.setStatut(Statut);
                commande.setCode_vente(vente.getCode_vente());

                total_ttt += vente.getTotal();
                if(vente.getType().equals("Boissons")){
                    Produit pPP = new Produit();
                    
                    String codeP = pPP.getCodeProduitForBoissons(vente.getMenu(), vente.getDesignation());
                    
                    Sorties s = new Sorties(0,vente.getDesignation(),vente.getQte(),vente.getPrixUnitaire(),vente.getDate_vente(),codeP);
                    s.vendreProduit();
                }
                
                print = "YES";
                // Ajouter la commande à la liste des commandes
                 if(Statut == "Impayé"){
                     vente.insererVentesTempon();
                     commande.insererCmd();
                     Produit P = new Produit(vente.getType(),vente.getMenu(),vente.getDesignation(),vente.getQte());
                     P.updateProductQuantity();
                }
                 else{
                     if(montant >= total_ttt){
                            
                            Produit P = new Produit(vente.getType(),vente.getMenu(),vente.getDesignation(),vente.getQte());
                            P.updateProductQuantity();
                            
                            vente.setModeDePaiement(modePaiement);
                            vente.setMontantRemis(montant);
                            vente.setMonnaie(montant-total_ttt);
                            //vente.updateMonnaieForFacture(factUpdate, montant -total_ttt);
                            double m = montant - total_ttt;
                            
                            vente.insererVentes();

                            commande.insererCmd();
                            double monnaie = montant - total_ttt;
                            labelMonnaieSurLeChamp.setText("Monnaie : "+ monnaie+ " FCFA");
                            //Ventes nV = new Ventes();
                            //nV.updateMonnaieForFacture(factUpdate, montant -total_ttt);
                     }
                     else{
                           showAlert(Alert.AlertType.ERROR, "IMPOSSIBLE", "Le montant remis doit être supérieure ou égal au total");
                     }
                 }


                reload();
                tableCmd.refresh();
            }

       
    }
    }

    
}

// modifier la commande <<<====

public void modifierCommandesSelectionnees() throws ParseException {
    Commande commandeSelectionnee = tableCmd.getSelectionModel().getSelectedItem();
    
    if (commandeSelectionnee == null) {
        showAlert(Alert.AlertType.WARNING, "Aucune commande sélectionnée", "Veuillez sélectionner une commande à modifier.");
        return;
    }
    
     if (!listeRecus.isEmpty()) {
        showAlert(Alert.AlertType.WARNING, "Transaction non achevée", "Veuillez sélectionner terminer l'enregistrement de la commande en cours ou annuler le panier\nLe panier contient des éléments.");
        return;
    }

    // Vérifier que le statut de la commande sélectionnée n'est pas "Payé"
    if ("Payé".equals(commandeSelectionnee.getStatut())) {
        showAlert(Alert.AlertType.WARNING, "Commande déjà payée", "La commande sélectionnée est déjà payée et ne peut pas être modifiée.");
        return;
    }

    // Demander confirmation à l'utilisateur
    Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
    confirmationAlert.setTitle("Confirmation");
    confirmationAlert.setHeaderText("Modifier la commande sélectionnée");
    confirmationAlert.setContentText("Êtes-vous sûr de vouloir modifier la commande sélectionnée ?");

    Optional<ButtonType> result = confirmationAlert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
        String fact___ = commandeSelectionnee.getFacture();
        // Récupérer toutes les lignes de la table de commandes avec le même code_vente
        ObservableList<Commande> commandesAModifier = FXCollections.observableArrayList();
        double totalRecuModifie = 0.0; // Initialiser le total du reçu modifié

        for (Commande commande : listeCommandes) {
            if (commande.getCode_vente().equals(commandeSelectionnee.getCode_vente())) {
                if(commande.getType().equals("Boissons")){
                    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
                    // Créez un objet SimpleDateFormat pour spécifier le format de sortie
                   
                    String dateString = commande.getDateHeure();
                     Date date = inputFormat.parse(dateString);
            
                // Utilisez le format de sortie pour formater la date en une nouvelle chaîne
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    
                    Produit pPP = new Produit();
                    
                    String codeP = pPP.getCodeProduitForBoissons(commande.getMenu(), commande.getDesignation());
                    
                    Sorties s = new Sorties(0,commande.getDesignation(),commande.getQte(),commande.getPrixU(),sqlDate,codeP);
                    s.retrancherQuantite();
                }
                commandesAModifier.add(commande);
                totalRecuModifie += commande.getTotal(); // Ajouter le total de chaque commande au total du reçu modifié
            }
        }

        // Insérer les enregistrements des commandes dans la table de reçus
        int nouveauIdRecu = 1; // Vous pouvez obtenir le nouvel ID de reçu de votre base de données
        for (Commande commande : commandesAModifier) {
            Recu nouveauRecu = new Recu(nouveauIdRecu, commande.getMenu(), commande.getDesignation(), 
                                         commande.getQte(), commande.getPrixU(), 
                                         commande.getTotal(), commande.getFacture(), 
                                         commande.getTable());
            updateStock(commande.getMenu(), commande.getDesignation(), 
                                         commande.getQte());
            listeRecus.add(nouveauRecu); // Ajouter le nouveau reçu à la liste
            Ventes vente = new Ventes(nouveauIdRecu, commande.getType(), commande.getMenu(),commande.getDesignation(), commande.getQte(), commande.getPrixU(), commande.getTotal(), commande.getFacture(), 0.0, 0.0,"NONE", commande.getCaissier(), commande.getServeur(),extractSqlDateFromString(commande.getDateHeure()), extractTimeFromString(commande.getDateHeure()),commande.getCode_vente());
            listeVentes.add(vente);
            nouveauIdRecu++; // Incrémenter l'ID de reçu
   
            
        }
        
        
        
        modifieCommandes();
        
        // Mettre à jour le total_fact_today
        
        total_fact_today = totalRecuModifie;
        String textTotal = "Total : " + total_fact_today + " fcfa";
        lblTotal.setText(textTotal);
        labelFacture.setText(fact___);
        
        // mettre à jour le serveur et la table de la commande à modifier
        
        comboServeur.setValue(commandeSelectionnee.getServeur());
        comboTable.setValue(commandeSelectionnee.getTable());
        showAlert(Alert.AlertType.INFORMATION, "Modification réussie", "La commande a été ajoutée au panier.\nRendez-vous sur l'interface de vente.");
        setComboTable();
    }
}

public void updateStock(String menu, String designation, int quantity) {
    MySqlConnection sql = new MySqlConnection();
    Connection connection = sql.getConnection();

    try {
        String queryUpdateStock = "UPDATE stock SET qte = qte + ? WHERE menu = ? AND designation = ?";
        PreparedStatement updateStockStatement = connection.prepareStatement(queryUpdateStock);

        updateStockStatement.setInt(1, quantity);
        updateStockStatement.setString(2, menu);
        updateStockStatement.setString(3, designation);
        updateStockStatement.executeUpdate();

        System.out.println("Stock updated successfully");
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Handle SQL exceptions
    } finally {
        try {
            connection.close();
        } catch (SQLException closeEx) {
            closeEx.printStackTrace();
        }
    }
}

// modifier cmd

public void modifieCommandes() {
    Commande commande = tableCmd.getSelectionModel().getSelectedItem();
    int id = commande.getId(); // Récupérez l'ID de la commande
    String statut = commande.getStatut();
    if(statut == "Payé"){
        showAlert(Alert.AlertType.ERROR, "ERREUR", "Impossible d'annuler une commande déja reglée");
        return;
    }
    

    MySqlConnection sql2 = new MySqlConnection();
    Connection connection = sql2.getConnection();
    try {
        // Enregistrer les informations de la commande annulée dans la table commandes_annulees avec l'ID
        String insertIntoCmdAnnulees = "INSERT INTO commandes_modifiees (id, type, menu, designation, qte, prixU, total, Facture, dateHeure, table_, serveur, caissier, statut, code_vente) " +
                "SELECT id, type, menu, designation, qte, prixU, total, Facture, dateHeure, table_, serveur, caissier, statut, code_vente FROM commandes WHERE code_vente = ?";
        PreparedStatement insertCmdAnnuleesStatement = connection.prepareStatement(insertIntoCmdAnnulees);
        insertCmdAnnuleesStatement.setString(1, commande.getCode_vente());
        insertCmdAnnuleesStatement.executeUpdate();
        
        supprimerCommandesEtVentesTempon(commande.getCode_vente());
        
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Gérer les exceptions SQL
    }
}

// annuler la commande

public void annulerCommandes() throws ParseException {
    Commande commande = tableCmd.getSelectionModel().getSelectedItem();
    int id = commande.getId(); // Récupérez l'ID de la commande
    String statut = commande.getStatut();
    if (statut.equals("Payé")) {
        showAlert(Alert.AlertType.ERROR, "ERREUR", "Impossible d'annuler une commande déjà réglée");
        return;
    }

    MySqlConnection sql2 = new MySqlConnection();
    Connection connection = sql2.getConnection();
    try {
        // Enregistrer les informations de la commande annulée dans la table commandes_annulees avec l'ID
        String insertIntoCmdAnnulees = "INSERT INTO commandes_annulees (id, type, menu, designation, qte, prixU, total, Facture, dateHeure, table_, serveur, caissier, statut, code_vente) " +
                "SELECT id, type, menu, designation, qte, prixU, total, Facture, dateHeure, table_, serveur, caissier, statut, code_vente FROM commandes WHERE code_vente = ?";
        PreparedStatement insertCmdAnnuleesStatement = connection.prepareStatement(insertIntoCmdAnnulees);
        insertCmdAnnuleesStatement.setString(1, commande.getCode_vente());
        insertCmdAnnuleesStatement.executeUpdate();

        // Mettre à jour le stock en réajoutant les quantités annulées
        ObservableList<Commande> commandesAModifier = FXCollections.observableArrayList();
        
        for (Commande cmd : listeCommandes) {
            if (cmd.getCode_vente().equals(commande.getCode_vente())) {
                if(commande.getType().equals("Boissons")){
                    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
                    // Créez un objet SimpleDateFormat pour spécifier le format de sortie
                   
                    String dateString = commande.getDateHeure();
                     Date date = inputFormat.parse(dateString);
            
                // Utilisez le format de sortie pour formater la date en une nouvelle chaîne
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    
                    Produit pPP = new Produit();
                    
                    String codeP = pPP.getCodeProduitForBoissons(commande.getMenu(), commande.getDesignation());
                    
                    Sorties s = new Sorties(0,commande.getDesignation(),commande.getQte(),commande.getPrixU(),sqlDate,codeP);
                    s.retrancherQuantite();
                }
                commandesAModifier.add(cmd);
            }
        }

        for (Commande cmd : commandesAModifier) {
            updateStock(cmd.getMenu(), cmd.getDesignation(), cmd.getQte());
        }
        
        supprimerCommandesEtVentesTempon(commandesAModifier.get(0).getCode_vente());
        
        showAlert(Alert.AlertType.INFORMATION, "Commande annulée", "La commande a été annulée avec succès.");
        genCancelledBill(getCancelledPrinterValue(),commande.getFacture(),commande.getTable());
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Gérer les exceptions SQL
    }   catch (JRException ex) {
            Logger.getLogger(SellerController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        try {
            connection.close();
        } catch (SQLException closeEx) {
            closeEx.printStackTrace();
        }
    }
}

public void supprimerCommandesEtVentesTempon(String codeVente) {
    MySqlConnection sql = new MySqlConnection();
    Connection connection = sql.getConnection();
    
    try {
        String queryDeleteCommandes = "DELETE FROM commandes WHERE code_vente = ?";
        String queryDeleteVentesTempon = "DELETE FROM ventes_tempon WHERE code_vente = ?";
        
        // Supprimer les commandes liées au code de vente
        try (PreparedStatement deleteCommandesStatement = connection.prepareStatement(queryDeleteCommandes)) {
            deleteCommandesStatement.setString(1, codeVente);
            deleteCommandesStatement.executeUpdate();
        }
        
        // Supprimer les ventes temporelles liées au code de vente
        try (PreparedStatement deleteVentesTemponStatement = connection.prepareStatement(queryDeleteVentesTempon)) {
            deleteVentesTemponStatement.setString(1, codeVente);
            deleteVentesTemponStatement.executeUpdate();
        }
        
        System.out.println("Tuples supprimés avec succès.");
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Gérer les exceptions SQL
    } finally {
        try {
            connection.close();
        } catch (SQLException closeEx) {
            closeEx.printStackTrace();
        }
    }
}


// chemin d'accès vers les recu et les rapport

public String getCancelledPrinterValue() {
        String cancelledPrinterValue = null;
        String query = "SELECT value FROM cancelled_printer";

        MySqlConnection mySqlConnection = new MySqlConnection();
        try (Connection connection = mySqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            
            if (resultSet.next()) {
                cancelledPrinterValue = resultSet.getString("value");
            }

        } catch (SQLException ex) {
            
        }
        
        return cancelledPrinterValue;
    }

public String getChemin(String type_) {
        String chemin = null;
        chemin = System.getProperty("user.dir");

        return chemin;
    }

public static String genererNumero() {
        // Générer un numéro aléatoire de 8 chiffres
        Random random = new Random();
        int numeroAleatoire = random.nextInt(900000) + 100000;


        // Obtenir la date du jour
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Concaténer le numéro aléatoire avec le format de date et le préfixe "_"
        String numeroConcatene = "Facture : " + dateFormat.format(date)+ "Fact_"+numeroAleatoire;

        return numeroConcatene;
    }

public int getNumberOfPrint() {
        int numberOfPrint = 0;
        String query = "SELECT number_of_print FROM printer";

        MySqlConnection mySqlConnection = new MySqlConnection();
        try (Connection connection = mySqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            
            if (resultSet.next()) {
                numberOfPrint = resultSet.getInt("number_of_print");
            }

        } catch (SQLException ex) {
            
        }
        
        return numberOfPrint;
    }

public void gen_bill_receipt_cmd_np(int number_of_receipts, String type){
    
    if (type == "type1"){
        if(print == "NO"){
            return;
        }
        
        String path = getChemin(type) + "/Receipt/SolderApresAvoirManger/cmd_np_client.jrxml";
   
        String Facture = labelFacture.getText().trim();
        String table = comboTable.getValue();



         MySqlConnection mySqlConnection = new MySqlConnection();
        try (Connection connexion = mySqlConnection.getConnection()) {

            JasperDesign jasperDesign = JRXmlLoader.load(path);

            String sql_query = "SELECT ventes_tempon.designation as v_design, " +
                       "ventes_tempon.qte as qte, " +
                       "ventes_tempon.prixUnitaire as prixU, " +
                       "ventes_tempon.total as total, " +
                       "ventes_tempon.montantRemis as montantR, " +
                       "ventes_tempon.monnaie as monnaie, " +
                       "ventes_tempon.facture as facture, " +
                       "ventes_tempon.modeDePaiement as paiement, " +
                       "ventes_tempon.caissier as caissier, " +
                       "ventes_tempon.serveur as serveur, " +
                       "ventes_tempon.date_vente as date_, " +
                       "ventes_tempon.heure as heure, " +
                       "(SELECT nom FROM informations WHERE id = 1) AS nom, " +
                       "(SELECT contact FROM informations WHERE id = 1) AS contact, " +
                       "(SELECT ville_secteur FROM informations WHERE id = 1) AS ville_secteur, " +
                       "(SELECT localisation FROM informations WHERE id = 1) AS localisation " +
                       "FROM ventes_tempon, commandes C " +
                       "WHERE ventes_tempon.facture = '" + Facture+ "'" +
                                                            " AND C.table_ = '" + table+ "'" +
                                                            " AND C.code_vente = ventes_tempon.code_vente" ;

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql_query);
            jasperDesign.setQuery(newQuery);




            
            Map<String, Object> parameters = new HashMap<>();

            double total_fact = extractAmount(lblTotal.getText());

            System.out.println(total_fact);
            parameters.put("Facture_no", Facture);

            parameters.put("Total", total_fact);
            parameters.put("Table", table);

            if(number_of_receipts > 1){
            int i = 1;
            while( i  <= number_of_receipts){
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connexion);
                JasperPrintManager.printReport(jasperPrint, false);
                i ++ ;
            }
        }
            else{
                 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connexion);
                JasperPrintManager.printReport(jasperPrint, false);
            }
            
           
            print = "NO";
        } catch (JRException e) {
            showAlert(Alert.AlertType.ERROR,"Erreur", "Erreur lors de la génération du rapport." + e);
        } catch (SQLException ex) {

        }
    }else{
        if(type == "type2"){
                String path = getChemin(type) + "/Receipt/SolderEmporter/cmd_emporter_client.jrxml";

                String Facture = labelFacture.getText().trim();
                String table = comboTable.getValue();



                 MySqlConnection mySqlConnection = new MySqlConnection();
                try (Connection connexion = mySqlConnection.getConnection()) {

                    JasperDesign jasperDesign = JRXmlLoader.load(path);

                   String sqlQuery = "SELECT ventes.designation as v_design,"+
                                            "ventes.qte as qte,"+
                                            "ventes.prixUnitaire as prixU,"+
                                            "ventes.total as total,"+
                                            "ventes.montantRemis as montantR,"+
                                            "ventes.monnaie as monnaie,"+
                                            "ventes.facture as facture,"+
                                            "ventes.modeDePaiement as paiement,"+
                                            "ventes.caissier as caissier,"+
                                            "ventes.serveur as serveur,"+
                                            "ventes.date_vente as date_,"+
                                            "ventes.heure as heure,"+
                                            "(SELECT nom FROM informations WHERE id = 1) AS nom,"+
                                            "(SELECT contact FROM informations WHERE id = 1) AS contact,"+
                                            "(SELECT ville_secteur FROM informations WHERE id = 1) AS ville_secteur,"+
                                            "(SELECT localisation FROM informations WHERE id = 1) AS localisation"+
                                            "FROM ventes" +
                                            "WHERE ventes.facture = '" + Facture + "';";

                        // Utilisez la chaîne 'sqlQuery' pour exécuter la requête SQL dans votre programme.


                        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                        JRDesignQuery newQuery = new JRDesignQuery();
                        newQuery.setText(sqlQuery);
                        jasperDesign.setQuery(newQuery);

                        Map<String, Object> parameters = new HashMap<>();

                        double total_fact = extractAmount(lblTotal.getText());


                        parameters.put("Facture_no", Facture);

                        parameters.put("Total", total_fact);
                        parameters.put("Table", table);


                        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connexion);
                        JasperPrintManager.printReport(jasperPrint, false);
        } catch (JRException e) {
            showAlert(Alert.AlertType.ERROR,"Erreur", "Erreur lors de la génération du rapport." + e);
        } catch (SQLException ex) {

        }
        }
        else{
            
        }
    }
    
    
}

public void gen_bill_after_paying(String Facture, String table, Double total_fact){
            String path = getChemin("yype") + "/Receipt/SolderEmporter/cmd_emporter_client.jrxml";

             MySqlConnection mySqlConnection = new MySqlConnection();
            try (Connection connexion = mySqlConnection.getConnection()) {

                JasperDesign jasperDesign = JRXmlLoader.load(path);

               String sqlQuery = "SELECT ventes.designation as v_design,"+
                                            "ventes.qte as qte,"+
                                            "ventes.prixUnitaire as prixU,"+
                                            "ventes.total as total,"+
                                            "ventes.montantRemis as montantR,"+
                                            "ventes.monnaie as monnaie,"+
                                            "ventes.facture as facture,"+
                                            "ventes.modeDePaiement as paiement,"+
                                            "ventes.caissier as caissier,"+
                                            "ventes.serveur as serveur,"+
                                            "ventes.date_vente as date_,"+
                                            "ventes.heure as heure,"+
                                            "(SELECT nom FROM informations WHERE id = 1) AS nom,"+
                                            "(SELECT contact FROM informations WHERE id = 1) AS contact,"+
                                            "(SELECT ville_secteur FROM informations WHERE id = 1) AS ville_secteur,"+
                                            "(SELECT localisation FROM informations WHERE id = 1) AS localisation"+
                                     	  "FROM ventes" +
                                             "WHERE ventes.facture = '" + Facture + "';";

                    // Utilisez la chaîne 'sqlQuery' pour exécuter la requête SQL dans votre programme.


                    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                    JRDesignQuery newQuery = new JRDesignQuery();
                    newQuery.setText(sqlQuery);
                    jasperDesign.setQuery(newQuery);

                    Map<String, Object> parameters = new HashMap<>();

                    parameters.put("Facture_no", Facture);

                    parameters.put("Total", total_fact);
                    parameters.put("Table", table);


                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connexion);
                    JasperPrintManager.printReport(jasperPrint, false);

}       catch (SQLException ex) {
            Logger.getLogger(SellerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(SellerController.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void genCancelledBill(String val,String facture,String table) throws JRException{
    if(val == "YES"){
            String path = getChemin("type2") + "/Receipt/ReglerFacture/cmd_np_client_annuler.jrxml";
         MySqlConnection mySqlConnection = new MySqlConnection();
        try (Connection connexion = mySqlConnection.getConnection()) {

            JasperDesign jasperDesign = JRXmlLoader.load(path);

            String sql_query = "SELECT ventes.designation as v_design, " +
                       "ventes_tempon.qte as qte, " +
                       "ventes_tempon.prixUnitaire as prixU, " +
                       "ventes_tempon.total as total, " +
                       "ventes_tempon.montantRemis as montantR, " +
                       "ventes_tempon.monnaie as monnaie, " +
                       "ventes_tempon.facture as facture, " +
                       "ventes_tempon.modeDePaiement as paiement, " +
                       "ventes_tempon.caissier as caissier, " +
                       "ventes_tempon.serveur as serveur, " +
                       "ventes_tempon.date_vente as date_, " +
                       "ventes_tempon.heure as heure, " +
                       "(SELECT nom FROM informations WHERE id = 1) AS nom, " +
                       "(SELECT contact FROM informations WHERE id = 1) AS contact, " +
                       "(SELECT ville_secteur FROM informations WHERE id = 1) AS ville_secteur, " +
                       "(SELECT localisation FROM informations WHERE id = 1) AS localisation " +
                       "FROM ventes_tempon, commandes C " +
                       "WHERE vt.facture = '" + facture+ "'" +
                                                            "AND C.table_ = '" + table+ "'" +
                                                            "AND C.code_vente = vt.code_vente" ;

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql_query);
            jasperDesign.setQuery(newQuery);




            
            Map<String, Object> parameters = new HashMap<>();

            double total_fact = extractAmount(lblTotal.getText());

            System.out.println(total_fact);
            parameters.put("Facture_no", facture);

            parameters.put("Total", total_fact);
            parameters.put("Table", table);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connexion);
            JasperPrintManager.printReport(jasperPrint, false);
              
    }   catch (SQLException ex) {
            Logger.getLogger(SellerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

public void saveCmd(ActionEvent event){
    
    if (listeVentes.isEmpty() || listeRecus.isEmpty()) {
        showAlert(Alert.AlertType.ERROR, "Erreur", "Impossible d'enregistrer les commandes. Assurez-vous que la liste des ventes et la liste des reçus ne sont pas vides.");
        return;
    }
    enregistrerCommandeAvecConfirmation("Impayé",0.0,"NONE");
    int nb_print = getNumberOfPrint();
    gen_bill_receipt_cmd_np(nb_print,"type1");
    actualiser();
    setComboTable();
    selectFacture();
}

/**************************************************** payer sur le champ (emporter) *******************************************/
@FXML 
public void payerSurLeChamp(ActionEvent event){
    String paiement = comboPaiementChap.getValue();
    double total_fact_ = extractAmount(lblTotal.getText());
        if(paiement != null){
               if(entryMontantRemisChap.getText().trim() != ""){
                    double montantRemis = Double.parseDouble(entryMontantRemisChap.getText().trim());
                    if(listeRecus.isEmpty()){
                        showAlert(Alert.AlertType.ERROR,"Erreur", "Le panier est vide");
                        return;
                    }
                    if(montantRemis < total_fact_){
                         showAlert(Alert.AlertType.ERROR,"Erreur", "Le montant remis doit être sup ou égal au total");
                        return;
                    }
                   
                    enregistrerCommandeAvecConfirmation("Payé",montantRemis,paiement);
                    gen_bill_receipt_cmd_np(0,"type2");
                    actualiser();
               }else{
                    showAlert(Alert.AlertType.ERROR,"Erreur", "Notez le montant remis par le client");
               }
            }else{
                showAlert(Alert.AlertType.ERROR,"Erreur", "Sélectionnez le mode de paiement");
            }
        setComboTable();
        }
    
/******************************* payer après avoir consommé **********************************************************/


public void updateCmd(){
    MySqlConnection mySqlConnection = new MySqlConnection();
     Commande commande = tableCmd.getSelectionModel().getSelectedItem();
     int id_cmd = commande.getId();
     
     String facture = commande.getFacture();
     String table = commande.getTable();
     String codeV = commande.getCode_vente();
     double total = commande.getTotal_(codeV,facture);
     commande.updateCmdStatut(table, facture, "Payé",codeV);
     System.out.println("Updated");
     double montantRemis = Double.parseDouble(entryMontantAfter.getText().trim());
     String paiement = comboModePaiementAfter.getValue().trim();
     
     
    try (Connection conn = mySqlConnection.getConnection()) {
       
            String selectVentesTemponSql = "SELECT * FROM ventes_tempon WHERE code_vente = ?";
            
            try (PreparedStatement selectStatement = conn.prepareStatement(selectVentesTemponSql)) {
                selectStatement.setString(1, commande.getCode_vente());

                try (ResultSet resultSet = selectStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Ventes vente = new Ventes();
                        vente.setType(resultSet.getString("type"));
                        vente.setMenu(resultSet.getString("menu"));
                        vente.setDesignation(resultSet.getString("designation"));
                        vente.setQte(resultSet.getInt("qte"));
                        System.out.println(resultSet.getDouble("prixUnitaire"));
                        vente.setPrixUnitaire(resultSet.getDouble("prixUnitaire"));
                        vente.setTotal(resultSet.getDouble("total"));
                        vente.setFacture(resultSet.getString("Facture"));
                        vente.setMontantRemis(montantRemis);
                        vente.setMonnaie(montantRemis-total);
                        vente.setModeDePaiement(paiement);
                        vente.setCaissier(resultSet.getString("caissier"));
                        vente.setServeur(resultSet.getString("serveur"));
                        vente.setDate_vente(resultSet.getDate("date_vente"));
                        vente.setHeure(resultSet.getString("heure"));
                        vente.insererVentes();
                        facture_apres_avoir_manger = resultSet.getString("Facture");
                        table_apres_avoir_manger = table;
                    }
                    
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
}

@FXML
public void reglerFacture(ActionEvent event){
    if(comboModePaiementAfter.getValue() != null & entryTotal.getText() !="" & entryMontantAfter.getText() !=""){
        double total = Double.parseDouble(entryTotal.getText());
        double montantRemis =  Double.parseDouble(entryMontantAfter.getText());
        if(montantRemis >= total){
            Commande c = new Commande();
            String statut = c.returnStatut(entryFacture.getText());
            if(statut == "Payé"){
                    showAlert(Alert.AlertType.ERROR, "ERREUR", "Impossible de regler une commande déja reglée");
                    return;
            }
            else{
                Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
                confirmationAlert.setTitle("Confirmation");
                confirmationAlert.setHeaderText("Regler la facture");
                confirmationAlert.setContentText("Êtes-vous sûr de vouloir regler cette facture ?");    
                Optional<ButtonType> result = confirmationAlert.showAndWait();
             if (result.isPresent() && result.get() == ButtonType.OK) {
                 updateCmd();
                 System.out.println(facture_apres_avoir_manger);
                 gen_bill_after_paying(facture_apres_avoir_manger,table_apres_avoir_manger,total);
                 entryTotal.setText(Double.toString(montantRemis-total));
                 
                 reload();
                tableCmd.refresh();
                comboModePaiementAfter.setValue(null);
                entryMontantAfter.setText("");
                entryFacture.setText("");
                entryTable.setText("");
                entryMontantAfter.setText("");
                comboModePaiementAfter.setValue(null);
                entryTotal.setText("");
               reload();
                tableCmd.refresh();
                facture_apres_avoir_manger = "";
                table_apres_avoir_manger = "";
                filterTableByStatus("Impayé");
               comboFIlterCommandesTable.setValue("Commandes Impayées");
             }
             else{
                 return;
             }
            
            }
              
            
        }
        else{
            showAlert(Alert.AlertType.ERROR, "Erreur", "Impossible de regler la facture. Assurez-vous que le montant remis est supérieure au total.");
            return;
        }
    }else{
        showAlert(Alert.AlertType.ERROR, "Erreur", "Impossible de regler la facture. Assurez-vous d'avoir sélectionné le mode de paiement, d'avoir entré le montant remis et que la zone du total dû n'est pas vide.");
        return;
    }
    setComboTable();
}

/**************************************************************************************************************************************/

// actualiser
 
public void actualiser() {
    comboPaiementChap.setValue(null);
    comboType.setValue(null);
    comboMenu.setValue(null);
    comboPlat.setValue(null);
    entryQte.setText("1");
    comboTable.setValue(null);
    comboServeur.setValue(null);
    String fact = genererNumero();
    labelFacture.setText(fact);
    // Vider les listes et la table
    listeRecus.clear();
    entryMontantRemisChap.clear();
    print = "NO";
    listeVentes.clear();
    tableRecu.getItems().clear();
    total_fact_today = 0.0;
    String textTotal = "Total : " + total_fact_today+" fcfa";
    lblTotal.setText(textTotal);
    facture_apres_avoir_manger = "";

   table_apres_avoir_manger = "";
    comboPaiementChap.setValue(null);
    imageView.setImage(null); // This will remove the image from the ImageView
    labelPrix.setText(Double.toString(0.0));
    lblQteU.setText(Integer.toString(0));
    labelNomPlat.setText("Nom du plat");
    reload();
    tableCmd.setItems(listeCommandes);
    comboFIlterCommandesTable.setValue("Commandes Impayées"); 
    filterTableByStatus("Impayé");
    entryTotal.setText("");
    labelMonnaieSurLeChamp.setText("");
}

@FXML
public void actualise(ActionEvent event){
    actualiser();
    setComboTable();
}

// annuler le pannier : avant avoir enregistré la commande
@FXML
public void annulerPanier(ActionEvent event) {
        if(listeRecus.isEmpty()){
            showAlert(Alert.AlertType.ERROR, "Erreur", "Impossible d'annuler le pannier car il est vide");
            return;
        }
        Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText("Êtes-vous sûr de vouloir annuler le panier ?");
        confirmationAlert.setContentText("Cliquez sur OK pour confirmer.");

        confirmationAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                 reload();
                 tableCmd.setItems(listeCommandes);
                 listeRecus.clear();
                 tableRecu.refresh();
                 total_fact_today = 0.0;
                String textTotal = "Total : " + total_fact_today+" fcfa";
                lblTotal.setText(textTotal);
                 facture_apres_avoir_manger = "";

                 table_apres_avoir_manger = "";
                afficherMessage("Panier annulé !");
            }
        });
    }

// pour afficher les alertes à l'écran

    public void afficherMessage(String message) {
        Alert infoAlert = new Alert(AlertType.INFORMATION);
        infoAlert.setTitle("Information");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(message);

        infoAlert.showAndWait();
    }

// v&rifie si le produit à ajouter existe déja dans la table reçu ( dans le panier de la commande du client)
    
private void verifierProduitsGroupes() {
    Map<String, Recu> produitsGroupesRecus = new HashMap<>();
    Map<String, Ventes> produitsGroupesVentes = new HashMap<>();

    // Parcourir la liste de reçus et regrouper les produits ayant la même désignation et menu
    for (Recu recu : listeRecus) {
        String key = recu.getDesignation() + "_" + recu.getMenu();

        if (produitsGroupesRecus.containsKey(key)) {
            System.out.println(key);
            Recu produitGroupe = produitsGroupesRecus.get(key);
            produitGroupe.setQte(produitGroupe.getQte() + recu.getQte());
            produitGroupe.setTotal(produitGroupe.getPrixU() * produitGroupe.getQte());
        } else {
            produitsGroupesRecus.put(key, recu);
        }
    }
    
     // Vider la liste de reçus actuelle
    listeRecus.clear();

    // Ajouter les produits groupés à la liste de reçus
    listeRecus.addAll(produitsGroupesRecus.values());
    
     for (Ventes vente : listeVentes) {
        String key = vente.getDesignation() + "_" + vente.getMenu();

        if (produitsGroupesVentes.containsKey(key)) {
            Ventes produitGroupe = produitsGroupesVentes.get(key);
            produitGroupe.setQte(produitGroupe.getQte() + vente.getQte());
            produitGroupe.setTotal(produitGroupe.getPrixUnitaire()* produitGroupe.getQte());
        } else {
            produitsGroupesVentes.put(key, vente);
        }
    }

    listeVentes.clear();
    listeVentes.addAll(produitsGroupesVentes.values());
    
    // ... Continuer la logique pour les ventes de la même manière
    
    // Mettre à jour les quantités et les totaux des ventes groupées dans la liste de ventes actuelle
    for (Ventes vente : produitsGroupesVentes.values()) {
        for (Ventes venteOriginale : listeVentes) {
               if (vente.getMenu().equals(venteOriginale.getMenu()) && vente.getDesignation().equals(venteOriginale.getDesignation())) {
                venteOriginale.setQte(vente.getQte());
                venteOriginale.setTotal(vente.getTotal());
                break;
            }
        }
    }
    
    

    // Rafraîchir la table
    tableRecu.refresh();
}


/*************************************************************************************************************/
// remplir les différents combobox 

public void remplirCombo(){
    ObservableList<String> typesMenu = FXCollections.observableArrayList();

        MySqlConnection mySqlConnection = new MySqlConnection();
        try (Connection connexion = mySqlConnection.getConnection()) {
            String requete = "SELECT DISTINCT type FROM type_menu";
            try (PreparedStatement statement = connexion.prepareStatement(requete);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String type = resultSet.getString("type");
                    typesMenu.add(type);
                }
            }
        } catch (SQLException e) {
        }
        comboType.setItems(typesMenu);
        
        comboType.setOnAction((ActionEvent event) -> {
            String typeSelectionne = comboType.getValue();
            fillComboMenu(typeSelectionne);
    });
        
        // pour les table 
        
       
}

// mettre à jour le combo menu quand le type est sélectionné

private void fillComboMenu(String typeSelectionne) {
       ObservableList<String> menus = FXCollections.observableArrayList();

       MySqlConnection mySqlConnection = new MySqlConnection();
       try (Connection connexion = mySqlConnection.getConnection()) {
           String requete = "SELECT menu FROM type_menu WHERE type = ?";
           try (PreparedStatement statement = connexion.prepareStatement(requete)) {
               statement.setString(1, typeSelectionne);
               try (ResultSet resultSet = statement.executeQuery()) {
                   while (resultSet.next()) {
                       String menu = resultSet.getString("menu");
                       menus.add(menu);
                   }
               }
           }
       } catch (SQLException e) {
       }

       comboMenu.setItems(menus);

       comboMenu.setOnAction((ActionEvent event) -> {
           String typeSelectionne1 = comboType.getValue();
           String menuSelectionne = comboMenu.getValue();
           fillComboDesignation(typeSelectionne1, menuSelectionne);
       });



   }

// mettre à jour la désignation quand le type et le menu sont sélectionnés

private void fillComboDesignation(String typeSelectionne, String menuSelectionnee) {
       ObservableList<String> designations = FXCollections.observableArrayList();

       MySqlConnection mySqlConnection = new MySqlConnection();
       try (Connection connexion = mySqlConnection.getConnection()) {
           String requete = "SELECT DISTINCT designation FROM stock WHERE type = ? AND menu = ?";
           try (PreparedStatement statement = connexion.prepareStatement(requete)) {
               statement.setString(1, typeSelectionne);
                statement.setString(2, menuSelectionnee);
               try (ResultSet resultSet = statement.executeQuery()) {
                   while (resultSet.next()) {
                       String designation = resultSet.getString("designation");
                       designations.add(designation);
                   }
               }
           }
       } catch (SQLException e) {
       }

       comboPlat.setItems(designations);
       comboPlat.setOnAction((ActionEvent event) -> {
           String typeSelectionne1 = comboType.getValue();
           String menuSelectionne = comboMenu.getValue();
           String platSelectionnee = comboPlat.getValue();
           labelNomPlat.setText(platSelectionnee);
           
           try {
               setQte_Price_ImageView(typeSelectionne1, menuSelectionne,platSelectionnee);
           } catch (SQLException ex) {
               Logger.getLogger(SellerController.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
   }

// recuperer le prix et la quantité disponible

private int getQuantiteDisponible(String Menu, String Designation) throws SQLException {
    String query = "SELECT qte FROM stock WHERE menu = ? AND designation = ?";

    MySqlConnection sqlConn = new MySqlConnection();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
        connection = sqlConn.getConnection();
        statement = connection.prepareStatement(query);
        statement.setString(1, Menu);
        statement.setString(2, Designation);
        resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("qte");
        } else {
            return 0; // Le produit n'a pas été trouvé dans la table produit
        }
    } finally {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}

// mettre l'image du plat quand le type, le menu et la désignation sont sélectionnés

private void setQte_Price_ImageView(String Type, String Menu, String Designation) throws SQLException{

    String query = "SELECT image_path, qte, prix FROM stock WHERE type = ? AND menu = ? AND designation = ?";

    MySqlConnection sqlConn = new MySqlConnection();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
        connection = sqlConn.getConnection();
        statement = connection.prepareStatement(query);
        statement.setString(1, Type);
        statement.setString(2, Menu);
        statement.setString(3, Designation);
        resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String file_path =  resultSet.getString("image_path");
             Image image = new Image("file:" + file_path, 188, 177, false, true);
             imageView.setImage(image);
             int qte = resultSet.getInt("qte");
             double prix = resultSet.getDouble("prix");
             labelPrix.setText(Double.toString(prix));
             lblQteU.setText(Integer.toString(qte));
        } 
    } finally {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}

// verifier si la quantité demandée est disponible 

public boolean verifierQuantiteDisponible() throws SQLException {
    String type = comboType.getValue();
    String menu = comboMenu.getValue();
    String designation = comboPlat.getValue();
    int quantiteDisponible = getQuantiteDisponible(menu,designation);
    int quantiteRecu = Integer.parseInt(entryQte.getText().trim());

    // Parcourir la liste de recus pour trouver le menu correspondant et la désignation correspondante : si le plat démandé existe déjà dans le reçu

    for (Recu recu : listeRecus) {
        if (recu.getMenu().equals(menu) && recu.getDesignation().equals(designation)) {
            int qteRec = recu.getQte();
            int nouvelleQuantite = quantiteRecu + qteRec;
            if (nouvelleQuantite <= quantiteDisponible) {
                return true;
            } else {
                showAlert(Alert.AlertType.WARNING, "Quantité indisponible", "La quantité disponible est insuffisante.\nQuantité disponible: " + quantiteDisponible + "\nQuantité demandée: " + nouvelleQuantite);
                return false;
            }
        }
    }

    // si le plat demandée n'est pas déjà dans le reçu, on verifie simplement la quantité

    if (quantiteRecu <= quantiteDisponible) {
        return true;
    } else {
        showAlert(Alert.AlertType.WARNING, "Quantité indisponible", "La quantité disponible est insuffisante.\nQuantité disponible: " + quantiteDisponible + "\nQuantité demandée: " + quantiteRecu);
        return false;
    }
}

// extraire le montant d'une chaine de caracrtère 

public static double extractAmount(String input) {
    String pattern = "\\d+(\\.\\d+)?"; // Recherche d'une séquence de chiffres avec optionnellement une partie décimale

    Pattern regexPattern = Pattern.compile(pattern);
    Matcher matcher = regexPattern.matcher(input);

    if (matcher.find()) {
        String amountString = matcher.group(); // Chaîne de caractères représentant le montant
        return Double.parseDouble(amountString); // Conversion en double et renvoi
    } else {
        throw new IllegalArgumentException("Aucun montant trouvé dans la chaîne.");
    }
}

// autocomplete pour la recherche des facture 

private void selectFacture() {
    String query = "SELECT DISTINCT Facture FROM commandes WHERE statut='Impayé'";
    MySqlConnection mySqlConnection = new MySqlConnection();
    try (Connection connection = mySqlConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {

        try (ResultSet resultSet = statement.executeQuery()) {
            List<String> codeP = new ArrayList<>();
            while (resultSet.next()) {
                String Facture = resultSet.getString("Facture");
                codeP.add(Facture);
            }

            TextFields.bindAutoCompletion(entryFacture, codeP);
            entryFacture.textProperty().addListener((observable, oldValue, newValue) -> {
                String Facture_ = newValue.trim();
                if (!Facture_.isEmpty()) {
                    try {
                        selectProduitTableFromCMD(Facture_);
                       
                    } catch (Exception ex) {
                        Logger.getLogger(SellerController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    entryFacture.setText("");
                }
            });
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void selectProduitTableFromCMD(String fact){
     String query = "SELECT  table_ FROM commandes WHERE Facture = '" + fact + "'";
    MySqlConnection mySqlConnection = new MySqlConnection();
    try (Connection connection = mySqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
        try (ResultSet resultSet = statement.executeQuery()) {
            List<String> codeP = new ArrayList<>();
            if (resultSet.next()) {
                String table = resultSet.getString("table_");
                entryTable.setText(table);
            }

    }   
        } catch (SQLException ex) {
            Logger.getLogger(SellerController.class.getName()).log(Level.SEVERE, null, ex);
        }
}

/*****************************************************************************************************************/

 // RAPPORTS DE VENTES 
    
@FXML
private void handleCheckBoxSelection(ActionEvent event) {
    if (checkBoxActiveSelection.isSelected()) {
        entryDate1Rapport.setDisable(true);
        btnGenererDate.setDisable(true);

        entryDate2Rapport.setDisable(false);
        entryDate3Rapport.setDisable(false);
        btnGenererPlage.setDisable(false);

        entryDate1Rapport.setValue(null);
        entryDate2Rapport.setValue(null);
        entryDate3Rapport.setValue(null);
    } else {
        entryDate1Rapport.setDisable(false); 
        btnGenererDate.setDisable(false);

        entryDate2Rapport.setDisable(true);
        entryDate3Rapport.setDisable(true);
        btnGenererPlage.setDisable(true);

        entryDate1Rapport.setValue(null);
        entryDate2Rapport.setValue(null);
        entryDate3Rapport.setValue(null);
    }
    setComboTable();
}

 @FXML
private void actualiserRapport(ActionEvent event) {
    // Mettre tous les DatePicker à null
    entryDate1Rapport.setValue(null);
    entryDate2Rapport.setValue(null);
    entryDate3Rapport.setValue(null);

    // Décocher le checkBox
    checkBoxActiveSelection.setSelected(false);

    // Désactiver btnGenererPlage, entryDate3Rapport et entryDate2Rapport
    btnGenererPlage.setDisable(true);
    entryDate3Rapport.setDisable(true);
    entryDate2Rapport.setDisable(true);

    // Activer entryDate1Rapport et btnGenererDate
    entryDate1Rapport.setDisable(false);
    btnGenererDate.setDisable(false);
    setComboTable();
}

// generer le rapport d'état pour une date

@FXML
public void genReportDate1(ActionEvent event) throws JRException{
    LocalDate date1 = entryDate1Rapport.getValue() ;
    if(date1 ==null){
         showAlert(Alert.AlertType.WARNING,  "Aucune date sélectionnée.", "Veuillez sélectionner la date afin de générer le rapport d'état.");
            
        return;
    }
     MySqlConnection mySqlConnection = new MySqlConnection();
        try (Connection connexion = mySqlConnection.getConnection()) {
            
            
            String path = getChemin("type4") + "\\rapports\\report3_.jrxml";
            String np = nomP + " "+ prenomP;
            JasperDesign jasperDesign = JRXmlLoader.load(path);

           String sql_query = "SELECT caissier, type, menu, designation, COUNT(*) as nombre_prod, SUM(qte) AS total_qte, SUM(total) AS total_vente," +
                   " (SELECT nom FROM informations WHERE id = 1) AS nom" +
                   " FROM ventes" +
                   " WHERE date_vente = '" + date1 + "'" +
                   " 'AND caissier = '" + np + "'" +
                   " GROUP BY type, menu, designation" +
                   " ORDER BY total_vente DESC";


            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql_query);
            jasperDesign.setQuery(newQuery);

            Map<String, Object> parameters = new HashMap<>();

            parameters.put("date1", entryDate1Rapport.getValue());
            parameters.put("PersonneCo", nomP+ " " + prenomP);
           parameters.put("Image",getChemin("type4")+"\\rapports\\cherry.jpg" );
           parameters.put("chemin",getChemin("type4")+"\\rapports\\" );
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connexion);
            JasperPrintManager.printReport(jasperPrint, true);
               
}       catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
}

// générer le rapport d'état pour deux dates

@FXML
public void genReportDate2(ActionEvent event) throws JRException{
    LocalDate date1 = entryDate2Rapport.getValue() ;
    LocalDate date2 = entryDate3Rapport.getValue() ;
    if(date1 ==null || date2==null){
         showAlert(Alert.AlertType.WARNING, "Au moins une date non sélectionnée.", "Veuillez sélectionner les dates afin de générer le rapport d'état.");
            
        return;
    }
     MySqlConnection mySqlConnection = new MySqlConnection();
        try (Connection connexion = mySqlConnection.getConnection()) {
            
            
            String path = getChemin("type4") + "\\rapports\\report3.jrxml";
            System.out.println(path);
            JasperDesign jasperDesign = JRXmlLoader.load(path);
            String np = nomP + " "+ prenomP;

             String sql_query = "SELECT caissier, type, menu, designation, COUNT(*) as nombre_prod, SUM(qte) AS total_qte, SUM(total) AS total_vente," +
                   " (SELECT nom FROM informations WHERE id = 1) AS nom" +
                   " FROM ventes" +
                   " WHERE date_vente BETWEEN '" + date2 + "' AND '" + date1 + "'" +
                   " 'AND caissier = '" + np + "'" +
                   " GROUP BY type, menu, designation" +
                   " ORDER BY total_vente DESC";

             
                   

            System.out.println(sql_query);

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql_query);
            jasperDesign.setQuery(newQuery);

            Map<String, Object> parameters = new HashMap<>();

            
            parameters.put("date1", date2);
            parameters.put("date2", date1);
            parameters.put("PersonneCo", nomP + " "+ prenomP);
            parameters.put("Image",getChemin("type4")+"\\rapports\\cherry.jpg" );
            /*getChemin("type4")+"\\rapports\\"*/ 
            parameters.put("chemin","");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connexion);
            JasperPrintManager.printReport(jasperPrint, true);
               
}       catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
  
public void setComboTable(){
     comboTable.getItems().add("Emporté");

    table_restau tr = new table_restau();
    ObservableList<table_restau> tableData = tr.getAllTables();

    // Créez une liste de chaînes à partir des données de la liste de tables
    ObservableList<String> tableNames = FXCollections.observableArrayList();
    for (table_restau table : tableData) {
        tableNames.add(table.getNoTable());
    }

    // Ajoutez les noms de table au ComboBox
    comboTable.getItems().addAll(tableNames);
}


/********************************************************************************************/
// mettre à jour l'horloge

private void startClock() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> updateClock()), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

private void updateClock() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String currentTime = sdf.format(new Date());
        labelHeure.setText(currentTime);
    }

/**************** INITIALISATION DES PAIEMENT ****************************************/

public void initPaiementMethode(){
    Paiement paiement = new Paiement();
    // Remplir comboModePaiementBefore
    comboPaiementChap.getItems().addAll(paiement.getAllPaymentMode());

    // Remplir comboModePaiementAfter
    comboModePaiementAfter.getItems().addAll(paiement.getAllPaymentMode());
}

 /******************************************************************************************/
    

@FXML
public void retour(ActionEvent event) throws IOException {
    Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
    confirmationAlert.setTitle("Confirmation de déconnexion");
    confirmationAlert.setHeaderText(null);
    confirmationAlert.setContentText("Êtes-vous sûr de vouloir vous déconnecter ?");

    Optional<ButtonType> result = confirmationAlert.showAndWait();

    if (result.isPresent() && result.get() == ButtonType.OK) {
        Node source = (Node) event.getSource();
        Stage currentStage = (Stage) source.getScene().getWindow();

        // Masquer (fermer) la fenêtre actuelle
        currentStage.hide();

        // Load the Connexion_1.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));

        // Create a new stage
        Stage stage = new Stage();
        stage.setTitle("INTERFACE ADMINISTRATEUR");
        stage.setMaximized(true);

        // Set the scene with the loaded FXML file
        stage.setScene(new Scene(root));

        // Show the stage
        stage.show();
    }
}

    
  /******************************************************************************************/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        startClock();
        remplirCombo();
        initialize_tableRecu();
        initialize_tableCmd();
        remplirComboServeursCaissiers();
        entryQte.setText("1");
        recupererInformationsFichierTexte();
        String fact = genererNumero();
        comboPaiementChap.getItems().addAll("Orange Money", "Moov Money", "Carte de credit", "Cash");
        initPaiementMethode();
        lblConnecte.setText("Connecté : " + nomP + " " + prenomP);
        labelFacture.setText(fact);
        selectFacture();
        setComboTable();
        initialise_table_serveur();
    }    
    
}
