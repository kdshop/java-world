package src.Models;


public class Sign {
  private String sign;

  public Sign() {
    this("?");
  }

  public Sign(String sign) {
    this.set(sign);
  }

  public String get() {
    return this.sign;
  }

  public Sign set(String sign) {
    if (sign.length() != 1) {
      throw new Error("Sign organizmu może mieć tylko 1 literę!");
    }

    this.sign = sign.toUpperCase();

    return this;
  }
}
