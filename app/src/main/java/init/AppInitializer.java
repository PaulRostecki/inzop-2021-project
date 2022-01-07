package init;

import cache.CacheProvider;
import cache.DataService;
import factory.PanelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import panel.PanelIf;

/**
 * Application initializer.
 *
 * @author created: Michał Musiałowicz on 06.12.2021
 * @author last changed:
 */
public class AppInitializer extends Application implements PanelIf
{
    private final Logger LOGGER = LogManager.getLogger( AppInitializer.class );

    private final DataService dataService = DataService.getDataService();

    private static final CacheProvider cacheProvider = CacheProvider.getCacheProvider();

    public static void main ( String[] args )
    {
        System.out.println("xxx");
        launch( args );
    }

    @Override
    public void start( Stage initStage )
    {
        LOGGER.info( "Starting application..." );

        integrateAppWithPostgreSQLDatabase();
        Stage loginPanel = createLoginPanel( initStage );
        loginPanel.show();
    }

    private Stage createLoginPanel( Stage loginPanel )
    {
        return PanelFactory.createLoginPanel( loginPanel );
    }

    private void integrateAppWithPostgreSQLDatabase()
    {
        dataService.fetchDataFromDatabase();
    }
}
