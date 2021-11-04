package sentence;

/**
 * EmptyNode represents an empty node in a sentence which denotes the end of a sentence. We can
 * infer that on reaching the empty node we have reached the end of the sentence.
 */
public class EmptyNode implements Sentence {
  private Sentence next;

  /**
   * Return the number of words in the sentence. Punctuation does not count as a
   * word.
   *
   * @return the number of words in the sentence.
   */
  @Override
  public int getNumberOfWords() {
    return 0;
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
    return "";
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
    return other;
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
    return this;
  }

  @Override
  public Sentence mergeHelper(Sentence other) {
    return other;
  }

  @Override
  public String toString() {
    return "";
  }
}
