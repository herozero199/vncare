package Search;

public enum Operators {
    EQUALITY, NEGATION, GREATER_THAN, LESS_THAN, SUBTRACT, MULTIPLY, DIVIDE, SUM;

    public static Operators get(String input) {
       if(input.equals("="))
           return EQUALITY;
       else if(input.equals("+"))
           return SUM;
       else if(input.equals("_"))
           return SUBTRACT;
       else if(input.equals("*"))
           return MULTIPLY;
       else if(input.equals(":"))
           return DIVIDE;
       else if(input.equals("!"))
           return NEGATION;
       else if(input.equals(">"))
           return GREATER_THAN;
       else if(input.equals("<"))
           return LESS_THAN;
       return null;
    }
}
