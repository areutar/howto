package sequence.makingSlices;

public class RangeConfigurator {
    public static final String WRONG_BOUNDARY = "Wrong boundary!";
    public static final String WRONG_DIRECTION = "Wrong direction!";
    public static final String WRONG_LENGTH = "Wrong length!";
    private final Integer start;
    private final Integer end;
    private final Integer step;
    private final int length;

    public RangeConfigurator(Integer start, Integer end,
            Integer step, int length) {
        // check if the length is positive
        checkLength(length);
        this.length = length;

        // check that start and end does not go beyond the boundaries
        checkBoundary(start, length);
        checkBoundary(end, length);

        // replace the negative value with positive by adding length
        Integer startModulated = modulateBoundary(start);
        Integer endModulated = modulateBoundary(end);

        // calculate step:
        // 1. the zero and null step is replaced by 1,
        // 2. but, if the non-null start is greater than the non-null end,
        // then the null step is replaced by -1
        this.step = correctStep(startModulated, endModulated, step);

        // null start with a positive step is replaced by zero
        // null start with a negative step is replaced by length - 1
        startModulated = correctStart(startModulated, this.step);

        // null end with a positive step is replaced by length
        // null end with a negative step is replaced by -1
        endModulated = correctEnd(endModulated, this.step);

        // handle the case when start is equal to end:
        // 1. if step is positive, we shift the end to the next element
        // of the list, if there is one
        // 2. if not present, throw an exception
        // 3. if step is negative, we shift the end to the previous element
        // of the list, if there is one
        // 4. if not present, throw an exception
        if (startModulated.equals(endModulated)) {
            endModulated = correctEndIfStartEqualsEnd(endModulated);
        }

        this.start = startModulated;
        this.end = endModulated;

        // check that the ordering of the start and end 
        // corresponds to the sign of the step, namely: 
        // ascending order - positive step
        // and descending order - negative step, 
        // otherwise throw an exception
        checkDirection(this.start, this.end, this.step, this.length);
    }

    private Integer correctEndIfStartEqualsEnd(Integer end) {
        if (step >= 0) {
            // if (end == length - 1) {
            //     throw new IllegalArgumentException(WRONG_DIRECTION);
            // } else {
                return end + 1;
            // }
        } else {
            // if (end == 0) {
            //     throw new IllegalArgumentException(WRONG_DIRECTION);
            // } else {
                return end - 1;
            // }
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
