#include <Arduino.h>
#include <Adafruit_NeoPixel.h>


#define X_MIN 331
#define Z_MIN 418

#define X_MAX  265
#define Z_MAX  353

#define THRESHOLD 3

#include "Grifo.h"

int x;

int z;
int angle;
int angleX;
int angleZ;

Grifo * grifo;

void setup() {
    grifo = new Grifo();
    Serial.begin(9600);
}

void showData() {
    Serial.print("Angulo X: ");
    Serial.print(angleX);
    Serial.print(", Angulo Z: ");
    Serial.print(angleZ);
    Serial.print(", Angulo : ");
    Serial.println(angle);
    Serial.print("X: ");
    Serial.print(x);
    Serial.print(", Z: ");
    Serial.println(z);
}




void loop() {

    x = analogRead(A0);
    z = analogRead(A2);

    angleX = map(x, X_MIN, X_MAX, 0, 90);
    angleZ = map(z, Z_MIN, Z_MAX, 0, 90);

    angle = (angleX + angleZ) / 2;


    if (angle >= THRESHOLD)
        grifo->setActual(millis());
    else
        grifo->setStop();

    showData();
    delay(100);

}