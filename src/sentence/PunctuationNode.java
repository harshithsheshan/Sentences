package sentence;

/**
 * PunctuationNode represents a punctuation which is part of a sentence and implements the
 * Sentence interface. It follows the usual English rules regarding the placement of a punctuation
 * in a sentence. Punctuations are to be followed by space unless it's an EmptyNode.
 */
public class PunctuationNode implements Sentence {
  private final String punctuation;
  private final Sentence next;

  /**
   * Constructor which instantiates the objects of punctuation node.
   *
   * @param pun  Punctuation as a string
   * @param next Next object in the sentence
   */
  public PunctuationNode(String pun, Sentence next) {
    if (pun == null || next == null) {
      throw new IllegalArgumentException();
    }
    this.punctuation = pun;
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
    return next.getNumberOfWords();
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
    return new PunctuationNode(this.punctuation, next.mergeHelper(other));
  }

  @Override
  public String toString() {
    if (next instanceof WordNode) {
      return String.format("%s %s", this.punctuation, next.toString());
    } else if (next instanceof PunctuationNode) {
      return String.format("%s %s", this.punctuation, next.toString());
    }
    return this.punctuation;
  }
}
