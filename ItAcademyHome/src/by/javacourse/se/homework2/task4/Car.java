package by.javacourse.se.homework2.task4;

import static by.javacourse.se.homework2.task4.Brand.*;
import static by.javacourse.se.homework2.task4.Color.*;

public class Car {

    private Color _color;
    private Brand _brand;

    public Car(Brand brand, Color color) {
        this._brand = brand;
        this._color = color;
    }

    public Color get_color() {
        return _color;
    }

    public Brand get_brand() {
        return _brand;
    }

    public Color changeColorCarByBrand(Color _color) {
        if (_brand.equals(AUDI)) {
            if (_color.equals(BLUE) || _color.equals(RED) || _color.equals(GREEN)) {
                this._color = _color;
            }
        }
        if (_brand.equals(BMW)) {
            if (_color.equals(ORANGE) || _color.equals(BLACK) || _color.equals(PURPLE)) {
                this._color = _color;
            }
        }
        if (_brand.equals(KIA)) {
            if (_color.equals(YELLOW) || _color.equals(GRAY) || _color.equals(WHITE)) {
                this._color = _color;
            }
        }

        return _color;
    }

}

