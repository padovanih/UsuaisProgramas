#include <QueueArray.h>

int i = 0;

#define NUM_READINGS 5
int readings[NUM_READINGS];      // the readings from the analog input
int readIndex = 0;              // the index of the current reading
int total = 0;                  // the running total
int average = 0;                // the average
int old_average = 0;            // necessario para o filtro 

// #########################################################

// Here are the queue to store the average
#define NUM_AVERAGES_QUEUE 5
QueueArray <int> queue_average;
int average_past = 0; // It is the average #NUM_AVERAGES_QUEUE in the past

// Here are the variables to control the IP from the RED led.
#define NUM_IP_RED 5
int ip_red_array[NUM_IP_RED];
int total_IP_RED = 0;
int average_IP_RED = 0;
int readIndex_IP_RED=0;
bool bool_set_IP_RED = true;
bool bool_set_IP_RED_old = false;

// Here are the variables to control the IB from the RED led.
#define NUM_IB_RED 5
int ib_red_array[NUM_IB_RED];
int total_IB_RED = 0;
int average_IB_RED = 0;
int readIndex_IB_RED=0;
bool bool_set_IB_RED = false;
bool bool_set_IB_RED_old = false;

// #########################################################

double alfa = 0.99;             // necessario para o filtro (passa alta)
double beta = 0.14;
int inputPin = A0;


double outpth = 0.0;            // saida do filtro high pass
double outpt = 0.0;


  // # # # # # # # # # # # # # # # # # # # # # # # # #
  // # # # # # # # # # #   SETUP   # # # # # # # # # #
  // # # # # # # # # # # # # # # # # # # # # # # # # #

void setup() {
  Serial.begin(9600);
  for (i = 0; i < NUM_AVERAGES_QUEUE; i++) { queue_average.push(0); }
  for (int thisReading = 0; thisReading < NUM_READINGS; thisReading++) { readings[thisReading] = 0; }
  for (i = 0; i < NUM_IP_RED; i++) { ip_red_array[i]; }
  for (i = 0; i < NUM_IB_RED; i++) { ib_red_array[i]; }
  analogReference(INTERNAL);
  queue_average.setPrinter(Serial);
}

void loop() {

  // # # # # # # # # # # # # # # # # # # # # # # # # #
  // # # # # # # # # # #  READING  # # # # # # # # # #
  // # # # # # # # # # # # # # # # # # # # # # # # # #

  // // subtract the last reading:
  // total = total - readings[readIndex];
  // // read from the sensor:
  // readings[readIndex] = analogRead(A0);
  // // add the reading to the total:
  // total = total + readings[readIndex];
  // // advance to the next position in the array:
  // readIndex = readIndex + 1;

  // // if we're at the end of the array...
  // if (readIndex >= NUM_READINGS) {
  //   // ...wrap around to the beginning:
  //   readIndex = 0;
  // }

  // calculate the average:
  total = 0;
  for (i = 0; i < NUM_READINGS; i++) { total += analogRead(A0); }
  
  old_average = average;
  average = total / NUM_READINGS;


  // # # # # # # # # # # # # # # # # # # # # # # # # #
  // # # # # # # # # #  GET IP AND IB  # # # # # # # #
  // # # # # # # # # # # # # # # # # # # # # # # # # #
  // STORE THE NEW AVERAGE
  queue_average.enqueue(average);
  // REMOVE AND STORE THE AVERAGE FROM NUM_AVERAGES_QUEUE STEPS IN THE PAST
  average_past = queue_average.dequeue();


  bool_set_IP_RED_old = bool_set_IP_RED;
  bool_set_IB_RED_old = bool_set_IB_RED;
  // CHECK THE DERIVATE SIGN
  if( average > average_past ) {
    bool_set_IP_RED = true;
    bool_set_IB_RED = false;
  } else {
    bool_set_IP_RED = false;
    bool_set_IB_RED = true;
  }

  // Get the new IP_RED value
  // Condition on left: false means that the value is decreasing, i.e., we are in the maximum local
  // Condition on right: true means that it is the first time we get a negative derivate, so we change the value once
  if( !bool_set_IP_RED && (bool_set_IP_RED!=bool_set_IP_RED_old) ) {
    // REMOVE THE OLDEST MEASURE
    total_IP_RED  = total_IP_RED - ip_red_array[readIndex_IP_RED];
    // INSERT THE NEW IB_RED VALUE
    ip_red_array[readIndex_IP_RED] = average;
    readIndex_IP_RED++;
    // CHECK IF REACH THE END OF THE ARRAY
    if (readIndex_IP_RED >= NUM_IP_RED) { readIndex_IP_RED = 0; }
    // GET IP_RED AVERAGE 
    average_IP_RED = total_IP_RED / NUM_IP_RED;
  } 
  else // Get the new IB_RED value, same logic for IP
  if(!bool_set_IB_RED && (bool_set_IB_RED!=bool_set_IB_RED_old) ) {
    total_IB_RED  = total_IB_RED - ib_red_array[readIndex_IB_RED];
    ib_red_array[readIndex_IB_RED] = average;
    readIndex_IB_RED++;
    if (readIndex_IB_RED >= NUM_IB_RED) { readIndex_IB_RED = 0; }
    average_IB_RED = total_IB_RED / NUM_IB_RED;
  }

  // # # # # # # # # # # # # # # # # # # # # # # # # #
  // # # # # # # # # # #  BAND PASS  # # # # # # # # #
  // # # # # # # # # # # # # # # # # # # # # # # # # #

  // HIGH PASS
  outpth = alfa*outpth - alfa*(average - old_average);
  // LOW PASS
  outpt = beta*outpth - (1-beta)*outpt;


  // # # # # # # # # # # # # # # # # # # # # # # # # #
  // # # # # # # # # # #  BAND PASS  # # # # # # # # #
  // # # # # # # # # # # # # # # # # # # # # # # # # #

  // send it to the computer as ASCII digits
  Serial.print(0);  // To freeze the lower limit
  Serial.print(" ");
  Serial.print(100);  // To freeze the upper limit
  Serial.print(" ");
  //Serial.print(average_IP_RED);
  //Serial.print(" ");
  //Serial.print(average_IB_RED);
  //Serial.print(" ");
  Serial.println(average);  // To send all three 'data' points to the plotter
  //delay(1);        // delay in between reads for stability
}
