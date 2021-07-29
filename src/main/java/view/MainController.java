package view;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.ChoiceBox;
import model.*;
import view.converters.AccordStringConverter;
import view.converters.IntervalStringConverter;
import view.converters.ModeStringConverter;
import view.converters.NoteStringConverter;
import view.wrappers.GammaDescriptionGroupWrapper;
import view.wrappers.GuitarNeckGroupWrapper;

import java.util.*;

public class MainController {
    @FXML
    private Group guitarGroup;

    @FXML
    private ChoiceBox<Note> choiceBoxFundamental;

    @FXML
    private ChoiceBox<Interval> choiceBoxInterval;

    @FXML
    private ChoiceBox<Mode> choiceBoxMode;


    @FXML
    private ChoiceBox<AccordType> choiceBoxAccord;

    @FXML
    private Group groupGammaDescription;


    private GuitarNeckGroupWrapper guitarNeckGroupWrapper;
    private GammaDescriptionGroupWrapper gammaDescriptionGroupWrapper;


    private Note selectedFundamental;
    private Interval selectedInterval;
    private Mode selectedMode;
    private Optional<AccordType> selectedAccordType;


    @FXML
    public void initialize() {
        // initialize fundamental choice box
        choiceBoxFundamental.getItems().addAll(Note.values());
        choiceBoxFundamental.getSelectionModel().selectFirst();
        choiceBoxFundamental.setConverter(new NoteStringConverter());
        choiceBoxFundamental.getSelectionModel().selectedIndexProperty().addListener((observableValue, number, t1) -> {
            int selectedItemIndex = t1.intValue();
            if ( 0 <= selectedItemIndex ) {
                this.selectedFundamental = choiceBoxFundamental.getItems().get(selectedItemIndex);
                drawGammaFromSelectedInputs();
            }
        });

        // initialize interval choice box
        choiceBoxInterval.getItems().addAll(Interval.values());
        choiceBoxInterval.getSelectionModel().selectFirst();
        choiceBoxInterval.setConverter(new IntervalStringConverter());
        choiceBoxInterval.getSelectionModel().selectedIndexProperty().addListener((observableValue, number, t1) -> {
            int selectedItemIndex = t1.intValue();
            if ( 0 <= selectedItemIndex ) {
                this.selectedInterval = choiceBoxInterval.getItems().get(selectedItemIndex);
                drawGammaFromSelectedInputs();
            }
        });

        // initialize mode choice box
        choiceBoxMode.getItems().addAll(Mode.values());
        choiceBoxMode.getSelectionModel().selectFirst();
        choiceBoxMode.setConverter(new ModeStringConverter());
        choiceBoxMode.getSelectionModel().selectedIndexProperty().addListener((observableValue, number, t1) -> {
            int selectedItemIndex = t1.intValue();
            if ( 0 <= selectedItemIndex ) {
                this.selectedMode = choiceBoxMode.getItems().get(selectedItemIndex);
                drawGammaFromSelectedInputs();
            }
        });

        // initialize mode choice box
        List<AccordType> accordTypes = new ArrayList<>();
        accordTypes.add(null);
        accordTypes.addAll(Arrays.asList(AccordType.values()));
        choiceBoxAccord.getItems().addAll(accordTypes);
        choiceBoxAccord.getSelectionModel().selectFirst();
        choiceBoxAccord.setConverter(new AccordStringConverter());
        choiceBoxAccord.getSelectionModel().selectedIndexProperty().addListener((observableValue, number, t1) -> {
            int selectedItemIndex = t1.intValue();
            List<AccordType> accordTypeList = choiceBoxAccord.getItems();
            if ( 0 <= selectedItemIndex && selectedItemIndex < accordTypeList.size() ) {
                AccordType accordType = choiceBoxAccord.getItems().get(selectedItemIndex);
                if (Objects.isNull(accordType)) {
                    this.selectedAccordType = Optional.empty();
                } else {
                    this.selectedAccordType = Optional.of(accordType);
                }
            }
            drawGammaFromSelectedInputs();
        });

        // initialize internal parameters
        this.selectedFundamental = this.choiceBoxFundamental.getSelectionModel().getSelectedItem();
        this.selectedInterval = this.choiceBoxInterval.getSelectionModel().getSelectedItem();
        this.selectedMode = this.choiceBoxMode.getSelectionModel().getSelectedItem();
        this.selectedAccordType = Optional.empty();

        // creates and initialize guitar draw wrapper
        this.guitarNeckGroupWrapper = new GuitarNeckGroupWrapper( guitarGroup, GTHFacade.standardGuitarTuning());
        this.gammaDescriptionGroupWrapper = new GammaDescriptionGroupWrapper( groupGammaDescription );
        drawGammaFromSelectedInputs();
    }

    private void drawGammaFromSelectedInputs() {
        // update drawing
        Gamma gamma = new Gamma(this.selectedFundamental, this.selectedInterval, this.selectedMode);
        if ( this.selectedAccordType.isPresent() ) {
            AccordFactory accordFactory = new AccordFactory(gamma);
            Accord accord = accordFactory.getFromAccordType(selectedAccordType.get());
            this.gammaDescriptionGroupWrapper.drawNotesPlacementInGamma(gamma, Optional.of(accord));
            this.guitarNeckGroupWrapper.drawAccord(accord);
        } else {
            this.gammaDescriptionGroupWrapper.drawNotesPlacementInGamma(gamma, Optional.empty());
            this.guitarNeckGroupWrapper.drawGamma(gamma);
        }
    }
}
