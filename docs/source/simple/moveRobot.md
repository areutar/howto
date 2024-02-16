### Движение робота

На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y. Робот описывается классом Robot, в котором реализованы методы: turnLeft() повернуться на 90 градусов против часовой стрелки; turnRight() повернуться на 90 градусов по часовой стрелке;
stepForward() шаг в направлении взгляда. Нужно, используя начальное и конечное состояния робота(координаты и направление вгляда), а также методы выше, привести робота в нужное место.

[Источник](https://stepik.org/lesson/12766/step/12?unit=3114)

<!-- tabs: start -->
#### **Python**

```python

```
#### **Test Python**

```python

```

#### **Java**

```java
package simple.moveRobot;

public class MoveRobot {   

    public static void moveRobot(Robot robot, int toX, int toY) {
        if (toY < robot.getY()) {
            setDirection(robot, Direction.DOWN);
        }
        if (toY > robot.getY()) {
            setDirection(robot, Direction.UP);
        }
        stepsForward(robot, robot.getY() - toY);

        if (toX < robot.getX()) {
            setDirection(robot, Direction.LEFT);
        }
        if (toX > robot.getX()) {
            setDirection(robot, Direction.RIGHT);
        }
        stepsForward(robot, robot.getX() - toX);

        System.out.println("x=" + robot.getX() + " y=" + robot.getY());
    }

    public static void setDirection(Robot robot, Direction direction) {
        while (robot.getDirection() != direction) {
            robot.turnLeft();
        }
    }

    public static void stepsForward(Robot robot, int number) {
        for (int i = 0; i < Math.abs(number); i++) {
            robot.stepForward();
        }
    }

    public class Robot {
        private Direction direction;
        private int x;
        private int y;

        public Robot(Direction direction, int x, int y) {
            this.direction = direction;
            this.x = x;
            this.y = y;
        }

        public Direction getDirection() {
            return direction;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            direction = Direction.values()[(direction.ordinal() + 3) % 4];
        }

        public void turnRight() {
            direction = Direction.values()[(direction.ordinal() + 1) % 4];
        }

        public void stepForward() {
            switch (direction) {
                case UP:
                    this.y++;
                    break;
                case RIGHT:
                    this.x++;
                    break;
                case DOWN:
                    this.y--;
                    break;
                case LEFT:
                    this.x--;
                    break;
            }
        }
    }

    public enum Direction {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }

}
```
#### **Test Java**

```java
package simple.moveRobot;

import static org.junit.Assert.assertEquals;
import static simple.moveRobot.MoveRobot.moveRobot;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import simple.moveRobot.MoveRobot.Direction;
import simple.moveRobot.MoveRobot.Robot;

public class TestMoveRobot {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private Robot robot;

    @BeforeEach
    void setSystemOut() {
        MoveRobot mRobot = new MoveRobot();
        robot = mRobot.new Robot(Direction.UP, 0, 0);
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "-1, -1, 'x=-1 y=-1'",
        "-1, 1, 'x=-1 y=1'",
        "-1, 0, 'x=-1 y=0'",
        "0, -1, 'x=0 y=-1'",
        "0, 0, 'x=0 y=0'",
        "0, 1, 'x=0 y=1'",
        "1, -1, 'x=1 y=-1'",
        "1, 0, 'x=1 y=0'",
        "1, 1, 'x=1 y=1'",
    })
    void testMoveRobot(int toX, int toY, String expected) {
        moveRobot(robot, toX, toY);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }


    @BeforeEach
    void setSystemOut1() {
        MoveRobot mRobot = new MoveRobot();
        robot = mRobot.new Robot(Direction.LEFT, -3, 12);
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "-1, -1, 'x=-1 y=-1'",
        "-1, 1, 'x=-1 y=1'",
        "-1, 0, 'x=-1 y=0'",
        "0, -1, 'x=0 y=-1'",
        "0, 0, 'x=0 y=0'",
        "0, 1, 'x=0 y=1'",
        "1, -1, 'x=1 y=-1'",
        "1, 0, 'x=1 y=0'",
        "1, 1, 'x=1 y=1'",
    })
    void testMoveRobot1(int toX, int toY, String expected) {
        moveRobot(robot, toX, toY);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut1() {
        System.setOut(null);
    }
}
```

#### **JavaScript**

```javascript

```
#### **Test JavaScript**

```javascript

```
<!-- tabs: end -->

[Ещё по теме:]()
