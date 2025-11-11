// Rauan Dauletbek, 12337766
package einfprog;
import java.util.Arrays;

public class Bsp06 {
    public static void main(String[] args) {
        char[] dna = {'G', 'T', 'C', 'T', 'A', 'T', 'C', 'C', 'A', 'T', 'A', 'G'};
        char[] promoter = {'C', '*', 'A'};
        char[] terminator = {'T', '*', 'G'};

        System.out.println("DNA: " + Arrays.toString(dna));
        System.out.println("Promoter: " + Arrays.toString(promoter));
        System.out.println("Terminator: " + Arrays.toString(terminator));

        char[] geneSequence = searchGeneSequence(promoter, terminator, dna);
        System.out.println("Gene Sequence = " + Arrays.toString(geneSequence));
    }


    /**
     * Searches the first occurrence of a pattern in the DNA.
     *
     * @param pattern the pattern to be searched
     * @param dna     the DNA sequence
     *
     * @return the position of the first character of the first pattern
     *         found in the DNA; -1, if pattern is not found
     */
    public static int searchPattern(char[] pattern, char[] dna) {
        int patternLength = pattern.length;
        int dnaLength = dna.length;

        for (int i = 0; i <= dnaLength - patternLength; i++) {
            int j;
            for (j = 0; j < patternLength; j++) {
                if (dna[i + j] != pattern[j]) {
                    break;
                }
            }
            if (j == patternLength) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns a random base sequence of given length.
     *
     * @return a random base sequence (containing the four DNA bases)
     */
public static char[] createSequence(int length, long... seed) {
        char[] bases = {'A', 'C', 'G', 'T'};
        java.util.Random prng;
        
        if (seed.length > 0) {
            prng = new java.util.Random(seed[0]);
        } else {
            prng = new java.util.Random();
        }
        
        char[] sequence = new char[length];

        for (int i = 0; i < length; i++) {
            sequence[i] = bases[prng.nextInt(4)]; // Zufällige Auswahl einer Base
        }

        return sequence;
    }

    /**
     * Returns the number of occurrences of a pattern in the DNA.
     *
     * @param pattern the pattern to be searched
     * @param dna     the DNA sequence
     *
     * @return the number of occurrences
     */
    public static int getNumberOfMatches(char[] pattern, char[] dna) {
        int count = 0;
        int index = 0;

        while (index != -1) {
            index = searchPattern(pattern, dna);
            if (index != -1) {
                count++;
                dna = cutTailAt(index + 1, dna); // Verkürzen der DNA-Sequenz
            }
        }

        return count;
    }

    /**
     * Returns the remainder (tail) of the array from the given position.
     *
     * @return the tail array (index 0 is at position 'pos' of 'sequence')
     */
    public static char[] cutTailAt(int pos, char[] sequence) {
        if (pos >= sequence.length)
            return new char[0]; // Wenn die Position außerhalb des Sequenzbereichs liegt, wird ein leeres Array zurückgegeben
        else
            return Arrays.copyOfRange(sequence, pos, sequence.length); // Rückgabe des verbleibenden Teils der Sequenz ab der angegebenen Position
    }

    // =========================================================================
    //  Part 2
    // =========================================================================

    /**
     * Searches the first occurrence of a wildcard pattern in the DNA.
     *
     * The wildcard pattern may include the wildcard character '*', which
     * matches any base.
     *
     * @param pattern the wildcard pattern to be searched
     * @param dna     the DNA sequence
     *
     * @return the position of the first character of the first wildcard
     *         pattern found in the DNA; -1, if pattern is not found
     */
    public static int searchWildCardPattern(char[] pattern, char[] dna) {
        for (int i = 0; i <= dna.length - pattern.length; i++) {
            int j;

            for (j = 0; j < pattern.length; j++) {
                if (pattern[j] != '*' && dna[i + j] != pattern[j])
                    break;
            }

            if (j == pattern.length)
                return i;
        }

        return -1;
    }


    /**
     * Searches the first gene sequence in the DNA with the given promoter
     * and terminator.
     *
     * @param promoter   the start wildcard pattern of a gene
     * @param terminator the end wildcard pattern of a gene
     *
     * @return the gene sequence between promoter and terminator (may be
     *         empty); null, if promoter or terminator not found
     */
    public static char[] searchGeneSequence(char[] promoter, char[] terminator, char[] dna) {
        int start = searchWildCardPattern(promoter, dna);
        if (start == -1) {
            return null; // Promoter nicht gefunden
        }

        int end = searchWildCardPattern(terminator, Arrays.copyOfRange(dna, start + promoter.length, dna.length));
        if (end == -1) {
            return null; // Terminator nicht gefunden
        }

        return Arrays.copyOfRange(dna, start + promoter.length, start + promoter.length + end);
    }
}