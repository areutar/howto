package string.makingSlices;

public class RangeConfigurator {
    public static final String WRONG_BOUNDARY = "Wrong boundary!";
    public static final String EMPTY_BOUNDARIES_AND_STEP = "Empty boundaries and step!";
    public static final String WRONG_DIRECTION = "Wrong direction!";
    public static final String WRONG_LENGTH = "Wrong Length!";
    private final Integer start;
    private final Integer end;
    private final Integer step;
    private final int length;

    public RangeConfigurator(Integer start, Integer end,
            Integer step, int length) {
        checkLength(length);
        this.length = length;

        checkBoundary(start, length);
        checkBoundary(end, length);
        Integer startModulated = modulateBoundary(start);
        Integer endModulated = modulateBoundary(end);
        this.step = correctStep(startModulated, endModulated, step);

        startModulated = correctStart(startModulated, this.step);
        endModulated = correctEnd(endModulated, this.step);

        if (startModulated.equals(endModulated)) {
            endModulated = correctEndIfStartEqualsEnd(endModulated);
        }

        this.start = startModulated;
        this.end = endModulated;
        checkDirection(this.start, this.end, this.step, this.length);
    }

    private Integer correctEndIfStartEqualsEnd(Integer end) {
        if (step >= 0) {
            if (end == length - 1) {
                throw new IllegalArgumentException(WRONG_DIRECTION);
            } else {
                return end + 1;
            }
        } else {
            if (end == 0) {
                throw new IllegalArgumentException(WRONG_DIRECTION);
            } else {
                return end - 1;
            }
        }
    }

    private void checkLength(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException(WRONG_LENGTH);
        }
    }

    private void checkDirection(Integer start, Integer end,
            Integer step, int length) {
        if (start != null && end != null
                && (end - start) * step < 0) {
            throw new IllegalArgumentException(WRONG_DIRECTION);
        }
    }

    private Integer correctEnd(Integer end, Integer step) {
        Integer correctedEnd = end;
        if (end == null) {
            if (step >= 0) {
                correctedEnd = length;
            } else {
                correctedEnd = -1;
            }
        }
        return correctedEnd;
    }

    private Integer correctStart(
            Integer start, Integer step) {
        Integer correctedStart = start;
        if (start == null) {
            if (step >= 0) {
                correctedStart = 0;
            } else {
                correctedStart = length - 1;
            }
        }
        return correctedStart;
    }

    private Integer correctStep(Integer start, Integer end,
            Integer step) {
        Integer correctedStep = step;
        if (start == null && end == null && step == null) {
            throw new IllegalArgumentException(
                    EMPTY_BOUNDARIES_AND_STEP);
        }

        if (step == null || step == 0) {
            correctedStep = 1;
            if (start != null && end != null && start > end) {
                correctedStep = -1;
            }
        }
        return correctedStep;
    }

    private void checkBoundary(Integer boundary, int length) {
        if (boundary != null && (boundary >= length || boundary <= -length)) {
            throw new IllegalArgumentException(
                    WRONG_BOUNDARY);
        }
    }

    private Integer modulateBoundary(Integer boundary) {
        if (boundary != null && boundary < 0) {
            return length + boundary;
        }
        return boundary;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    public Integer getStep() {
        return step;
    }

    public Integer getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "[start=" + start
                + ", end=" + end
                + ", step=" + step
                + ", length=" + length
                + "]";
    }

}
