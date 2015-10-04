


#include "Grifo.h"



Grifo::Grifo() {
    start = 0;
    actual = 0;

    pinMode(BEEP_PIN, OUTPUT);

    strip = new Adafruit_NeoPixel(LEDS, LEDS_PIN, NEO_GRB + NEO_KHZ800);

    strip->begin();
    strip->setBrightness(100);

    BLACK = Adafruit_NeoPixel::Color(0, 0, 0);
    RED = Adafruit_NeoPixel::Color(255, 0, 0);
    GREEN = Adafruit_NeoPixel::Color(0, 255, 0);


    for (byte i = 0; i < 3; i++)
        color[i] = RED;

    for (byte i = 3; i < 6; i++)
        color[i] = GREEN;

    for (byte i = 6; i < 9; i++)
        color[i] = RED;


}


void Grifo::setActual(unsigned long actual) {

    if (start == 0)
        start = actual;

    Serial.print("Tiempo: ");

    this->actual = actual;
    int seconds = getSeconds();

    Serial.print(seconds);
    Serial.println(" segundos");
    strip->clear();

    for (byte i = 0; i < seconds; i++)
        strip->setPixelColor(i, color[i]);


    if (seconds > BEEP_TIME)
        digitalWrite(BEEP_PIN, blink);

    if (seconds > MAX_TIME)
        strip->setPixelColor(MAX_TIME - 1, blink ? BLACK : RED);



    blink = blink ? false:true;

    strip->show();
}


int Grifo::getSeconds()  {

    return (actual - start) / 1000;

}

void Grifo::setStop() {
    start = 0;
    blink = 0;
    strip->clear();
    strip->show();
    digitalWrite(BEEP_PIN, blink);
}
