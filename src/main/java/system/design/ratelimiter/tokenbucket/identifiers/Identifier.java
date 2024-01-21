package system.design.ratelimiter.tokenbucket.identifiers;

public sealed interface Identifier permits APIKey, EmailId {
    String value();
}
