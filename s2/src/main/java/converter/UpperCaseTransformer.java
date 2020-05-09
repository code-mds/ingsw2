package converter;

public class UpperCaseTransformer implements LineTrasfomer {
    @Override
    public String transform(String input) {
        return input.toUpperCase();
    }
}
