  public Set<String> getPermutations(String inputString) {

    // base case
    if (inputString.length() <= 1) {
        return new HashSet<String>(Arrays.asList(inputString));
    }

    String allCharsExceptLast = inputString.substring(0, inputString.length() - 1);
    char lastChar = inputString.charAt(inputString.length() - 1);

    // recursive call: get all possible permutations for all chars except last
    Set<String> permutationsOfAllCharsExceptLast = getPermutations(allCharsExceptLast);

    // put the last char in all possible positions for each of the above permutations
    int highestPossiblePositionsToPutLastChar = allCharsExceptLast.length();
    Set<String> permutations = new HashSet<String>();
    for (String permutationOfAllCharsExceptLast : permutationsOfAllCharsExceptLast) {
        for (int position=0; position <= highestPossiblePositionsToPutLastChar; position++) {
            String permutation = permutationOfAllCharsExceptLast.substring(0, position) + lastChar + permutationOfAllCharsExceptLast.substring(position);
            permutations.add(permutation);
        }
    }

    return permutations;
}
