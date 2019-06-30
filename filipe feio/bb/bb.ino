#include <QueueArray.h>


// #########################################################

// VARIABLES FOR READING FROM RED LED
#define NUM_READINGS_RED 10
int readings_RED[NUM_READINGS_RED];      // the readings from the analog input
int readIndex_RED = 0;              // the index of the current reading
int total_RED = 0;                  // the running total
int average_RED = 0;                // the average
int old_average_RED = 0;            // necessario para o filtro 

// #########################################################

// VARIABLES FOR READING FROM IR LED
#define NUM_READINGS_IR 10
int readings_IR[NUM_READINGS_IR];      // the readings from the analog input
int readIndex_IR = 0;              // the index of the current reading
int total_IR = 0;                  // the running total
int average_IR = 0;                // the average
int old_average_IR = 0;            // necessario para o filtro 

// #########################################################
//                      RED VARIABLES
// #########################################################
// Here are the queue to store the average
#define NUM_AVERAGES_QUEUE_RED 10
QueueArray <int> queue_average_RED;
int average_past_RED = 0; // It is the average #NUM_AVERAGES_QUEUE_RED in the past

// Here are the variables to control the IP from the RED led.
#define NUM_IP_RED 5
int ip_RED_array[NUM_IP_RED];

int total_IP_RED = 0;
int average_IP_RED = 0;
int readIndex_IP_RED=0;
bool bool_set_IP_RED = true;
bool bool_set_IP_RED_old = false;

// Here are the variables to control the IB from the RED led.
#define NUM_IB_RED 5
int ib_RED_array[NUM_IB_RED];
int total_IB_RED = 0;
int average_IB_RED = 0;
int readIndex_IB_RED=0;
bool bool_set_IB_RED = false;
bool bool_set_IB_RED_old = false;


// #########################################################
//                      IR VARIABLES
// #########################################################
// Here are the queue to store the average
#define NUM_AVERAGES_QUEUE_IR 10
QueueArray <int> queue_average_IR;
int average_past_IR = 0; // It is the average #NUM_AVERAGES_QUEUE_IR in the past

// Here are the variables to control the IP from the RED led.
#define NUM_IP_IR 5
int ip_IR_array[NUM_IP_IR];

int total_IP_IR = 0;
int average_IP_IR = 0;
int readIndex_IP_IR=0;
bool bool_set_IP_IR = true;
bool bool_set_IP_IR_old = false;

// Here are the variables to control the IB from the RED led.
#define NUM_IB_IR 5
int ib_IR_array[NUM_IB_IR];
int total_IB_IR = 0;
int average_IB_IR = 0;
int readIndex_IB_IR=0;
bool bool_set_IB_IR = false;
bool bool_set_IB_IR_old = false;


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
  // RED
  for (int thisReading = 0; thisReading < NUM_READINGS_RED; thisReading++) { readings_RED[thisReading] = 0; }
  for (int i = 0; i < NUM_AVERAGES_QUEUE_RED; i++) { queue_average_RED.push(0); }
  for (int i = 0; i < NUM_IP_RED; i++) { ip_RED_array[i]; }
  for (int i = 0; i < NUM_IB_RED; i++) { ib_RED_array[i]; }
  // IR
  for (int thisReading = 0; thisReading < NUM_READINGS_IR; thisReading++) { readings_IR[thisReading] = 0; }
  for (int i = 0; i < NUM_AVERAGES_QUEUE_IR; i++) { queue_average_IR.push(0); }
  for (int i = 0; i < NUM_IP_IR; i++) { ip_IR_array[i]; }
  for (int i = 0; i < NUM_IB_IR; i++) { ib_IR_array[i]; }
  analogReference(INTERNAL);
  queue_average_RED.setPrinter(Serial);
  queue_average_IR.setPrinter(Serial);
}

