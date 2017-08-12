package Tests.AcceptanceTests;

import Models.PageSteps.SearchItemSteps;
import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.io.LoadFromURL;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;


@RunWith(JUnitReportingRunner.class)
public class CheckSearchFormOnHomePage extends JUnitStory {

    @Override
    public Configuration configuration(){
        URL storyURL=null;
        try {
            storyURL=new URL("file://" + System.getProperty("user.dir") + "/src/main/resources/stories/home_page/");
            System.out.println(storyURL.toString());
        }
        catch (  MalformedURLException e) {
            e.printStackTrace();
        }

        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromRelativeFile(storyURL))
                .useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.HTML));

        /*return new MostUsefulConfiguration()
                // where to find the stories
                .useStoryLoader(new LoadFromRelativeFile(storyURL))
                // CONSOLE and TXT reporting
                .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE, Format.TXT));*/
    }

    // Here we specify the steps classes
    @Override
    public InjectableStepsFactory stepsFactory() {
        // varargs, can have more that one steps classes
        return new InstanceStepsFactory(configuration(), new SearchItemSteps());
    }

}
