package system.design.ratelimiter.tokenbucket.identifiers;

public record APIKey(String key) implements Identifier {
    @Override
    public String value() {
        return null;
    }
}
