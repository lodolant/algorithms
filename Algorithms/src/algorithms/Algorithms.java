package algorithms;

public class Algorithms {
	// Function to calculate Levenshtein distance between two strings
	public static int computeLevenshteinDistance(String word1, String word2) {
		int length1 = word1.length();
		int length2 = word2.length();

		// Create a matrix to store the distances
		int[][] distanceMatrix = new int[length1 + 1][length2 + 1];

		// Initialize the matrix
		for (int word1Index = 0; word1Index <= length1; word1Index++) {
			for (int word2Index = 0; word2Index <= length2; word2Index++) {
				if (word1Index == 0) {
					distanceMatrix[word1Index][word2Index] = word2Index; // If first string is empty, all insertions
				} else if (word2Index == 0) {
					distanceMatrix[word1Index][word2Index] = word1Index; // If second string is empty, all deletions
				} else {
					boolean isSameCharacter = word1.charAt(word1Index - 1) == word2.charAt(word2Index - 1);
					int cost = isSameCharacter ? 0 : 1;
					distanceMatrix[word1Index][word2Index] = Math.min(
							Math.min(distanceMatrix[word1Index - 1][word2Index] + 1, // Deletion - Propagate from line
									distanceMatrix[word1Index][word2Index - 1] + 1), // Insertion - Propagate from
																						// column
							distanceMatrix[word1Index - 1][word2Index - 1] + cost); // Substitution/same - propagate on
																					// both
				}
			}
		}

		int result = distanceMatrix[length1][length2];
		// Return the Levenshtein distance (bottom-right value in the matrix)
		System.out.println("Levenshtein Distance between '" + word1 + "' and '" + word2 + "' is: " + result);
		return result;
	}
}
