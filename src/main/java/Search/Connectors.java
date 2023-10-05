package Search;

public enum Connectors {
    AND, OR;

    public static Connectors get(String input) {
        if(input.equals("&"))
            return AND;
        else if(input.equals("|"))
            return OR;
        return null;
    }
}
