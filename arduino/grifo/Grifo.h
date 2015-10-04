

#ifndef BLINK_GRIFO_H
#define BLINK_GRIFO_H

#include "Adafruit_NeoPixel.h"
#include <wiring_private.h>

#define LEDS 9
#define LEDS_PIN 6
#define MAX_TIME 9
#define BEEP_PIN 4
#define BEEP_TIME 6


class Grifo {
private:

    int blink;
    uint32_t RED;
    uint32_t GREEN;
    uint32_t BLACK;
    uint32_t color[9];
    int getSeconds();
    unsigned long start;
    unsigned long actual;
    Adafruit_NeoPixel * strip;

public:
    Grifo();
    void setStop();
    void setActual(unsigned long actual);

};


#endif //BLINK_GRIFO_H