void loop() {

  // # # # # # # # # # # # # # # # # # # # # # # # # #
  // # # # # # # # # # #  READING  # # # # # # # # # #
  // # # # # # # # # # # # # # # # # # # # # # # # # #

  // *************** READING FOR RED *****************
  // subtract the last reading:
  total_RED = total_RED - readings_RED[readIndex_RED];
  // read from the sensor:
  readings_RED[readIndex_RED] = analogRead(A0);
  // add the reading to the total:
  total_RED = total_RED + readings_RED[readIndex_RED];
  // advance to the next position in the array:
  readIndex_RED = readIndex_RED + 1;
  // if we're at the end of the array... ...wrap around to the beginning:
  if (readIndex_RED >= NUM_READINGS_RED) { readIndex_RED = 0; }
  // calculate the average:
  old_average_RED = average_RED;
  average_RED = total_RED / NUM_READINGS_RED;

    // *************** READING FOR IR *****************
  // subtract the last reading:
  total_IR = total_IR - readings_IR[readIndex_IR];
  // read from the sensor:
  readings_IR[readIndex_IR] = analogRead(A0);
  // add the reading to the total:
  total_IR = total_IR + readings_IR[readIndex_IR];
  // advance to the next position in the array:
  readIndex_IR = readIndex_IR + 1;
  // if we're at the end of the array... ...wrap around to the beginning:
  if (readIndex_IR >= NUM_READINGS_IR) { readIndex_IR = 0; }
  // calculate the average:
  old_average_IR = average_IR;
  average_IR = total_IR / NUM_READINGS_IR;


  // # # # # # # # # # # # # # # # # # # # # # # # # #
  // # # # # # # # # #  GET IP AND IB  # # # # # # # #
  // # # # # # # # # # # # # # # # # # # # # # # # # #

  // ******************** FOR RED ********************
  // STORE THE NEW AVERAGE
  queue_average_RED.enqueue(average_RED);
  // REMOVE AND STORE THE AVERAGE FROM NUM_AVERAGES_QUEUE STEPS IN THE PAST
  average_past_RED = queue_average_RED.pop();

  // derivate
  bool_set_IP_RED_old = bool_set_IP_RED;
  bool_set_IB_RED_old = bool_set_IB_RED;
  // CHECK THE DERIVATE SIGN
  if( average_RED > average_past_RED ) {
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
    total_IP_RED  = total_IP_RED - ip_RED_array[readIndex_IP_RED];
    // INSERT THE NEW IB_RED VALUE
    ip_RED_array[readIndex_IP_RED] = average_RED;
    readIndex_IP_RED++;
    // CHECK IF REACH THE END OF THE ARRAY
    if (readIndex_IP_RED >= NUM_IP_RED) { readIndex_IP_RED = 0; }
    // GET IP_RED AVERAGE 
    average_IP_RED = total_IP_RED / NUM_IP_RED;
  } 
  else // Get the new IB_RED value, same logic for IP
  if(!bool_set_IB_RED && (bool_set_IB_RED!=bool_set_IB_RED_old) ) {
    total_IB_RED  = total_IB_RED - ib_RED_array[readIndex_IB_RED];
    ib_RED_array[readIndex_IB_RED] = average_RED;
    readIndex_IB_RED++;
    if (readIndex_IB_RED >= NUM_IB_RED) { readIndex_IB_RED = 0; }
    average_IB_RED = total_IB_RED / NUM_IB_RED;
  }







  // # # # # # # # # # # # # # # # # # # # # # # # # #
  // # # # # # # # # #  GET IP AND IB  # # # # # # # #
  // # # # # # # # # # # # # # # # # # # # # # # # # #

  // ******************** FOR IR ********************

  // THE LOGIC IS THE SAME FOR RED LED. 
  // Check the above documentation
  queue_average_IR.enqueue(average_IR);
  average_past_IR = queue_average_IR.pop();

  bool_set_IP_IR_old = bool_set_IP_IR;
  bool_set_IB_IR_old = bool_set_IB_IR;
  if( average_IR > average_past_IR ) {
    bool_set_IP_IR = true;
    bool_set_IB_IR = false;
  } else {
    bool_set_IP_IR = false;
    bool_set_IB_IR = true;
  }

  if( !bool_set_IP_IR && (bool_set_IP_IR!=bool_set_IP_IR_old) ) {
    // REMOVE THE OLDEST MEASURE
    total_IP_IR  = total_IP_IR - ip_IR_array[readIndex_IP_IR];
    // INSERT THE NEW IB_IR VALUE
    ip_IR_array[readIndex_IP_IR] = average_IR;
    readIndex_IP_IR++;
    if (readIndex_IP_IR >= NUM_IP_IR) { readIndex_IP_IR = 0; }
    average_IP_IR = total_IP_IR / NUM_IP_IR;
  } 
  else
  if(!bool_set_IB_IR && (bool_set_IB_IR!=bool_set_IB_IR_old) ) {
    total_IB_IR  = total_IB_IR - ib_IR_array[readIndex_IB_IR];
    ib_IR_array[readIndex_IB_IR] = average_IR;
    readIndex_IB_IR++;
    if (readIndex_IB_IR >= NUM_IB_IR) { readIndex_IB_IR = 0; }
    average_IB_IR = total_IB_IR / NUM_IB_IR;
  }











  // # # # # # # # # # # # # # # # # # # # # # # # # #
  // # # # # # # # # # #  BAND PASS  # # # # # # # # #
  // # # # # # # # # # # # # # # # # # # # # # # # # #

  // HIGH PASS
  //outpth = alfa*outpth - alfa*(average_RED - old_average_RED);
  // LOW PASS
  //outpt = beta*outpth - (1-beta)*outpt;


  // # # # # # # # # # # # # # # # # # # # # # # # # #
  // # # # # # # # # # # #  PRINT  # # # # # # # # # #
  // # # # # # # # # # # # # # # # # # # # # # # # # #

  Serial.print(0);
  Serial.print(" ");
  Serial.print(100);
  Serial.print(" ");
  Serial.print(average_IP_RED);
  Serial.print(" ");
  Serial.println(average_IB_RED);
  //delay(1);        // delay in between reads for stability
}
