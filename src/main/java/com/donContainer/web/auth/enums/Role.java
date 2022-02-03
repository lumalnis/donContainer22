package com.donContainer.web.auth.enums;

public enum Role {

  USER("USER"),
  ADMIN("ADMIN");

  private static final String ROLE_PREFIX = "ROLE_";
  private final String name;

  Role(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String getFullRoleName() {
    return ROLE_PREFIX + name;
  }

}
