# avaJ-Launcher
avaJ Launcer is a flight tower simulation program written in Java programming language

The file "scenario.txt" contains instructions for the simulation.

The first line of the file contains a positive integer number. This number represents the number of times the simulation is run. In our case, this will be the number of times a weather change is triggered.
Each following line describes an aircraft that will be part of the simulation, with this format: TYPE NAME LONGITUDE LATITUDE HEIGHT.


There are 4 types of weather:
  • RAIN 
  • FOG
  • SUN
  • SNOW
Each 3 dimensional point has its own weather. Weather is generated randomly.



Aircrafts

• JetPlane:
  ◦ SUN - Latitude increases with 10, Height increases with 2 ◦ RAIN - Latitude increases with 5
  ◦ FOG - Latitude increases with 1
  ◦ SNOW - Height decreases with 7
• Helicopter:
  ◦ SUN - Longitude increases with 10, Height increases with 2 ◦ RAIN - Longitude increases with 5
  ◦ FOG - Longitude increases with 1
  ◦ SNOW - Height decreases with 12
• Baloon:
  ◦ SUN - Longitude increases with 2, Height increases with 4 ◦ RAIN - Height decreases with 5
  ◦ FOG - Height decreases with 3
  ◦ SNOW - Height decreases with 15
  
  Simulation
• Coordinates are positive numbers.
• The height is in the 0-100 range.
• If an aircraft needs to pass the upper limit height it remains at 100.
• Each time an aircraft is created, it receives a unique ID. There can’t be 2 aircrafts with the same ID.
• If an aircraft reaches height 0 or needs to go below it, the aircraft lands, unregisters from the weather tower and logs its current coordinates.
• When a weather change occurs, each aircraft type needs to log a message, as seen in the example. The message format is: TYPE#NAME(UNIQUE_ID): SPECIFIC_MESSAGE. A funny message will be appreciated during the correction.
• Each time an aircraft registers or unregisters to/from the weather tower, a message will be logged.
