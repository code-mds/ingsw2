package converter;

public class LowerCaseTransformer implements LineTrasfomer {
    @Override
    public String transform(String input) {
        return input.toLowerCase();
    }
}
