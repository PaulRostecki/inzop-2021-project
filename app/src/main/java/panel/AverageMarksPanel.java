package panel;

import cache.CacheProvider;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import model.model.Mark;
import model.model.Student;
import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Panel for average marks chart.
 *
 * @author created: Michał Musiałowicz on 09.01.2022
 * @author last changed:
 */
public class AverageMarksPanel implements PanelIf
{
    @FXML
    private HBox centerPane;

    private Student student;

    private static final CacheProvider cacheProvider = CacheProvider.getCacheProvider();

    private static final DecimalFormat decimalFormat = new DecimalFormat( "0.00" );

    private static final double MAX_BAR_WIDTH = 160D;

    private static final double MIN_CATEGORY_GAP = 30D;

    public AverageMarksPanel()
    {

    }

    public void initialize()
    {
        Platform.runLater( this::initializeStudent );
        Platform.runLater( this::createChart );
    }

    private void initializeStudent()
    {
        student = (Student) getCurrentStage( centerPane ).getUserData();
    }

    private void createChart()
    {
        Float average = getAverageMarks();
        if( average == 0 )
        {
            centerPane.getChildren().removeAll();
            centerPane.getChildren().add( new Label( "Student " + student.getFullName() + " nie posiada żadnych ocen." ) );
            return;
        }
        Tooltip.install( centerPane, new Tooltip( String.valueOf( average ) ) );

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel( StringUtils.EMPTY );
        NumberAxis yAxis = new NumberAxis( 2.0, 5.0, 0.25 ); // min range, max range, spacing.
        yAxis.setLabel( StringUtils.EMPTY );

        XYChart.Series< String, Number > dataSeries = new XYChart.Series<>();
        dataSeries.getData().add( new XYChart.Data<>( StringUtils.EMPTY, average ) );
        dataSeries.setName( "Średnia ocen: " + student.getFullName() );

        BarChart< String, Number > barChart = new BarChart<>( xAxis, yAxis );
        barChart.getData().add( dataSeries );

        // setting max column width.
        setColumnWidth( xAxis, barChart );
        barChart.widthProperty().addListener( ( obs, a1, a2 ) -> Platform.runLater( () -> setColumnWidth( xAxis, barChart ) ) );

        centerPane.getChildren().removeAll();
        centerPane.getChildren().add( barChart );
    }

    private Float getAverageMarks()
    {
        List< Mark > marks = cacheProvider.getMarks().stream()
                .filter( mark -> mark.getMarkId().getStudentId() == Integer.parseInt( student.getIndexNumber() ) )
                .collect( Collectors.toList() );
        if( marks.isEmpty() )
        {
            return 0.00f;
        }

        float marksSum = (float) marks.stream().mapToDouble( Mark::getMarkValue ).sum();
        return Float.valueOf( decimalFormat.format( marksSum / marks.size() ).replace( ",", "." ) );
    }


    // modified algorithm from https://stackoverflow.com/questions/28047818/limit-width-size-of-bar-chart.
    private void setColumnWidth( CategoryAxis xAxis, BarChart barChart )
    {
        double barWidth;
        do
        {
            double space = xAxis.getCategorySpacing();
            double availableBarSpace = space - ( barChart.getCategoryGap() + barChart.getBarGap() );
            barWidth = ( availableBarSpace / barChart.getData().size() ) - barChart.getBarGap();
            if ( barWidth > MAX_BAR_WIDTH )
            {
                availableBarSpace = ( MAX_BAR_WIDTH + barChart.getBarGap() ) * barChart.getData().size();
                barChart.setCategoryGap( space - availableBarSpace - barChart.getBarGap() );
            }
        } while( barWidth > MAX_BAR_WIDTH );

        do
        {
            double space = xAxis.getCategorySpacing();
            double availableBarSpace = space - ( MIN_CATEGORY_GAP + barChart.getBarGap() );
            barWidth = Math.min( MAX_BAR_WIDTH, ( availableBarSpace / barChart.getData().size() ) - barChart.getBarGap() );
            availableBarSpace = ( barWidth + barChart.getBarGap())* barChart.getData().size();
            barChart.setCategoryGap( space - availableBarSpace - barChart.getBarGap() );
        } while( barWidth < MAX_BAR_WIDTH && barChart.getCategoryGap() > MIN_CATEGORY_GAP );
    }
}
