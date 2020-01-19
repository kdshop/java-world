package src.Models;


public class LiveLength {
  private Integer liveLength;

  public LiveLength() {
    this(5);
  }

  public LiveLength(Integer liveLength) {
    this.set(liveLength);
  }

  public Integer get() {
    return this.liveLength;
  }

  public LiveLength set(Integer liveLength) {
    if (liveLength < 0) {
      throw new Error("Live length must be 0 or more!");
    }
    this.liveLength = liveLength;

    return this;
  }
}


