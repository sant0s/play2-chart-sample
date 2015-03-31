import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;

import org.junit.Test;

import play.twirl.api.Content;

public class ApplicationTest {

    @Test
    public void renderTemplate() {
	Content html = views.html.index.render(null, null, null, null, null, null, null, null);
	assertThat(contentType(html)).isEqualTo("text/html");
	assertThat(contentAsString(html)).contains("Chart module application");
    }

}
