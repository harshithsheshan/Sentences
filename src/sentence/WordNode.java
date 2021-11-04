package sentence;

/**
 * WordNode represents the word in a sentence and follows the rules in english regarding placement
 * in a sentence. Words should be followed by a space if the next object is a word. Otherwise, it
 * must not be followed by a space.
 */
public class WordNode implements Sentence {
  private final String word;
  private final Sentence next;

  /**
   * Constructor which instantiates the objects of punctuation node.
   *
   * @param word Word as a string
   * @param next Next object in the sentence
   */
  public WordNode(String word, Sentence next) {
    if (word == null || next == null) {
      throw new IllegalArgumentException();
    }
    this.word = word;
    this.next = next;
  }

  /**
   * Return the number of words in the sentence. Punctuation does not count as a
   * word.
   *
   * @return the number of words in the sentence.
   */
  @Override
  public int getNumberOfWords() {
    return (1 + next.getNumberOfWords());
  }

  /**
   * Return the (first) longest word in the sentence. The longest word should not
   * begin or end with punctuation. If the sentence is empty, it should an empty
   * string.
   *
   * @return the longest word in the sentence.
   */
  @Override
  public String longestWord() {
    if (word.length() >= next.longestWord().length()) {
      return word;
    }
    return next.longestWord();

  }

  /**
   * Merge two sentences together. The merge sentence is a list that preserves all
   * of the punctuation. The merged list should be returned by this method, and
   * the original lists should be unchanged.
   *
   * @param other the sentence to add to the end of this sentence.
   * @return the merged sentence
   */
  @Override
  public Sentence merge(Sentence other) {
    return mergeHelper(other);
  }

  /**
   * Return a duplicate of this sentence. A duplicate is a list that has the same
   * words and punctuation in the same sequence, but is independent of the
   * original list.
   *
   * @return a duplicate of this sentence
   */
  @Override
  public Sentence clone() {
    return mergeHelper(new EmptyNode());
  }

  @Override
  public Sentence mergeHelper(Sentence other) {
    return new WordNode(this.word, next.mergeHelper(other));
  }

  @Override
  public String toString() {
    if (next instanceof PunctuationNode) {
      return String.format("%s%s", this.word, next.toString());
    } else if (next instanceof WordNode) {
      return String.format("%s %s", this.word, next.toString());
    }
    return this.word;

  }
}
