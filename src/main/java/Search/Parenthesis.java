package Search;

public enum Parenthesis {
    LEFT, RIGHT;

    public static Parenthesis get(String input) {
        if(input.equals("("))
            return LEFT;
        else if(input.equals(")"))
            return RIGHT;
        return null;
    }
}
