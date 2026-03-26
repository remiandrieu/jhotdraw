package org.jhotdraw.draw.handle;

/**
 * Enumeration of detail levels for creating handles on figures.
 * Used by {@link org.jhotdraw.draw.figure.Figure#createHandles(int)} to specify
 * the type of handles to generate.
 */
public enum HandleDetailLevel {
  /** Highlight figures, used by SelectAreaTracker and HandleTracker. */
  HIGHLIGHT,
  /** Bounding box handles for basic manipulation. */
  BOUNDING_BOX,
  /** Point handles for detailed manipulation. */
  POINT;

  public static HandleDetailLevel increaseDetailLevel(HandleDetailLevel detailLevel) {
    switch (detailLevel) {
      case HIGHLIGHT:
        return BOUNDING_BOX;
      case BOUNDING_BOX:
        return POINT;
      case POINT:
        return BOUNDING_BOX;
    }
    return BOUNDING_BOX;
  }
}
