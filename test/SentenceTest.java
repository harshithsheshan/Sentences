

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sentence.EmptyNode;
import sentence.PunctuationNode;
import sentence.Sentence;
import sentence.WordNode;

/**
 * To test the functionalities of the Sentence interface with all possibilities and types of
 * combinations.
 */
public class SentenceTest {

  private Sentence dummy;
  private Sentence dummy1;
  private Sentence dummy2;
  private Sentence dummy3;
  private Sentence empty;

  @Before
  public void setUp() {
    dummy = new WordNode("Howdy", new WordNode("What", new WordNode("are",
        new WordNode("you", new EmptyNode()))));
    dummy1 = new WordNode("Hey", new PunctuationNode(",", new WordNode("are",
        new WordNode("you", new WordNode("the", new WordNode("God", new EmptyNode()))))));
    dummy2 = new WordNode("Tony", new WordNode("Stark", new WordNode("is",
        new WordNode("the", new PunctuationNode("IronMan",
            new PunctuationNode("!", new EmptyNode()))))));
    dummy3 = new WordNode("Hey", new WordNode("What", new WordNode("are",
        new WordNode("you", new WordNode("Doing", new EmptyNode())))));
    empty = new EmptyNode();
  }

  @Test
  public void getNumberOfWords() {
    Assert.assertEquals(4, dummy.getNumberOfWords());
    Assert.assertEquals(5, dummy1.getNumberOfWords());
    Assert.assertEquals(4, dummy2.getNumberOfWords());
    Assert.assertEquals(5, dummy3.getNumberOfWords());
    Assert.assertEquals(0, empty.getNumberOfWords());
  }

  @Test
  public void longestWord() {
    Assert.assertEquals("Howdy", dummy.longestWord());
    Assert.assertEquals("Hey", dummy1.longestWord());
    Assert.assertEquals("Stark", dummy2.longestWord());
    Assert.assertEquals("Doing", dummy3.longestWord());
    Assert.assertEquals(0, empty.getNumberOfWords());
  }

  @Test
  public void merge() {
    Assert.assertEquals("Howdy What are you Hey, are you the God", dummy.merge(dummy1).toString());
    Assert.assertEquals("Howdy What are you Tony Stark is theIronMan !",
        dummy.merge(dummy2).toString());
    Assert.assertEquals("Howdy What are you Hey What are you Doing",
        dummy.merge(dummy3).toString());
    Assert.assertEquals("Howdy What are you Howdy What are you", dummy.merge(dummy).toString());
    Assert.assertEquals("Hey, are you the God", empty.merge(dummy1).toString());

  }

  @Test
  public void testClone() {
    Assert.assertEquals(dummy.toString(), dummy.clone().toString());
    Assert.assertEquals(dummy1.toString(), dummy1.clone().toString());
    Assert.assertEquals(dummy2.toString(), dummy2.clone().toString());
    Assert.assertEquals(dummy3.toString(), dummy3.clone().toString());
    Assert.assertEquals(empty.toString(), empty.clone().toString());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Howdy What are you", dummy.toString());
    Assert.assertEquals("Hey, are you the God", dummy1.toString());
    Assert.assertEquals("Tony Stark is theIronMan !", dummy2.toString());
    Assert.assertEquals("Hey What are you Doing", dummy3.toString());
    Assert.assertEquals("", empty.toString());

  }
}