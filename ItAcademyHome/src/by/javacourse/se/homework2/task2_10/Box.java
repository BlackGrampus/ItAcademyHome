package by.javacourse.se.homework2.task2_10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Box {

    private int x;
    private int y;
    private int z;
    private static String type;

    public Box(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        setBoxType();
    }

    public Box(String itsBox) {
        getParamBox(itsBox);
        setBoxType();
    }

    private final void getParamBox(String itsBox) {
        Integer[] paramBox = new Integer[3];
        int counter = 0;

        Pattern pattern = Pattern.compile("Box\\[(\\d+)+,?(\\d+)?,?(\\d+)?\\]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(itsBox);

        while (matcher.find()) {
            for (int i = 0; i < 3; i++) {
                if (matcher.group(i + 1) == null) {
                    paramBox[i] = null;
                    continue;
                }
                paramBox[i] = Integer.parseInt(matcher.group(i + 1));
                counter++;
            }
        }

        switch (counter) {
            case 1: {
                x = y = z = paramBox[0];
                break;
            }
            case 2: {
                x = paramBox[0];
                y = paramBox[1];
                z = 0;
                break;
            }
            case 3: {
                x = paramBox[0];
                y = paramBox[1];
                z = paramBox[2];
                break;
            }
            default: {
                x = y = z = 0;
            }
        }
    }

    private final void setBoxType() {
        if ((x > 0) && (y > 0) && (z >= 0)) {
            if ((x == y) && (x == z)) {
                type = "Cube";
            } else if (z == 0) {
                type = "Letter";
            } else if (z > 0) {
                type = "Box";
            }
        } else {
            type = "Not defined";
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public static String getBoxType(Box box) {
        return type;
    }
}


