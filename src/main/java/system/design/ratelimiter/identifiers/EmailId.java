package system.design.ratelimiter.identifiers;

public record EmailId(String email) implements Identifier {
    @Override
    public String value() {
        return email;
    }
}
