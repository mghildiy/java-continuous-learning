package system.design.ratelimiter.identifiers;

public sealed interface Identifier permits APIKey, EmailId {
    String value();
}
