package unit.com.example.parser;

import com.example.parser.ListOperation;
import com.example.parser.MyYamlParser;
import com.example.parser.ParserModel;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by p711679 on 13/10/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class MyYamlParserTest {

    private MyYamlParser testIntance = new MyYamlParser();


    @Test
    public void testListParse() throws Exception {

        String yaml =
                "models:\n" +
                "- {name: arul " +
                        ",age : 35}\n" +
                "- {name: joel "+
                    ",age : 35}" ;

       ListOperation  output=  testIntance.getListObject(yaml);
        org.junit.Assert.assertNotNull(output);
        Assert.assertThat(output.getModels().size(), Matchers.is(2));
    }

    @Test
    public void testParse() throws Exception {

        String yaml = "name: arul\n" +
                         "age: 35";
        ParserModel output =  testIntance.getObject(yaml);
        org.junit.Assert.assertNotNull(output);
        }
        }
