package org.hellchang.model.oauth;

public enum ProviderType {

    // TODO yml, Security settings
    GOOGLE("google"),
    GITHUB("github");

    private final String ROLE_PREFIX = "ROLE_";
    private String name;

    ProviderType(String name) {
        this.name = name;
    }

    public String getRoleType() {
        return ROLE_PREFIX + name.toUpperCase();
    }

    public String getValue() {
        return name;
    }

    public boolean isEquals(String authority) {
        return this.getRoleType().equals(authority);
    }
}
